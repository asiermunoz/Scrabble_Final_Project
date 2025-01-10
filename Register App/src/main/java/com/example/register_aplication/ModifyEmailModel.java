package com.example.register_aplication;

import com.example.register_aplication.exceptions.InvalidEmailException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class ModifyEmailModel {
    LinkedList<User> listOfUsers = new LinkedList<User>();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();
    private ChangeSceneStrategy strategy;


    @FXML
    private TextField oldEmailField;

    @FXML
    private TextField newEmailField;

    @FXML
    private Label messageText;

    @FXML
    protected String obtainOldEmail(){
        return oldEmailField.getText();
    }

    @FXML
    protected String obtainNewEmail(){
        return newEmailField.getText();
    }

    public void enter(){
        listOfUsers = JsonHandler.readFromJson();

        //validate email
        String oldEmail = obtainOldEmail();
        String newEmail = obtainNewEmail();
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
