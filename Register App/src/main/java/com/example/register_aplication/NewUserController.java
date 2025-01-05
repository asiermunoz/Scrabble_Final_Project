package com.example.register_aplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.example.register_aplication.exceptions.InvalidAliasException;
import com.example.register_aplication.exceptions.InvalidEmailException;
import java.util.LinkedList;

public class NewUserController {
    LinkedList<User> listOfUsers = new LinkedList<User>();


    @FXML
    private TextField aliasField;

    @FXML
    private TextField emailField;

    @FXML
    private Button exitButton;

    @FXML
    private Label messageText;

    @FXML
    protected String obtainAlias(){
        return aliasField.getText();
    }

    @FXML
    protected String obtainEmail(){
        return emailField.getText();
    }

    @FXML
    protected void Enter(){
        listOfUsers = JsonHandler.readFromJson();
        if (listOfUsers == null) {
            listOfUsers = new LinkedList<User>();
        }

        //validate email
        String email = obtainEmail();
        String alias = obtainAlias();
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

    @FXML
    protected void exitPage (){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
