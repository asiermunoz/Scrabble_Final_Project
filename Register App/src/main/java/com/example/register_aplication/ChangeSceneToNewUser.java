package com.example.register_aplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class ChangeSceneToNewUser implements ChangeSceneStrategy{

    @Override
    public Stage changeScene(ActionEvent actionEvent) {
        try{
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
        return null;
    }
}
