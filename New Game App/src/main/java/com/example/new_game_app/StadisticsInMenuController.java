package com.example.new_game_app;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player1 = PlayerManager.player1;
        player2 = PlayerManager.player2;

        player1Name.setText(player1.getAlias());
        player1Score.setText(String.valueOf(player1.getScore()));
        player2Name.setText(player2.getAlias());
        player2Score.setText(String.valueOf(player2.getScore()));
    }
}
