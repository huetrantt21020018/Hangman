package com.example.hangman;

public class HGame {
    private final Player player;
    private  Word word;
    private Controller controller;
    private GameState gameState;

    public void setController(Controller controller) {
        this.controller = controller;
        controller.setGuessedWord(word.getGuessedWord());
    }

    public HGame() {
        this.player = new Player();
        this.word = new Word();
        this.gameState = GameState.ONGOING;
    }

    public void reRender() {
        controller.setGuessedWord(word.getGuessedWord());
        controller.setStateGame(gameState);
        controller.setBadGuessed(player.getBadGuessCount());
    }

    public void receiveInput(char letter) {
        letter = Character.toLowerCase(letter);
        if(!word.isContain(letter)) player.increaseBadGuesses();

        updateGameState();
        reRender();
    }

    public void updateGameState() {
        if(word.isGuessed()) {
            gameState = GameState.WON;
        }
        if(player.getBadGuessCount() >= Player.MAX_BAD_GUESSES) {
            gameState = GameState.LOST;
        }
    }

    public GameState getGameState() {
        return gameState;
    }

    public void endGame() {
        controller.setDisable();
    }
}
