package com.example.new_game_app;

import com.example.new_game_app.objects.jsonHandlers.JsonManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class StadisticsController implements Initializable {

    private Player player1;
    private Player player2;

    @FXML
    private BarChart<Number, String> barChart;

    @FXML
    private CategoryAxis yAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player1 = JsonManager.gameInProgress.getGamePlayer1();
        player2 = JsonManager.gameInProgress.getGamePlayer2();

        // Create a series for player scores
        XYChart.Series<Number, String> series = new XYChart.Series<>();
        series.setName("Player Scores");

        // Add data to the series
        series.getData().add(new XYChart.Data<>(player1.getScore(), player1.getAlias()));
        series.getData().add(new XYChart.Data<>(player2.getScore(), player2.getAlias()));
        series.getData().add(new XYChart.Data<>(player2.getScore() + player1.getScore(), "Total"));

        // Set the axes
        NumberAxis xAxis = new NumberAxis();
        yAxis = new CategoryAxis();
        xAxis.setLabel("Score");
        yAxis.setLabel("Player");

        // Add the series to the bar chart
        barChart.getData().add(series);
    }


}