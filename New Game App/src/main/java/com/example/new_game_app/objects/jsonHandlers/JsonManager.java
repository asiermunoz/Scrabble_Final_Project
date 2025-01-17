package com.example.new_game_app.objects.jsonHandlers;
import com.example.new_game_app.GameInformation;

import java.util.LinkedList;

public class JsonManager {
    public static boolean isGameFounded = false;
    public static LinkedList<GameInformation> games = new LinkedList<GameInformation>();
    public static LinkedList<GameInformation> finishedGames = new LinkedList<GameInformation>();
    public static boolean overWritedGame = false;
    public static GameInformation gameInProgress;
    public static boolean newGameNeeded = true;
}
