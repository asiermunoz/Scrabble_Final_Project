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

public class ChangeSceneryToLoginMenu implements ChangeSceneStrategy {
    @Override
    public Stage changeScene(ActionEvent actionEvent) {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login-menu-view.fxml")));
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.setMinWidth(469);
            stage.setMinHeight(698);
            //Modificar link seleccionando con click derecho ScrabbleIcon -> Copy Path Reference -> Absolute Path.
            stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(new ImagesURL().icon))));
            stage.show();
            return stage;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
