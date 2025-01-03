package users.exceptions;

public class InvalidEmailException extends Exception {

    //CONSTRUCTOR
    public InvalidEmailException() {}

    //ERROR
    public String messageInvalidEmailException(){
        return "INVALID EMAIL";
    }
}
