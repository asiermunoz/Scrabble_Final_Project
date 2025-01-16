package com.example.new_game_app;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player turn;
    private Order order = new Order();
    private Bag bag = new Bag();
    private int skippedTurns;
    private int secondsElapsed;
    private int wordsPut;
    private final int initialLettersNeeded = 7;
    private LettersToPut tokensSelected = new LettersToPut();
    private final ChangeSceneStrategy strategy = new ChangeSceneryToWinnerScreen();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();

    public void setNewGame() {
        secondsElapsed = 0;
        board  = new Board();
        skippedTurns = 0;
        wordsPut = 0;
        player1 = PlayerManager.player1;
        player1.setHolder(bag.fillNewHolder(initialLettersNeeded));
        player2 = PlayerManager.player2;
        player2.setHolder(bag.fillNewHolder(initialLettersNeeded));
        order.setNewOrder(player1, player2);
        turn = order.getFirstPlayer();
    }

    public void setGameInProgress(GameInformation gameInProgress) {
        secondsElapsed = gameInProgress.getGameTimePlayed();
        skippedTurns = 0;
        player1 = gameInProgress.getGamePlayer1();
        player2 = gameInProgress.getGamePlayer2();
        order = gameInProgress.getGameOrder();
        turn = order.getFirstPlayer();
    }

    public String returnTimer(Boolean update){
        if(update){
            secondsElapsed++;
        }
        int hours = secondsElapsed / 3600;
        int minutes = (secondsElapsed % 3600) / 60;
        int seconds = secondsElapsed % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    //Revisar ↓
    public boolean reviewBoard(Label exception){
        CheckBoard verify = new CheckBoard(board);
        if(verify.check()){
            board.setMarkersFalse();
            turn.sumScore(verify.getScore());
            exception.setText(verify.getMessage());
            wordsPut = wordsPut + verify.getWordsFound();
            if(bag.getTotal() != 0) {
                turn.eraseAndRefillHolder(tokensSelected, bag, initialLettersNeeded);
                exception.setText(exception.getText() + bag.getException());
            }
            return true;
        }
        else{
            exception.setText(verify.getMessage());
            return false;
        }
    }

    public void finishGame(javafx.event.ActionEvent actionEvent){
        StageManager.exit.close();
        StageManager.bag.close();
        StageManager.stadistics.close();
        if(order.getFirstPlayer() == player1) {
            EndGameInfo.player1 = order.getFirstPlayer();
            EndGameInfo.player2 = order.getLastPlayer();
        }
        else{
            EndGameInfo.player2 = order.getLastPlayer();
            EndGameInfo.player1 = order.getFirstPlayer();
        }
        if(skippedTurns == 4) {
            EndGameInfo.motive = "Hubieron 4 pases seguidos por ambos jugadores";
        }
        else if(order.getFirstPlayer().getHolder().getHoldSize() == 0){
            EndGameInfo.motive = "El jugador " + order.getFirstPlayer().getAlias() + " se quedó sin fichas";
        }
        else{
            EndGameInfo.motive = "El jugador " + order.getLastPlayer().getAlias() + " se quedó sin fichas";
        }
        context.setStrategy(strategy);
        context.change(actionEvent);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getTurn() {
        return turn;
    }

    public Order getOrder() {
        return order;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getSkippedTurns() {
        return skippedTurns;
    }

    public void restartSkippedTurns() {
        this.skippedTurns = 0;
    }

    public void addSkippedTurns() {
        this.skippedTurns++;
    }

    public void exchange(){
        turn.getHolder().exchangeAll(bag);
    }

    public void turnToLastPlayer(){
        turn = order.getLastPlayer();
    }

    public void turnToFirstPlayer(){
        turn = order.getFirstPlayer();
    }

    public LettersToPut getTokensSelected() {
        return tokensSelected;
    }



    public void addLetterToTokensSelected(int i){
        tokensSelected.addLetter(turn.getHolder().hold.get(i));
    }

    public String takeFirstTokenSelected(int index){
        Letter letter = tokensSelected.takeFirstLetter();
        board.addTokenToTable(index, letter);
        return letter.getLink();
    }

    public ArrayList<ImageView> returnNotUsedTokens(ArrayList<ImageView> tableImages){
        return board.returnNotUsedTokens(tableImages);
    }

    public int getSecondsElapsed() {
        return secondsElapsed;
    }

    public void setSecondsElapsed(int secondsElapsed) {
        this.secondsElapsed = secondsElapsed;
    }
}
