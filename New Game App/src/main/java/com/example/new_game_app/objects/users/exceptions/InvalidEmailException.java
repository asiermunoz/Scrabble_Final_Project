package com.example.new_game_app.objects.users.exceptions;

public class InvalidEmailException extends Exception {

    //CONSTRUCTOR
    public InvalidEmailException() {}

    //ERROR
    public String messageInvalidEmailException(){
        return "INVALID EMAIL";
    }
}
