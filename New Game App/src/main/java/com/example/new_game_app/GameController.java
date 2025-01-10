package com.example.new_game_app;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class GameController implements Initializable {
    private Game game;
    private Boolean skip = false;
    private final PopUpSelected popUpselected = new PopUpSelected();
    private Timeline timeline;
    private int secondsElapsed;
    private ArrayList<ImageView> playerTokens = new ArrayList<>();
    private ArrayList<Button> buttonTokens = new ArrayList<>();
    private ArrayList<ImageView> tableImages = new ArrayList<>();
    private ArrayList<Button> tableButtons = new ArrayList<>();

    @FXML
    private Label exceptions;
    @FXML
    private Label turnAnnouncer;
    @FXML
    private Label player1Name;
    @FXML
    private Label player1Score;
    @FXML
    private Label player2Name;
    @FXML
    private Label player2Score;
    @FXML
    private Label timerLabel;

    @FXML private ImageView token1;
    @FXML private ImageView token2;
    @FXML private ImageView token3;
    @FXML private ImageView token4;
    @FXML private ImageView token5;
    @FXML private ImageView token6;
    @FXML private ImageView token7;

    @FXML private Button buttonToken1;
    @FXML private Button buttonToken2;
    @FXML private Button buttonToken3;
    @FXML private Button buttonToken4;
    @FXML private Button buttonToken5;
    @FXML private Button buttonToken6;
    @FXML private Button buttonToken7;

    private ArrayList<Button> actionButtons = new ArrayList<>();
    @FXML
    private Button buttonExchange;
    @FXML
    private Button buttonReturn;
    @FXML
    private Button buttonPlay;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Timer:
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTimer()));
        timeline.setCycleCount(Animation.INDEFINITE);
        secondsElapsed = 0;
        timeline.play();
        game = new Game();

        //Función que define la nueva partida.
        game.setNewGame(exceptions);

        addToArrayList();
        for (Button button:actionButtons){
            if(button != buttonExchange) {
                button.setOpacity(0.28);
                button.setDisable(true);
            }
        }
        StageManager.exit = new Stage();
        StageManager.bag = new Stage();
        StageManager.stadistics = new Stage();
        updateTimer();
        modifyLabels();
        showHolder();
    }

    public void onPassTurnButtonClick(javafx.event.ActionEvent actionEvent) {
        if (!skip) {
            game.addSkippedTurns();
        }
        exceptions.setText(game.getTurn().getAlias() + " paso su turno.");
        skip = false;
        nextTurn(actionEvent);
    }

    public void onSelectedTokenButtonClick(javafx.event.ActionEvent actionEvent) {
        int i = 0;
        if(!skip) {
            for (Button button : buttonTokens) {
                if (actionEvent.getSource() == button) {
                    if (button.getOpacity() == 1) {
                        button.setOpacity(0.28);
                        button.setDisable(true);
                        buttonReturn.setOpacity(1);
                        buttonReturn.setDisable(false);
                        game.addLettersToUse(i);
                    }
                }
                i++;
            }
        }
    }

    public void onPutTokenOnTable(javafx.event.ActionEvent actionEvent){
        if(game.getLettersToUse() != null){
            int i = 0;
            for(Button button: tableButtons){
                if(actionEvent.getSource() == button){
                    tableImages.get(i).setImage(new Image(game.getLettersToUse().getFirst().getLink()));
                }
                i++;
            }
        }
    }

    @FXML
    public void onReturnButton(){
        for (Button button : buttonTokens) {
            if(button.getOpacity() == 0.28){
                button.setDisable(false);
                button.setOpacity(1);
            }
        }
        game.returnLettersToUse();
        buttonReturn.setOpacity(0.28);
        buttonReturn.setDisable(true);
    }

    @FXML
    public void onExchangeButtonClick() {
        exceptions.setText("Se intercambiaron todas sus fichas.");
        game.exchange();
        game.restartSkippedTurns();
        showHolder();
        onReturnButton();
        skip = true;
        for (Button button : actionButtons) {
            button.setOpacity(0.28);
            button.setDisable(true);
        }
    }

    @FXML
    public void onExitToMenuButtonClick() {
        PopUpCommand command = new PopUpExit();
        popUpselected.setCommand(command);
        StageManager.exit = popUpselected.buttonPressed();
    }

    @FXML
    public void onBagButtonClick() {
        PopUpCommand command = new PopUpBag();
        popUpselected.setCommand(command);
        StageManager.bag = popUpselected.buttonPressed();
    }

    @FXML
    public void onStadisticsButtonClick() {
        PopUpCommand command = new PopUpStadistics();
        popUpselected.setCommand(command);
        StageManager.stadistics = popUpselected.buttonPressed();
    }

    private void updateTimer() {
        secondsElapsed++;
        int hours = secondsElapsed / 3600;
        int minutes = (secondsElapsed % 3600) / 60;
        int seconds = secondsElapsed % 60;
        timerLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    private String stopTimer() {
        timeline.stop();
        int hours = secondsElapsed / 3600;
        int minutes = (secondsElapsed % 3600) / 60;
        int seconds = secondsElapsed % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }


    private void modifyLabels() {
        turnAnnouncer.setText("Es el turno de: " + game.getTurn().getAlias());
        player1Name.setText(game.getPlayer1().getAlias());
        player1Score.setText(String.valueOf(game.getPlayer1().getScore()));
        player2Name.setText(game.getPlayer2().getAlias());
        player2Score.setText(String.valueOf(game.getPlayer2().getScore()));
    }

    private void showHolder() {
        int i = 0;
        for (ImageView view : playerTokens) {
            if (i < game.getTurn().getHolder().getHoldSize()) {
                view.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(game.getTurn().getHolder().hold.get(i).getLink()))));
                view.setOpacity(1);
            } else {
                view.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(new ImagesURL().emptySpace))));
                view.setOpacity(0.28);
                buttonTokens.get(i).setDisable(true);
            }
            i++;
        }
    }

    private void nextTurn(javafx.event.ActionEvent actionEvent) {
        if (game.getSkippedTurns() == 4) {
            EndGameInfo.pastTime = stopTimer();
            game.finishGame(actionEvent);
        }
        if (game.getTurn() == game.getOrder().getFirstPlayer()) {
            game.turnToLastPlayer();
        } else {
            game.turnToFirstPlayer();
        }
        onReturnButton();
        modifyLabels();
        showHolder();
        for (Button button : actionButtons) {
            if (button != buttonReturn && button != buttonPlay) {
                button.setOpacity(1);
                button.setDisable(false);
            } else {
                button.setOpacity(0.28);
                button.setDisable(true);
            }
        }
    }

    private void addToArrayList(){
        playerTokens.add(token1);
        playerTokens.add(token2);
        playerTokens.add(token3);
        playerTokens.add(token4);
        playerTokens.add(token5);
        playerTokens.add(token6);
        playerTokens.add(token7);

        buttonTokens.add(buttonToken1);
        buttonTokens.add(buttonToken2);
        buttonTokens.add(buttonToken3);
        buttonTokens.add(buttonToken4);
        buttonTokens.add(buttonToken5);
        buttonTokens.add(buttonToken6);
        buttonTokens.add(buttonToken7);

        actionButtons.add(buttonExchange);
        actionButtons.add(buttonReturn);
        actionButtons.add(buttonPlay);

        tableImages.add(tableImage1);
        tableImages.add(tableImage2);
        tableImages.add(tableImage3);
        tableImages.add(tableImage4);
        tableImages.add(tableImage5);
        tableImages.add(tableImage6);
        tableImages.add(tableImage7);
        tableImages.add(tableImage8);
        tableImages.add(tableImage9);
        tableImages.add(tableImage10);
        tableImages.add(tableImage11);
        tableImages.add(tableImage12);
        tableImages.add(tableImage13);
        tableImages.add(tableImage14);
        tableImages.add(tableImage15);
        tableImages.add(tableImage16);
        tableImages.add(tableImage17);
        tableImages.add(tableImage18);
        tableImages.add(tableImage19);
        tableImages.add(tableImage20);
        tableImages.add(tableImage21);
        tableImages.add(tableImage22);
        tableImages.add(tableImage23);
        tableImages.add(tableImage24);
        tableImages.add(tableImage25);
        tableImages.add(tableImage26);
        tableImages.add(tableImage27);
        tableImages.add(tableImage28);
        tableImages.add(tableImage29);
        tableImages.add(tableImage30);
        tableImages.add(tableImage31);
        tableImages.add(tableImage32);
        tableImages.add(tableImage33);
        tableImages.add(tableImage34);
        tableImages.add(tableImage35);
        tableImages.add(tableImage36);
        tableImages.add(tableImage37);
        tableImages.add(tableImage38);
        tableImages.add(tableImage39);
        tableImages.add(tableImage40);
        tableImages.add(tableImage41);
        tableImages.add(tableImage42);
        tableImages.add(tableImage43);
        tableImages.add(tableImage44);
        tableImages.add(tableImage45);
        tableImages.add(tableImage46);
        tableImages.add(tableImage47);
        tableImages.add(tableImage48);
        tableImages.add(tableImage49);
        tableImages.add(tableImage50);
        tableImages.add(tableImage51);
        tableImages.add(tableImage52);
        tableImages.add(tableImage53);
        tableImages.add(tableImage54);
        tableImages.add(tableImage55);
        tableImages.add(tableImage56);
        tableImages.add(tableImage57);
        tableImages.add(tableImage58);
        tableImages.add(tableImage59);
        tableImages.add(tableImage60);
        tableImages.add(tableImage61);
        tableImages.add(tableImage62);
        tableImages.add(tableImage63);
        tableImages.add(tableImage64);
        tableImages.add(tableImage65);
        tableImages.add(tableImage66);
        tableImages.add(tableImage67);
        tableImages.add(tableImage68);
        tableImages.add(tableImage69);
        tableImages.add(tableImage70);
        tableImages.add(tableImage71);
        tableImages.add(tableImage72);
        tableImages.add(tableImage73);
        tableImages.add(tableImage74);
        tableImages.add(tableImage75);
        tableImages.add(tableImage76);
        tableImages.add(tableImage77);
        tableImages.add(tableImage78);
        tableImages.add(tableImage79);
        tableImages.add(tableImage80);
        tableImages.add(tableImage81);
        tableImages.add(tableImage82);
        tableImages.add(tableImage83);
        tableImages.add(tableImage84);
        tableImages.add(tableImage85);
        tableImages.add(tableImage86);
        tableImages.add(tableImage87);
        tableImages.add(tableImage88);
        tableImages.add(tableImage89);
        tableImages.add(tableImage90);
        tableImages.add(tableImage91);
        tableImages.add(tableImage92);
        tableImages.add(tableImage93);
        tableImages.add(tableImage94);
        tableImages.add(tableImage95);
        tableImages.add(tableImage96);
        tableImages.add(tableImage97);
        tableImages.add(tableImage98);
        tableImages.add(tableImage99);
        tableImages.add(tableImage100);
        tableImages.add(tableImage101);
        tableImages.add(tableImage102);
        tableImages.add(tableImage103);
        tableImages.add(tableImage104);
        tableImages.add(tableImage105);
        tableImages.add(tableImage106);
        tableImages.add(tableImage107);
        tableImages.add(tableImage108);
        tableImages.add(tableImage109);
        tableImages.add(tableImage110);
        tableImages.add(tableImage111);
        tableImages.add(tableImage112);
        tableImages.add(tableImage113);
        tableImages.add(tableImage114);
        tableImages.add(tableImage115);
        tableImages.add(tableImage116);
        tableImages.add(tableImage117);
        tableImages.add(tableImage118);
        tableImages.add(tableImage119);
        tableImages.add(tableImage120);
        tableImages.add(tableImage121);
        tableImages.add(tableImage122);
        tableImages.add(tableImage123);
        tableImages.add(tableImage124);
        tableImages.add(tableImage125);
        tableImages.add(tableImage126);
        tableImages.add(tableImage127);
        tableImages.add(tableImage128);
        tableImages.add(tableImage129);
        tableImages.add(tableImage130);
        tableImages.add(tableImage131);
        tableImages.add(tableImage132);
        tableImages.add(tableImage133);
        tableImages.add(tableImage134);
        tableImages.add(tableImage135);
        tableImages.add(tableImage136);
        tableImages.add(tableImage137);
        tableImages.add(tableImage138);
        tableImages.add(tableImage139);
        tableImages.add(tableImage140);
        tableImages.add(tableImage141);
        tableImages.add(tableImage142);
        tableImages.add(tableImage143);
        tableImages.add(tableImage144);
        tableImages.add(tableImage145);
        tableImages.add(tableImage146);
        tableImages.add(tableImage147);
        tableImages.add(tableImage148);
        tableImages.add(tableImage149);
        tableImages.add(tableImage150);
        tableImages.add(tableImage151);
        tableImages.add(tableImage152);
        tableImages.add(tableImage153);
        tableImages.add(tableImage154);
        tableImages.add(tableImage155);
        tableImages.add(tableImage156);
        tableImages.add(tableImage157);
        tableImages.add(tableImage158);
        tableImages.add(tableImage159);
        tableImages.add(tableImage160);
        tableImages.add(tableImage161);
        tableImages.add(tableImage162);
        tableImages.add(tableImage163);
        tableImages.add(tableImage164);
        tableImages.add(tableImage165);
        tableImages.add(tableImage166);
        tableImages.add(tableImage167);
        tableImages.add(tableImage168);
        tableImages.add(tableImage169);
        tableImages.add(tableImage170);
        tableImages.add(tableImage171);
        tableImages.add(tableImage172);
        tableImages.add(tableImage173);
        tableImages.add(tableImage174);
        tableImages.add(tableImage175);
        tableImages.add(tableImage176);
        tableImages.add(tableImage177);
        tableImages.add(tableImage178);
        tableImages.add(tableImage179);
        tableImages.add(tableImage180);
        tableImages.add(tableImage181);
        tableImages.add(tableImage182);
        tableImages.add(tableImage183);
        tableImages.add(tableImage184);
        tableImages.add(tableImage185);
        tableImages.add(tableImage186);
        tableImages.add(tableImage187);
        tableImages.add(tableImage188);
        tableImages.add(tableImage189);
        tableImages.add(tableImage190);
        tableImages.add(tableImage191);
        tableImages.add(tableImage192);
        tableImages.add(tableImage193);
        tableImages.add(tableImage194);
        tableImages.add(tableImage195);
        tableImages.add(tableImage196);
        tableImages.add(tableImage197);
        tableImages.add(tableImage198);
        tableImages.add(tableImage199);
        tableImages.add(tableImage200);
        tableImages.add(tableImage201);
        tableImages.add(tableImage202);
        tableImages.add(tableImage203);
        tableImages.add(tableImage204);
        tableImages.add(tableImage205);
        tableImages.add(tableImage206);
        tableImages.add(tableImage207);
        tableImages.add(tableImage208);
        tableImages.add(tableImage209);
        tableImages.add(tableImage210);
        tableImages.add(tableImage211);
        tableImages.add(tableImage212);
        tableImages.add(tableImage213);
        tableImages.add(tableImage214);
        tableImages.add(tableImage215);
        tableImages.add(tableImage216);
        tableImages.add(tableImage217);
        tableImages.add(tableImage218);
        tableImages.add(tableImage219);
        tableImages.add(tableImage220);
        tableImages.add(tableImage221);
        tableImages.add(tableImage222);
        tableImages.add(tableImage223);
        tableImages.add(tableImage224);
        tableImages.add(tableImage225);

        tableButtons.add(tableButton1);
        tableButtons.add(tableButton2);
        tableButtons.add(tableButton3);
        tableButtons.add(tableButton4);
        tableButtons.add(tableButton5);
        tableButtons.add(tableButton6);
        tableButtons.add(tableButton7);
        tableButtons.add(tableButton8);
        tableButtons.add(tableButton9);
        tableButtons.add(tableButton10);
        tableButtons.add(tableButton11);
        tableButtons.add(tableButton12);
        tableButtons.add(tableButton13);
        tableButtons.add(tableButton14);
        tableButtons.add(tableButton15);
        tableButtons.add(tableButton16);
        tableButtons.add(tableButton17);
        tableButtons.add(tableButton18);
        tableButtons.add(tableButton19);
        tableButtons.add(tableButton20);
        tableButtons.add(tableButton21);
        tableButtons.add(tableButton22);
        tableButtons.add(tableButton23);
        tableButtons.add(tableButton24);
        tableButtons.add(tableButton25);
        tableButtons.add(tableButton26);
        tableButtons.add(tableButton27);
        tableButtons.add(tableButton28);
        tableButtons.add(tableButton29);
        tableButtons.add(tableButton30);
        tableButtons.add(tableButton31);
        tableButtons.add(tableButton32);
        tableButtons.add(tableButton33);
        tableButtons.add(tableButton34);
        tableButtons.add(tableButton35);
        tableButtons.add(tableButton36);
        tableButtons.add(tableButton37);
        tableButtons.add(tableButton38);
        tableButtons.add(tableButton39);
        tableButtons.add(tableButton40);
        tableButtons.add(tableButton41);
        tableButtons.add(tableButton42);
        tableButtons.add(tableButton43);
        tableButtons.add(tableButton44);
        tableButtons.add(tableButton45);
        tableButtons.add(tableButton46);
        tableButtons.add(tableButton47);
        tableButtons.add(tableButton48);
        tableButtons.add(tableButton49);
        tableButtons.add(tableButton50);
        tableButtons.add(tableButton51);
        tableButtons.add(tableButton52);
        tableButtons.add(tableButton53);
        tableButtons.add(tableButton54);
        tableButtons.add(tableButton55);
        tableButtons.add(tableButton56);
        tableButtons.add(tableButton57);
        tableButtons.add(tableButton58);
        tableButtons.add(tableButton59);
        tableButtons.add(tableButton60);
        tableButtons.add(tableButton61);
        tableButtons.add(tableButton62);
        tableButtons.add(tableButton63);
        tableButtons.add(tableButton64);
        tableButtons.add(tableButton65);
        tableButtons.add(tableButton66);
        tableButtons.add(tableButton67);
        tableButtons.add(tableButton68);
        tableButtons.add(tableButton69);
        tableButtons.add(tableButton70);
        tableButtons.add(tableButton71);
        tableButtons.add(tableButton72);
        tableButtons.add(tableButton73);
        tableButtons.add(tableButton74);
        tableButtons.add(tableButton75);
        tableButtons.add(tableButton76);
        tableButtons.add(tableButton77);
        tableButtons.add(tableButton78);
        tableButtons.add(tableButton79);
        tableButtons.add(tableButton80);
        tableButtons.add(tableButton81);
        tableButtons.add(tableButton82);
        tableButtons.add(tableButton83);
        tableButtons.add(tableButton84);
        tableButtons.add(tableButton85);
        tableButtons.add(tableButton86);
        tableButtons.add(tableButton87);
        tableButtons.add(tableButton88);
        tableButtons.add(tableButton89);
        tableButtons.add(tableButton90);
        tableButtons.add(tableButton91);
        tableButtons.add(tableButton92);
        tableButtons.add(tableButton93);
        tableButtons.add(tableButton94);
        tableButtons.add(tableButton95);
        tableButtons.add(tableButton96);
        tableButtons.add(tableButton97);
        tableButtons.add(tableButton98);
        tableButtons.add(tableButton99);
        tableButtons.add(tableButton100);
        tableButtons.add(tableButton101);
        tableButtons.add(tableButton102);
        tableButtons.add(tableButton103);
        tableButtons.add(tableButton104);
        tableButtons.add(tableButton105);
        tableButtons.add(tableButton106);
        tableButtons.add(tableButton107);
        tableButtons.add(tableButton108);
        tableButtons.add(tableButton109);
        tableButtons.add(tableButton110);
        tableButtons.add(tableButton111);
        tableButtons.add(tableButton112);
        tableButtons.add(tableButton113);
        tableButtons.add(tableButton114);
        tableButtons.add(tableButton115);
        tableButtons.add(tableButton116);
        tableButtons.add(tableButton117);
        tableButtons.add(tableButton118);
        tableButtons.add(tableButton119);
        tableButtons.add(tableButton120);
        tableButtons.add(tableButton121);
        tableButtons.add(tableButton122);
        tableButtons.add(tableButton123);
        tableButtons.add(tableButton124);
        tableButtons.add(tableButton125);
        tableButtons.add(tableButton126);
        tableButtons.add(tableButton127);
        tableButtons.add(tableButton128);
        tableButtons.add(tableButton129);
        tableButtons.add(tableButton130);
        tableButtons.add(tableButton131);
        tableButtons.add(tableButton132);
        tableButtons.add(tableButton133);
        tableButtons.add(tableButton134);
        tableButtons.add(tableButton135);
        tableButtons.add(tableButton136);
        tableButtons.add(tableButton137);
        tableButtons.add(tableButton138);
        tableButtons.add(tableButton139);
        tableButtons.add(tableButton140);
        tableButtons.add(tableButton141);
        tableButtons.add(tableButton142);
        tableButtons.add(tableButton143);
        tableButtons.add(tableButton144);
        tableButtons.add(tableButton145);
        tableButtons.add(tableButton146);
        tableButtons.add(tableButton147);
        tableButtons.add(tableButton148);
        tableButtons.add(tableButton149);
        tableButtons.add(tableButton150);
        tableButtons.add(tableButton151);
        tableButtons.add(tableButton152);
        tableButtons.add(tableButton153);
        tableButtons.add(tableButton154);
        tableButtons.add(tableButton155);
        tableButtons.add(tableButton156);
        tableButtons.add(tableButton157);
        tableButtons.add(tableButton158);
        tableButtons.add(tableButton159);
        tableButtons.add(tableButton160);
        tableButtons.add(tableButton161);
        tableButtons.add(tableButton162);
        tableButtons.add(tableButton163);
        tableButtons.add(tableButton164);
        tableButtons.add(tableButton165);
        tableButtons.add(tableButton166);
        tableButtons.add(tableButton167);
        tableButtons.add(tableButton168);
        tableButtons.add(tableButton169);
        tableButtons.add(tableButton170);
        tableButtons.add(tableButton171);
        tableButtons.add(tableButton172);
        tableButtons.add(tableButton173);
        tableButtons.add(tableButton174);
        tableButtons.add(tableButton175);
        tableButtons.add(tableButton176);
        tableButtons.add(tableButton177);
        tableButtons.add(tableButton178);
        tableButtons.add(tableButton179);
        tableButtons.add(tableButton180);
        tableButtons.add(tableButton181);
        tableButtons.add(tableButton182);
        tableButtons.add(tableButton183);
        tableButtons.add(tableButton184);
        tableButtons.add(tableButton185);
        tableButtons.add(tableButton186);
        tableButtons.add(tableButton187);
        tableButtons.add(tableButton188);
        tableButtons.add(tableButton189);
        tableButtons.add(tableButton190);
        tableButtons.add(tableButton191);
        tableButtons.add(tableButton192);
        tableButtons.add(tableButton193);
        tableButtons.add(tableButton194);
        tableButtons.add(tableButton195);
        tableButtons.add(tableButton196);
        tableButtons.add(tableButton197);
        tableButtons.add(tableButton198);
        tableButtons.add(tableButton199);
        tableButtons.add(tableButton200);
        tableButtons.add(tableButton201);
        tableButtons.add(tableButton202);
        tableButtons.add(tableButton203);
        tableButtons.add(tableButton204);
        tableButtons.add(tableButton205);
        tableButtons.add(tableButton206);
        tableButtons.add(tableButton207);
        tableButtons.add(tableButton208);
        tableButtons.add(tableButton209);
        tableButtons.add(tableButton210);
        tableButtons.add(tableButton211);
        tableButtons.add(tableButton212);
        tableButtons.add(tableButton213);
        tableButtons.add(tableButton214);
        tableButtons.add(tableButton215);
        tableButtons.add(tableButton216);
        tableButtons.add(tableButton217);
        tableButtons.add(tableButton218);
        tableButtons.add(tableButton219);
        tableButtons.add(tableButton220);
        tableButtons.add(tableButton221);
        tableButtons.add(tableButton222);
        tableButtons.add(tableButton223);
        tableButtons.add(tableButton224);
        tableButtons.add(tableButton225);
    }

    //ID DE CADA CUADRO DEL TABLERO
    @FXML private Button tableButton1;
    @FXML private Button tableButton2;
    @FXML private Button tableButton3;
    @FXML private Button tableButton4;
    @FXML private Button tableButton5;
    @FXML private Button tableButton6;
    @FXML private Button tableButton7;
    @FXML private Button tableButton8;
    @FXML private Button tableButton9;
    @FXML private Button tableButton10;
    @FXML private Button tableButton11;
    @FXML private Button tableButton12;
    @FXML private Button tableButton13;
    @FXML private Button tableButton14;
    @FXML private Button tableButton15;
    @FXML private Button tableButton16;
    @FXML private Button tableButton17;
    @FXML private Button tableButton18;
    @FXML private Button tableButton19;
    @FXML private Button tableButton20;
    @FXML private Button tableButton21;
    @FXML private Button tableButton22;
    @FXML private Button tableButton23;
    @FXML private Button tableButton24;
    @FXML private Button tableButton25;
    @FXML private Button tableButton26;
    @FXML private Button tableButton27;
    @FXML private Button tableButton28;
    @FXML private Button tableButton29;
    @FXML private Button tableButton30;
    @FXML private Button tableButton31;
    @FXML private Button tableButton32;
    @FXML private Button tableButton33;
    @FXML private Button tableButton34;
    @FXML private Button tableButton35;
    @FXML private Button tableButton36;
    @FXML private Button tableButton37;
    @FXML private Button tableButton38;
    @FXML private Button tableButton39;
    @FXML private Button tableButton40;
    @FXML private Button tableButton41;
    @FXML private Button tableButton42;
    @FXML private Button tableButton43;
    @FXML private Button tableButton44;
    @FXML private Button tableButton45;
    @FXML private Button tableButton46;
    @FXML private Button tableButton47;
    @FXML private Button tableButton48;
    @FXML private Button tableButton49;
    @FXML private Button tableButton50;
    @FXML private Button tableButton51;
    @FXML private Button tableButton52;
    @FXML private Button tableButton53;
    @FXML private Button tableButton54;
    @FXML private Button tableButton55;
    @FXML private Button tableButton56;
    @FXML private Button tableButton57;
    @FXML private Button tableButton58;
    @FXML private Button tableButton59;
    @FXML private Button tableButton60;
    @FXML private Button tableButton61;
    @FXML private Button tableButton62;
    @FXML private Button tableButton63;
    @FXML private Button tableButton64;
    @FXML private Button tableButton65;
    @FXML private Button tableButton66;
    @FXML private Button tableButton67;
    @FXML private Button tableButton68;
    @FXML private Button tableButton69;
    @FXML private Button tableButton70;
    @FXML private Button tableButton71;
    @FXML private Button tableButton72;
    @FXML private Button tableButton73;
    @FXML private Button tableButton74;
    @FXML private Button tableButton75;
    @FXML private Button tableButton76;
    @FXML private Button tableButton77;
    @FXML private Button tableButton78;
    @FXML private Button tableButton79;
    @FXML private Button tableButton80;
    @FXML private Button tableButton81;
    @FXML private Button tableButton82;
    @FXML private Button tableButton83;
    @FXML private Button tableButton84;
    @FXML private Button tableButton85;
    @FXML private Button tableButton86;
    @FXML private Button tableButton87;
    @FXML private Button tableButton88;
    @FXML private Button tableButton89;
    @FXML private Button tableButton90;
    @FXML private Button tableButton91;
    @FXML private Button tableButton92;
    @FXML private Button tableButton93;
    @FXML private Button tableButton94;
    @FXML private Button tableButton95;
    @FXML private Button tableButton96;
    @FXML private Button tableButton97;
    @FXML private Button tableButton98;
    @FXML private Button tableButton99;
    @FXML private Button tableButton100;
    @FXML private Button tableButton101;
    @FXML private Button tableButton102;
    @FXML private Button tableButton103;
    @FXML private Button tableButton104;
    @FXML private Button tableButton105;
    @FXML private Button tableButton106;
    @FXML private Button tableButton107;
    @FXML private Button tableButton108;
    @FXML private Button tableButton109;
    @FXML private Button tableButton110;
    @FXML private Button tableButton111;
    @FXML private Button tableButton112;
    @FXML private Button tableButton113;
    @FXML private Button tableButton114;
    @FXML private Button tableButton115;
    @FXML private Button tableButton116;
    @FXML private Button tableButton117;
    @FXML private Button tableButton118;
    @FXML private Button tableButton119;
    @FXML private Button tableButton120;
    @FXML private Button tableButton121;
    @FXML private Button tableButton122;
    @FXML private Button tableButton123;
    @FXML private Button tableButton124;
    @FXML private Button tableButton125;
    @FXML private Button tableButton126;
    @FXML private Button tableButton127;
    @FXML private Button tableButton128;
    @FXML private Button tableButton129;
    @FXML private Button tableButton130;
    @FXML private Button tableButton131;
    @FXML private Button tableButton132;
    @FXML private Button tableButton133;
    @FXML private Button tableButton134;
    @FXML private Button tableButton135;
    @FXML private Button tableButton136;
    @FXML private Button tableButton137;
    @FXML private Button tableButton138;
    @FXML private Button tableButton139;
    @FXML private Button tableButton140;
    @FXML private Button tableButton141;
    @FXML private Button tableButton142;
    @FXML private Button tableButton143;
    @FXML private Button tableButton144;
    @FXML private Button tableButton145;
    @FXML private Button tableButton146;
    @FXML private Button tableButton147;
    @FXML private Button tableButton148;
    @FXML private Button tableButton149;
    @FXML private Button tableButton150;
    @FXML private Button tableButton151;
    @FXML private Button tableButton152;
    @FXML private Button tableButton153;
    @FXML private Button tableButton154;
    @FXML private Button tableButton155;
    @FXML private Button tableButton156;
    @FXML private Button tableButton157;
    @FXML private Button tableButton158;
    @FXML private Button tableButton159;
    @FXML private Button tableButton160;
    @FXML private Button tableButton161;
    @FXML private Button tableButton162;
    @FXML private Button tableButton163;
    @FXML private Button tableButton164;
    @FXML private Button tableButton165;
    @FXML private Button tableButton166;
    @FXML private Button tableButton167;
    @FXML private Button tableButton168;
    @FXML private Button tableButton169;
    @FXML private Button tableButton170;
    @FXML private Button tableButton171;
    @FXML private Button tableButton172;
    @FXML private Button tableButton173;
    @FXML private Button tableButton174;
    @FXML private Button tableButton175;
    @FXML private Button tableButton176;
    @FXML private Button tableButton177;
    @FXML private Button tableButton178;
    @FXML private Button tableButton179;
    @FXML private Button tableButton180;
    @FXML private Button tableButton181;
    @FXML private Button tableButton182;
    @FXML private Button tableButton183;
    @FXML private Button tableButton184;
    @FXML private Button tableButton185;
    @FXML private Button tableButton186;
    @FXML private Button tableButton187;
    @FXML private Button tableButton188;
    @FXML private Button tableButton189;
    @FXML private Button tableButton190;
    @FXML private Button tableButton191;
    @FXML private Button tableButton192;
    @FXML private Button tableButton193;
    @FXML private Button tableButton194;
    @FXML private Button tableButton195;
    @FXML private Button tableButton196;
    @FXML private Button tableButton197;
    @FXML private Button tableButton198;
    @FXML private Button tableButton199;
    @FXML private Button tableButton200;
    @FXML private Button tableButton201;
    @FXML private Button tableButton202;
    @FXML private Button tableButton203;
    @FXML private Button tableButton204;
    @FXML private Button tableButton205;
    @FXML private Button tableButton206;
    @FXML private Button tableButton207;
    @FXML private Button tableButton208;
    @FXML private Button tableButton209;
    @FXML private Button tableButton210;
    @FXML private Button tableButton211;
    @FXML private Button tableButton212;
    @FXML private Button tableButton213;
    @FXML private Button tableButton214;
    @FXML private Button tableButton215;
    @FXML private Button tableButton216;
    @FXML private Button tableButton217;
    @FXML private Button tableButton218;
    @FXML private Button tableButton219;
    @FXML private Button tableButton220;
    @FXML private Button tableButton221;
    @FXML private Button tableButton222;
    @FXML private Button tableButton223;
    @FXML private Button tableButton224;
    @FXML private Button tableButton225;

    //IMAGE VIEW
    @FXML private ImageView tableImage1;
    @FXML private ImageView tableImage2;
    @FXML private ImageView tableImage3;
    @FXML private ImageView tableImage4;
    @FXML private ImageView tableImage5;
    @FXML private ImageView tableImage6;
    @FXML private ImageView tableImage7;
    @FXML private ImageView tableImage8;
    @FXML private ImageView tableImage9;
    @FXML private ImageView tableImage10;
    @FXML private ImageView tableImage11;
    @FXML private ImageView tableImage12;
    @FXML private ImageView tableImage13;
    @FXML private ImageView tableImage14;
    @FXML private ImageView tableImage15;
    @FXML private ImageView tableImage16;
    @FXML private ImageView tableImage17;
    @FXML private ImageView tableImage18;
    @FXML private ImageView tableImage19;
    @FXML private ImageView tableImage20;
    @FXML private ImageView tableImage21;
    @FXML private ImageView tableImage22;
    @FXML private ImageView tableImage23;
    @FXML private ImageView tableImage24;
    @FXML private ImageView tableImage25;
    @FXML private ImageView tableImage26;
    @FXML private ImageView tableImage27;
    @FXML private ImageView tableImage28;
    @FXML private ImageView tableImage29;
    @FXML private ImageView tableImage30;
    @FXML private ImageView tableImage31;
    @FXML private ImageView tableImage32;
    @FXML private ImageView tableImage33;
    @FXML private ImageView tableImage34;
    @FXML private ImageView tableImage35;
    @FXML private ImageView tableImage36;
    @FXML private ImageView tableImage37;
    @FXML private ImageView tableImage38;
    @FXML private ImageView tableImage39;
    @FXML private ImageView tableImage40;
    @FXML private ImageView tableImage41;
    @FXML private ImageView tableImage42;
    @FXML private ImageView tableImage43;
    @FXML private ImageView tableImage44;
    @FXML private ImageView tableImage45;
    @FXML private ImageView tableImage46;
    @FXML private ImageView tableImage47;
    @FXML private ImageView tableImage48;
    @FXML private ImageView tableImage49;
    @FXML private ImageView tableImage50;
    @FXML private ImageView tableImage51;
    @FXML private ImageView tableImage52;
    @FXML private ImageView tableImage53;
    @FXML private ImageView tableImage54;
    @FXML private ImageView tableImage55;
    @FXML private ImageView tableImage56;
    @FXML private ImageView tableImage57;
    @FXML private ImageView tableImage58;
    @FXML private ImageView tableImage59;
    @FXML private ImageView tableImage60;
    @FXML private ImageView tableImage61;
    @FXML private ImageView tableImage62;
    @FXML private ImageView tableImage63;
    @FXML private ImageView tableImage64;
    @FXML private ImageView tableImage65;
    @FXML private ImageView tableImage66;
    @FXML private ImageView tableImage67;
    @FXML private ImageView tableImage68;
    @FXML private ImageView tableImage69;
    @FXML private ImageView tableImage70;
    @FXML private ImageView tableImage71;
    @FXML private ImageView tableImage72;
    @FXML private ImageView tableImage73;
    @FXML private ImageView tableImage74;
    @FXML private ImageView tableImage75;
    @FXML private ImageView tableImage76;
    @FXML private ImageView tableImage77;
    @FXML private ImageView tableImage78;
    @FXML private ImageView tableImage79;
    @FXML private ImageView tableImage80;
    @FXML private ImageView tableImage81;
    @FXML private ImageView tableImage82;
    @FXML private ImageView tableImage83;
    @FXML private ImageView tableImage84;
    @FXML private ImageView tableImage85;
    @FXML private ImageView tableImage86;
    @FXML private ImageView tableImage87;
    @FXML private ImageView tableImage88;
    @FXML private ImageView tableImage89;
    @FXML private ImageView tableImage90;
    @FXML private ImageView tableImage91;
    @FXML private ImageView tableImage92;
    @FXML private ImageView tableImage93;
    @FXML private ImageView tableImage94;
    @FXML private ImageView tableImage95;
    @FXML private ImageView tableImage96;
    @FXML private ImageView tableImage97;
    @FXML private ImageView tableImage98;
    @FXML private ImageView tableImage99;
    @FXML private ImageView tableImage100;
    @FXML private ImageView tableImage101;
    @FXML private ImageView tableImage102;
    @FXML private ImageView tableImage103;
    @FXML private ImageView tableImage104;
    @FXML private ImageView tableImage105;
    @FXML private ImageView tableImage106;
    @FXML private ImageView tableImage107;
    @FXML private ImageView tableImage108;
    @FXML private ImageView tableImage109;
    @FXML private ImageView tableImage110;
    @FXML private ImageView tableImage111;
    @FXML private ImageView tableImage112;
    @FXML private ImageView tableImage113;
    @FXML private ImageView tableImage114;
    @FXML private ImageView tableImage115;
    @FXML private ImageView tableImage116;
    @FXML private ImageView tableImage117;
    @FXML private ImageView tableImage118;
    @FXML private ImageView tableImage119;
    @FXML private ImageView tableImage120;
    @FXML private ImageView tableImage121;
    @FXML private ImageView tableImage122;
    @FXML private ImageView tableImage123;
    @FXML private ImageView tableImage124;
    @FXML private ImageView tableImage125;
    @FXML private ImageView tableImage126;
    @FXML private ImageView tableImage127;
    @FXML private ImageView tableImage128;
    @FXML private ImageView tableImage129;
    @FXML private ImageView tableImage130;
    @FXML private ImageView tableImage131;
    @FXML private ImageView tableImage132;
    @FXML private ImageView tableImage133;
    @FXML private ImageView tableImage134;
    @FXML private ImageView tableImage135;
    @FXML private ImageView tableImage136;
    @FXML private ImageView tableImage137;
    @FXML private ImageView tableImage138;
    @FXML private ImageView tableImage139;
    @FXML private ImageView tableImage140;
    @FXML private ImageView tableImage141;
    @FXML private ImageView tableImage142;
    @FXML private ImageView tableImage143;
    @FXML private ImageView tableImage144;
    @FXML private ImageView tableImage145;
    @FXML private ImageView tableImage146;
    @FXML private ImageView tableImage147;
    @FXML private ImageView tableImage148;
    @FXML private ImageView tableImage149;
    @FXML private ImageView tableImage150;
    @FXML private ImageView tableImage151;
    @FXML private ImageView tableImage152;
    @FXML private ImageView tableImage153;
    @FXML private ImageView tableImage154;
    @FXML private ImageView tableImage155;
    @FXML private ImageView tableImage156;
    @FXML private ImageView tableImage157;
    @FXML private ImageView tableImage158;
    @FXML private ImageView tableImage159;
    @FXML private ImageView tableImage160;
    @FXML private ImageView tableImage161;
    @FXML private ImageView tableImage162;
    @FXML private ImageView tableImage163;
    @FXML private ImageView tableImage164;
    @FXML private ImageView tableImage165;
    @FXML private ImageView tableImage166;
    @FXML private ImageView tableImage167;
    @FXML private ImageView tableImage168;
    @FXML private ImageView tableImage169;
    @FXML private ImageView tableImage170;
    @FXML private ImageView tableImage171;
    @FXML private ImageView tableImage172;
    @FXML private ImageView tableImage173;
    @FXML private ImageView tableImage174;
    @FXML private ImageView tableImage175;
    @FXML private ImageView tableImage176;
    @FXML private ImageView tableImage177;
    @FXML private ImageView tableImage178;
    @FXML private ImageView tableImage179;
    @FXML private ImageView tableImage180;
    @FXML private ImageView tableImage181;
    @FXML private ImageView tableImage182;
    @FXML private ImageView tableImage183;
    @FXML private ImageView tableImage184;
    @FXML private ImageView tableImage185;
    @FXML private ImageView tableImage186;
    @FXML private ImageView tableImage187;
    @FXML private ImageView tableImage188;
    @FXML private ImageView tableImage189;
    @FXML private ImageView tableImage190;
    @FXML private ImageView tableImage191;
    @FXML private ImageView tableImage192;
    @FXML private ImageView tableImage193;
    @FXML private ImageView tableImage194;
    @FXML private ImageView tableImage195;
    @FXML private ImageView tableImage196;
    @FXML private ImageView tableImage197;
    @FXML private ImageView tableImage198;
    @FXML private ImageView tableImage199;
    @FXML private ImageView tableImage200;
    @FXML private ImageView tableImage201;
    @FXML private ImageView tableImage202;
    @FXML private ImageView tableImage203;
    @FXML private ImageView tableImage204;
    @FXML private ImageView tableImage205;
    @FXML private ImageView tableImage206;
    @FXML private ImageView tableImage207;
    @FXML private ImageView tableImage208;
    @FXML private ImageView tableImage209;
    @FXML private ImageView tableImage210;
    @FXML private ImageView tableImage211;
    @FXML private ImageView tableImage212;
    @FXML private ImageView tableImage213;
    @FXML private ImageView tableImage214;
    @FXML private ImageView tableImage215;
    @FXML private ImageView tableImage216;
    @FXML private ImageView tableImage217;
    @FXML private ImageView tableImage218;
    @FXML private ImageView tableImage219;
    @FXML private ImageView tableImage220;
    @FXML private ImageView tableImage221;
    @FXML private ImageView tableImage222;
    @FXML private ImageView tableImage223;
    @FXML private ImageView tableImage224;
    @FXML private ImageView tableImage225;
}