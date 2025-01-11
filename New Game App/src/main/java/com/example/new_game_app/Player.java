package com.example.new_game_app;

public class Player {
    private String alias;
    private int score;
    private Holder holder;
    private boolean winner;

    public Player(String alias, int score, Holder holder, boolean winner) {
        this.alias = alias;
        this.score = score;
        this.holder = holder;
        this.winner = winner;
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

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public Holder getHolder() {
        return holder;
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
