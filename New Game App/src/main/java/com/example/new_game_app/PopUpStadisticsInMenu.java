package com.example.new_game_app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PopUpStadisticsInMenu implements PopUpCommand{
    @Override
    public Stage PopUp() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StadisticsInMenuView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Stadistics");
            stage.setScene(new Scene(root));
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(new ImagesURL().icon))));
            stage.show();
            return stage;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
