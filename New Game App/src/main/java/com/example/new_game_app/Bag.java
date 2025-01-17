package com.example.new_game_app;

import javafx.scene.control.Label;

import java.util.ArrayList;

public class Bag {
    private int total = 0;
    private String exception;
    private ArrayList<Letter> letters = new ArrayList<>();
    private Amount amount;

    //Rellenar bolsa inicial
    public Bag(){
        this.amount = Amount.getInstance();
        for(Letter bagList:new LettersList().getList()){
            for(int i = 0; i < bagList.getAmount(); i++){
                this.letters.add(bagList);
                total++;
            }
        }
        exception = "";
    }

    public int getTotal() {
        return total;
    }

    public Holder fillNewHolder(int lettersNeeded){
        ArrayList <Letter> letters = new ArrayList<>();
        for(int i = 0; i < lettersNeeded; i++){
            if(total!=0){
                letters.add(takeRandomLetter());
                reduceTotal();
            }
            else{
                exception = "Bolsa vacía";
            }
        }
        return new Holder(letters);
    }

    private void reduceTotal(){
        this.total--;
    }

    public ArrayList <Letter> reFill(int lettersNeeded){
        ArrayList <Letter> letters = new ArrayList<>();
        try {
            for (int i = 0; i < lettersNeeded; i++) {
                letters.add(takeRandomLetter());
                reduceTotal();
                if (total == 0) {
                    throw new EmptyBagException();
                }
            }
        }catch(EmptyBagException e){
            exception = e.getMessage();
        }
        return letters;
    }

    public ArrayList <Letter> changeHolder(int lettersNeeded){
        ArrayList <Letter> letters = new ArrayList<>();
        for(int i = 0; i < lettersNeeded; i++){
            letters.add(takeRandomLetter());
        }
        return letters;
    }

    public void fillBag(ArrayList<Letter> letters) {
        for(Letter letter: letters){
            letter.sumAmount();
            this.letters.add(letter);
        }
    }

    //Sacar letra al azar
    private Letter takeRandomLetter(){
        int i = (int)Math.floor(Math.random()*this.total);
        Letter letter = letters.get(i);
        letter.restAmount();
        letters.remove(i);
        return letter;
    }

    public void chargeBag() {
        for (Letter letter : letters) {
            String letterName = letter.getLetter();
            int count = 0;
            for (Letter l : letters) {
                if (l.getLetter().equals(letterName)) {
                    count++;
                }
            }
            amount.updateAmount(letterName, count);
        }
    }

    public String getException() {
        return exception;
    }
}
