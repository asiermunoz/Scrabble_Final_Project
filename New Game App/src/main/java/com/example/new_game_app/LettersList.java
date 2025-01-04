package com.example.new_game_app;

import java.util.ArrayList;

public class LettersList {
    private final ArrayList<Letter> list = new ArrayList<>();
    public int jokerValue = 0;

    public LettersList() {
        list.addLast(new Letter(new ImagesURL().tokenA,1,12));
        list.addLast(new Letter(new ImagesURL().tokenB,4,2));
        list.addLast(new Letter(new ImagesURL().tokenC,3,4));
        list.addLast(new Letter(new ImagesURL().tokenCH,8,1));
        list.addLast(new Letter(new ImagesURL().tokenD,3,5));
        list.addLast(new Letter(new ImagesURL().tokenE,1,12));
        list.addLast(new Letter(new ImagesURL().tokenF,5,1));
        list.addLast(new Letter(new ImagesURL().tokenG,3,2));
        list.addLast(new Letter(new ImagesURL().tokenH,5,2));
        list.addLast(new Letter(new ImagesURL().tokenI,1,6));
        list.addLast(new Letter(new ImagesURL().tokenJ,10,1));
        list.addLast(new Letter(new ImagesURL().tokenL,2,4));
        list.addLast(new Letter(new ImagesURL().tokenLL,8,1));
        list.addLast(new Letter(new ImagesURL().tokenM,3,2));
        list.addLast(new Letter(new ImagesURL().tokenN,2,5));
        list.addLast(new Letter(new ImagesURL().tokenÑ,10,1));
        list.addLast(new Letter(new ImagesURL().tokenO,1,9));
        list.addLast(new Letter(new ImagesURL().tokenP,4,2));
        list.addLast(new Letter(new ImagesURL().tokenQ,8,1));
        list.addLast(new Letter(new ImagesURL().tokenR,2,5));
        list.addLast(new Letter(new ImagesURL().tokenRR,8,1));
        list.addLast(new Letter(new ImagesURL().tokenS,1,6));
        list.addLast(new Letter(new ImagesURL().tokenT,2,4));
        list.addLast(new Letter(new ImagesURL().tokenU,1,5));
        list.addLast(new Letter(new ImagesURL().tokenV,4,1));
        list.addLast(new Letter(new ImagesURL().tokenX,10,1));
        list.addLast(new Letter(new ImagesURL().tokenY,5,1));
        list.addLast(new Letter(new ImagesURL().tokenZ,10,1));
        list.addLast(new Letter(new ImagesURL().tokenJoker,jokerValue,2));
    }

    public ArrayList<Letter> getList() {
        return list;
    }
}