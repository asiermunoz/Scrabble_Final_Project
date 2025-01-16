package com.example.new_game_app;

import java.util.Objects;

public class Letter {
    private String letter;
    private String link;
    private int value;
    private boolean joker;

    public Letter(String letter, String link, int value) {
        this.letter = letter;
        this.link = link;
        this.value = value;
        this.joker = false;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isJoker() {
        return joker;
    }

    public void setJoker(boolean joker) {
        this.joker = joker;
    }

    public int getAmount() {
        int amount = 0;
        if(Objects.equals(link, new ImagesURL().tokenA)){
            amount = Amount.a;
        }
        if(Objects.equals(link, new ImagesURL().tokenB)){
            amount = Amount.b;
        }
        if(Objects.equals(link, new ImagesURL().tokenC)){
            amount = Amount.c;
        }
        if(Objects.equals(link, new ImagesURL().tokenCH)){
            amount = Amount.ch;
        }
        if(Objects.equals(link, new ImagesURL().tokenD)){
            amount = Amount.d;
        }
        if(Objects.equals(link, new ImagesURL().tokenE)){
            amount = Amount.e;
        }
        if(Objects.equals(link, new ImagesURL().tokenF)){
            amount = Amount.f;
        }
        if(Objects.equals(link, new ImagesURL().tokenG)){
            amount = Amount.g;
        }
        if(Objects.equals(link, new ImagesURL().tokenH)){
            amount = Amount.h;
        }
        if(Objects.equals(link, new ImagesURL().tokenI)){
            amount = Amount.i;
        }
        if(Objects.equals(link, new ImagesURL().tokenJ)){
            amount = Amount.j;
        }
        if(Objects.equals(link, new ImagesURL().tokenL)){
            amount = Amount.l;
        }
        if(Objects.equals(link, new ImagesURL().tokenLL)){
            amount = Amount.ll;
        }
        if(Objects.equals(link, new ImagesURL().tokenM)){
            amount = Amount.m;
        }
        if(Objects.equals(link, new ImagesURL().tokenN)){
            amount = Amount.n;
        }
        if(Objects.equals(link, new ImagesURL().tokenÑ)){
            amount = Amount.ñ;
        }
        if(Objects.equals(link, new ImagesURL().tokenO)){
            amount = Amount.o;
        }
        if(Objects.equals(link, new ImagesURL().tokenP)){
            amount = Amount.p;
        }
        if(Objects.equals(link, new ImagesURL().tokenQ)){
            amount = Amount.q;
        }
        if(Objects.equals(link, new ImagesURL().tokenR)){
            amount = Amount.r;
        }
        if(Objects.equals(link, new ImagesURL().tokenRR)){
            amount = Amount.rr;
        }
        if(Objects.equals(link, new ImagesURL().tokenS)){
            amount = Amount.s;
        }
        if(Objects.equals(link, new ImagesURL().tokenT)){
            amount = Amount.t;
        }
        if(Objects.equals(link, new ImagesURL().tokenU)){
            amount = Amount.u;
        }
        if(Objects.equals(link, new ImagesURL().tokenV)){
            amount = Amount.v;
        }
        if(Objects.equals(link, new ImagesURL().tokenX)){
            amount = Amount.x;
        }
        if(Objects.equals(link, new ImagesURL().tokenY)){
            amount = Amount.y;
        }
        if(Objects.equals(link, new ImagesURL().tokenZ)){
            amount = Amount.z;
        }
        if(Objects.equals(link, new ImagesURL().tokenJoker)){
            amount = Amount.joker;
        }
        return amount;
    }

    public void restAmount(){
        if(Objects.equals(link, new ImagesURL().tokenA)){
            Amount.a--;
        }
        if(Objects.equals(link, new ImagesURL().tokenB)){
            Amount.b--;
        }
        if(Objects.equals(link, new ImagesURL().tokenC)){
            Amount.c--;
        }
        if(Objects.equals(link, new ImagesURL().tokenCH)){
            Amount.ch--;
        }
        if(Objects.equals(link, new ImagesURL().tokenD)){
            Amount.d--;
        }
        if(Objects.equals(link, new ImagesURL().tokenE)){
            Amount.e--;
        }
        if(Objects.equals(link, new ImagesURL().tokenF)){
            Amount.f--;
        }
        if(Objects.equals(link, new ImagesURL().tokenG)){
            Amount.g--;
        }
        if(Objects.equals(link, new ImagesURL().tokenH)){
            Amount.h--;
        }
        if(Objects.equals(link, new ImagesURL().tokenI)){
            Amount.i--;
        }
        if(Objects.equals(link, new ImagesURL().tokenJ)){
            Amount.j--;
        }
        if(Objects.equals(link, new ImagesURL().tokenL)){
            Amount.l--;
        }
        if(Objects.equals(link, new ImagesURL().tokenLL)){
            Amount.ll--;
        }
        if(Objects.equals(link, new ImagesURL().tokenM)){
            Amount.m--;
        }
        if(Objects.equals(link, new ImagesURL().tokenN)){
            Amount.n--;
        }
        if(Objects.equals(link, new ImagesURL().tokenÑ)){
            Amount.ñ--;
        }
        if(Objects.equals(link, new ImagesURL().tokenO)){
            Amount.o--;
        }
        if(Objects.equals(link, new ImagesURL().tokenP)){
            Amount.p--;
        }
        if(Objects.equals(link, new ImagesURL().tokenQ)){
            Amount.q--;
        }
        if(Objects.equals(link, new ImagesURL().tokenR)){
            Amount.r--;
        }
        if(Objects.equals(link, new ImagesURL().tokenRR)){
            Amount.rr--;
        }
        if(Objects.equals(link, new ImagesURL().tokenS)){
            Amount.s--;
        }
        if(Objects.equals(link, new ImagesURL().tokenT)){
            Amount.t--;
        }
        if(Objects.equals(link, new ImagesURL().tokenU)){
            Amount.u--;
        }
        if(Objects.equals(link, new ImagesURL().tokenV)){
            Amount.v--;
        }
        if(Objects.equals(link, new ImagesURL().tokenX)){
            Amount.x--;
        }
        if(Objects.equals(link, new ImagesURL().tokenY)){
            Amount.y--;
        }
        if(Objects.equals(link, new ImagesURL().tokenZ)){
            Amount.z--;
        }
        if(Objects.equals(link, new ImagesURL().tokenJoker)){
            Amount.joker--;
        }
    }

    public void sumAmount(){
        if(Objects.equals(link, new ImagesURL().tokenA)){
            Amount.a++;
        }
        if(Objects.equals(link, new ImagesURL().tokenB)){
            Amount.b++;
        }
        if(Objects.equals(link, new ImagesURL().tokenC)){
            Amount.c++;
        }
        if(Objects.equals(link, new ImagesURL().tokenCH)){
            Amount.ch++;
        }
        if(Objects.equals(link, new ImagesURL().tokenD)){
            Amount.d++;
        }
        if(Objects.equals(link, new ImagesURL().tokenE)){
            Amount.e++;
        }
        if(Objects.equals(link, new ImagesURL().tokenF)){
            Amount.f++;
        }
        if(Objects.equals(link, new ImagesURL().tokenG)){
            Amount.g++;
        }
        if(Objects.equals(link, new ImagesURL().tokenH)){
            Amount.h++;
        }
        if(Objects.equals(link, new ImagesURL().tokenI)){
            Amount.i++;
        }
        if(Objects.equals(link, new ImagesURL().tokenJ)){
            Amount.j++;
        }
        if(Objects.equals(link, new ImagesURL().tokenL)){
            Amount.l++;
        }
        if(Objects.equals(link, new ImagesURL().tokenLL)){
            Amount.ll++;
        }
        if(Objects.equals(link, new ImagesURL().tokenM)){
            Amount.m++;
        }
        if(Objects.equals(link, new ImagesURL().tokenN)){
            Amount.n++;
        }
        if(Objects.equals(link, new ImagesURL().tokenÑ)){
            Amount.ñ++;
        }
        if(Objects.equals(link, new ImagesURL().tokenO)){
            Amount.o++;
        }
        if(Objects.equals(link, new ImagesURL().tokenP)){
            Amount.p++;
        }
        if(Objects.equals(link, new ImagesURL().tokenQ)){
            Amount.q++;
        }
        if(Objects.equals(link, new ImagesURL().tokenR)){
            Amount.r++;
        }
        if(Objects.equals(link, new ImagesURL().tokenRR)){
            Amount.rr++;
        }
        if(Objects.equals(link, new ImagesURL().tokenS)){
            Amount.s++;
        }
        if(Objects.equals(link, new ImagesURL().tokenT)){
            Amount.t++;
        }
        if(Objects.equals(link, new ImagesURL().tokenU)){
            Amount.u++;
        }
        if(Objects.equals(link, new ImagesURL().tokenV)){
            Amount.v++;
        }
        if(Objects.equals(link, new ImagesURL().tokenX)){
            Amount.x++;
        }
        if(Objects.equals(link, new ImagesURL().tokenY)){
            Amount.y++;
        }
        if(Objects.equals(link, new ImagesURL().tokenZ)){
            Amount.z++;
        }
        if(Objects.equals(link, new ImagesURL().tokenJoker)){
            Amount.joker++;
        }
    }
}