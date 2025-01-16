package com.example.new_game_app;

import com.example.new_game_app.objects.jsonHandlers.JsonManager;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class OverwriteGameController {
    private ChangeSceneStrategy strategy = null;
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();

    @FXML
    public void onOverwriteButtonClick(javafx.event.ActionEvent actionEvent) {
        JsonManager.gameInProgress = null;
        JsonManager.isGameFounded = false;
        JsonManager.overWritedGame = true;
        strategy = new ChangeSceneryToGame();
        StageManager.menu.close();
        context.setStrategy(strategy);
        StageManager.game = context.change(actionEvent);
    }

    public void onCancelButtonClick() {
        StageManager.overwrite.close();
    }
}
