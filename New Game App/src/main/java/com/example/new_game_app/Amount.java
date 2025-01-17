package com.example.new_game_app;

import java.util.ArrayList;

public class Amount {
    private static Amount instance;
    public ArrayList<Integer> amounts = new ArrayList<>();
    static int a = 12;
    static int b = 2;
    static int c = 4;
    static int ch = 1;
    static int d = 5;
    static int e = 12;
    static int f = 1;
    static int g = 2;
    static int h = 2;
    static int i = 6;
    static int j = 1;
    static int l = 4;
    static int ll = 1;
    static int m = 2;
    static int n = 5;
    static int ñ = 1;
    static int o = 9;
    static int p = 2;
    static int q = 1;
    static int r = 5;
    static int rr = 1;
    static int s = 6;
    static int t = 4;
    static int u = 5;
    static int v = 1;
    static int x = 1;
    static int y = 1;
    static int z = 1;
    static int joker = 2;

    private Amount() {
        amounts.add(a);
        amounts.add(b);
        amounts.add(c);
        amounts.add(ch);
        amounts.add(d);
        amounts.add(e);
        amounts.add(f);
        amounts.add(g);
        amounts.add(h);
        amounts.add(i);
        amounts.add(j);
        amounts.add(l);
        amounts.add(ll);
        amounts.add(m);
        amounts.add(n);
        amounts.add(ñ);
        amounts.add(o);
        amounts.add(p);
        amounts.add(q);
        amounts.add(r);
        amounts.add(rr);
        amounts.add(s);
        amounts.add(t);
        amounts.add(u);
        amounts.add(v);
        amounts.add(x);
        amounts.add(y);
        amounts.add(z);
        amounts.add(joker);
    }

    public static Amount getInstance() {
        if (instance == null) {
            instance = new Amount();
        }
        return instance;
    }

    public ArrayList<Integer> getAmounts() {
        return amounts;
    }

    public void setAmounts(ArrayList<Integer> amounts) {
        this.amounts = amounts;
    }

    public void updateAmount(String letter, int value) {
        switch (letter) {
            case "a": a = value; break;
            case "b": b = value; break;
            case "c": c = value; break;
            case "ch": ch = value; break;
            case "d": d = value; break;
            case "e": e = value; break;
            case "f": f = value; break;
            case "g": g = value; break;
            case "h": h = value; break;
            case "i": i = value; break;
            case "j": j = value; break;
            case "l": l = value; break;
            case "ll": ll = value; break;
            case "m": m = value; break;
            case "n": n = value; break;
            case "ñ": ñ = value; break;
            case "o": o = value; break;
            case "p": p = value; break;
            case "q": q = value; break;
            case "r": r = value; break;
            case "rr": rr = value; break;
            case "s": s = value; break;
            case "t": t = value; break;
            case "u": u = value; break;
            case "v": v = value; break;
            case "x": x = value; break;
            case "y": y = value; break;
            case "z": z = value; break;
            case "joker": joker = value; break;
        }
    }
}
