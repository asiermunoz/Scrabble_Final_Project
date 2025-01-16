package com.example.new_game_app;

public class InexistentWord extends RuntimeException {
    public InexistentWord() {
        super("La palabra ingresada no existe. Intentelo de nuevo.");
    }
}
