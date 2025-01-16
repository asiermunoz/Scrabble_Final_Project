package com.example.new_game_app;

import java.util.ArrayList;

public class LettersList {
    private final ArrayList<Letter> list = new ArrayList<>();
    public int jokerValue = 0;

    public LettersList() {
        list.addLast(new Letter("a", new ImagesURL().tokenA,1));
        list.addLast(new Letter("b", new ImagesURL().tokenB,4));
        list.addLast(new Letter("c", new ImagesURL().tokenC,3));
        list.addLast(new Letter("ch", new ImagesURL().tokenCH,8));
        list.addLast(new Letter("d", new ImagesURL().tokenD,3));
        list.addLast(new Letter("e", new ImagesURL().tokenE,1));
        list.addLast(new Letter("f", new ImagesURL().tokenF,5));
        list.addLast(new Letter("g", new ImagesURL().tokenG,3));
        list.addLast(new Letter("h", new ImagesURL().tokenH,5));
        list.addLast(new Letter("i", new ImagesURL().tokenI,1));
        list.addLast(new Letter("j", new ImagesURL().tokenJ,10));
        list.addLast(new Letter("l", new ImagesURL().tokenL,2));
        list.addLast(new Letter("ll", new ImagesURL().tokenLL,8));
        list.addLast(new Letter("m", new ImagesURL().tokenM,3));
        list.addLast(new Letter("n", new ImagesURL().tokenN,2));
        list.addLast(new Letter("ñ", new ImagesURL().tokenÑ,10));
        list.addLast(new Letter("o", new ImagesURL().tokenO,1));
        list.addLast(new Letter("p", new ImagesURL().tokenP,4));
        list.addLast(new Letter("q", new ImagesURL().tokenQ,8));
        list.addLast(new Letter("r", new ImagesURL().tokenR,2));
        list.addLast(new Letter("rr", new ImagesURL().tokenRR,8));
        list.addLast(new Letter("s", new ImagesURL().tokenS,1));
        list.addLast(new Letter("t", new ImagesURL().tokenT,2));
        list.addLast(new Letter("u", new ImagesURL().tokenU,1));
        list.addLast(new Letter("v", new ImagesURL().tokenV,4));
        list.addLast(new Letter("x", new ImagesURL().tokenX,10));
        list.addLast(new Letter("y", new ImagesURL().tokenY,5));
        list.addLast(new Letter("z", new ImagesURL().tokenZ,10));
        list.addLast(new Letter("☻", new ImagesURL().tokenJoker,jokerValue));
    }

    public ArrayList<Letter> getList() {
        return list;
    }
}