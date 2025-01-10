package com.example.register_aplication;

import javafx.fxml.FXML;


public class NewUserController {

    NewUserModel model = new NewUserModel();


    @FXML
    protected void Enter(){
        model.enter();
    }

    @FXML
    protected void exitPage (javafx.event.ActionEvent actionEvent){
        model.exit(actionEvent);
    }

}
