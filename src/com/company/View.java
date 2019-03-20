package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

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
    private int count;
    private Controller C;

    public View()
    {
        count=0;
        add(rootPanel);
        setSize(300,300);
        setTitle("TicTacToe Game");
        C=new Controller(); //creating controller object
        B1.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\empty.png"));
        B2.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\empty.png"));
        B3.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\empty.png"));
        B4.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\empty.png"));
        B5.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\empty.png"));
        B6.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\empty.png"));
        B7.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\empty.png"));
        B8.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\empty.png"));
        B9.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\empty.png"));



        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;  //runs for each move
                if(count%2==0)
                {
                    //set cross icon
                    B1.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\cross.png"));
                    B1.setText(null);
                    B1.setEnabled(false);
                    C.setCross(0,0);

                    if(C.isCrossWinner()==true)
                    {
                        Result.setText("!!! CROSS WINS !!!");
                        gameEnd();
                    }
                    else if(count==9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                }
                else
                {
                    //sets circle icon
                    B1.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\circle.png"));
                    B1.setText(null);
                    B1.setEnabled(false);
                    C.setCircle(0,0);
                    if(C.isCircleWinner()==true)
                    {
                        Result.setText("!!! CIRCLE WINS !!!");
                        gameEnd();
                    }
                    else if(count==9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                }

            }
        });
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;

                if(count%2==0) {
                    B2.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\cross.png"));
                    B2.setText(null);
                    B2.setEnabled(false);
                    C.setCross(0,1);
                    if(C.isCrossWinner()==true)
                    {
                        Result.setText("!!! CROSS WINS !!!");
                        gameEnd();
                    }
                    else if(count==9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                }
                else
                {
                    B2.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\circle.png"));
                    B2.setText(null);
                    B2.setEnabled(false);
                    C.setCircle(0,1);
                    if(C.isCircleWinner()==true)
                    {
                        Result.setText("!!! CIRCLE WINS !!!");
                        gameEnd();

                    }
                    else if(count==9) //TIE
                    {
                        Result.setText("!!! GAME TIED !!!");
                        gameEnd();
                    }
                }
            }
        });
        B3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count++;

            if(count%2==0) {
                B3.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\cross.png"));
                B3.setText(null);
                B3.setEnabled(false);
                C.setCross(0,2);
                if(C.isCrossWinner()==true)
                {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
            else
            {
                B3.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\circle.png"));
                B3.setText(null);
                B3.setEnabled(false);
                C.setCircle(0,2);
                if(C.isCircleWinner()==true)
                {
                    Result.setText("!!! CIRCLE WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
        }
    });
        B4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count++;

            if(count%2==0) {
                B4.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\cross.png"));
                B4.setText(null);
                B4.setEnabled(false);
                C.setCross(1,0);
                if(C.isCrossWinner()==true)
                {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
            else
            {
                B4.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\circle.png"));
                B4.setText(null);
                B4.setEnabled(false);
                C.setCircle(1,0);
                if(C.isCircleWinner()==true)
                {
                    Result.setText("!!! CIRCLE WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
        }
    });
        B5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count++;

            if(count%2==0) {
                B5.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\cross.png"));
                B5.setText(null);
                B5.setEnabled(false);
                C.setCross(1,1);
                if(C.isCrossWinner()==true)
                {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
            else
            {
                B5.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\circle.png"));
                B5.setText(null);
                B5.setEnabled(false);
                C.setCircle(1,1);
                if(C.isCircleWinner()==true)
                {
                    Result.setText("--- CIRCLE WINS ---");
                    gameEnd();
                }
                else if(count==9) //TIE
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

            if(count%2==0) {
                B6.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\cross.png"));
                B6.setText(null);
                B6.setEnabled(false);
                C.setCross(1,2);
                if(C.isCrossWinner()==true)
                {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
            else
            {
                B6.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\circle.png"));
                B6.setText(null);
                B6.setEnabled(false);
                C.setCircle(1,2);
                if(C.isCircleWinner()==true)
                {
                    Result.setText("!!! CIRCLE WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
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

            if(count%2==0) {
                B7.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\cross.png"));
                B7.setText(null);
                B7.setEnabled(false);
                C.setCross(2,0);
                if(C.isCrossWinner()==true)
                {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
            else
            {
                B7.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\circle.png"));
                B7.setText(null);
                B7.setEnabled(false);
                C.setCircle(2,0);
                if(C.isCircleWinner()==true)
                {
                    Result.setText("!!! CIRCLE WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
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

            if(count%2==0) {
                B8.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\cross.png"));
                B8.setText(null);
                B8.setEnabled(false);
                C.setCross(2,1);
                if(C.isCrossWinner()==true)
                {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
            else
            {
                B8.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\circle.png"));
                B8.setText(null);
                B8.setEnabled(false);
                C.setCircle(2,1);
                if(C.isCircleWinner()==true)
                {
                    Result.setText("!!! CIRCLE WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
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

            if(count%2==0) {
                B9.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\cross.png"));
                B9.setText(null);
                B9.setEnabled(false);
                C.setCross(2,2);
                if(C.isCrossWinner())
                {
                    Result.setText("!!! CROSS WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
            else
            {
                B9.setIcon(new ImageIcon("C:\\Users\\HP\\IdeaProjects\\TicTacToe\\src\\com\\company\\circle.png"));
                B9.setText(null);
                B9.setEnabled(false);
                C.setCircle(2,2);
                if(C.isCircleWinner()==true)
                {
                    Result.setText("!!! CIRCLE WINS !!!");
                    gameEnd();
                }
                else if(count==9) //TIE
                {
                    Result.setText("!!! GAME TIED !!!");
                    gameEnd();
                }
            }
        }
    });

    }
    public void gameEnd()
    {
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
        View ez=new View();
        ez.setVisible(true);

    }

}
