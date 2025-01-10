package com.example.new_game_app;

import javafx.scene.control.Label;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private Player turn;
    private final Order order = new Order();
    private Bag bag = new Bag();
    private int skippedTurns;
    private LettersHold tokensSelected = new LettersHold();
    private final ChangeSceneStrategy strategy = new ChangeSceneryToWinnerScreen();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();

    public void setNewGame(Label exceptions) {
        skippedTurns = 0;
        int initialLettersNeeded = 7;
        player1 = PlayerManager.player1;
        player1.setHolder(bag.fillNewHolder(initialLettersNeeded, exceptions));
        player2 = PlayerManager.player2;
        player2.setHolder(bag.fillNewHolder(initialLettersNeeded, exceptions));
        order.setNewOrder(player1, player2);
        turn = order.getFirstPlayer();
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

    public int getSkippedTurns() {
        return skippedTurns;
    }

    public void restartSkippedTurns() {
        this.skippedTurns = 0;
    }

    public void addSkippedTurns() {
        this.skippedTurns++;
    }

    public LettersHold getTokensSelected() {
        return tokensSelected;
    }

    public void addLetterToTokensSelected(int i){
        tokensSelected.addLetter(turn.getHolder().hold.get(i));
    }

    public String takeFirstTokenSelected(){
        return tokensSelected.takeFirstLetter();
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

}
