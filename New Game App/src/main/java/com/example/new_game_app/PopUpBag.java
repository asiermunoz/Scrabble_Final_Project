package com.example.new_game_app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PopUpBag implements PopUpCommand{
    @Override
    public Stage PopUp() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BagView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Bag");
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
