package org.example;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int TOTAL_THREADS = 10;

    public static void main(String[] args) {
        Random rm = new Random();
        int numberHidden = rm.nextInt(0, 101); // Número entre 0 y 100.
        System.out.println("Número a adivinar: " + numberHidden);

        HiddenNumber n = new HiddenNumber(numberHidden);
        ExecutorService pool = Executors.newFixedThreadPool(TOTAL_THREADS);

        for (int i = 0; i < TOTAL_THREADS; i++) {
            pool.execute(new RunnableGuess(n));
        }

        pool.shutdown();
    }
}