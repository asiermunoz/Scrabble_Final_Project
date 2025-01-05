package com.example.register_aplication.exceptions;

public class InvalidAliasException extends Exception {

    //CONSTRUCTOR
    public InvalidAliasException() {}

    //ERROR
    public String messageInvalidAliasException(){
        return "INVALID ALIAS";
    }
}
