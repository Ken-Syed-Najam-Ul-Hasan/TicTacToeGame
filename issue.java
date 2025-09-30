import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@RestController
public class VulnerableController {

    private static final Logger log = LoggerFactory.getLogger(VulnerableController.class);

    // VULNERABILITY: Hardcoded secrets. API keys, database passwords, etc., should never be in source code.
    private final String API_KEY = "sk_live_12345abcdeFGHIjklmnoPqrsTuv";
    private final String DB_PASSWORD = "password123";

    // BAD PRACTICE: Mutable static state is dangerous in a multi-threaded environment.
    // This can lead to race conditions and unpredictable behavior.
    public static String lastUser = "";

    /**
     * VULNERABILITY: SQL Injection (SQLi)
     * User input is directly concatenated into a database query.
     * A malicious user can provide input like "' OR 1=1 --" to bypass authentication.
     */
    @GetMapping("/user")
    public String getUserData(@RequestParam String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        try (Connection con = DriverManager.getConnection("jdbc:h2:mem:testdb", "user", DB_PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                lastUser = rs.getString("username");
                return "User data for: " + lastUser;
            }
        } catch (Exception e) {
            // BUG: Catching a generic 'Exception' is too broad.
            return "Error retrieving user.";
        }
        return "User not found.";
    }

    /**
     * VULNERABILITY: Path Traversal
     * User input is used to construct a file path without proper sanitization.
     * A user could provide "../../../etc/passwd" to read sensitive system files.
     */
    @GetMapping("/file")
    public String getFileContent(@RequestParam String filename) throws IOException {
        // BUG: Inadequate input validation. A simple replace is not enough.
        String sanitizedFilename = filename.replace("..", "");
        String filePath = "/tmp/user_files/" + sanitizedFilename;

        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    /**
     * VULNERABILITY: Command Injection
     * User input is passed directly to the operating system shell.
     * A user could provide "8.8.8.8; rm -rf /" to execute arbitrary commands.
     */
    @GetMapping("/exec")
    public String executeCommand(@RequestParam String domain) throws IOException {
        // This is extremely dangerous.
        Process process = Runtime.getRuntime().exec("ping -c 1 " + domain);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            StringBuilder output = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            return output.toString();
        }
    }

    /**
     * VULNERABILITY: Insecure Deserialization
     * Deserializing data from an untrusted source can lead to Remote Code Execution (RCE)
     * if a malicious "gadget chain" is present in the classpath.
     */
    @PostMapping("/deserialize")
    public String processSerializedData(@RequestBody byte[] data) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bis);
            // VULNERABILITY: Deserializing untrusted data.
            Object obj = ois.readObject();
            ois.close();
            return "Object deserialized: " + obj.toString();
        } catch (Exception e) {
            // BUG: Empty catch block. The exception is swallowed, hiding potential errors.
        }
        return "Deserialization failed.";
    }
    
    /**
     * VULNERABILITY: Cross-Site Scripting (XSS)
     * Reflected XSS. The 'name' parameter is reflected back to the user without escaping.
     * A user can inject malicious scripts, e.g., ?name=<script>alert('XSS')</script>
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        // BUG: Sensitive data (password) being logged.
        log.info("User {} logged in with password 'password123'", name);
        return "<h1>Hello, " + name + "!</h1>";
    }

    /**
     * VULNERABILITY: Insecure Regular Expression (Potential for ReDoS)
     * A poorly written regex can be exploited to cause a Denial of Service.
     * This regex (([a-z]+)+)+ is a classic example of "evil regex".
     */
    @GetMapping("/validate")
    public boolean validateInput(@RequestParam String input) {
        Pattern evilRegex = Pattern.compile("(([a-z]+)+)+");
        return evilRegex.matcher(input).matches();
    }

    /**
     * Contains multiple bugs and bad practices.
     */
    public void utilityMethod(String input) {
        // BUG: Comparing strings using '==' instead of '.equals()'.
        if (input == "admin") {
            System.out.println("Admin user detected."); // BAD PRACTICE: Using System.out instead of a logger.
        }

        // BAD PRACTICE: Inefficient string concatenation in a loop.
        String result = "";
        for (int i = 0; i < 100; i++) {
            result += i; // A good analyzer will suggest using StringBuilder.
        }

        // BUG: Resource leak. The FileInputStream is never closed.
        try {
            FileInputStream fis = new FileInputStream("somefile.txt");
            fis.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // BUG: Ignoring the return value of a method that indicates success/failure.
        File file = new File("temp.txt");
        file.delete();
    }
}

/**
 * A utility class to demonstrate other issues.
 */
class DangerousUtils {
    // BUG: A static SimpleDateFormat is not thread-safe.
    // In a Spring singleton bean, multiple threads could access this concurrently, causing incorrect date formatting.
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String formatDate(Date date) {
        // This call is not thread-safe.
        return dateFormat.format(date);
    }

    // BUG: Potential NullPointerException (NPE).
    // The 'user' object is not checked for null before being used.
    public int getUsernameLength(UserDto user) {
        return user.getUsername().length();
    }
}

class UserDto {
    private String username;
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
