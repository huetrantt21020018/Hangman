package com.example.hangman;

public class Player {
    private int badGuessCount;
    public static final int MAX_BAD_GUESSES = 7;

    public Player() {
        badGuessCount = 0;
    }

    public void increaseBadGuesses() {
        badGuessCount++;
    }

    public int getBadGuessCount() {
        return badGuessCount;
    }
}
