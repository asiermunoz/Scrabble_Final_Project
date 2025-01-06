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
    private ArrayList<ImageView> playerTokens = new ArrayList<>() {
        @FXML
        private Button buttonToken1;
        @FXML
        private Button buttonToken2;
        @FXML
        private Button buttonToken3;
        @FXML
        private Button buttonToken4;
        @FXML
        private Button buttonToken5;
        @FXML
        private Button buttonToken6;
        @FXML
        private Button buttonToken7;
    };
    private ArrayList<Button> buttonTokens = new ArrayList<>() {
        @FXML
        private ImageView token1;
        @FXML
        private ImageView token2;
        @FXML
        private ImageView token3;
        @FXML
        private ImageView token4;
        @FXML
        private ImageView token5;
        @FXML
        private ImageView token6;
        @FXML
        private ImageView token7;
    };
    private ArrayList<Button> actionButtons = new ArrayList<>();
    @FXML
    private Button buttonExchange;
    @FXML
    private Button buttonReturn;
    @FXML
    private Button buttonPlay;

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

    public void modifyLabels() {
        turnAnnouncer.setText("Es el turno de: " + game.getTurn().getAlias());
        player1Name.setText(game.getPlayer1().getAlias());
        player1Score.setText(String.valueOf(game.getPlayer1().getScore()));
        player2Name.setText(game.getPlayer2().getAlias());
        player2Score.setText(String.valueOf(game.getPlayer2().getScore()));
    }

    public void showHolder() {
        int i = 0;
        for (ImageView view : playerTokens) {
            if (i < game.getTurn().getHolder().getHoldSize()) {
                view.setImage(new Image(game.getTurn().getHolder().hold.get(i).getLink()));
                view.setOpacity(1);
            } else {
                view.setImage(new Image(getClass().getResourceAsStream(new ImagesURL().emptySpace)));
                view.setOpacity(0.28);
                buttonTokens.get(i).setDisable(true);
            }
            i++;
        }
    }

    public void nextTurn(javafx.event.ActionEvent actionEvent) {
        if (game.getSkippedTurns() == 4) {
            game.finishGame(actionEvent);
        }
        if (game.getTurn() == game.getOrder().getFirstPlayer()) {
            game.turnToLastPlayer();
        } else {
            game.turnToFirstPlayer();
        }
        modifyLabels();
        showHolder();
        for (Button button : actionButtons) {
            if (button != buttonReturn || button != buttonPlay) {
                button.setOpacity(1);
                button.setDisable(false);
            } else {
                button.setOpacity(0.28);
                button.setDisable(true);
            }
        }
    }

    public void onPassTurnButtonClick(javafx.event.ActionEvent actionEvent) {
        if (!doNotCountPass) {
            game.addSkippedTurns();
        }
        exceptions.setText(game.getTurn().getAlias() + " paso su turno.");
        doNotCountPass = false;
        nextTurn(actionEvent);
    }

    public void onSelectedTokenButtonClick(javafx.event.ActionEvent actionEvent) {
        int i = 0;
        for (Button button : buttonTokens) {
            if (actionEvent.getSource() == button) {
                if (button.getOpacity() == 1) {
                    button.setOpacity(0.28);
                    game.addLettersToUse(i);
                } else {
                    button.setOpacity(1);
                }
            }
            i++;
        }
    }

    @FXML
    public void onExchangeButtonClick() {
        exceptions.setText("Se intercambiaron todas sus fichas.");
        game.exchange();
        game.restartSkippedTurns();
        showHolder();
        doNotCountPass = true;
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

    //ID DE CADA CUADRO DEL TABLERO
    private ArrayList<Button> tableButtons = new ArrayList<>() {
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
    };
    //IMAGE VIEW
    private ArrayList<ImageView> tableImages = new ArrayList<>() {
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
//        @FXML private ImageView tableImage61;
//        @FXML private ImageView tableImage62;
//        @FXML private ImageView tableImage63;
//        @FXML private ImageView tableImage64;
//        @FXML private ImageView tableImage65;
//        @FXML private ImageView tableImage66;
//        @FXML private ImageView tableImage67;
//        @FXML private ImageView tableImage68;
//        @FXML private ImageView tableImage69;
//        @FXML private ImageView tableImage70;
//        @FXML private ImageView tableImage71;
//        @FXML private ImageView tableImage72;
//        @FXML private ImageView tableImage73;
//        @FXML private ImageView tableImage74;
//        @FXML private ImageView tableImage75;
//        @FXML private ImageView tableImage76;
//        @FXML private ImageView tableImage77;
//        @FXML private ImageView tableImage78;
//        @FXML private ImageView tableImage79;
//        @FXML private ImageView tableImage80;
//        @FXML private ImageView tableImage81;
//        @FXML private ImageView tableImage82;
//        @FXML private ImageView tableImage83;
//        @FXML private ImageView tableImage84;
//        @FXML private ImageView tableImage85;
//        @FXML private ImageView tableImage86;
//        @FXML private ImageView tableImage87;
//        @FXML private ImageView tableImage88;
//        @FXML private ImageView tableImage89;
//        @FXML private ImageView tableImage90;
//        @FXML private ImageView tableImage91;
//        @FXML private ImageView tableImage92;
//        @FXML private ImageView tableImage93;
//        @FXML private ImageView tableImage94;
//        @FXML private ImageView tableImage95;
//        @FXML private ImageView tableImage96;
//        @FXML private ImageView tableImage97;
//        @FXML private ImageView tableImage98;
//        @FXML private ImageView tableImage99;
//        @FXML private ImageView tableImage100;
//        @FXML private ImageView tableImage101;
//        @FXML private ImageView tableImage102;
//        @FXML private ImageView tableImage103;
//        @FXML private ImageView tableImage104;
//        @FXML private ImageView tableImage105;
//        @FXML private ImageView tableImage106;
//        @FXML private ImageView tableImage107;
//        @FXML private ImageView tableImage108;
//        @FXML private ImageView tableImage109;
//        @FXML private ImageView tableImage110;
//        @FXML private ImageView tableImage111;
//        @FXML private ImageView tableImage112;
//        @FXML private ImageView tableImage113;
//        @FXML private ImageView tableImage114;
//        @FXML private ImageView tableImage115;
//        @FXML private ImageView tableImage116;
//        @FXML private ImageView tableImage117;
//        @FXML private ImageView tableImage118;
//        @FXML private ImageView tableImage119;
//        @FXML private ImageView tableImage120;
//        @FXML private ImageView tableImage121;
//        @FXML private ImageView tableImage122;
//        @FXML private ImageView tableImage123;
//        @FXML private ImageView tableImage124;
//        @FXML private ImageView tableImage125;
//        @FXML private ImageView tableImage126;
//        @FXML private ImageView tableImage127;
//        @FXML private ImageView tableImage128;
//        @FXML private ImageView tableImage129;
//        @FXML private ImageView tableImage130;
//        @FXML private ImageView tableImage131;
//        @FXML private ImageView tableImage132;
//        @FXML private ImageView tableImage133;
//        @FXML private ImageView tableImage134;
//        @FXML private ImageView tableImage135;
//        @FXML private ImageView tableImage136;
//        @FXML private ImageView tableImage137;
//        @FXML private ImageView tableImage138;
//        @FXML private ImageView tableImage139;
//        @FXML private ImageView tableImage140;
//        @FXML private ImageView tableImage141;
//        @FXML private ImageView tableImage142;
//        @FXML private ImageView tableImage143;
//        @FXML private ImageView tableImage144;
//        @FXML private ImageView tableImage145;
//        @FXML private ImageView tableImage146;
//        @FXML private ImageView tableImage147;
//        @FXML private ImageView tableImage148;
//        @FXML private ImageView tableImage149;
//        @FXML private ImageView tableImage150;
//        @FXML private ImageView tableImage151;
//        @FXML private ImageView tableImage152;
//        @FXML private ImageView tableImage153;
//        @FXML private ImageView tableImage154;
//        @FXML private ImageView tableImage155;
//        @FXML private ImageView tableImage156;
//        @FXML private ImageView tableImage157;
//        @FXML private ImageView tableImage158;
//        @FXML private ImageView tableImage159;
//        @FXML private ImageView tableImage160;
//        @FXML private ImageView tableImage161;
//        @FXML private ImageView tableImage162;
//        @FXML private ImageView tableImage163;
//        @FXML private ImageView tableImage164;
//        @FXML private ImageView tableImage165;
//        @FXML private ImageView tableImage166;
//        @FXML private ImageView tableImage167;
//        @FXML private ImageView tableImage168;
//        @FXML private ImageView tableImage169;
//        @FXML private ImageView tableImage170;
//        @FXML private ImageView tableImage171;
//        @FXML private ImageView tableImage172;
//        @FXML private ImageView tableImage173;
//        @FXML private ImageView tableImage174;
//        @FXML private ImageView tableImage175;
//        @FXML private ImageView tableImage176;
//        @FXML private ImageView tableImage177;
//        @FXML private ImageView tableImage178;
//        @FXML private ImageView tableImage179;
//        @FXML private ImageView tableImage180;
//        @FXML private ImageView tableImage181;
//        @FXML private ImageView tableImage182;
//        @FXML private ImageView tableImage183;
//        @FXML private ImageView tableImage184;
//        @FXML private ImageView tableImage185;
//        @FXML private ImageView tableImage186;
//        @FXML private ImageView tableImage187;
//        @FXML private ImageView tableImage188;
//        @FXML private ImageView tableImage189;
//        @FXML private ImageView tableImage190;
//        @FXML private ImageView tableImage191;
//        @FXML private ImageView tableImage192;
//        @FXML private ImageView tableImage193;
//        @FXML private ImageView tableImage194;
//        @FXML private ImageView tableImage195;
//        @FXML private ImageView tableImage196;
//        @FXML private ImageView tableImage197;
//        @FXML private ImageView tableImage198;
//        @FXML private ImageView tableImage199;
//        @FXML private ImageView tableImage200;
//        @FXML private ImageView tableImage201;
//        @FXML private ImageView tableImage202;
//        @FXML private ImageView tableImage203;
//        @FXML private ImageView tableImage204;
//        @FXML private ImageView tableImage205;
//        @FXML private ImageView tableImage206;
//        @FXML private ImageView tableImage207;
//        @FXML private ImageView tableImage208;
//        @FXML private ImageView tableImage209;
//        @FXML private ImageView tableImage210;
//        @FXML private ImageView tableImage211;
//        @FXML private ImageView tableImage212;
//        @FXML private ImageView tableImage213;
//        @FXML private ImageView tableImage214;
//        @FXML private ImageView tableImage215;
//        @FXML private ImageView tableImage216;
//        @FXML private ImageView tableImage217;
//        @FXML private ImageView tableImage218;
//        @FXML private ImageView tableImage219;
//        @FXML private ImageView tableImage220;
//        @FXML private ImageView tableImage221;
//        @FXML private ImageView tableImage222;
//        @FXML private ImageView tableImage223;
//        @FXML private ImageView tableImage224;
//        @FXML private ImageView tableImage225;
    };

}