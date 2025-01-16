package com.example.new_game_app;

public class EndGameInfo {
    static Player player1;
    static Player player2;
    static String motive;
    static int pastTime;

    public String getPlayer1Alias() { return player1.getAlias(); }

    public String getPlayer2Alias() {
        return player2.getAlias();
    }
}
