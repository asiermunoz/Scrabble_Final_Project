package com.example.new_game_app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class JokerController {
    public static String joker = "";
    @FXML
    private TextField jokerValue;
    @FXML
    private Label errorMessage;

    public void onSetJokerButtonClick(javafx.event.ActionEvent actionEvent){
        joker = jokerValue.getText();
        for(Letter letter : new LettersList().getList()){
            if(Objects.equals(letter.getLetter(), joker)){
                StageManager.joker.close();
            }
        }
        errorMessage.setText("La letra ingresada no se encuentra dentro de la lista de letras que posee el juego");
    }

}
