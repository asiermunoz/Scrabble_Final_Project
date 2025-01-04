package com.example.new_game_app;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstPlayer1 implements FirstOne{

    @Override
    public ArrayList<Player> setFirst(Player player1, Player player2) {
        return new ArrayList<>(Arrays.asList(player1,player2));
    }
}
