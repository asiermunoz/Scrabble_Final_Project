package com.example.register_aplication;

import javafx.stage.Stage;

public class ChangeSceneryToContext {
    private ChangeSceneStrategy strategy;

    public void setStrategy(ChangeSceneStrategy strategy){
        this.strategy = strategy;
    }

    public Stage change(javafx.event.ActionEvent actionEvent){
        return strategy.changeScene(actionEvent);
    }
}
