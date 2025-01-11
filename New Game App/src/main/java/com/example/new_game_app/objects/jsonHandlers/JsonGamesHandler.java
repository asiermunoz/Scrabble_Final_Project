package com.example.new_game_app.objects.jsonHandlers;

import com.example.new_game_app.EndGameInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonGamesHandler {
    private static Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();
    }

    public static void writeToJson(LinkedList<EndGameInfo> gamesList) {
        String payload = gson.toJson(gamesList);
        try {
            Files.write(Paths.get("games.json"), payload.getBytes());
        }
        catch (IOException ex) {
            Logger.getLogger(JsonGamesHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static LinkedList<EndGameInfo> readFromJson() {
        String recoveryPayload = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("games.json"));
            recoveryPayload = new String(bytes);
        } catch (IOException ex) {
            Logger.getLogger(JsonGamesHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        Type userListType = new TypeToken<LinkedList<EndGameInfo>>(){}.getType();
        return gson.fromJson(recoveryPayload, userListType);
    }

    public static void clearJsonFile() {
        try {
            // Sobrescribir el contenido del archivo con un JSON vacío
            Files.write(Paths.get("games.json"), "[]".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING); }
        catch (IOException ex) {
            Logger.getLogger(JsonGamesHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
