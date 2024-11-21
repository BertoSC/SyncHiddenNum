package org.example;

import java.util.Random;

public class RunnableGuess implements Runnable {
    private final HiddenNumber hidden;

    public RunnableGuess(HiddenNumber hn) {
        this.hidden = hn;
    }

    @Override
    public void run() {
        Random rm = new Random();

        while (!hidden.getGuessed()) {
            int guess = rm.nextInt(0, 101); // Genera un número aleatorio entre 0 y 100.
            int result = hidden.numberGuess(guess);

            switch (result) {
                case 1:
                    // Este hilo acertó el número.
                    System.out.println(Thread.currentThread().getName() + " ha acertado el valor: " + guess);
                    break;
                case 0:
                    // Este hilo sigue intentándolo.
                    System.out.println(Thread.currentThread().getName() + " sigue intentándolo con " + guess);
                    break;
                case -1:
                    // Este hilo ya sabe que otro acertó.
                    System.out.println(Thread.currentThread().getName() + " no lo ha acertado, pero otro sí.");
                    return; // Salir del bucle, ya no hay trabajo que hacer.
            }
        }
    }
}
