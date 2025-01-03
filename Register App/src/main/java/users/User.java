package users;

import users.exceptions.InvalidAliasException;
import users.exceptions.InvalidEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User{
    private String alias;
    private String email;

    //CONSTRUCTOR
    public User(String alias, String email1) {
        this.alias = alias;
        this.email = email1;
    }

    //GETTER Y SETTER
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {this.alias = alias;}
    public String getEmail(){ return email;}
    public void setEmail(String email) {this.email = email;}


    //METODOS
    public void validateAlias() throws InvalidAliasException {
        if (this.alias == null || this.alias.isEmpty()) {
            throw new InvalidAliasException();
        }
    }

    public void validateEmail() throws InvalidEmailException {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(this.email);
        if(! matcher.matches()){
            throw new InvalidEmailException();
        }
    }

}
