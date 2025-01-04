package com.example.new_game_app;

public class EmptyBagException extends RuntimeException {
  public EmptyBagException() {
    super("La bolsa ha quedado vacía.");
  }
}