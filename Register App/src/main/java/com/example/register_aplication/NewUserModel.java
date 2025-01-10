package com.example.register_aplication;

import com.example.register_aplication.exceptions.InvalidAliasException;
import com.example.register_aplication.exceptions.InvalidEmailException;
import javafx.scene.control.Label;
import java.util.LinkedList;

public class NewUserModel {

    LinkedList<User> listOfUsers = new LinkedList<User>();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();
    private ChangeSceneStrategy strategy;


    public void enter(String obtainAlias, String obtainEmail, Label messageText) {
        listOfUsers = JsonHandler.readFromJson();
        if (listOfUsers == null) {
            listOfUsers = new LinkedList<User>();
        }

        //validate email
        String email = obtainEmail;
        String alias = obtainAlias;
        User user = new User(alias, email);
        boolean isValid = true;
        try {
            user.validateAlias();
        } catch (InvalidAliasException ex) {
            messageText.setText(ex.messageInvalidAliasException());
            isValid = false;
        }

        try {
            user.validateEmail();
        } catch (InvalidEmailException ex) {
            messageText.setText(ex.messageInvalidEmailException());
            isValid = false;
        }

        for (User u : listOfUsers) {
            if (u.getAlias().equals(alias)) {
                isValid = false;
                messageText.setText("ALIAS ALREADY EXIST");
            }
            if (u.getEmail().equals(email)) {
                isValid = false;
                messageText.setText("EMAIL ALREADY EXIST");
            }
        }

        if(isValid) {
            listOfUsers.add(user);
            JsonHandler.writeToJson(listOfUsers);
            messageText.setText("USER ADDED");
        }
    }

    public void exit(javafx.event.ActionEvent actionEvent){
        strategy = new ChangeSceneToRegisterUser();
        context.setStrategy(strategy);
        context.change(actionEvent);
    }
}
