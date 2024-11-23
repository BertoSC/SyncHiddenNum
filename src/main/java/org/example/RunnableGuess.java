package org.example;

import java.util.Random;

public class RunnableGuess implements Runnable {
    private final AtomicHiddenNumber hidden;
    //private final HiddenNumber hidden;

    public RunnableGuess(AtomicHiddenNumber hn) {
        this.hidden = hn;
    }

    /*public RunnableGuess(HiddenNumber hn) {
        this.hidden = hn;
    }*/

    @Override
    public void run() {
        Random rm = new Random();
        int result = 24;
        while (true) {
            int guess = rm.nextInt(0, 101);
            result = hidden.numberGuess(guess);
            switch (result) {
                case 1:
                    System.out.println(Thread.currentThread().getName() + " ha acertado el valor: " + guess);
                    return;
                case 0:
                    System.out.println(Thread.currentThread().getName() + " sigue intentándolo con " + guess);
                    break;
                case -1:
                    System.out.println(Thread.currentThread().getName() + " no lo ha acertado, pero otro sí.");
                    return;
            }
        }
    }
}
