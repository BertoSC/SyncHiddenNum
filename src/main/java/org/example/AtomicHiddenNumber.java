package org.example;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicHiddenNumber {
    private final AtomicInteger num;
    private AtomicBoolean guessed;

    public AtomicHiddenNumber(int n) {
        this.num= new AtomicInteger(n);
        this.guessed = new AtomicBoolean(false);
    }

    public void setGuessed(boolean g) {
        guessed.set(g);
    }

    public int numberGuess(int n) {
        if (guessed.get()) {
            return -1;
        } else if (num.get() == n) {
            guessed.set(true);
            return 1;
        } else {
            return 0;
        }
    }

    public boolean getGuessed() {
        return guessed.get();
    }
}
