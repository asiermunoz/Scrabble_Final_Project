package com.example.new_game_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("RegisterView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.setMinWidth(469);
        stage.setMinHeight(789);
        //Modificar link seleccionando con click derecho ScrabbleIcon -> Copy Path Reference -> Absolute Path.
        stage.getIcons().add(new Image(new ImagesURL().icon));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}