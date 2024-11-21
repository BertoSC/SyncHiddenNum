package org.example;

public class HiddenNumber {
    private final int number; // Número oculto.
    private boolean guessed;  // Indica si el número ya fue adivinado.

    public HiddenNumber(int n) {
        this.number = n;
        this.guessed = false;
    }

    // Método sincronizado para intentar adivinar el número.
    public synchronized int numberGuess(int num) {
        if (guessed) {
            return -1; // Ya fue adivinado.
        } else if (number == num) {
            guessed = true; // Adivinado correctamente.
            return 1;
        } else {
            return 0; // Intento fallido.
        }
    }

    // Obtener el estado de "adivinado".
    public synchronized boolean getGuessed() {
        return guessed;
    }
}
