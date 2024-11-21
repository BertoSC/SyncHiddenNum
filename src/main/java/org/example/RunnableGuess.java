package org.example;

import java.util.Random;
import java.util.concurrent.Callable;

public class RunnableGuess implements Callable{
    HiddenNumber hidden;
    int result;

    public RunnableGuess(HiddenNumber hn){
        this.hidden=hn;
        result=25;
    }

    public int guess () {
        Random rm = new Random();
        int guess = rm.nextInt(0, 101);
        result = hidden.numberGuess(guess);
        return result;
    }


    @Override
    public Object call() throws Exception {
        return null;
    }
}
