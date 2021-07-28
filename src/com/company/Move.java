package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.*;

public class Move implements ActionListener {
    private final Win win = new Win();
    private final JLabel label = new JLabel("Tic-Tac-Toe");
    private final JButton pvp = new JButton("Player starts");
    private final JButton pvc = new JButton("Computer starts");
    private final JButton btnX;
    private final JButton btnO;
    private final JButton reset = new JButton("RESET");
    private int turn=0;
    private int counter=0;
    private ImageIcon character;
    private ImageIcon opponent;
    private final JFrame window = new JFrame("Tic Tac Toe");
    private final JPanel panel = new JPanel();
    private final JPanel panel1 = new JPanel();
    private final JPanel panel2 = new JPanel();
    private final JPanel panel3 = new JPanel();
    private final JButton b[] = new JButton[9];
    private ImageIcon X;
    private ImageIcon O;
    private final MiniMax miniMax = new MiniMax();
    private final GameState state = new GameState();

    public Move(){
        window.add(pvp);
        window.add(pvc);
        window.setSize(600,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLayout(new GridLayout());

        // Assign images
        X = new ImageIcon("X.png");
        Image imgX = X.getImage();
        Image new_X = imgX.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        X = new ImageIcon(new_X);
        O = new ImageIcon("O.png");
        Image imgO = O.getImage();
        Image new_O = imgO.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        O = new ImageIcon(new_O);
        btnX = new JButton("",X);
        btnO = new JButton("",O);
        btnX.addActionListener(this);
        btnO.addActionListener(this);
        btnX.setBounds(150,200,75,75);
        btnO.setBounds(250,200,75,75);



        pvp.addActionListener(this);
        pvc.addActionListener(this);
        pvp.setBounds(175,250,100,50);
        pvc.setBounds(300,250,135,50);
        panel.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == pvp) {
            turn = 1;
            pvp.hide();
            pvc.hide();
            window.setLayout(new GridBagLayout());
            panel.add(btnX,X);
            panel.add(btnO,O);
            btnO.show();
            btnX.show();
            panel.show();
            window.add(panel,new GridBagConstraints());
        }
        else if (obj == pvc) {
            turn = 2;
            pvp.hide();
            pvc.hide();
            window.setLayout(new GridBagLayout());
            panel.add(btnX,X);
            panel.add(btnO,O);
            btnO.show();
            btnX.show();
            panel.show();
            window.add(panel,new GridBagConstraints());
        }

        if (obj == btnX || obj == btnO) {
            if (obj == btnX) {
                character = X;
                opponent = O;
                panel1.show();
                panel2.show();
                panel3.show();

            } else if (obj == btnO) {
                character = O;
                opponent = X;
                panel1.show();
                panel2.show();
                panel3.show();
            }
            panel.hide();
            btnX.hide();
            btnO.hide();

            Border brd = label.getBorder();
            Border margin = new EmptyBorder(10,15,10,10);
            label.setBorder(new CompoundBorder(brd,margin));
            window.setLayout(new BorderLayout());
            label.setFont(label.getFont().deriveFont(64f));
            panel1.setBackground(Color.BLUE);
            panel1.setBorder(BorderFactory.createBevelBorder(0));
            panel1.setLayout(new BorderLayout());
            panel1.add(label, BorderLayout.NORTH);
            window.add(panel1, BorderLayout.NORTH);
            panel2.setBackground(Color.CYAN);
            panel2.setBounds(0,100,500,400);
            panel2.setLayout(new GridLayout(3,3));

            // Add Buttons
            for (int i = 0; i < 9; i++) {
                b[i] = new JButton();
                panel2.add(b[i]);
            }

            // Add ActionListener
            for (int i = 0; i < 9; i++) {
                b[i].addActionListener(clickboard);
            }

            reset.setBounds(0,0,100,25);
            reset.addActionListener(clickReset);
            panel3.setLayout(new BorderLayout());
            panel3.add(reset);
            window.add(panel2);
            window.add(panel3,BorderLayout.SOUTH);
            if(turn == 2){
                miniMax.findBestMove(b,0,turn, character, opponent, win);
            }
        }
    }
    private ActionListener clickboard = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ev) {
            if(turn == 1){
                for (int i = 0; i < 9; i++) {
                    if (ev.getSource() == b[i] && b[i].getIcon() == null || ev.getSource() == b[i] && b[i].getIcon() == null) {
                        if (character == X) {
                            b[i].setIcon(X);
                        } else if (character == O) {
                            b[i].setIcon(O);
                        }
                        state.gameState(b,counter,turn,character,opponent,win,miniMax);
                        counter +=1;
                        win.showWinner(character,opponent,b,label);
                    }
                }
            }
            else if(turn == 2) {
                for (int i = 0; i < 9; i++) {
                    if (ev.getSource() == b[i] && b[i].getIcon() == null || ev.getSource() == b[i] && b[i].getIcon() == null) {
                        if (character == X) {
                            b[i].setIcon(X);
                        } else if (character == O) {
                            b[i].setIcon(O);
                        }
                        counter += 1;
                        state.gameState(b, counter,turn,character,opponent,win,miniMax);
                        win.showWinner(character,opponent,b,label);
                    }
                }
            }
        }
    };
    private ActionListener clickReset = ev -> {
        if(ev.getSource() == reset){
            for(int i=0; i<9; i++){
                b[i].setIcon(null);
                counter = 0;
                for(int j=0; j<9; j++) b[j].setEnabled(true);
                panel2.remove(b[i]);
                label.setText("Tic-Tac-Toe");
                label.setBorder(new CompoundBorder());
                panel1.hide();
                panel2.hide();
                panel3.hide();
                pvp.show();
                pvc.show();
            }
        }
    };

}