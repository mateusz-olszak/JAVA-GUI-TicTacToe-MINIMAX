package com.company;
import javax.swing.*;
import javax.xml.stream.StreamFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.*;
public class Win{
    public int if_win(ImageIcon character,ImageIcon opponent,JButton btns[]){
        //horizontally
        if (btns[0].getIcon() == character && btns[1].getIcon() == character && btns[2].getIcon() == character && btns[0].getIcon() != null || btns[3].getIcon() == character && btns[4].getIcon() == character && btns[5].getIcon() == character && btns[3].getIcon() != null || btns[6].getIcon() == character && btns[7].getIcon() == character && btns[8].getIcon() == character && btns[7].getIcon() != null) {
            return -1;
        }
        if (btns[0].getIcon() == opponent && btns[1].getIcon() == opponent && btns[2].getIcon() == opponent && btns[0].getIcon() != null || btns[3].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == opponent && btns[3].getIcon() != null || btns[6].getIcon() == opponent && btns[7].getIcon() == opponent && btns[8].getIcon() == opponent && btns[6].getIcon() != null) {
            return 1;
        }

        // vertically
        if (btns[0].getIcon() == character && btns[3].getIcon() == character && btns[6].getIcon() == character && btns[0].getIcon() != null || btns[1].getIcon() == character && btns[4].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() != null || btns[2].getIcon() == character && btns[5].getIcon() == character && btns[8].getIcon() == character && btns[2].getIcon() != null) {
            return -1;
        }
        if (btns[0].getIcon() == opponent && btns[3].getIcon() == opponent && btns[6].getIcon() == opponent && btns[0].getIcon() != null || btns[1].getIcon() == opponent && btns[4].getIcon() == opponent && btns[7].getIcon() == opponent && btns[1].getIcon() != null || btns[2].getIcon() == opponent && btns[5].getIcon() == opponent && btns[8].getIcon() == opponent && btns[2].getIcon() != null) {
            return 1;
        }

        //diagonally
        if (btns[0].getIcon() == character && btns[4].getIcon() == character && btns[8].getIcon() == character && btns[0].getIcon() != null || btns[2].getIcon() == character && btns[4].getIcon() == character && btns[6].getIcon() == character && btns[2].getIcon() != null) {
            return -1;
        }
        if (btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[8].getIcon() == opponent && btns[0].getIcon() != null || btns[2].getIcon() == opponent && btns[4].getIcon() == opponent && btns[6].getIcon() == opponent && btns[2].getIcon() != null) {
            return 1;
        }

        return 0;
    }
    public boolean tie(ImageIcon character,ImageIcon opponent,JButton btns[],JLabel label){
        if(btns[0].getIcon() != null && btns[1].getIcon() != null && btns[2].getIcon() != null && btns[3].getIcon() != null && btns[4].getIcon() != null && btns[5].getIcon() != null && btns[6].getIcon() != null && btns[7].getIcon() != null && btns[8].getIcon() != null && win(character,opponent,btns,label) == true)
        {
            label.setText("It's a tie");
            return true;
        }
        return false;
    }
    public boolean win(ImageIcon character,ImageIcon opponent,JButton btns[],JLabel label){
        //horizontally
        if (btns[0].getIcon() == character && btns[1].getIcon() == character && btns[2].getIcon() == character && btns[0].getIcon() != null || btns[3].getIcon() == character && btns[4].getIcon() == character && btns[5].getIcon() == character && btns[3].getIcon() != null || btns[6].getIcon() == character && btns[7].getIcon() == character && btns[8].getIcon() == character && btns[7].getIcon() != null) {
            label.setText("Player wins");
            return false;
        }
        if (btns[0].getIcon() == opponent && btns[1].getIcon() == opponent && btns[2].getIcon() == opponent && btns[0].getIcon() != null || btns[3].getIcon() == opponent && btns[4].getIcon() == opponent && btns[5].getIcon() == opponent && btns[3].getIcon() != null || btns[6].getIcon() == opponent && btns[7].getIcon() == opponent && btns[8].getIcon() == opponent && btns[6].getIcon() != null) {
            label.setText("Opponent wins");
            return false;
        }
        // vertically
        if (btns[0].getIcon() == character && btns[3].getIcon() == character && btns[6].getIcon() == character && btns[0].getIcon() != null || btns[1].getIcon() == character && btns[4].getIcon() == character && btns[7].getIcon() == character && btns[1].getIcon() != null || btns[2].getIcon() == character && btns[5].getIcon() == character && btns[8].getIcon() == character && btns[2].getIcon() != null) {
            label.setText("Player wins");
            return false;
        }
        if (btns[0].getIcon() == opponent && btns[3].getIcon() == opponent && btns[6].getIcon() == opponent && btns[0].getIcon() != null || btns[1].getIcon() == opponent && btns[4].getIcon() == opponent && btns[7].getIcon() == opponent && btns[1].getIcon() != null || btns[2].getIcon() == opponent && btns[5].getIcon() == opponent && btns[8].getIcon() == opponent && btns[2].getIcon() != null) {
            label.setText("Opponent wins");
            return false;
        }

        //diagonally
        if (btns[0].getIcon() == character && btns[4].getIcon() == character && btns[8].getIcon() == character && btns[0].getIcon() != null || btns[2].getIcon() == character && btns[4].getIcon() == character && btns[6].getIcon() == character && btns[2].getIcon() != null) {
            label.setText("Player wins");
            return false;
        }
        if (btns[0].getIcon() == opponent && btns[4].getIcon() == opponent && btns[8].getIcon() == opponent && btns[0].getIcon() != null || btns[2].getIcon() == opponent && btns[4].getIcon() == opponent && btns[6].getIcon() == opponent && btns[2].getIcon() != null) {
            label.setText("Opponent wins");
            return false;
        }
        return true;
    }
    public void who_wins(ImageIcon character,ImageIcon opponent,JButton btns[],JLabel label){
        if(win(character,opponent,btns,label) != true) for(int i=0; i<9; i++) btns[i].setEnabled(false);
        if(tie(character,opponent,btns,label) == true) for(int i=0; i<9; i++) btns[i].setEnabled(false);
    }
}