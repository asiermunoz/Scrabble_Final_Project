package com.example.register_aplication;

import com.example.register_aplication.exceptions.InvalidAliasException;
import com.example.register_aplication.exceptions.InvalidEmailException;
import javafx.scene.control.Label;
import java.util.LinkedList;

public class DeleteUserModel {

    LinkedList<User> listOfUsers = new LinkedList<User>();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();
    private ChangeSceneStrategy strategy;


    public void enter(String obtainAlias, String obtainEmail, Label deleteMessageText) {
        listOfUsers = JsonHandler.readFromJson();

        String email = obtainEmail;
        String alias = obtainAlias;
        User user = new User(alias, email);
        boolean isValid = true;
        try {
            user.validateAlias();
        } catch (InvalidAliasException ex) {
            deleteMessageText.setText(ex.messageInvalidAliasException());
            isValid = false;
        }

        try {
            user.validateEmail();
        } catch (InvalidEmailException ex) {
            deleteMessageText.setText(ex.messageInvalidEmailException());
            isValid = false;
        }

        if (isValid) {
            boolean userFound = false;
            for (User u : listOfUsers) {
                if (u.getAlias().equals(alias) && u.getEmail().equals(email)) {
                    listOfUsers.remove(u);
                    userFound = true;
                    break;
                }
            }
            if (userFound) {
                JsonHandler.writeToJson(listOfUsers);
                deleteMessageText.setText("USER DELETED");
            } else {
                deleteMessageText.setText("USER NOT FOUND");
            }
        }
    }

    public void exit(javafx.event.ActionEvent actionEvent){
        strategy = new ChangeSceneToRegisterUser();
        context.setStrategy(strategy);
        context.change(actionEvent);
    }
}
