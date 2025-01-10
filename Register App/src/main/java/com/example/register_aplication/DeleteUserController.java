package com.example.register_aplication;

import javafx.fxml.FXML;


public class DeleteUserController {

    DeleteUserModel model = new DeleteUserModel();

    @FXML
    protected void Enter(){
        model.enter();
    }

    @FXML
    protected void exitPage (javafx.event.ActionEvent actionEvent){
        model.exit(actionEvent);
    }

}