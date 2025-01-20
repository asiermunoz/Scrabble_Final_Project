package com.example.new_game_app;

import java.util.LinkedList;

public class MainMenuModel {
    public GameInformation searchGame(Player user1, Player user2, LinkedList<GameInformation> gamesInProgress) {
        GameInformation foundedGame;

        if (gamesInProgress == null) {
            throw new NoGamesInProgressException();
        }
        //Buscar partida en base al jugador 1
        for (int i = 0; i < gamesInProgress.size(); i++) {
            if (user1.equalsName(gamesInProgress.get(i).getPlayer1Alias())) {

                //Si se encuentra al jugador 1 se busca al jugador 2
                for (int j = 0; j < gamesInProgress.size(); j++) {
                    if (user2.equalsName(gamesInProgress.get(i).getPlayer2Alias())) {
                        foundedGame = gamesInProgress.get(i);
                        return foundedGame;
                    }
                }

                //Si no se encuentra se busca el user pero como jugador 2
            }
            else if (user1.equalsName(gamesInProgress.get(i).getPlayer2Alias())) {

                //Si se encuentra se busca al jugador 2
                for (int j = 0; j < gamesInProgress.size(); j++) {
                    if (user2.equalsName(gamesInProgress.get(i).getPlayer1Alias())) {
                        foundedGame = gamesInProgress.get(i);
                        return foundedGame;
                    }
                }

                //No se consiguio ninguno
            }

        }
        return null;
    }
}
