package com.example.register_aplication;

import com.example.register_aplication.exceptions.InvalidEmailException;
import javafx.scene.control.Label;
import java.util.LinkedList;

public class ModifyEmailModel {

    LinkedList<User> listOfUsers = new LinkedList<User>();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();
    private ChangeSceneStrategy strategy;

    public void enter(String obtainOldEmail, String obtainNewEmail, Label messageText){
        listOfUsers = JsonHandler.readFromJson();

        //validate email
        String oldEmail = obtainOldEmail;
        String newEmail = obtainNewEmail;
        boolean isValid = true;
        boolean emailFound = false;

        try {
            if (oldEmail == null || oldEmail.isEmpty()) {
                throw new InvalidEmailException();
            }
        } catch (InvalidEmailException ex) {
            messageText.setText("INVALID OLD EMAIL");
            isValid = false;
        }

        try {
            if (newEmail == null || newEmail.isEmpty() || newEmail.equals(oldEmail)) {
                throw new InvalidEmailException();
            }
        } catch (InvalidEmailException ex) {
            messageText.setText("INVALID NEW EMAIL");
            isValid = false;
        }


        if(isValid) {
            for (User u : listOfUsers) {
                if (u.getEmail().equals(oldEmail)) {
                    u.setEmail(newEmail);
                    JsonHandler.writeToJson(listOfUsers);
                    messageText.setText("EMAIL CHANGED");
                    emailFound = true;
                    break;
                }
            }

            if(!emailFound){
                messageText.setText("EMAIL NOT FOUND");
            }
        }
    }

    public void exit(javafx.event.ActionEvent actionEvent){
        strategy = new ChangeSceneToRegisterUser();
        context.setStrategy(strategy);
        context.change(actionEvent);
    }
}
