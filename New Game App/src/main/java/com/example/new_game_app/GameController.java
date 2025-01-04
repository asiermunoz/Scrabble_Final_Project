package com.example.new_game_app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class GameController implements Initializable {
    private Game game;
    private Boolean doNotCountPass = false;
    private final PopUpSelected popUpselected = new PopUpSelected();

    @FXML private Label exceptions;
    @FXML private Label turnAnnouncer;
    @FXML private Label player1Name;
    @FXML private Label player1Score;
    @FXML private Label player2Name;
    @FXML private Label player2Score;
    private ArrayList<ImageView> playerTokens = new ArrayList<>(){
        @FXML private Button buttonToken1;
        @FXML private Button buttonToken2;
        @FXML private Button buttonToken3;
        @FXML private Button buttonToken4;
        @FXML private Button buttonToken5;
        @FXML private Button buttonToken6;
        @FXML private Button buttonToken7;
    };
    private ArrayList<Button> buttonTokens = new ArrayList<>(){
        @FXML private ImageView token1;
        @FXML private ImageView token2;
        @FXML private ImageView token3;
        @FXML private ImageView token4;
        @FXML private ImageView token5;
        @FXML private ImageView token6;
        @FXML private ImageView token7;
    };
    private ArrayList<Button> actionButtons = new ArrayList<>();
    @FXML private Button buttonExchange;
    @FXML private Button buttonReturn;
    @FXML private Button buttonPlay;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = new Game();
        game.setGame(exceptions);

        actionButtons.add(buttonExchange);
        actionButtons.add(buttonReturn);
        actionButtons.add(buttonPlay);
        StageManager.exit = new Stage();
        StageManager.bag = new Stage();
        StageManager.stadistics = new Stage();
        modifyLabels();
        showHolder();
    }

    public void modifyLabels(){
        turnAnnouncer.setText("Es el turno de: " + game.getTurn().getAlias());
        player1Name.setText(game.getPlayer1().getAlias());
        player1Score.setText(String.valueOf(game.getPlayer1().getScore()));
        player2Name.setText(game.getPlayer2().getAlias());
        player2Score.setText(String.valueOf(game.getPlayer2().getScore()));
    }

    public void showHolder(){
        int i = 0;
        for(ImageView view:playerTokens){
            if(i<game.getTurn().getHolder().getHoldSize()){
                view.setImage(new Image(game.getTurn().getHolder().hold.get(i).getLink()));
                view.setOpacity(1);
            } else {
                view.setImage(new Image(new ImagesURL().emptySpace));
                view.setOpacity(0.28);
                buttonTokens.get(i).setDisable(true);
            }
            i++;
        }
    }

    public void nextTurn(javafx.event.ActionEvent actionEvent){
        if(game.getSkippedTurns() == 4){
            game.finishGame(actionEvent);
        }
        if(game.getTurn() == game.getOrder().getFirstPlayer()){
            game.turnToLastPlayer();
        }
        else{
            game.turnToFirstPlayer();
        }
        modifyLabels();
        showHolder();
        for(Button button:actionButtons){
            if(button != buttonReturn || button != buttonPlay) {
                button.setOpacity(1);
                button.setDisable(false);
            }
            else{
                button.setOpacity(0.28);
                button.setDisable(true);
            }
        }
    }

    public void onPassTurnButtonClick(javafx.event.ActionEvent actionEvent) {
        if(!doNotCountPass) {
            game.addSkippedTurns();
        }
        exceptions.setText(game.getTurn().getAlias() + " paso su turno.");
        doNotCountPass = false;
        nextTurn(actionEvent);
    }

    public void onSelectedTokenButtonClick(javafx.event.ActionEvent actionEvent){
        int i = 0;
        for(Button button:buttonTokens){
            if(actionEvent.getSource() == button){
                if(button.getOpacity() == 1) {
                    button.setOpacity(0.28);
                    game.addLettersToUse(i);
                }
                else{
                    button.setOpacity(1);
                }
            }
            i++;
        }
    }

    @FXML
    public void onExchangeButtonClick(){
        exceptions.setText("Se intercambiaron todas sus fichas.");
        game.exchange();
        game.restartSkippedTurns();
        showHolder();
        doNotCountPass = true;
        for(Button button:actionButtons){
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

    //ID DE CADA CUADRO DEL TABLERO
    @FXML
    private Button tabelButton1;
    @FXML
    private Button tabelButton2;
    @FXML
    private Button tabelButton3;
    @FXML
    private Button tabelButton4;
    @FXML
    private Button tabelButton5;
    @FXML
    private Button tabelButton6;
    @FXML
    private Button tabelButton7;
    @FXML
    private Button tabelButton8;
    @FXML
    private Button tabelButton9;
    @FXML
    private Button tabelButton10;
    @FXML
    private Button tabelButton11;
    @FXML
    private Button tabelButton12;
    @FXML
    private Button tabelButton13;
    @FXML
    private Button tabelButton14;
    @FXML
    private Button tabelButton15;
    @FXML
    private Button tabelButton16;
    @FXML
    private Button tabelButton17;
    @FXML
    private Button tabelButton18;
    @FXML
    private Button tabelButton19;
    @FXML
    private Button tabelButton20;
    @FXML
    private Button tabelButton21;
    @FXML
    private Button tabelButton22;
    @FXML
    private Button tabelButton23;
    @FXML
    private Button tabelButton24;
    @FXML
    private Button tabelButton25;
    @FXML
    private Button tabelButton26;
    @FXML
    private Button tabelButton27;
    @FXML
    private Button tabelButton28;
    @FXML
    private Button tabelButton29;
    @FXML
    private Button tabelButton30;
    @FXML
    private Button tabelButton31;
    @FXML
    private Button tabelButton32;
    @FXML
    private Button tabelButton33;
    @FXML
    private Button tabelButton34;
    @FXML
    private Button tabelButton35;
    @FXML
    private Button tabelButton36;
    @FXML
    private Button tabelButton37;
    @FXML
    private Button tabelButton38;
    @FXML
    private Button tabelButton39;
    @FXML
    private Button tabelButton40;
    @FXML
    private Button tabelButton41;
    @FXML
    private Button tabelButton42;
    @FXML
    private Button tabelButton43;
    @FXML
    private Button tabelButton44;
    @FXML
    private Button tabelButton45;
    @FXML
    private Button tabelButton46;
    @FXML
    private Button tabelButton47;
    @FXML
    private Button tabelButton48;
    @FXML
    private Button tabelButton49;
    @FXML
    private Button tabelButton50;
    @FXML
    private Button tabelButton51;
    @FXML
    private Button tabelButton52;
    @FXML
    private Button tabelButton53;
    @FXML
    private Button tabelButton54;
    @FXML
    private Button tabelButton55;
    @FXML
    private Button tabelButton56;
    @FXML
    private Button tabelButton57;
    @FXML
    private Button tabelButton58;
    @FXML
    private Button tabelButton59;
    @FXML
    private Button tabelButton60;
    @FXML
    private Button tabelButton61;
    @FXML
    private Button tabelButton62;
    @FXML
    private Button tabelButton63;
    @FXML
    private Button tabelButton64;
    @FXML
    private Button tabelButton65;
    @FXML
    private Button tabelButton66;
    @FXML
    private Button tabelButton67;
    @FXML
    private Button tabelButton68;
    @FXML
    private Button tabelButton69;
    @FXML
    private Button tabelButton70;
    @FXML
    private Button tabelButton71;
    @FXML
    private Button tabelButton72;
    @FXML
    private Button tabelButton73;
    @FXML
    private Button tabelButton74;
    @FXML
    private Button tabelButton75;
    @FXML
    private Button tabelButton76;
    @FXML
    private Button tabelButton77;
    @FXML
    private Button tabelButton78;
    @FXML
    private Button tabelButton79;
    @FXML
    private Button tabelButton80;
    @FXML
    private Button tabelButton81;
    @FXML
    private Button tabelButton82;
    @FXML
    private Button tabelButton83;
    @FXML
    private Button tabelButton84;
    @FXML
    private Button tabelButton85;
    @FXML
    private Button tabelButton86;
    @FXML
    private Button tabelButton87;
    @FXML
    private Button tabelButton88;
    @FXML
    private Button tabelButton89;
    @FXML
    private Button tabelButton90;
    @FXML
    private Button tabelButton91;
    @FXML
    private Button tabelButton92;
    @FXML
    private Button tabelButton93;
    @FXML
    private Button tabelButton94;
    @FXML
    private Button tabelButton95;
    @FXML
    private Button tabelButton96;
    @FXML
    private Button tabelButton97;
    @FXML
    private Button tabelButton98;
    @FXML
    private Button tabelButton99;
    @FXML
    private Button tabelButton100;
    @FXML
    private Button tabelButton101;
    @FXML
    private Button tabelButton102;
    @FXML
    private Button tabelButton103;
    @FXML
    private Button tabelButton104;
    @FXML
    private Button tabelButton105;
    @FXML
    private Button tabelButton106;
    @FXML
    private Button tabelButton107;
    @FXML
    private Button tabelButton108;
    @FXML
    private Button tabelButton109;
    @FXML
    private Button tabelButton110;
    @FXML
    private Button tabelButton111;
    @FXML
    private Button tabelButton112;
    @FXML
    private Button tabelButton113;
    @FXML
    private Button tabelButton114;
    @FXML
    private Button tabelButton115;
    @FXML
    private Button tabelButton116;
    @FXML
    private Button tabelButton117;
    @FXML
    private Button tabelButton118;
    @FXML
    private Button tabelButton119;
    @FXML
    private Button tabelButton120;
    @FXML
    private Button tabelButton121;
    @FXML
    private Button tabelButton122;
    @FXML
    private Button tabelButton123;
    @FXML
    private Button tabelButton124;
    @FXML
    private Button tabelButton125;
    @FXML
    private Button tabelButton126;
    @FXML
    private Button tabelButton127;
    @FXML
    private Button tabelButton128;
    @FXML
    private Button tabelButton129;
    @FXML
    private Button tabelButton130;
    @FXML
    private Button tabelButton131;
    @FXML
    private Button tabelButton132;
    @FXML
    private Button tabelButton133;
    @FXML
    private Button tabelButton134;
    @FXML
    private Button tabelButton135;
    @FXML
    private Button tabelButton136;
    @FXML
    private Button tabelButton137;
    @FXML
    private Button tabelButton138;
    @FXML
    private Button tabelButton139;
    @FXML
    private Button tabelButton140;
    @FXML
    private Button tabelButton141;
    @FXML
    private Button tabelButton142;
    @FXML
    private Button tabelButton143;
    @FXML
    private Button tabelButton144;
    @FXML
    private Button tabelButton145;
    @FXML
    private Button tabelButton146;
    @FXML
    private Button tabelButton147;
    @FXML
    private Button tabelButton148;
    @FXML
    private Button tabelButton149;
    @FXML
    private Button tabelButton150;
    @FXML
    private Button tabelButton151;
    @FXML
    private Button tabelButton152;
    @FXML
    private Button tabelButton153;
    @FXML
    private Button tabelButton154;
    @FXML
    private Button tabelButton155;
    @FXML
    private Button tabelButton156;
    @FXML
    private Button tabelButton157;
    @FXML
    private Button tabelButton158;
    @FXML
    private Button tabelButton159;
    @FXML
    private Button tabelButton160;
    @FXML
    private Button tabelButton161;
    @FXML
    private Button tabelButton162;
    @FXML
    private Button tabelButton163;
    @FXML
    private Button tabelButton164;
    @FXML
    private Button tabelButton165;
    @FXML
    private Button tabelButton166;
    @FXML
    private Button tabelButton167;
    @FXML
    private Button tabelButton168;
    @FXML
    private Button tabelButton169;
    @FXML
    private Button tabelButton170;
    @FXML
    private Button tabelButton171;
    @FXML
    private Button tabelButton172;
    @FXML
    private Button tabelButton173;
    @FXML
    private Button tabelButton174;
    @FXML
    private Button tabelButton175;
    @FXML
    private Button tabelButton176;
    @FXML
    private Button tabelButton177;
    @FXML
    private Button tabelButton178;
    @FXML
    private Button tabelButton179;
    @FXML
    private Button tabelButton180;
    @FXML
    private Button tabelButton181;
    @FXML
    private Button tabelButton182;
    @FXML
    private Button tabelButton183;
    @FXML
    private Button tabelButton184;
    @FXML
    private Button tabelButton185;
    @FXML
    private Button tabelButton186;
    @FXML
    private Button tabelButton187;
    @FXML
    private Button tabelButton188;
    @FXML
    private Button tabelButton189;
    @FXML
    private Button tabelButton190;
    @FXML
    private Button tabelButton191;
    @FXML
    private Button tabelButton192;
    @FXML
    private Button tabelButton193;
    @FXML
    private Button tabelButton194;
    @FXML
    private Button tabelButton195;
    @FXML
    private Button tabelButton196;
    @FXML
    private Button tabelButton197;
    @FXML
    private Button tabelButton198;
    @FXML
    private Button tabelButton199;
    @FXML
    private Button tabelButton200;
    @FXML
    private Button tabelButton201;
    @FXML
    private Button tabelButton202;
    @FXML
    private Button tabelButton203;
    @FXML
    private Button tabelButton204;
    @FXML
    private Button tabelButton205;
    @FXML
    private Button tabelButton206;
    @FXML
    private Button tabelButton207;
    @FXML
    private Button tabelButton208;
    @FXML
    private Button tabelButton209;
    @FXML
    private Button tabelButton210;
    @FXML
    private Button tabelButton211;
    @FXML
    private Button tabelButton212;
    @FXML
    private Button tabelButton213;
    @FXML
    private Button tabelButton214;
    @FXML
    private Button tabelButton215;
    @FXML
    private Button tabelButton216;
    @FXML
    private Button tabelButton217;
    @FXML
    private Button tabelButton218;
    @FXML
    private Button tabelButton219;
    @FXML
    private Button tabelButton220;
    @FXML
    private Button tabelButton221;
    @FXML
    private Button tabelButton222;
    @FXML
    private Button tabelButton223;
    @FXML
    private Button tabelButton224;
    @FXML
    private Button tabelButton225;

    //IMAGE VIEW
    @FXML
    private ImageView tabelImage1;
    @FXML
    private ImageView tabelImage2;
    @FXML
    private ImageView tabelImage3;
    @FXML
    private ImageView tabelImage4;
    @FXML
    private ImageView tabelImage5;
    @FXML
    private ImageView tabelImage6;
    @FXML
    private ImageView tabelImage7;
    @FXML
    private ImageView tabelImage8;
    @FXML
    private ImageView tabelImage9;
    @FXML
    private ImageView tabelImage10;
    @FXML
    private ImageView tabelImage11;
    @FXML
    private ImageView tabelImage12;
    @FXML
    private ImageView tabelImage13;
    @FXML
    private ImageView tabelImage14;
    @FXML
    private ImageView tabelImage15;
    @FXML
    private ImageView tabelImage16;
    @FXML
    private ImageView tabelImage17;
    @FXML
    private ImageView tabelImage18;
    @FXML
    private ImageView tabelImage19;
    @FXML
    private ImageView tabelImage20;
    @FXML
    private ImageView tabelImage21;
    @FXML
    private ImageView tabelImage22;
    @FXML
    private ImageView tabelImage23;
    @FXML
    private ImageView tabelImage24;
    @FXML
    private ImageView tabelImage25;
    @FXML
    private ImageView tabelImage26;
    @FXML
    private ImageView tabelImage27;
    @FXML
    private ImageView tabelImage28;
    @FXML
    private ImageView tabelImage29;
    @FXML
    private ImageView tabelImage30;
    @FXML
    private ImageView tabelImage31;
    @FXML
    private ImageView tabelImage32;
    @FXML
    private ImageView tabelImage33;
    @FXML
    private ImageView tabelImage34;
    @FXML
    private ImageView tabelImage35;
    @FXML
    private ImageView tabelImage36;
    @FXML
    private ImageView tabelImage37;
    @FXML
    private ImageView tabelImage38;
    @FXML
    private ImageView tabelImage39;
    @FXML
    private ImageView tabelImage40;
    @FXML
    private ImageView tabelImage41;
    @FXML
    private ImageView tabelImage42;
    @FXML
    private ImageView tabelImage43;
    @FXML
    private ImageView tabelImage44;
    @FXML
    private ImageView tabelImage45;
    @FXML
    private ImageView tabelImage46;
    @FXML
    private ImageView tabelImage47;
    @FXML
    private ImageView tabelImage48;
    @FXML
    private ImageView tabelImage49;
    @FXML
    private ImageView tabelImage50;
    @FXML
    private ImageView tabelImage51;
    @FXML
    private ImageView tabelImage52;
    @FXML
    private ImageView tabelImage53;
    @FXML
    private ImageView tabelImage54;
    @FXML
    private ImageView tabelImage55;
    @FXML
    private ImageView tabelImage56;
    @FXML
    private ImageView tabelImage57;
    @FXML
    private ImageView tabelImage58;
    @FXML
    private ImageView tabelImage59;
    @FXML
    private ImageView tabelImage60;
    @FXML
    private ImageView tabelImage61;
    @FXML
    private ImageView tabelImage62;
    @FXML
    private ImageView tabelImage63;
    @FXML
    private ImageView tabelImage64;
    @FXML
    private ImageView tabelImage65;
    @FXML
    private ImageView tabelImage66;
    @FXML
    private ImageView tabelImage67;
    @FXML
    private ImageView tabelImage68;
    @FXML
    private ImageView tabelImage69;
    @FXML
    private ImageView tabelImage70;
    @FXML
    private ImageView tabelImage71;
    @FXML
    private ImageView tabelImage72;
    @FXML
    private ImageView tabelImage73;
    @FXML
    private ImageView tabelImage74;
    @FXML
    private ImageView tabelImage75;
    @FXML
    private ImageView tabelImage76;
    @FXML
    private ImageView tabelImage77;
    @FXML
    private ImageView tabelImage78;
    @FXML
    private ImageView tabelImage79;
    @FXML
    private ImageView tabelImage80;
    @FXML
    private ImageView tabelImage81;
    @FXML
    private ImageView tabelImage82;
    @FXML
    private ImageView tabelImage83;
    @FXML
    private ImageView tabelImage84;
    @FXML
    private ImageView tabelImage85;
    @FXML
    private ImageView tabelImage86;
    @FXML
    private ImageView tabelImage87;
    @FXML
    private ImageView tabelImage88;
    @FXML
    private ImageView tabelImage89;
    @FXML
    private ImageView tabelImage90;
    @FXML
    private ImageView tabelImage91;
    @FXML
    private ImageView tabelImage92;
    @FXML
    private ImageView tabelImage93;
    @FXML
    private ImageView tabelImage94;
    @FXML
    private ImageView tabelImage95;
    @FXML
    private ImageView tabelImage96;
    @FXML
    private ImageView tabelImage97;
    @FXML
    private ImageView tabelImage98;
    @FXML
    private ImageView tabelImage99;
    @FXML
    private ImageView tabelImage100;
    @FXML
    private ImageView tabelImage101;
    @FXML
    private ImageView tabelImage102;
    @FXML
    private ImageView tabelImage103;
    @FXML
    private ImageView tabelImage104;
    @FXML
    private ImageView tabelImage105;
    @FXML
    private ImageView tabelImage106;
    @FXML
    private ImageView tabelImage107;
    @FXML
    private ImageView tabelImage108;
    @FXML
    private ImageView tabelImage109;
    @FXML
    private ImageView tabelImage110;
    @FXML
    private ImageView tabelImage111;
    @FXML
    private ImageView tabelImage112;
    @FXML
    private ImageView tabelImage113;
    @FXML
    private ImageView tabelImage114;
    @FXML
    private ImageView tabelImage115;
    @FXML
    private ImageView tabelImage116;
    @FXML
    private ImageView tabelImage117;
    @FXML
    private ImageView tabelImage118;
    @FXML
    private ImageView tabelImage119;
    @FXML
    private ImageView tabelImage120;
    @FXML
    private ImageView tabelImage121;
    @FXML
    private ImageView tabelImage122;
    @FXML
    private ImageView tabelImage123;
    @FXML
    private ImageView tabelImage124;
    @FXML
    private ImageView tabelImage125;
    @FXML
    private ImageView tabelImage126;
    @FXML
    private ImageView tabelImage127;
    @FXML
    private ImageView tabelImage128;
    @FXML
    private ImageView tabelImage129;
    @FXML
    private ImageView tabelImage130;
    @FXML
    private ImageView tabelImage131;
    @FXML
    private ImageView tabelImage132;
    @FXML
    private ImageView tabelImage133;
    @FXML
    private ImageView tabelImage134;
    @FXML
    private ImageView tabelImage135;
    @FXML
    private ImageView tabelImage136;
    @FXML
    private ImageView tabelImage137;
    @FXML
    private ImageView tabelImage138;
    @FXML
    private ImageView tabelImage139;
    @FXML
    private ImageView tabelImage140;
    @FXML
    private ImageView tabelImage141;
    @FXML
    private ImageView tabelImage142;
    @FXML
    private ImageView tabelImage143;
    @FXML
    private ImageView tabelImage144;
    @FXML
    private ImageView tabelImage145;
    @FXML
    private ImageView tabelImage146;
    @FXML
    private ImageView tabelImage147;
    @FXML
    private ImageView tabelImage148;
    @FXML
    private ImageView tabelImage149;
    @FXML
    private ImageView tabelImage150;
    @FXML
    private ImageView tabelImage151;
    @FXML
    private ImageView tabelImage152;
    @FXML
    private ImageView tabelImage153;
    @FXML
    private ImageView tabelImage154;
    @FXML
    private ImageView tabelImage155;
    @FXML
    private ImageView tabelImage156;
    @FXML
    private ImageView tabelImage157;
    @FXML
    private ImageView tabelImage158;
    @FXML
    private ImageView tabelImage159;
    @FXML
    private ImageView tabelImage160;
    @FXML
    private ImageView tabelImage161;
    @FXML
    private ImageView tabelImage162;
    @FXML
    private ImageView tabelImage163;
    @FXML
    private ImageView tabelImage164;
    @FXML
    private ImageView tabelImage165;
    @FXML
    private ImageView tabelImage166;
    @FXML
    private ImageView tabelImage167;
    @FXML
    private ImageView tabelImage168;
    @FXML
    private ImageView tabelImage169;
    @FXML
    private ImageView tabelImage170;
    @FXML
    private ImageView tabelImage171;
    @FXML
    private ImageView tabelImage172;
    @FXML
    private ImageView tabelImage173;
    @FXML
    private ImageView tabelImage174;
    @FXML
    private ImageView tabelImage175;
    @FXML
    private ImageView tabelImage176;
    @FXML
    private ImageView tabelImage177;
    @FXML
    private ImageView tabelImage178;
    @FXML
    private ImageView tabelImage179;
    @FXML
    private ImageView tabelImage180;
    @FXML
    private ImageView tabelImage181;
    @FXML
    private ImageView tabelImage182;
    @FXML
    private ImageView tabelImage183;
    @FXML
    private ImageView tabelImage184;
    @FXML
    private ImageView tabelImage185;
    @FXML
    private ImageView tabelImage186;
    @FXML
    private ImageView tabelImage187;
    @FXML
    private ImageView tabelImage188;
    @FXML
    private ImageView tabelImage189;
    @FXML
    private ImageView tabelImage190;
    @FXML
    private ImageView tabelImage191;
    @FXML
    private ImageView tabelImage192;
    @FXML
    private ImageView tabelImage193;
    @FXML
    private ImageView tabelImage194;
    @FXML
    private ImageView tabelImage195;
    @FXML
    private ImageView tabelImage196;
    @FXML
    private ImageView tabelImage197;
    @FXML
    private ImageView tabelImage198;
    @FXML
    private ImageView tabelImage199;
    @FXML
    private ImageView tabelImage200;
    @FXML
    private ImageView tabelImage201;
    @FXML
    private ImageView tabelImage202;
    @FXML
    private ImageView tabelImage203;
    @FXML
    private ImageView tabelImage204;
    @FXML
    private ImageView tabelImage205;
    @FXML
    private ImageView tabelImage206;
    @FXML
    private ImageView tabelImage207;
    @FXML
    private ImageView tabelImage208;
    @FXML
    private ImageView tabelImage209;
    @FXML
    private ImageView tabelImage210;
    @FXML
    private ImageView tabelImage211;
    @FXML
    private ImageView tabelImage212;
    @FXML
    private ImageView tabelImage213;
    @FXML
    private ImageView tabelImage214;
    @FXML
    private ImageView tabelImage215;
    @FXML
    private ImageView tabelImage216;
    @FXML
    private ImageView tabelImage217;
    @FXML
    private ImageView tabelImage218;
    @FXML
    private ImageView tabelImage219;
    @FXML
    private ImageView tabelImage220;
    @FXML
    private ImageView tabelImage221;
    @FXML
    private ImageView tabelImage222;
    @FXML
    private ImageView tabelImage223;
    @FXML
    private ImageView tabelImage224;
    @FXML
    private ImageView tabelImage225;


}