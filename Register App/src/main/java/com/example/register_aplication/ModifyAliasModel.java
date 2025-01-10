package com.example.register_aplication;

import com.example.register_aplication.exceptions.InvalidAliasException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.LinkedList;

public class ModifyAliasModel {

    LinkedList<User> listOfUsers = new LinkedList<User>();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();
    private ChangeSceneStrategy strategy;

    @FXML
    private TextField oldAliasField;

    @FXML
    private TextField newAliasField;

    @FXML
    private Button exitButton;

    @FXML
    private Label messageText;

    @FXML
    protected String obtainOldAlias(){
        return oldAliasField.getText();
    }

    @FXML
    protected String obtainNewAlias(){
        return newAliasField.getText();
    }

    public void enter(){
        listOfUsers = JsonHandler.readFromJson();

        //validate email
        String oldAlias = obtainOldAlias();
        String newAlias = obtainNewAlias();
        boolean isValid = true;
        boolean aliasFound = false;

        try {
            if (oldAlias == null || oldAlias.isEmpty()) {
                throw new InvalidAliasException();
            }
        } catch (InvalidAliasException ex) {
            messageText.setText("INVALID OLD ALIAS");
            isValid = false;
        }

        try {
            if (newAlias == null || newAlias.isEmpty() || newAlias.equals(oldAlias)) {
                throw new InvalidAliasException();
            }
        } catch (InvalidAliasException ex) {
            messageText.setText("INVALID NEW ALIAS");
            isValid = false;
        }


        if(isValid) {
            for (User u : listOfUsers) {
                if (u.getAlias().equals(oldAlias)) {
                    u.setAlias(newAlias);
                    JsonHandler.writeToJson(listOfUsers);
                    messageText.setText("ALIAS CHANGED");
                    aliasFound = true;
                    break;
                }
            }

            if(!aliasFound){
                messageText.setText("ALIAS NOT FOUND");
            }
        }
    }

    public void exit(javafx.event.ActionEvent actionEvent) {
        strategy = new ChangeSceneToRegisterUser();
        context.setStrategy(strategy);
        context.change(actionEvent);
    }
}
