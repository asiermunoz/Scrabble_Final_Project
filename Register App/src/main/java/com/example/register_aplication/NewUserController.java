package com.example.register_aplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class NewUserController {
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

    NewUserModel model = new NewUserModel();


    @FXML
    protected void Enter(){
        model.enter(obtainAlias(), obtainEmail(), messageText);
    }

    @FXML
    protected void exitPage (javafx.event.ActionEvent actionEvent){
        model.exit(actionEvent);
    }

}
