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

    private final com.example.new_game_app.ChangeSceneStrategy strategy = new ChangeSceneryToGame();
    private final com.example.new_game_app.ChangeSceneryToContext context = new com.example.new_game_app.ChangeSceneryToContext();

    //Constructors and Getters y Setters


    //Methods


    @FXML
    public void exitMenu(javafx.event.ActionEvent actionEvent) {
        ChangeSceneStrategy strategy = new ChangeSceneryToLoginMenu();
        ChangeSceneryToContext context = new ChangeSceneryToContext();
        context.setStrategy(strategy);
        context.change(actionEvent);
    }

    public void onNewGameButtonClick(javafx.event.ActionEvent actionEvent) {
        context.setStrategy(strategy);
        StageManager.game = context.change(actionEvent);
    }
}