package com.example.new_game_app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

    //FXML Variables

    @FXML
    private Button createNewGameButton;
    @FXML
    private Button loadGameButton;
    @FXML
    private Button showStadisticsButton;
    @FXML
    private Button exitButton;

    //Java Variables
    private ChangeSceneStrategy strategy = null;
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();
    private final PopUpSelected popUpselected = new PopUpSelected();
    private final MainMenuModel model = new MainMenuModel();
    private boolean gameAlreadyCreated;
    private EndGameInfo foundedGame = null;
    private EndGameInfo gamePlayed;

    //Methods
    @FXML
    public void onExitClick() {
        System.exit(0);
    }

    public void initialize(){

    }

    public void onReturnToLoginButtonClick(javafx.event.ActionEvent actionEvent){
        this.strategy = new ChangeSceneryToLoginMenu();
        context.setStrategy(strategy);
        context.change(actionEvent);

    }

    public void onNewGameButtonClick(javafx.event.ActionEvent actionEvent) {
        strategy = new ChangeSceneryToGame();
        context.setStrategy(strategy);
        StageManager.game = context.change(actionEvent);
    }

    public void onShowStadisticsButtonClick(javafx.event.ActionEvent actionEvent) {
        PopUpCommand command = new PopUpStadisticsInMenu();
        popUpselected.setCommand(command);
        StageManager.stadistics = popUpselected.buttonPressed();
    }
}