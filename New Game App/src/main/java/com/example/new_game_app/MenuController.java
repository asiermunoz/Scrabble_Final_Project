package com.example.new_game_app;

import javafx.fxml.FXML;

public class MenuController {
    private final ChangeSceneStrategy strategy = new ChangeSceneryToGame();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();

    @FXML
    protected void onExitButtonClick() {
        System.exit(0);
    }

    public void onNewGameButtonClick(javafx.event.ActionEvent actionEvent) {
        context.setStrategy(strategy);
        StageManager.game = context.change(actionEvent);
    }
}