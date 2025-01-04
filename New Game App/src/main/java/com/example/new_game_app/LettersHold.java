package com.example.new_game_app;

import java.util.ArrayList;

public abstract class LettersHold{
    protected ArrayList<Letter> hold = new ArrayList<>();

    public ArrayList<Letter> getHold() {
        return hold;
    }

    public void setHold(ArrayList<Letter> hold) {
        this.hold = hold;
    }

    public int getHoldSize(){
        return hold.size();
    }

    public void addLetter(Letter letter){
        this.hold.addLast(letter);
    }

    public void removeLetter(){
        this.hold.removeLast();
    }
}