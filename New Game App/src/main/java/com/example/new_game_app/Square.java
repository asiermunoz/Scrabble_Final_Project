package com.example.new_game_app;


import java.awt.*;

public class Square{
    protected Letter letter;
    protected boolean marked;
    protected int x;
    protected int y;

    public Square(int y, int x){
        this.letter = new Letter ("  ", 0);
        this.x = x;
        this.y = y;
        this. marked = false;
    }

    public String getLetter() {
        return letter.getLink();
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public int getValue() {
        return letter.getValue();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}