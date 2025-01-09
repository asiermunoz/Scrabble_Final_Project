package com.example.new_game_app;

import com.example.new_game_app.objects.PlayerManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.example.new_game_app.ChangeSceneStrategy;
import com.example.new_game_app.ChangeSceneryToContext;

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
    private Player player1, player2;

    //Methods
    @FXML
    public void onExitClick() {
        System.exit(0);
    }

    public void setPlayers() {
        this.player1 = PlayerManager.player1;
        this.player2 = PlayerManager.player2;
    }

    @FXML
    public void initialize() {
        setPlayers();
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
}