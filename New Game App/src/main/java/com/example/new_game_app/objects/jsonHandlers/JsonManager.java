package com.example.new_game_app.objects.jsonHandlers;
import com.example.new_game_app.GameInformation;

import java.util.LinkedList;

public class JsonManager {
    public static GameInformation foundedGame;
    public static boolean isGameFounded = false;
    public static LinkedList<GameInformation> games = new LinkedList<GameInformation>();
    public static boolean overWritedGame = false;
}
