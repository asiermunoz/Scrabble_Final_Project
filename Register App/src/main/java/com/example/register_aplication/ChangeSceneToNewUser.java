package com.example.register_aplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;


public class ChangeSceneToNewUser implements ChangeSceneStrategy{

    @Override
    public Stage changeScene(ActionEvent actionEvent) {
        /*try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewUser.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("New User");
            stage.setScene(new Scene(root));
            stage.show();
            return stage;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;*/
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewUser.fxml")));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("New User");
            stage.setScene(scene);
            stage.setMinWidth(641);
            stage.setMinHeight(522);
            stage.show();
            return stage;
        }

        catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
