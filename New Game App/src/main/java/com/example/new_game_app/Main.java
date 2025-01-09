package com.example.new_game_app;

import com.example.new_game_app.objects.jsonHandlers.JsonUserHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login-menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 699, 699);

        LoginMenuController controller = fxmlLoader.getController();
        controller.setUsersLinkedList(JsonUserHandler.readFromJson());


        stage.setTitle("LogIn");
        stage.setScene(scene);
        stage.setMinWidth(699);
        stage.setMinHeight(699);
        //Modificar link seleccionando con click derecho ScrabbleIcon -> Copy Path Reference -> Absolute Path.
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(new ImagesURL().icon))));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}