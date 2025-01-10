package com.example.register_aplication;

import javafx.fxml.FXML;


public class ModifyEmailController {
    ModifyEmailModel model = new ModifyEmailModel();

    @FXML
    protected void Enter() {
        model.enter();
    }

    @FXML
    protected void exitPage (javafx.event.ActionEvent actionEvent){
        model.exit(actionEvent);
    }
}
