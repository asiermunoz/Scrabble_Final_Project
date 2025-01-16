package com.example.new_game_app;

public class Bonus {
    private String message;

    public Bonus() {
        this.message = "";
    }

    public int scrabbleBonus(int score) throws InterruptedException {
        message = message + "¡¡¡¡¡¡¡SCRABBLE conseguido!! +50 puntos ";
        Thread.sleep(2000);
        int scrabble = 50;
        score = score + scrabble;
        return score;
    }

    public int doubleWordBonus(int score, int doubleWordBoost) throws InterruptedException {
        message = message + "+x2 palabra ";
        Thread.sleep(1500);
        for(int i = 0; i<doubleWordBoost; i++){
            score = score * 2;
        }
        return score;
    }

    public int tripleWordBonus(int score, int tripleWordBoost) throws InterruptedException {
        message = message + "+x3 palabra ";
        Thread.sleep(1500);
        for(int i = 0; i<tripleWordBoost; i++){
            score = score * 3;
        }
        return score;
    }

    public int doubleLetterBonus(int letterToMultiply) throws InterruptedException {
        message = message + "+x2 letra ";
        Thread.sleep(1500);
        return letterToMultiply;
    }

    public int tripleLetterBonus(int letterToMultiply) throws InterruptedException {
        message = message + "+x3 letra ";
        Thread.sleep(1500);
        return letterToMultiply*2;
    }

    public String getMessage() {
        return message;
    }
}
