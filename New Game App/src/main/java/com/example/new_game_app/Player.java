package com.example.new_game_app;

import javafx.scene.control.Label;

public class Player {
    private String alias;
    private int score;
    private Holder holder;
    private boolean winner;
    private int wordsPut;

    public Player(String alias, int score, Holder holder, boolean winner, int wordsPut) {
        this.alias = alias;
        this.score = score;
        this.holder = holder;
        this.winner = winner;
        this.wordsPut = wordsPut;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void sumScore(int sum){
        this.score = (this.score + sum);
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public Holder getHolder() {
        return holder;
    }

    public int getWordsPut() {
        return wordsPut;
    }

    public void setWordsPut(int wordsPut) {
        this.wordsPut = wordsPut;
    }

    public void eraseAndRefillHolder(LettersToPut lettersToPut, Bag bag, int lettersNeeded){
        this.holder.removeLettersUsed(lettersToPut);
        this.holder.refillHolder(bag, lettersNeeded - this.holder.getHoldSize());
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public String showToken(int i){
        return holder.showToken(i);
    }

    public boolean equalsName(String name) {
        return this.alias.equals(name);
    }
}
