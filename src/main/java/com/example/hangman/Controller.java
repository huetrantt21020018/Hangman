package com.example.hangman;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    private HGame game;

    public void setGame(HGame game) {
        this.game = game;
    }

    @FXML
    private TextField inputText;

    @FXML
    private Label guessedWord;

    @FXML
    private Label badGuessed;

    @FXML
    private Label invalidInput;

    @FXML
    private Label gameState;

    @FXML
    private Button button;

    @FXML
    public void initialize() {
        guessedWord.setText("");
        invalidInput.setText("");
        gameState.setText("ONGOING");
        badGuessed.setText("BAD GUESSED: 0");
    }

    public void setGuessedWord(String word) {
        guessedWord.setText(word);
    }

    public void setBadGuessed(int count) {
        badGuessed.setText("BAD GUESSED: " + count);
    }

    public void setStateGame(GameState state) {
        gameState.setText(state.toString());
    }

    public void setDisable() {
        inputText.setDisable(true);
        button.setDisable(true);
    }

    @FXML
    protected void onclick() {
        String input = inputText.getText();
        if (input.length() == 1) {
            game.receiveInput(input.charAt(0));
            invalidInput.setText("");
        } else {
            invalidInput.setText("You can only guess one letter");
        }
    }
}