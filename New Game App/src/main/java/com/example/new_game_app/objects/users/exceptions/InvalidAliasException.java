package com.example.new_game_app.objects.users.exceptions;

public class InvalidAliasException extends Exception {

    //CONSTRUCTOR
    public InvalidAliasException() {}

    //ERROR
    public String messageInvalidAliasException(){
        return "INVALID ALIAS";
    }
}
