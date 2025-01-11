package com.example.new_game_app;

import java.util.ArrayList;

public class LettersList {
    private final ArrayList<Letter> list = new ArrayList<>();
    public int jokerValue = 0;

    public LettersList() {
        list.addLast(new Letter(new ImagesURL().tokenA,1));
        list.addLast(new Letter(new ImagesURL().tokenB,4));
        list.addLast(new Letter(new ImagesURL().tokenC,3));
        list.addLast(new Letter(new ImagesURL().tokenCH,8));
        list.addLast(new Letter(new ImagesURL().tokenD,3));
        list.addLast(new Letter(new ImagesURL().tokenE,1));
        list.addLast(new Letter(new ImagesURL().tokenF,5));
        list.addLast(new Letter(new ImagesURL().tokenG,3));
        list.addLast(new Letter(new ImagesURL().tokenH,5));
        list.addLast(new Letter(new ImagesURL().tokenI,1));
        list.addLast(new Letter(new ImagesURL().tokenJ,10));
        list.addLast(new Letter(new ImagesURL().tokenL,2));
        list.addLast(new Letter(new ImagesURL().tokenLL,8));
        list.addLast(new Letter(new ImagesURL().tokenM,3));
        list.addLast(new Letter(new ImagesURL().tokenN,2));
        list.addLast(new Letter(new ImagesURL().tokenÑ,10));
        list.addLast(new Letter(new ImagesURL().tokenO,1));
        list.addLast(new Letter(new ImagesURL().tokenP,4));
        list.addLast(new Letter(new ImagesURL().tokenQ,8));
        list.addLast(new Letter(new ImagesURL().tokenR,2));
        list.addLast(new Letter(new ImagesURL().tokenRR,8));
        list.addLast(new Letter(new ImagesURL().tokenS,1));
        list.addLast(new Letter(new ImagesURL().tokenT,2));
        list.addLast(new Letter(new ImagesURL().tokenU,1));
        list.addLast(new Letter(new ImagesURL().tokenV,4));
        list.addLast(new Letter(new ImagesURL().tokenX,10));
        list.addLast(new Letter(new ImagesURL().tokenY,5));
        list.addLast(new Letter(new ImagesURL().tokenZ,10));
        list.addLast(new Letter(new ImagesURL().tokenJoker,jokerValue));
    }

    public ArrayList<Letter> getList() {
        return list;
    }
}