package com.example.new_game_app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class BagController implements Initializable {
    @FXML
    private Label tokenA;
    @FXML
    private Label tokenB;
    @FXML
    private Label tokenC;
    @FXML
    private Label tokenCH;
    @FXML
    private Label tokenD;
    @FXML
    private Label tokenE;
    @FXML
    private Label tokenF;
    @FXML
    private Label tokenG;
    @FXML
    private Label tokenH;
    @FXML
    private Label tokenI;
    @FXML
    private Label tokenJ;
    @FXML
    private Label tokenL;
    @FXML
    private Label tokenLL;
    @FXML
    private Label tokenM;
    @FXML
    private Label tokenN;
    @FXML
    private Label tokenÑ;
    @FXML
    private Label tokenO;
    @FXML
    private Label tokenP;
    @FXML
    private Label tokenQ;
    @FXML
    private Label tokenR;
    @FXML
    private Label tokenRR;
    @FXML
    private Label tokenS;
    @FXML
    private Label tokenT;
    @FXML
    private Label tokenU;
    @FXML
    private Label tokenV;
    @FXML
    private Label tokenX;
    @FXML
    private Label tokenY;
    @FXML
    private Label tokenZ;
    @FXML
    private Label tokenJoker;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tokenA.setText(String.valueOf(Amount.a));
        tokenB.setText(String.valueOf(Amount.b));
        tokenC.setText(String.valueOf(Amount.c));
        tokenCH.setText(String.valueOf(Amount.ch));
        tokenD.setText(String.valueOf(Amount.d));
        tokenE.setText(String.valueOf(Amount.e));
        tokenF.setText(String.valueOf(Amount.f));
        tokenG.setText(String.valueOf(Amount.g));
        tokenH.setText(String.valueOf(Amount.h));
        tokenI.setText(String.valueOf(Amount.i));
        tokenJ.setText(String.valueOf(Amount.j));
        tokenL.setText(String.valueOf(Amount.l));
        tokenLL.setText(String.valueOf(Amount.ll));
        tokenM.setText(String.valueOf(Amount.m));
        tokenN.setText(String.valueOf(Amount.n));
        tokenÑ.setText(String.valueOf(Amount.ñ));
        tokenO.setText(String.valueOf(Amount.o));
        tokenP.setText(String.valueOf(Amount.p));
        tokenQ.setText(String.valueOf(Amount.q));
        tokenR.setText(String.valueOf(Amount.r));
        tokenRR.setText(String.valueOf(Amount.rr));
        tokenS.setText(String.valueOf(Amount.s));
        tokenT.setText(String.valueOf(Amount.t));
        tokenU.setText(String.valueOf(Amount.u));
        tokenV.setText(String.valueOf(Amount.v));
        tokenX.setText(String.valueOf(Amount.x));
        tokenY.setText(String.valueOf(Amount.y));
        tokenZ.setText(String.valueOf(Amount.z));
        tokenJoker.setText(String.valueOf(Amount.joker));
    }
}
