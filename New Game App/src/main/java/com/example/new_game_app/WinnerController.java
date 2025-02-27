package com.example.new_game_app;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class WinnerController implements Initializable {
    private final ChangeSceneStrategy strategy = new ChangeSceneryToMainMenu();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();
    @FXML private Label winnerPlayer;
    @FXML private Label motive;
    @FXML private Label pastTime;

    @FXML private Label player1Name;
    @FXML private Label player1Score;

    @FXML private Label player2Name;
    @FXML private Label player2Score;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(EndGameInfo.player1.getScore() < EndGameInfo.player2.getScore()){
            winnerPlayer.setText(EndGameInfo.player2.getAlias());
        }
        else if(EndGameInfo.player1.getScore() > EndGameInfo.player2.getScore()){
            winnerPlayer.setText(EndGameInfo.player1.getAlias());
        }
        else{
            winnerPlayer.setText("Empate");
        }
        motive.setText(EndGameInfo.motive);
        int secondsElapsed = EndGameInfo.pastTime;
        int hours = secondsElapsed / 3600;
        int minutes = (secondsElapsed % 3600) / 60;
        int seconds = secondsElapsed % 60;
        pastTime.setText("Tiempo transcurrido: " + String.format("%02d:%02d:%02d", hours, minutes, seconds));
        player1Name.setText(EndGameInfo.player1.getAlias());
        player1Score.setText("Score: " + EndGameInfo.player1.getScore());
        player2Name.setText(EndGameInfo.player2.getAlias());
        player2Score.setText("Score: " + EndGameInfo.player2.getScore());

    }

    public void onGoToMenuClick(javafx.event.ActionEvent actionEvent) {
        context.setStrategy(strategy);
        context.change(actionEvent);
    }
}
