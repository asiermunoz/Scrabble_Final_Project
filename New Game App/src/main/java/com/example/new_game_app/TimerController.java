package com.example.new_game_app;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TimerController {

    @FXML
    private Label timerLabel;

    private Timeline timeline;
    private int secondsElapsed;

    @FXML
    public void initialize() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTimer()));
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    @FXML
    private void startTimer() {
        secondsElapsed = 0;
        timeline.play();
    }

    @FXML
    private void stopTimer() {
        timeline.stop();
    }

    private void updateTimer() {
        secondsElapsed++;
        int hours = secondsElapsed / 3600;
        int minutes = (secondsElapsed % 3600) / 60;
        int seconds = secondsElapsed % 60;
        timerLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
}
