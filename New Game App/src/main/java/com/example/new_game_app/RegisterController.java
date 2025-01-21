package com.example.new_game_app;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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