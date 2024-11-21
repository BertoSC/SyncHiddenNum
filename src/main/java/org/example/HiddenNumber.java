package org.example;

import java.util.Random;

public class HiddenNumber {
    int number;
    int guessed;

    public HiddenNumber(int n){
        this.number=n;
        guessed=25;
    }

    public int getNumber() {
        return number;
    }

    public int getGuessed() {
        return guessed;
    }

    synchronized public int numberGuess(int num){
        if (guessed==rue){
            return -1;
        } else{
            if (number==num){
                guessed=true;
                return 1;
            } else {
                return 0;
            }
        }
    }
}
