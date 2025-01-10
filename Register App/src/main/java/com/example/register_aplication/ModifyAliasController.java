package com.example.register_aplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ModifyAliasController {

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

    ModifyAliasModel model = new ModifyAliasModel();

    @FXML
    protected void Enter() {
        model.enter(obtainOldAlias(), obtainNewAlias(), messageText);
    }

    @FXML
    protected void exitPage (javafx.event.ActionEvent actionEvent){
        model.exit(actionEvent);
    }
}
