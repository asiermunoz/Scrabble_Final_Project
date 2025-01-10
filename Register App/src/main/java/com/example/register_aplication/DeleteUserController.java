package com.example.register_aplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class DeleteUserController {

    @FXML
    private TextField deleteAliasField;

    @FXML
    private TextField deleteEmailField;

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

    DeleteUserModel model = new DeleteUserModel();

    @FXML
    protected void Enter(){ model.enter(obtainAlias(), obtainEmail(), deleteMessageText);}

    @FXML
    protected void exitPage (javafx.event.ActionEvent actionEvent){ model.exit(actionEvent);}

}