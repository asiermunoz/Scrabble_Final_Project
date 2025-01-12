package com.example.new_game_app;

import com.example.new_game_app.objects.jsonHandlers.JsonManager;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class OverwriteGameController {
    @FXML
    public void onOverwriteButtonClick() {
        JsonManager.gameInProgress = null;
        JsonManager.isGameFounded = false;
        JsonManager.overWritedGame = true;



        StageManager.overwrite.close();
    }

    public void onCancelButtonClick() {
        StageManager.overwrite.close();
    }
}
