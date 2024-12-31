package com.example.new_game_app;

import javafx.stage.Stage;

public class PopUpSelected {
    private PopUpCommand command;

    public void setCommand(PopUpCommand command){
        this.command = command;
    }

    public Stage buttonPressed(){
        return command.PopUp();
    }
}
