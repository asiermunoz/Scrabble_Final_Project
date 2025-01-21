package com.example.new_game_app;

import javafx.fxml.FXML;

public class ExitToMenuController {
    private final ChangeSceneStrategy strategy = new ChangeSceneryToMainMenu();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();

    @FXML
    public void onContinueButtonClick(){
        StageManager.exit.close();
    }

    public void onGoToMenuClick(javafx.event.ActionEvent actionEvent) {
        StageManager.exit.close();
        StageManager.game.close();
        StageManager.bag.close();
        StageManager.stadistics.close();
        context.setStrategy(strategy);
        context.change(actionEvent);
    }

}
