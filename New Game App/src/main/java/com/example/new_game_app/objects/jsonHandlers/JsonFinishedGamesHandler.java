package com.example.new_game_app.objects.jsonHandlers;

import com.example.new_game_app.GameInformation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonFinishedGamesHandler {
    private static Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();
    }

    public static void writeToJson(LinkedList<GameInformation> gamesList) {
        String payload = gson.toJson(gamesList);
        try {
            Files.write(Paths.get("finishedGames.json"), payload.getBytes());
        }
        catch (IOException ex) {
            Logger.getLogger(JsonFinishedGamesHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static LinkedList<GameInformation> readFromJson() {
        String recoveryPayload = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("finishedGames.json"));
            recoveryPayload = new String(bytes);
        } catch (IOException ex) {
            Logger.getLogger(JsonFinishedGamesHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        Type userListType = new TypeToken<LinkedList<GameInformation>>(){}.getType();
        return gson.fromJson(recoveryPayload, userListType);
    }
}
