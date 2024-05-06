package com.example.hangman;

import java.util.Random;

public class Word {
    private final String secretWord;
    private StringBuffer guessedWord;

    private final String[] WORD_LIST = {"laptop", "table", "human", "hello", "what"};
    String chooseWord()
    {
        int randomIndex = new Random().nextInt(WORD_LIST.length);
        return WORD_LIST[randomIndex];
    }

    public Word() {
        secretWord = chooseWord();
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
