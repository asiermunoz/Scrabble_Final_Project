package com.example.register_aplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChangeSceneToModifyName implements ChangeSceneStrategy{
    @Override
    public Stage changeScene(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChangeName.fxml")));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Change Name");
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
