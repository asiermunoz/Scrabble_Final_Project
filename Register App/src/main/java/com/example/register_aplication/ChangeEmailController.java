package com.example.register_aplication;

import handler.JsonHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import users.User;
import users.exceptions.InvalidEmailException;

import java.util.LinkedList;

public class ChangeEmailController {
    LinkedList<User> listOfUsers = new LinkedList<User>();


    @FXML
    private TextField oldEmailField;

    @FXML
    private TextField newEmailField;

    @FXML
    private Button exitButton;

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

    @FXML
    protected void Enter() {
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

    @FXML
    protected void exitPage (){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
