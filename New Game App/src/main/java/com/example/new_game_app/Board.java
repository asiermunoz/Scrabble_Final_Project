package com.example.new_game_app;

import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Objects;

public class Board {
    private final int length = 15;
    private final Square[][] table = new Square[length][length];
    private ArrayList<Letter> oldBoardLetters = new ArrayList<>();

    public Board(){
        int central = length/2;
        for(int i = 0; i<length; i++){
            for(int j = 0; j<length; j++){
                if(i==central && j==central){
                    table[i][j] = new CentralSquare(i,j);
                }
                else {
                    table[i][j] = new NormalSquare(i, j);
                }
            }
        }
        for(int i = 0; i < length; i++){
            if(i == 0 || i == length - 1) {
                table[i][i] = new TripleWordSquare(i, i);
            }
            else if(i == 5 || i == 9){
                table[i][i] = new TripleLetterSquare(i,i);
            }
            else if(i == 6 || i == 8){
                table[i][i] = new DoubleLetterSquare(i,i);
            }
            else if (i != central){
                table[i][i] = new DoubleWordSquare(i,i);
            }
        }

        int i = 0;
        for(int j = length-1; j >=0; j--){
            if(j == 0 || j == length - 1) {
                table[i][j] = new TripleWordSquare(i,j);
            }
            else if(j == 5 || j == 9){
                table[i][j] = new TripleLetterSquare(i,j);
            }
            else if(j == 6 || j == 8){
                table[i][j] = new DoubleLetterSquare(i,j);
            }
            else if (j != central){
                table[i][j] = new DoubleWordSquare(i,j);
            }
            i++;
        }
        table[0][0] = new TripleWordSquare(0, 0);
        table[0][14] = new TripleWordSquare(0, 14);
        table[14][0] = new TripleWordSquare(14, 0);
        table[14][14] = new TripleWordSquare(14, 14);

        table[0][3] = new DoubleLetterSquare(0, 3);
        table[3][0] = new DoubleLetterSquare(3, 0);
        table[3][14] = new DoubleLetterSquare(3, 14);
        table[14][3] = new DoubleLetterSquare(14, 3);
        table[0][11] = new DoubleLetterSquare(0, 11);
        table[11][0] = new DoubleLetterSquare(11, 0);
        table[11][14] = new DoubleLetterSquare(11, 14);
        table[14][11] = new DoubleLetterSquare(14, 11);
        table[1][5] = new TripleLetterSquare(1, 5);
        table[5][1] = new TripleLetterSquare(5, 1);
        table[1][9] = new TripleLetterSquare(1, 9);
        table[9][1] = new TripleLetterSquare(9, 1);
        table[5][13] = new TripleLetterSquare(5, 13);
        table[13][5] = new TripleLetterSquare(13, 5);
        table[9][13] = new TripleLetterSquare(9, 13);
        table[13][9] = new TripleLetterSquare(13, 9);
        table[6][12] = new DoubleLetterSquare(6, 12);
        table[12][6] = new DoubleLetterSquare(12, 6);
        table[6][2] = new DoubleLetterSquare(6, 2);
        table[2][6] = new DoubleLetterSquare(2, 6);
        table[8][2] = new DoubleLetterSquare(8, 2);
        table[2][8] = new DoubleLetterSquare(2, 8);
        table[8][12] = new DoubleLetterSquare(8, 12);
        table[12][8] = new DoubleLetterSquare(12, 8);
        table[central][3] = new DoubleLetterSquare(central, 3);
        table[3][central] = new DoubleLetterSquare(3, central);
        table[central][11] = new DoubleLetterSquare(central, 11);
        table[11][central] = new DoubleLetterSquare(11, central);
        table[0][central] = new TripleWordSquare(0, central);
        table[14][central] = new TripleWordSquare(14,central);
        table[central][0] = new TripleWordSquare(central, 0);
        table[central][14] = new TripleWordSquare(central, 0);
    }

    public int getLength() {
        return length;
    }

    public Square[][] getTable() {
        return table;
    }

    public void addTokenToTable(int index, Letter letter){
        int boardIndex = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(boardIndex == index){
                    table[i][j].setLetter(letter);
                    table[i][j].marked = true;
                }
                boardIndex++;
            }
        }
    }

    public ArrayList<ImageView> returnNotUsedTokens (ArrayList<ImageView> tableImages){
        int boardIndex = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(table[i][j].marked){
                    tableImages.get(boardIndex).setImage(null);
                    table[i][j].clearLetter();
                }
                boardIndex++;
            }
        }
        return tableImages;
    }

    public void setMarkersFalse(){
        for (int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                table[i][j].marked = false;
            }
        }
    }

    public ArrayList<Integer> fillOldBoard(){
        ArrayList<Integer> oldBoard = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(!Objects.equals(table[i][j].getLink(), "  ")){
                    oldBoard.add(index);
                    oldBoardLetters.add(table[i][j].letter);
                }
                index++;
            }
        }
        return oldBoard;
    }

    public String getOldBoardFirstLink() {
        Letter letter = oldBoardLetters.getFirst();
        oldBoardLetters.removeFirst();
        return letter.getLink();
    }
}