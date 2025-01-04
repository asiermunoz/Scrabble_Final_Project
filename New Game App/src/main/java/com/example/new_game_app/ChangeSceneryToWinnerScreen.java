package com.example.new_game_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChangeSceneryToWinnerScreen implements ChangeSceneStrategy{
    @Override
    public Stage changeScene(ActionEvent actionEvent) {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WinnerView.fxml")));
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("WINNER");
            stage.setScene(scene);
            stage.setMinWidth(451);
            stage.setMinHeight(315);
            //Modificar link seleccionando con click derecho ScrabbleIcon -> Copy Path Reference -> Absolute Path.
            stage.getIcons().add(new Image(new ImagesURL().icon));
            stage.show();
            return stage;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
