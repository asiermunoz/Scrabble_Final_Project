package com.example.new_game_app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    @FXML
    private TextField User1;

    @FXML
    private TextField Gmail1;

    @FXML
    private TextField User2;

    @FXML
    private TextField Gmail2;

    public void onFinishButtonClick(javafx.event.ActionEvent actionEvent) {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MenuView.fxml")));
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.setMinWidth(469);
            stage.setMinHeight(698);
            //Modificar link seleccionando con click derecho ScrabbleIcon -> Copy Path Reference -> Absolute Path.
            stage.getIcons().add(new Image("C:\\Users\\admdiazramos\\IdeaProjects\\New Game App\\src\\main\\resources\\com\\example\\new_game_app\\Images\\ScrabbleIcon.png"));
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}