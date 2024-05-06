package com.example.hangman;

public class Word {
    private final String secretWord;
    private StringBuffer guessedWord;

    public Word() {
        secretWord = "hangman";
        guessedWord = new StringBuffer();
        guessedWord.append("_".repeat(secretWord.length()));
    }

    public boolean isContain(char letter) {
        boolean contain = false;
        for(int i = 0; i < secretWord.length(); i++) {
            if(letter == secretWord.charAt(i)) {
                contain = true;
                guessedWord.setCharAt(i, letter);
            }
        }
        return contain;
    }

    public boolean isGuessed() {
        return secretWord.equals(guessedWord.toString());
    }

    public String getGuessedWord() {
        return guessedWord.toString();
    }
}
