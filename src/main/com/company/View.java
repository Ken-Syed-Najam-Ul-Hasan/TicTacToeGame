package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JButton buttons[] = new JButton[9];

    private JButton B1;
    private JButton B2;
    private JButton B3;
    private JButton B4;
    private JButton B5;
    private JButton B6;
    private JButton B9;
    private JButton B8;
    private JButton B7;
    private JPanel rootPanel;
    private JLabel Result;
    private JTextField syedNajamUlHasanTextField;
    private int count;
    private Controller C;

    private final String emptyImageDir = "resources/empty.png";
    private final String crossImageDir = "resources/cross.png";
    private final String circleImageDir = "resources/circle.png";


    public View() {
        count = 0;
        add(rootPanel);
        setSize(300, 300);
        setTitle("TicTacToe Game");
        C = new com.company.Controller(); //creating controller object
        ImageIcon imageIcon = new ImageIcon(emptyImageDir);
        B1.setIcon(imageIcon);
        B2.setIcon(imageIcon);
        B3.setIcon(imageIcon);
        B4.setIcon(imageIcon);
        B5.setIcon(imageIcon);
        B6.setIcon(imageIcon);
        B7.setIcon(imageIcon);
        B8.setIcon(imageIcon);
        B9.setIcon(imageIcon);


        B1.addActionListener(e -> {
            count++;  //runs for each move
            if (count % 2 == 0) {
                //set cross icon
                B1.setIcon(new ImageIcon(crossImageDir));
                B1.setText(null);
                B1.setEnabled(false);
                C.setCross(0, 0);

                if (C.isCrossWinner()) {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                } else if (count == 9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            } else {
                //sets circle icon
                B1.setIcon(new ImageIcon(circleImageDir));
                B1.setText(null);
                B1.setEnabled(false);
                C.setCircle(0, 0);
                if (C.isCircleWinner()) {
                    Result.setText("!!! CIRCLE WINS !!!");
                    gameEnd();
                } else if (count == 9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }

        });
        B2.addActionListener(e -> {
            count++;

            if (count % 2 == 0) {
                B2.setIcon(new ImageIcon(crossImageDir));
                B2.setText(null);
                B2.setEnabled(false);
                C.setCross(0, 1);
                if (C.isCrossWinner() == true) {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                } else if (count == 9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            } else {
                B2.setIcon(new ImageIcon(circleImageDir));
                B2.setText(null);
                B2.setEnabled(false);
                C.setCircle(0, 1);
                if (C.isCircleWinner()) {
                    Result.setText("!!! CIRCLE WINS !!!");
                    gameEnd();

                } else if (count == 9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
        });
        B3.addActionListener(e -> {
            count++;

            if (count % 2 == 0) {
                B3.setIcon(new ImageIcon(crossImageDir));
                B3.setText(null);
                B3.setEnabled(false);
                C.setCross(0, 2);
                if (C.isCrossWinner()) {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                } else if (count == 9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            } else {
                B3.setIcon(new ImageIcon(circleImageDir));
                B3.setText(null);
                B3.setEnabled(false);
                C.setCircle(0, 2);
                if (C.isCircleWinner()) {
                    Result.setText("!!! CIRCLE WINS !!!");
                    gameEnd();
                } else if (count == 9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
        });
        B4.addActionListener(e -> {
            count++;

            if (count % 2 == 0) {
                B4.setIcon(new ImageIcon(crossImageDir));
                B4.setText(null);
                B4.setEnabled(false);
                C.setCross(1, 0);
                if (C.isCrossWinner()) {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                } else if (count == 9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            } else {
                B4.setIcon(new ImageIcon(circleImageDir));
                B4.setText(null);
                B4.setEnabled(false);
                C.setCircle(1, 0);
                if (C.isCircleWinner()) {
                    Result.setText("!!! CIRCLE WINS !!!");
                    gameEnd();
                } else if (count == 9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
        });
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;

                if (count % 2 == 0) {
                    B5.setIcon(new ImageIcon(crossImageDir));
                    B5.setText(null);
                    B5.setEnabled(false);
                    C.setCross(1, 1);
                    if (C.isCrossWinner() == true) {
                        Result.setText("!!! CROSS WINS !!!");
                        gameEnd();
                    } else if (count == 9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                } else {
                    B5.setIcon(new ImageIcon(circleImageDir));
                    B5.setText(null);
                    B5.setEnabled(false);
                    C.setCircle(1, 1);
                    if (C.isCircleWinner() == true) {
                        Result.setText("--- CIRCLE WINS ---");
                        gameEnd();
                    } else if (count == 9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                }
            }
        });
        B6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;

                if (count % 2 == 0) {
                    B6.setIcon(new ImageIcon(crossImageDir));
                    B6.setText(null);
                    B6.setEnabled(false);
                    C.setCross(1, 2);
                    if (C.isCrossWinner() == true) {
                        Result.setText("!!! CROSS WINS !!!");
                        gameEnd();
                    } else if (count == 9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                } else {
                    B6.setIcon(new ImageIcon(circleImageDir));
                    B6.setText(null);
                    B6.setEnabled(false);
                    C.setCircle(1, 2);
                    if (C.isCircleWinner() == true) {
                        Result.setText("!!! CIRCLE WINS !!!");
                        gameEnd();
                    } else if (count == 9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                }
            }
        });
        B7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;

                if (count % 2 == 0) {
                    B7.setIcon(new ImageIcon(crossImageDir));
                    B7.setText(null);
                    B7.setEnabled(false);
                    C.setCross(2, 0);
                    if (C.isCrossWinner() == true) {
                        Result.setText("!!! CROSS WINS !!!");
                        gameEnd();
                    } else if (count == 9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                } else {
                    B7.setIcon(new ImageIcon(circleImageDir));
                    B7.setText(null);
                    B7.setEnabled(false);
                    C.setCircle(2, 0);
                    if (C.isCircleWinner() == true) {
                        Result.setText("!!! CIRCLE WINS !!!");
                        gameEnd();
                    } else if (count == 9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                }
            }
        });
        B8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;

                if (count % 2 == 0) {
                    B8.setIcon(new ImageIcon(crossImageDir));
                    B8.setText(null);
                    B8.setEnabled(false);
                    C.setCross(2, 1);
                    if (C.isCrossWinner() == true) {
                        Result.setText("!!! CROSS WINS !!!");
                        gameEnd();
                    } else if (count == 9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                } else {
                    B8.setIcon(new ImageIcon(circleImageDir));
                    B8.setText(null);
                    B8.setEnabled(false);
                    C.setCircle(2, 1);
                    if (C.isCircleWinner() == true) {
                        Result.setText("!!! CIRCLE WINS !!!");
                        gameEnd();
                    } else if (count == 9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                }
            }
        });
        B9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;

                if (count % 2 == 0) {
                    B9.setIcon(new ImageIcon(crossImageDir));
                    B9.setText(null);
                    B9.setEnabled(false);
                    C.setCross(2, 2);
                    if (C.isCrossWinner()) {
                        Result.setText("!!! CROSS WINS !!!");
                        gameEnd();
                    } else if (count == 9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                } else {
                    B9.setIcon(new ImageIcon(circleImageDir));
                    B9.setText(null);
                    B9.setEnabled(false);
                    C.setCircle(2, 2);
                    if (C.isCircleWinner() == true) {
                        Result.setText("!!! CIRCLE WINS !!!");
                        gameEnd();
                    } else if (count == 9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                }
            }
        });

    }

    public void gameEnd() {
        B1.setEnabled(false);
        B2.setEnabled(false);
        B3.setEnabled(false);
        B4.setEnabled(false);
        B5.setEnabled(false);
        B6.setEnabled(false);
        B7.setEnabled(false);
        B8.setEnabled(false);
        B9.setEnabled(false);
    }

    public static void main(String[] args) {
        View ez = new View();
        ez.setVisible(true);

    }

}
