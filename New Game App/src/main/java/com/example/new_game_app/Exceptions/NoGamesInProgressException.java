package com.example.new_game_app.Exceptions;

public class NoGamesInProgressException extends RuntimeException {
    public NoGamesInProgressException() {
        super("No se han encontrado partidas jugadas previas.");
    }
}
