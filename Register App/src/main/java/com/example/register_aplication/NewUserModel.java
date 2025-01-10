package com.example.register_aplication;

import com.example.register_aplication.exceptions.InvalidAliasException;
import com.example.register_aplication.exceptions.InvalidEmailException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class NewUserModel {

    LinkedList<User> listOfUsers = new LinkedList<User>();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();
    private ChangeSceneStrategy strategy;

    @FXML
    private TextField aliasField;

    @FXML
    private TextField emailField;

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




    public void enter(){
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

    public void exit(javafx.event.ActionEvent actionEvent){
        strategy = new ChangeSceneToRegisterUser();
        context.setStrategy(strategy);
        context.change(actionEvent);
    }
}
