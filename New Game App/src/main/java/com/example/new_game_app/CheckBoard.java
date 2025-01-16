package com.example.new_game_app;

import java.util.ArrayList;
import java.util.Objects;

public class CheckBoard {
    private Board board;
    private int score;
    private int wordsFound;
    private int lettersMarked;
    private Bonus bonus;
    private String message;
    private boolean scrabble;
    private boolean completeWord;

    public CheckBoard(Board board) {
        bonus = new Bonus();
        this.board = board;
        this.scrabble = false;
        this.completeWord = false;
        this.wordsFound = 0;
        this.score = 0;
        this.lettersMarked = 0;
    }

    public int getScore() {
        return score;
    }

    public int getWordsFound() {
        return wordsFound;
    }

    public String getMessage() {
        return message;
    }

    public boolean check(){
        boolean collision = false;
        int doubleLetterBoost = 0;
        int tripleLetterBoost = 0;
        int doubleWordBoost = 0;
        int tripleWordBoost = 0;
        try {
            for (int i = 0; i < board.getLength(); i++) {
                for (int j = 0; j < board.getLength(); j++) {
                    if (board.getTable()[i][j].marked) {
                        if (board.getTable()[i][j] instanceof CentralSquare) {
                            collision = true;
                            doubleWordBoost++;
                        }
                        if (board.getTable()[i][j] instanceof DoubleLetterSquare) {
                            doubleLetterBoost = doubleLetterBoost + board.getTable()[i][j].letter.getValue();
                        }
                        if (board.getTable()[i][j] instanceof TripleLetterSquare) {
                            tripleLetterBoost = tripleLetterBoost + board.getTable()[i][j].letter.getValue();
                        }
                        if (board.getTable()[i][j] instanceof DoubleWordSquare) {
                            doubleWordBoost++;
                        }
                        if (board.getTable()[i][j] instanceof TripleWordSquare) {
                            tripleWordBoost++;
                        }
                        if (!collision) {
                            collision = reviseCollision(i, j);
                        }
                    }
                }
            }
            if (!collision) {
                throw new LackOfCollisionException();
            }
            if(!read()){
                throw new InexistentWord();
            }
            if(scrabble){
                score = bonus.scrabbleBonus(score);
            }
            if(doubleLetterBoost != 0){
                score = score + bonus.doubleLetterBonus(doubleLetterBoost);
            }
            if(tripleLetterBoost != 0){
                score = score + bonus.tripleLetterBonus(doubleLetterBoost);
            }
            if(doubleWordBoost != 0){
                score = bonus.doubleWordBonus(score, doubleWordBoost);
            }
            if(tripleWordBoost != 0){
                score = bonus.tripleWordBonus(score, tripleWordBoost);
            }
            this.board.setMarkersFalse();
            message = bonus.getMessage();
            return true;
        }catch (LackOfCollisionException | InexistentWord e){
            this.message = e.getMessage();
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean read() {
        boolean exists;
        exists = readHorizontal();
        if(exists){
            exists = readVertical();
        }
        if(!completeWord){
            exists = false;
        }
        if(lettersMarked == 7){
            scrabble = true;
        }
        return exists;
    }

    public boolean readHorizontal(){
        boolean enter = false;
        int copyScore = 0;
        ArrayList<Letter> letters = new ArrayList<>();
        for (int i = 0; i < board.getLength(); i++){
            for(int j = 0; j < board.getLength(); j++){
                if (!Objects.equals(board.getTable()[i][j].letter.getLink(), "  ")) {
                    letters.add(board.getTable()[i][j].letter);
                    copyScore = copyScore + board.getTable()[i][j].getValue();
                    if(board.getTable()[i][j].marked){
                        enter = true;
                        lettersMarked++;
                    }
                }
                else{
                    if((letters.size() > 1 && enter)){
                        if(readWord(letters)){
                            this.score = this.score + copyScore;
                            letters = new ArrayList<>();
                            copyScore = 0;
                            completeWord = true;
                        }
                        else{
                            return false;
                        }
                    }
                    else{
                        copyScore = 0;
                        letters = new ArrayList<>();
                        enter = false;
                    }
                }
            }
        }
        return true;
    }

    public boolean readVertical(){
        boolean enter = false;
        int copyScore = 0;
        ArrayList<Letter> letters = new ArrayList<>();
        for (int i = 0; i < board.getLength(); i++){
            for(int j = 0; j < board.getLength(); j++){
                if (!Objects.equals(board.getTable()[j][i].letter.getLink(), "  ")) {
                    letters.add(board.getTable()[j][i].letter);
                    copyScore = copyScore + board.getTable()[j][i].getValue();
                    if(board.getTable()[j][i].marked){
                        enter = true;
                        lettersMarked++;
                    }
                }
                else{
                    if((letters.size() > 1 && enter)){
                        if(readWord(letters)){
                            this.score = this.score + copyScore;
                            letters = new ArrayList<>();
                            copyScore = 0;
                            completeWord = true;
                        }
                        else{
                            return false;
                        }
                    }
                    else{
                        copyScore = 0;
                        letters = new ArrayList<>();
                        enter = false;
                    }
                }
            }
        }
        return true;
    }

    public boolean readWord(ArrayList<Letter> letters){
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getLetter().toLowerCase());
        }
        wordsFound++;
        return new WordChecker().checkWord(String.valueOf(word));
    }

    public boolean reviseCollision(int y, int x){
        for (int i = 0; i < board.getLength(); i++){
            for(int j = 0; j < board.getLength(); j++){
                if(!Objects.equals(board.getTable()[i][j].letter.getLink(), "  ") && !board.getTable()[i][j].marked){
                    if((i == y+1 && j == x) || (i==y-1 && j == x) || (i == y && j == x+1) || (i == y && j == x-1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
