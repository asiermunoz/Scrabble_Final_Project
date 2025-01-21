package com.example.new_game_app.Exceptions;

public class LackOfCollisionException extends RuntimeException {
  public LackOfCollisionException() {
    super("Palabra ingresada no posee colisiones con otras palabras ni posee colisión con el centro del tablero.");
  }
}
