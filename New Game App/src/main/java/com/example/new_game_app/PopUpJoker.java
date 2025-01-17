package com.example.new_game_app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PopUpJoker implements PopUpCommand{
    @Override
    public Stage PopUp() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JokerView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Set Joker");
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(new ImagesURL().icon))));
            StageManager.joker = stage;
            stage.showAndWait();
            return stage;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
