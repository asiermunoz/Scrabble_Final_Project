package users.exceptions;

public class InvalidAliasException extends Exception {

    //CONSTRUCTOR
    public InvalidAliasException() {}

    //ERROR
    public String messageInvalidAliasException(){
        return "INVALID ALIAS";
    }
}
