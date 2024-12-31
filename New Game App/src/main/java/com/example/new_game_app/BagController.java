package com.example.new_game_app;

import javafx.fxml.FXML;

public class BagController {

    @FXML
    public void onCloseButtonClick(){
        StageManager.exit.close();
    }
}
