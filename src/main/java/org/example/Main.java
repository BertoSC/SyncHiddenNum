package org.example;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    private static final int TOTAL_THREADS=10;

    public static void main(String[] args) {
        Random rm = new Random();
        int numberHidden = rm.nextInt(0, 101);

        ExecutorService pool = Executors.newFixedThreadPool(TOTAL_THREADS);
        HiddenNumber n = new HiddenNumber(numberHidden);

        while (!n.isGuessed()) {
            for (int i = 0; i <= TOTAL_THREADS; i++) {
                Callable rn = new RunnableGuess(n);
                Future fut = pool.submit(rn);
                try {
                    int result= (int) fut.get();
                    Threa
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        pool.shutdown();

    }
}