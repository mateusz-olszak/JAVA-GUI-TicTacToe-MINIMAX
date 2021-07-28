package com.company;

import javax.swing.*;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class MiniMax {

    private final GameState state = new GameState();

    public void findBestMove(JButton[] btns, int counter, int turn, ImageIcon character, ImageIcon opponent, Win win) {
        int bestScore = -1;
        int num=0;

        //  TURN 1
        if(turn == 1){
            if (
                    btns[8].getIcon() == character && btns[1].getIcon() == character && btns[3].getIcon() == character && btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[2].getIcon() == opponent && btns[7].getIcon() == null && btns[6].getIcon() == null
            ) {
                for (int i = 0; i < 9; i++) {
                    if (btns[i].getIcon() == null) {
                        btns[i].setIcon(opponent);
                        int score = minimax(btns, 0, true, character, opponent, win);
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
                        int score = minimax(btns, 0, false, character, opponent, win);
                        btns[i].setIcon(null);
                        if (score > bestScore) {
                            bestScore = score;
                            num = i;
                        }
                    }
                }
            }
        }
        //  TURN 2
        else{
            // For turn 2
            if(counter <3 && btns[4].getIcon() == character) {
                for (int i = 0; i < 9; i++) {
                    if (btns[i].getIcon() == null) {
                        btns[i].setIcon(opponent);
                        int score = minimax(btns, 0, false, character, opponent, win);
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
                        int score = minimax(btns, 0, true, character, opponent, win);
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

    private int minimax(JButton[] btns, int depth, Boolean isMax, ImageIcon character, ImageIcon opponent, Win win) {
        int score;
        score = win.checkWinner(character,opponent,btns);

        if (score == 1)
            return score - depth;

        if (score == -1)
            return score + depth;

        if (state.isMovesLeft(btns) == false)
            return 0;


        if (isMax) {
            int bestScore = -1;
            for (int i = 0; i < 9; i++) {
                if (btns[i].getIcon() == null) {
                    btns[i].setIcon(opponent);
                    score = minimax(btns, depth+1, isMax, character, opponent, win);
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
                    score = minimax(btns, depth+1, isMax, character, opponent, win);
                    btns[i].setIcon(null);
                    bestScore = min(score, bestScore);
                }
            }
            return bestScore;
        }
    }

}
