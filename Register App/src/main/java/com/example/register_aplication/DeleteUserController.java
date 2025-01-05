package com.example.register_aplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.example.register_aplication.exceptions.InvalidAliasException;
import com.example.register_aplication.exceptions.InvalidEmailException;
import java.util.LinkedList;

public class DeleteUserController {
    LinkedList<User> listOfUsers = new LinkedList<User>();


    @FXML
    private TextField deleteAliasField;

    @FXML
    private TextField deleteEmailField;

    @FXML
    private Button deleteExitButton;

    @FXML
    private Label deleteMessageText;

    @FXML
    protected String obtainAlias(){
        return deleteAliasField.getText();
    }

    @FXML
    protected String obtainEmail(){
        return deleteEmailField.getText();
    }

    @FXML
    protected void Enter(){
        listOfUsers = JsonHandler.readFromJson();

        String email = obtainEmail();
        String alias = obtainAlias();
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

    @FXML
    protected void exitPage (){
        Stage stage = (Stage) deleteExitButton.getScene().getWindow();
        stage.close();
    }

}