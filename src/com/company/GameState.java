package com.company;

import javax.swing.*;

public class GameState {


    public Boolean isMovesLeft(JButton[] board) {
        for (int i = 0; i < board.length; i++)
            if (board[i].getIcon() == null)
                return true;
        return false;
    }

    public int gameState(JButton[] btns, int counter,int turn, ImageIcon character, ImageIcon opponent,Win win,MiniMax miniMax) {
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
                miniMax.findBestMove(btns,counter,turn, character, opponent, win);
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
            miniMax.findBestMove(btns,1,2, character, opponent, win);
        }

        return 0;
    }
}
