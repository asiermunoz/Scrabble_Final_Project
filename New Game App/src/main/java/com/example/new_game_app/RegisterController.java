package com.example.new_game_app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    private final ChangeSceneStrategy strategy = new ChangeSceneryToMenu();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();

    @FXML
    private TextField User1;

    @FXML
    private TextField Gmail1;

    @FXML
    private TextField User2;

    @FXML
    private TextField Gmail2;

    public void onFinishButtonClick(javafx.event.ActionEvent actionEvent) {
        context.setStrategy(strategy);
        context.change(actionEvent);
    }
}