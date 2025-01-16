package com.example.new_game_app;

import com.example.new_game_app.objects.jsonHandlers.JsonManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class StadisticsController implements Initializable {

    private Player player1;
    private Player player2;

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player1 = JsonManager.gameInProgress.getGamePlayer1();
        player2 = JsonManager.gameInProgress.getGamePlayer2();

        // Create a series for player scores
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.setName("Player Scores");

        // Add data to the series
        series.getData().add(new XYChart.Data<>(player1.getAlias(), player1.getScore()));
        series.getData().add(new XYChart.Data<>(player2.getAlias(), player2.getScore()));

        // Add the series to the bar chart
        barChart.getData().add(series);
    }
}