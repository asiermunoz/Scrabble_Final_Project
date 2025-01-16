package com.example.new_game_app;

import com.example.new_game_app.objects.jsonHandlers.JsonManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.String.valueOf;

public class StadisticsInMenuController implements Initializable {

    //java variables
    private Player player1;
    private Player player2;

    @FXML
    private Label player1Name;
    @FXML
    private Label player1Score;
    @FXML
    private Label player2Name;
    @FXML
    private Label player2Score;
    @FXML
    private Label player1Win;
    @FXML
    private Label player2Win;
    @FXML
    private Label timePlayed1;
    @FXML
    private Label timePlayed2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player1 = JsonManager.gameInProgress.getGamePlayer1();
        player2 = JsonManager.gameInProgress.getGamePlayer2();

        player1Name.setText(player1.getAlias());
        player1Score.setText(String.valueOf(player1.getScore()));
        player2Name.setText(player2.getAlias());
        player2Score.setText(String.valueOf(player2.getScore()));

        if(player1.isWinner()) {
            player1Win.setText("Gano");
            player2Win.setText("Perdio");
        } else if(player2.isWinner()) {
            player1Win.setText("Perdio");
            player2Win.setText("Gano");
        } else {
            player1Win.setText("?");
            player2Win.setText("?");
        }

        int hours = JsonManager.gameInProgress.getGameTimePlayed() / 3600;
        int minutes = (JsonManager.gameInProgress.getGameTimePlayed() % 3600) / 60;
        int seconds = JsonManager.gameInProgress.getGameTimePlayed() % 60;
        timePlayed1.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        timePlayed2.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
}
