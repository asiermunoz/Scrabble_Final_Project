package com.example.new_game_app;

import java.util.ArrayList;

public class LettersHold{
    protected ArrayList<Letter> hold = new ArrayList<>();

    public void setHold(ArrayList<Letter> hold) {
        this.hold = hold;
    }

    public int getHoldSize(){
        return hold.size();
    }

    public void addLetter(Letter letter){
        this.hold.addLast(letter);
    }

    public boolean holdIsEmpty(){
        return hold.isEmpty();
    }

    public String takeFirstLetter(){
        String first = hold.getFirst().getLink();
        hold.removeFirst();
        return first;
    }

    public void clearHold(){
        hold.clear();
    }
}