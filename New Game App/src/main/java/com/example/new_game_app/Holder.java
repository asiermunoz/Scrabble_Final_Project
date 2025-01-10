package com.example.new_game_app;

import java.util.ArrayList;

public class Holder extends LettersHold{

    public Holder(ArrayList<Letter> hold) {
        setHold(hold);
    }

    public String showToken(int i){
        return hold.get(i).getLink();
    }
//    public void takeEverythingBack(LettersHold lettersHold){
//        try {
//            if (lettersHold.getHoldSize() == 0) {
//                throw new EmptyArrayException();
//            }
//            for (Letter letter : lettersHold.getHold()) {
//                if (letter.isJoker()) {
//                    addLetter(new Letter(new ImagesURL().tokenJoker,new LettersList().jokerValue,2));
//                } else {
//                    addLetter(letter);
//                }
//            }
//        }catch(EmptyArrayException _){
//        }
//    }
//
//    public Letter takeLetter(String token) {
//        token = token.toUpperCase();
//        boolean joker = false;
//        int jokerMark = 0;
//        try {
//            for (Letter letter : getHold()) {
//                if (Objects.equals(letter.getLetter(), token)) {
//                    hold.remove(letter);
//                    return letter;
//                }
//                else if(Objects.equals(letter.getLink(), new ImagesURL().tokenJoker)){
//                    joker = true;
//                }
//                if(!joker){
//                    jokerMark++;
//                }
//            }
//            if(joker){
//                for(Letter letter: new LettersList().getList()){
//                    if(Objects.equals(letter.getLetter(), token)){
//                        hold.remove(jokerMark);
//                        letter.setJoker(true);
//                        letter.setValue(Letter.jokerValue);
//                        return letter;
//                    }
//                }
//            }
//            throw new LetterNotFoundException();
//        } catch (LetterNotFoundException e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }

    public void exchangeAll(Bag bag){
        bag.fillBag(hold);
        int size = getHoldSize();
        this.hold = bag.changeHolder(size);
    }
//
//    public void backtrack(LettersHold lettersHold) {
//        try {
//            if(lettersHold.getHoldSize() == 0){
//                throw new EmptyArrayException();
//            }
//            if(lettersHold.getHold().getLast().isJoker()){
//                addLetter(new Letter("☻",Letter.jokerValue));
//            }
//            else {
//                addLetter(lettersHold.getHold().getLast());
//            }
//            lettersHold.removeLetter();
//            show();
//            lettersHold.show();
//        }catch(EmptyArrayException e){
//            System.out.println(e.getMessage());
//        }
//    }
}