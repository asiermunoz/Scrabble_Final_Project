package com.example.register_aplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ModifyEmailController {

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

    ModifyEmailModel model = new ModifyEmailModel();

    @FXML
    protected void Enter() {
        model.enter(obtainOldEmail(), obtainNewEmail(), messageText);
    }

    @FXML
    protected void exitPage (javafx.event.ActionEvent actionEvent){
        model.exit(actionEvent);
    }
}
