package org.example;

public class HiddenNumber {
    private final int number;
    private boolean guessed;

    public HiddenNumber(int n) {
        this.number = n;
        this.guessed = false;
    }

    synchronized public void setGuessed(boolean g) {
        this.guessed =g;
    }

    public synchronized int numberGuess(int num) {
        if (guessed) {
            return -1;
        } else if (number == num) {
            guessed = true;
            return 1;
        } else {
            return 0;
        }
    }

    public synchronized boolean getGuessed() {
        return guessed;
    }
}
