package com.example.new_game_app;

import javafx.fxml.FXML;
import javafx.stage.Stage;

import javax.swing.*;

public class GameController {
    private final PopUpSelected popUpselected = new PopUpSelected();

    public GameController() {
        StageManager.exit = new Stage();
        StageManager.bag = new Stage();
        StageManager.stadistics = new Stage();
    }

    @FXML
    protected void onExitToMenuButtonClick() {
        PopUpCommand command = new PopUpExit();
        popUpselected.setCommand(command);
        StageManager.exit = popUpselected.buttonPressed();
    }

    @FXML
    protected void onBagButtonClick() {
        PopUpCommand command = new PopUpBag();
        popUpselected.setCommand(command);
        StageManager.bag = popUpselected.buttonPressed();
    }

    @FXML
    protected void onStadisticsButtonClick() {
        PopUpCommand command = new PopUpStadistics();
        popUpselected.setCommand(command);
        StageManager.stadistics = popUpselected.buttonPressed();
    }
}