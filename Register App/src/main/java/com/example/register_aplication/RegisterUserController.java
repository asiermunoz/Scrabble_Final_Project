package com.example.register_aplication;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterUserController {

    @FXML
    private Button NweUserButton;

    private final ChangeSceneryToContext context = new ChangeSceneryToContext();
    private ChangeSceneStrategy strategy;

    @FXML
    protected void onButtonNewUser(javafx.event.ActionEvent actionEvent) {
        strategy = new ChangeSceneToNewUser();
        context.setStrategy(strategy);
        context.change(actionEvent);

    }

    @FXML
    protected void onButtonChangeName(javafx.event.ActionEvent actionEvent) {

    }

    @FXML
    protected void onButtonChangeEmail(javafx.event.ActionEvent actionEvent) {

    }

    @FXML
    protected void onButtonDeleteUser(javafx.event.ActionEvent actionEvent) {
        strategy = new ChangeSceneToDeleteUser();
        context.setStrategy(strategy);
        context.change(actionEvent);
    }


    @FXML
    protected void exitPage (){
        Platform.exit();
    }
}
