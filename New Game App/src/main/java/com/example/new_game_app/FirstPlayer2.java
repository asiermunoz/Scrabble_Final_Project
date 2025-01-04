package com.example.new_game_app;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstPlayer2 implements FirstOne{

    @Override
    public ArrayList<Player> setFirst(Player player1, Player player2) {
        return new ArrayList<>(Arrays.asList(player2,player1));
    }
}
