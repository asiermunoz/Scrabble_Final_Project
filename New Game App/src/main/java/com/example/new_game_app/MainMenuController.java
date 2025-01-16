package com.example.new_game_app;

import com.example.new_game_app.objects.jsonHandlers.JsonGamesHandler;
import com.example.new_game_app.objects.jsonHandlers.JsonManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.LinkedList;

public class MainMenuController {

    //FXML Variables

    @FXML
    private Button createNewGameButton;
    @FXML
    private Button loadGameButton;
    @FXML
    private Button showStadisticsButton;
    @FXML
    private Button exitButton;

    //Java Variables
    private ChangeSceneStrategy strategy = null;
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();
    private final PopUpSelected popUpselected = new PopUpSelected();
    private final MainMenuModel model = new MainMenuModel();
    private boolean gameAlreadyCreated;
    private GameInformation foundedGame = null;
    private Player user1 = PlayerManager.player1;
    private Player user2 = PlayerManager.player2;
    private LinkedList<GameInformation> gamesInProgress;

    //Methods

    @FXML
    public void onExitClick() {
        System.exit(0);
    }

    public void initialize(){
        gamesInProgress = JsonGamesHandler.readFromJson();
        if(gamesInProgress == null) {
            gamesInProgress = new LinkedList<GameInformation>();
        }
        JsonManager.games = gamesInProgress;

        try {
            foundedGame = model.searchGame(user1, user2, gamesInProgress);
            JsonManager.gameInProgress = foundedGame;
            if(foundedGame != null) {
                gameAlreadyCreated = true;
            } else {
                gameAlreadyCreated = false;
            }
        } catch (NoGamesInProgressException e){
            System.out.println(e.getMessage());
        }

    }

    public void onReturnToLoginButtonClick(javafx.event.ActionEvent actionEvent){
        this.strategy = new ChangeSceneryToLoginMenu();
        context.setStrategy(strategy);
        context.change(actionEvent);
    }

    public void onNewGameButtonClick(javafx.event.ActionEvent actionEvent) {

        //verificar si el juego ha sido sobreescrito
        //tiene que estar aqui para que de chance al pop up de sobreescribir
        if(JsonManager.overWritedGame) {
            gamesInProgress.remove(foundedGame);
            foundedGame = JsonManager.gameInProgress;
            gameAlreadyCreated = JsonManager.isGameFounded;
            if(gamesInProgress.isEmpty()) {
                JsonGamesHandler.clearJsonFile();
            } else {
                JsonGamesHandler.writeToJson(gamesInProgress);
            }
            JsonManager.overWritedGame = false;
        }

        //verificar si ya hay un juego creado
        if(gameAlreadyCreated){
            //se va al pop up
            PopUpCommand command = new PopUpOverwriteGame();
            popUpselected.setCommand(command);
            StageManager.overwrite = popUpselected.buttonPressed();
        } else {
            strategy = new ChangeSceneryToGame();
            context.setStrategy(strategy);
            StageManager.game = context.change(actionEvent);
        }
    }

    public void onContinueGameButtonClick(javafx.event.ActionEvent actionEvent) {
        if(!gameAlreadyCreated) {
            PopUpCommand command = new PopUpNoExistingGame();
            popUpselected.setCommand(command);
            StageManager.noExistingGames = popUpselected.buttonPressed();
        } else {
            JsonManager.newGameNeeded = false;
            strategy = new ChangeSceneryToGame();
            context.setStrategy(strategy);
            StageManager.game = context.change(actionEvent);
        }
    }

    public void onShowStadisticsButtonClick(javafx.event.ActionEvent actionEvent) {
        if(!gameAlreadyCreated){
            //se va al pop up
            PopUpCommand command = new PopUpNoExistingGame();
            popUpselected.setCommand(command);
            StageManager.noExistingGames = popUpselected.buttonPressed();
        } else {
            PopUpCommand command = new PopUpStadisticsInMenu();
            popUpselected.setCommand(command);
            StageManager.stadistics = popUpselected.buttonPressed();
        }
    }
}