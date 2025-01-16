package com.example.new_game_app;

import java.util.ArrayList;

public class LettersToPut extends LettersHold{
    protected ArrayList<Letter> lettersUsed = new ArrayList<>();

    public boolean holdIsEmpty(){
        return hold.isEmpty();
    }

    public Letter takeFirstLetter(){
        Letter first = hold.getFirst();
        lettersUsed.add(hold.getFirst());
        hold.removeFirst();
        return first;
    }

    public void clearHold(){
        hold.clear();
        lettersUsed.clear();
    }

    public ArrayList<Letter> getLettersUsed() {
        return lettersUsed;
    }
}
