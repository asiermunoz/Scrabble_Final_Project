package com.example.new_game_app;

import com.example.new_game_app.objects.jsonHandlers.JsonGamesHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class Game {
    private Board board = new Board();
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

    public void exchange(){
        turn.getHolder().exchangeAll(bag);
    }

    public void turnToLastPlayer(){
        turn = order.getLastPlayer();
    }

    public void turnToFirstPlayer(){
        turn = order.getFirstPlayer();
    }

    public LettersHold getTokensSelected() {
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

}
