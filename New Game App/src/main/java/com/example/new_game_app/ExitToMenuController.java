package com.example.new_game_app;

import javafx.fxml.FXML;

public class ExitToMenuController {
    private final ChangeSceneStrategy strategy = new ChangeSceneryToMenu();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();

    @FXML
    public void onContinueButtonClick(){
        StageManager.exit.close();
    }

    public void onGoToMenuClick(javafx.event.ActionEvent actionEvent) {
        StageManager.exit.close();
        StageManager.game.close();
        context.setStrategy(strategy);
        context.change(actionEvent);
    }

}
