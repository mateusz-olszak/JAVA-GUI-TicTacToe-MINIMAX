package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.xml.stream.StreamFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.*;

public class Move extends Win implements ActionListener {
    JLabel label = new JLabel("Tic-Tac-Toe");
    JButton pvp = new JButton("Player starts");
    JButton pvc = new JButton("Computer starts");
    JButton btnX;
    JButton btnO;
    JButton reset = new JButton("RESET");
    int score;
    int turn=0;
    int counter=0;
    boolean player = false;
    boolean computer = false;
    ImageIcon character;
    ImageIcon opponent;
    JFrame window = new JFrame("Tic Tac Toe");
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JButton b[] = new JButton[9];
    ImageIcon X;
    ImageIcon O;

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
                findBestMove(b,0,turn);
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
                        gameState(b,counter);
                        counter +=1;
                        who_wins(character,opponent,b,label);
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
                        gameState(b, counter);
                        who_wins(character,opponent,b,label);
                    }
                }
            }
        }
    };
    private ActionListener clickReset = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ev) {
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
        }
    };
    ///################################## MINIMAX ALGORITHM #################################


    public Boolean isMovesLeft(JButton[] board) {
        for (int i = 0; i < board.length; i++)
            if (board[i].getIcon() == null)
                return true;
        return false;
    }


    public void findBestMove(JButton[] btns, int counter, int turn) {
        int bestScore = -1;
        int num=0;

        // ##################################################### TURN 1 #################################################
        if(turn == 1){
            if (
                    btns[8].getIcon() == character && btns[1].getIcon() == character && btns[3].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[2].getIcon() == opponent && btns[7].getIcon() == null && btns[6].getIcon() == null
            ) {
                for (int i = 0; i < 9; i++) {
                    if (btns[i].getIcon() == null) {
                        btns[i].setIcon(opponent);
                        int score = minimax(btns, 0, true);
                        btns[i].setIcon(null);
                        if (score > bestScore) {
                            bestScore = score;
                            num = i;
                        }
                    }
                }
            } else {
                for (int i = 0; i < 9; i++) {
                    if (btns[i].getIcon() == null) {
                        btns[i].setIcon(opponent);
                        int score = minimax(btns, 0, false);
                        btns[i].setIcon(null);
                        if (score > bestScore) {
                            bestScore = score;
                            num = i;
                        }
                    }
                }
            }
        }
        // ##################################################### TURN 2 #################################################
        else{
            // For turn 2
            if(counter <3 && btns[4].getIcon() == character) {
                for (int i = 0; i < 9; i++) {
                    if (btns[i].getIcon() == null) {
                        btns[i].setIcon(opponent);
                        int score = minimax(btns, 0, false);
                        btns[i].setIcon(null);
                        if (score > bestScore) {
                            bestScore = score;
                            num = i;
                        }
                    }
                }
            }
            else{
                for (int i = 0; i < 9; i++) {
                    if (btns[i].getIcon() == null) {
                        btns[i].setIcon(opponent);
                        int score = minimax(btns, 0, true);
                        btns[i].setIcon(null);
                        if (score > bestScore) {
                            bestScore = score;
                            num = i;
                        }
                    }
                }
            }
        }
        btns[num].setIcon(opponent);
    }

    //#############################$#$#$$$$$$$$$$$$$###$##$#$$$#$#$#$$##$##$$#$#$#$#$##
    public int minimax(JButton[] btns, int depth, Boolean isMax) {
        player = false;
        computer = true;
        score = if_win(character,opponent,btns);

        if (score == 1)
            return score - depth;

        if (score == -1)
            return score + depth;

        if (isMovesLeft(btns) == false)
            return 0;


        if (isMax) {
            int bestScore = -1;
            for (int i = 0; i < 9; i++) {
                if (btns[i].getIcon() == null) {
                    btns[i].setIcon(opponent);
                    score = minimax(btns, depth+1, isMax);
                    btns[i].setIcon(null);
                    bestScore = max(score, bestScore);
                }
            }
            return bestScore;
        }
        else {
            int bestScore = 1;
            for (int i = 0; i < 9; i++) {
                if (btns[i].getIcon() == null ) {
                    btns[i].setIcon(character);
                    score = minimax(btns, depth+1, isMax);
                    btns[i].setIcon(null);
                    bestScore = min(score, bestScore);
                }
            }
            return bestScore;
        }
    }
    public int gameState(JButton[] btns, int counter) {
        if(turn == 1){
            // SET 0
            if(
                    btns[4].getIcon() == character && btns[0].getIcon() == null && btns[2].getIcon() == null && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                            btns[1].getIcon() == character && btns[0].getIcon() == null && btns[5].getIcon() == null && btns[8].getIcon() == null ||
                            btns[3].getIcon() == character && btns[0].getIcon() == null && btns[2].getIcon() == null ||
                            btns[2].getIcon() == character && btns[5].getIcon() == character && btns[6].getIcon() == character && btns[4].getIcon() == opponent && btns[8].getIcon() == opponent && btns[0].getIcon() == null && btns[1].getIcon() == null && btns[3].getIcon() == null && btns[7].getIcon() == null
            ){
                btns[0].setIcon(opponent);
                return 1;
            }
            // SET 1
            if(
                    btns[0].getIcon() == character && btns[2].getIcon() == character && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null && btns[3].getIcon() == null && btns[6].getIcon() == null ||
                            btns[0].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[7].getIcon() == null && btns[0].getIcon() == null ||
                            btns[2].getIcon() == character && btns[6].getIcon() == character && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[7].getIcon() == null && btns[0].getIcon() == null && btns[3].getIcon() == null && btns[5].getIcon() == null ||
                            btns[0].getIcon() == opponent && btns[4].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[5].getIcon() == null ||
                            btns[3].getIcon() == character && btns[6].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[7].getIcon() == opponent && btns[0].getIcon() == null && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[5].getIcon() == null ||
                            btns[0].getIcon() == character && btns[6].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[7].getIcon() == opponent && btns[3].getIcon() == null && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[5].getIcon() == null ||
                            btns[0].getIcon() == character && btns[5].getIcon() == character && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[3].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                            btns[7].getIcon() == character && btns[1].getIcon() == null && btns[8].getIcon() == null && btns[6].getIcon() == null && btns[2].getIcon() == null && btns[4].getIcon() == null && btns[5].getIcon() == null
            ){
                btns[1].setIcon(opponent);
                return 1;
            }
            // SET 2
            if(
                    btns[6].getIcon() == character && btns[8].getIcon() == character && btns[1].getIcon() == character && btns[5].getIcon() == character && btns[4].getIcon() == opponent && btns[7].getIcon() == opponent && btns[2].getIcon() == null ||
                            btns[3].getIcon() == character &&  btns[7].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[6].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[5].getIcon() == null ||
                            btns[1].getIcon() == character &&  btns[7].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[6].getIcon() == opponent && btns[0].getIcon() == null && btns[2].getIcon() == null && btns[5].getIcon() == null ||
                            btns[0].getIcon() == character &&  btns[7].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[6].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[3].getIcon() == null && btns[5].getIcon() == null ||
                            btns[0].getIcon() == opponent && btns[4].getIcon() == character && btns[6].getIcon() == character && btns[2].getIcon() == null ||
                            btns[0].getIcon() == opponent && btns[4].getIcon() == character && btns[8].getIcon() == character && btns[2].getIcon() == null && btns[5].getIcon() == null ||
                            btns[5].getIcon() == character && btns[2].getIcon() == null && btns[6].getIcon() == null && btns[3].getIcon() == null && btns[0].getIcon() == null ||
                            btns[0].getIcon() == character && btns[1].getIcon() == character && btns[4].getIcon() == opponent && btns[3].getIcon() == null && btns[6].getIcon() == null && btns[2].getIcon() == null ||
                            btns[0].getIcon() == character && btns[3].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[6].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[5].getIcon() == null && btns[7].getIcon() == null ||
                            btns[0].getIcon() == character && btns[3].getIcon() == character && btns[5].getIcon() == character && btns[4].getIcon() == opponent && btns[6].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                            btns[0].getIcon() == character && btns[3].getIcon() == character && btns[7].getIcon() == character && btns[4].getIcon() == opponent && btns[6].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[5].getIcon() == null && btns[8].getIcon() == null
            ){
                btns[2].setIcon(opponent);
                return 1;
            }
            // SET 3
            if(
                    btns[0].getIcon() == opponent && btns[4].getIcon() == character && btns[5].getIcon() == character && btns[3].getIcon() == null && btns[2].getIcon() == null && btns[7].getIcon() == null ||
                            btns[2].getIcon() == opponent && btns[4].getIcon() == character && btns[5].getIcon() == character && btns[3].getIcon() == null && btns[6].getIcon() == null && btns[1].getIcon() == null && btns[8].getIcon() == null ||
                            btns[0].getIcon() == character && btns[6].getIcon() == character && btns[4].getIcon() == opponent && btns[3].getIcon() == null && btns[2].getIcon() == null && btns[8].getIcon() == null ||
                            btns[2].getIcon() == character && btns[7].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[5].getIcon() == opponent && btns[6].getIcon() == opponent && btns[0].getIcon() == character && btns[1].getIcon() == null && btns[3].getIcon() == null ||
                            btns[2].getIcon() == character && btns[7].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[5].getIcon() == opponent && btns[6].getIcon() == opponent && btns[1].getIcon() == character && btns[3].getIcon() == null ||
                            btns[2].getIcon() == character && btns[6].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[5].getIcon() == opponent && btns[0].getIcon() == null && btns[1].getIcon() == null && btns[3].getIcon() == null && btns[7].getIcon() == null ||
                            btns[2].getIcon() == character && btns[7].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[5].getIcon() == opponent && btns[0].getIcon() == null && btns[1].getIcon() == null && btns[3].getIcon() == null && btns[6].getIcon() == null ||
                            btns[1].getIcon() == character && btns[2].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[5].getIcon() == opponent && btns[0].getIcon() == null && btns[7].getIcon() == null && btns[3].getIcon() == null && btns[6].getIcon() == null ||
                            btns[0].getIcon() == character && btns[2].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[5].getIcon() == opponent && btns[1].getIcon() == null && btns[3].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null ||
                            btns[0].getIcon() == character && btns[5].getIcon() == character && btns[2].getIcon() == opponent && btns[1].getIcon() == null && btns[3].getIcon() == null && btns[4].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                            btns[2].getIcon() == character && btns[4].getIcon() == character && btns[5].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == opponent && btns[6].getIcon() == opponent && btns[8].getIcon() == opponent && btns[0].getIcon() == null && btns[3].getIcon() == null ||
                            btns[2].getIcon() == character && btns[4].getIcon() == character && btns[7].getIcon() == character && btns[0].getIcon() == opponent && btns[6].getIcon() == opponent && btns[1].getIcon() == null && btns[3].getIcon() == null && btns[5].getIcon() == null && btns[8].getIcon() == null
            ){
                btns[3].setIcon(opponent);
                return 1;
            }
            // SET 4
            if(btns[0].getIcon() == character && btns[4].getIcon() == null && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[3].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                    btns[2].getIcon() == character && btns[4].getIcon() == null && btns[1].getIcon() == null ||
                    btns[6].getIcon() == character && btns[4].getIcon() == null && btns[7].getIcon() == null && btns[0].getIcon() == null ||
                    btns[8].getIcon() == character && btns[4].getIcon() == null && btns[7].getIcon() == null && btns[3].getIcon() == null ||
                    btns[0].getIcon() == character && btns[7].getIcon() == character && btns[3].getIcon() == character && btns[1].getIcon() == opponent && btns[6].getIcon() == opponent && btns[2].getIcon() == null && btns[4].getIcon() == null && btns[5].getIcon() == null && btns[8].getIcon() == null ||
                    btns[1].getIcon() == character && btns[3].getIcon() == character && btns[0].getIcon() == opponent && btns[2].getIcon() == null && btns[4].getIcon() == null && btns[5].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                    btns[3].getIcon() == character && btns[5].getIcon() == character && btns[0].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[4].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                    btns[3].getIcon() == character && btns[5].getIcon() == character && btns[2].getIcon() == opponent && btns[1].getIcon() == null && btns[0].getIcon() == null && btns[4].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                    btns[0].getIcon() == character && btns[5].getIcon() == character && btns[1].getIcon() == opponent && btns[2].getIcon() == null && btns[3].getIcon() == null && btns[4].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null
            ){
                btns[4].setIcon(opponent);
                return 1;
            }
            // SET 5
            if(
                    btns[0].getIcon() == opponent && btns[4].getIcon() == character && btns[3].getIcon() == character && btns[5].getIcon() == null && btns[1].getIcon() == null && btns[8].getIcon() == null && btns[6].getIcon() == null ||
                            btns[2].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[0].getIcon() == null && btns[1].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[5].getIcon() == null && btns[3].getIcon() == null ||
                            btns[1].getIcon() == character && btns[2].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[0].getIcon() == opponent && btns[3].getIcon() == null && btns[5].getIcon() == null ||
                            btns[0].getIcon() == character && btns[6].getIcon() == character && btns[7].getIcon() == character && btns[8].getIcon() == opponent && btns[3].getIcon() == opponent && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[5].getIcon() == null ||
                            btns[0].getIcon() == character && btns[1].getIcon() == character && btns[6].getIcon() == character && btns[2].getIcon() == opponent && btns[3].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == null && btns[8].getIcon() == null && btns[7].getIcon() == character ||
                            btns[0].getIcon() == character && btns[1].getIcon() == character && btns[6].getIcon() == character && btns[2].getIcon() == opponent && btns[3].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == character ||
                            btns[2].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[0].getIcon() == character && btns[6].getIcon() == opponent && btns[5].getIcon() == null && btns[6].getIcon() == null ||
                            btns[0].getIcon() == character && btns[3].getIcon() == character && btns[4].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == opponent && btns[6].getIcon() == opponent && btns[8].getIcon() == opponent && btns[2].getIcon() == null && btns[5].getIcon() == null ||
                            btns[0].getIcon() == character && btns[7].getIcon() == character && btns[2].getIcon() == character && btns[8].getIcon() == character && btns[1].getIcon() == opponent && btns[4].getIcon() == opponent && btns[6].getIcon() == opponent && btns[3].getIcon() == null && btns[5].getIcon() == null ||
                            btns[0].getIcon() == character && btns[1].getIcon() == character && btns[6].getIcon() == character && btns[3].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                            btns[0].getIcon() == character && btns[2].getIcon() == character && btns[6].getIcon() == character && btns[3].getIcon() == opponent && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null && btns[5].getIcon() == null
            ){
                btns[5].setIcon(opponent);
                return 1;
            }
            // SET 6
            if(btns[0].getIcon() == opponent && btns[4].getIcon() == character && btns[2].getIcon() == character && btns[6].getIcon() == null ||
                    btns[0].getIcon() == character && btns[3].getIcon() == character && btns[4].getIcon() == opponent && btns[6].getIcon() == null && btns[8].getIcon() == null && btns[2].getIcon() == null ||
                    btns[0].getIcon() == character && btns[5].getIcon() == character && btns[1].getIcon() == character && btns[4].getIcon() == opponent && btns[6].getIcon() == null && btns[8].getIcon() == null  && btns[7].getIcon() == null && btns[3].getIcon() == null  && btns[2].getIcon() == opponent ||
                    btns[0].getIcon() == character && btns[8].getIcon() == character && btns[1].getIcon() == character && btns[4].getIcon() == opponent && btns[6].getIcon() == null && btns[5].getIcon() == null  && btns[7].getIcon() == null && btns[3].getIcon() == null  && btns[2].getIcon() == opponent ||
                    btns[0].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == character && btns[4].getIcon() == opponent && btns[6].getIcon() == null && btns[5].getIcon() == null  && btns[8].getIcon() == null && btns[3].getIcon() == null  && btns[2].getIcon() == opponent ||
                    btns[0].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == opponent && btns[6].getIcon() == null && btns[2].getIcon() == null && btns[3].getIcon() == null && btns[4].getIcon() == null && btns[5].getIcon() == null && btns[8].getIcon() == null ||
                    btns[7].getIcon() == character && btns[5].getIcon() == character && btns[1].getIcon() == opponent && btns[0].getIcon() == null && btns[2].getIcon() == null && btns[4].getIcon() == null && btns[3].getIcon() == null ||
                    btns[3].getIcon() == character && btns[5].getIcon() == character && btns[1].getIcon() == character && btns[2].getIcon() == opponent && btns[4].getIcon() == opponent && btns[0].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                    btns[3].getIcon() == character && btns[5].getIcon() == character && btns[7].getIcon() == character && btns[2].getIcon() == opponent && btns[4].getIcon() == opponent && btns[0].getIcon() == null && btns[1].getIcon() == null && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                    btns[3].getIcon() == character && btns[5].getIcon() == character && btns[8].getIcon() == character && btns[2].getIcon() == opponent && btns[4].getIcon() == opponent && btns[0].getIcon() == null && btns[1].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null ||
                    btns[2].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == opponent && btns[0].getIcon() == null && btns[3].getIcon() == null && btns[4].getIcon() == null && btns[5].getIcon() == null && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                    btns[7].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == null && btns[0].getIcon() == null && btns[2].getIcon() == null && btns[3].getIcon() == null ||
                    btns[7].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[6].getIcon() == null ||
                    btns[1].getIcon() == character && btns[5].getIcon() == character && btns[8].getIcon() == character && btns[2].getIcon() == opponent && btns[4].getIcon() == opponent && btns[0].getIcon() == null && btns[3].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null ||
                    btns[0].getIcon() == character && btns[1].getIcon() == character && btns[8].getIcon() == character && btns[2].getIcon() == opponent && btns[4].getIcon() == opponent && btns[3].getIcon() == null && btns[7].getIcon() == null ||
                    btns[4].getIcon() == character && btns[5].getIcon() == character && btns[7].getIcon() == character && btns[0].getIcon() == opponent && btns[3].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                    btns[4].getIcon() == character && btns[5].getIcon() == character && btns[8].getIcon() == character && btns[0].getIcon() == opponent && btns[3].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null ||
                    btns[0].getIcon() == character && btns[5].getIcon() == character && btns[8].getIcon() == character && btns[2].getIcon() == opponent && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[3].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null
            ){
                btns[6].setIcon(opponent);
                return 1;
            }
            // SET 7
            if(
                    btns[6].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[7].getIcon() == null && btns[1].getIcon() == null && btns[0].getIcon() == null ||
                            btns[0].getIcon() == opponent && btns[4].getIcon() == character && btns[1].getIcon() == character && btns[7].getIcon() == null && btns[2].getIcon() == null && btns[5].getIcon() == null ||
                            btns[5].getIcon() == character && btns[8].getIcon() == character && btns[4].getIcon() == opponent && btns[2].getIcon() == opponent && btns[0].getIcon() == null && btns[6].getIcon() == character && btns[7].getIcon() == null ||
                            btns[0].getIcon() == character && btns[2].getIcon() == character && btns[8].getIcon() == character && btns[1].getIcon() == opponent && btns[4].getIcon() == opponent && btns[3].getIcon() == null && btns[5].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null ||
                            btns[0].getIcon() == character && btns[2].getIcon() == character && btns[3].getIcon() == character && btns[1].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                            btns[0].getIcon() == character && btns[2].getIcon() == character && btns[6].getIcon() == character && btns[1].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == null && btns[3].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                            btns[2].getIcon() == character && btns[3].getIcon() == character && btns[6].getIcon() == character && btns[8].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == opponent && btns[1].getIcon() == null && btns[7].getIcon() == null ||
                            btns[0].getIcon() == character && btns[5].getIcon() == character && btns[6].getIcon() == character && btns[8].getIcon() == character && btns[2].getIcon() == opponent && btns[3].getIcon() == opponent && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[7].getIcon() == null
            ){
                btns[7].setIcon(opponent);
                return 1;
            }
            // SET 8
            if(btns[7].getIcon() == character && btns[6].getIcon() == character && btns[8].getIcon() == null && btns[0].getIcon() == null && btns[2].getIcon() == null && btns[3].getIcon() == null ||
                    btns[6].getIcon() == character && btns[7].getIcon() == character && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[8].getIcon() == null && btns[3].getIcon() == null ||
                    btns[2].getIcon() == character && btns[5].getIcon() == character && btns[4].getIcon() == opponent && btns[0].getIcon() == null && btns[1].getIcon() == null && btns[3].getIcon() == null && btns[7].getIcon() == null ||
                    btns[3].getIcon() == character && btns[1].getIcon() == character && btns[2].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == null && btns[6].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                    btns[6].getIcon() == character && btns[1].getIcon() == character && btns[2].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == null && btns[3].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                    btns[7].getIcon() == character && btns[1].getIcon() == character && btns[2].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == null && btns[3].getIcon() == null && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                    btns[0].getIcon() == character && btns[4].getIcon() == character && btns[5].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == opponent && btns[2].getIcon() == opponent && btns[3].getIcon() == opponent && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                    btns[0].getIcon() == character && btns[4].getIcon() == character && btns[5].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == opponent && btns[3].getIcon() == opponent && btns[6].getIcon() == opponent && btns[8].getIcon() == null && btns[2].getIcon() == null ||
                    btns[7].getIcon() == character && btns[1].getIcon() == character && btns[3].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[2].getIcon() == null && btns[5].getIcon() == null && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                    btns[5].getIcon() == character && btns[1].getIcon() == character && btns[3].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[2].getIcon() == null && btns[7].getIcon() == null && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                    btns[6].getIcon() == character && btns[1].getIcon() == character && btns[3].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[2].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                    btns[0].getIcon() == character && btns[2].getIcon() == character && btns[5].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == opponent && btns[6].getIcon() == opponent && btns[4].getIcon() == opponent && btns[3].getIcon() == null && btns[8].getIcon() == null ||
                    btns[0].getIcon() == character && btns[5].getIcon() == character && btns[6].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == opponent && btns[3].getIcon() == opponent && btns[4].getIcon() == opponent && btns[2].getIcon() == null && btns[8].getIcon() == null ||
                    btns[2].getIcon() == character && btns[3].getIcon() == character && btns[6].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[5].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null ||
                    btns[2].getIcon() == character && btns[3].getIcon() == character && btns[7].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[5].getIcon() == null && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                    btns[3].getIcon() == character && btns[5].getIcon() == character && btns[7].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                    btns[0].getIcon() == character && btns[2].getIcon() == character && btns[5].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() == opponent && btns[3].getIcon() == opponent && btns[4].getIcon() == opponent && btns[6].getIcon() == null && btns[8].getIcon() == null ||
                    btns[3].getIcon() == character && btns[5].getIcon() == character && btns[6].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[1].getIcon() == null && btns[2].getIcon() == null && btns[7].getIcon() == null && btns[8].getIcon() == null
            ){
                btns[8].setIcon(opponent);
                return 1;
            }
            if(btns[0].getIcon() == null || btns[1].getIcon() == null || btns[2].getIcon() == null || btns[3].getIcon() == null || btns[4].getIcon() == null || btns[5].getIcon() == null || btns[6].getIcon() == null || btns[7].getIcon() == null || btns[8].getIcon() == null)
                findBestMove(b,counter,turn);
        }
        else{
            if(counter == 1 && btns[0].getIcon() == opponent && btns[8].getIcon() == character || counter == 1 && btns[0].getIcon() == opponent && btns[5].getIcon() == character || counter == 1 && btns[0].getIcon() == opponent && btns[7].getIcon() == character){
                btns[2].setIcon(opponent);
                return 1;
            }
            if(btns[0].getIcon() == opponent && btns[2].getIcon() == opponent && btns[1].getIcon() == character  && btns[8].getIcon() == character && btns[6].getIcon() == null){
                btns[6].setIcon(opponent);
                return 1;}
            if(btns[0].getIcon() == opponent && btns[2].getIcon() == opponent && btns[1].getIcon() == character  && btns[5].getIcon() == character && btns[4].getIcon() == null){
                btns[4].setIcon(opponent);
                return 1;}
            if(btns[0].getIcon() == opponent && btns[2].getIcon() == opponent && btns[1].getIcon() == character  && btns[7].getIcon() == character && btns[4].getIcon() == null){
                btns[4].setIcon(opponent);
                return 1;}
            findBestMove(btns,1,2);
        }

        return 0;
    }
}