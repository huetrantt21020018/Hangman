package com.example.hangman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {
    HGame game;

    @Override
    public void start(Stage stage) throws IOException {
        // Tải FXML
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        // Lấy controller từ FXMLLoader
        Controller controller = fxmlLoader.getController();
        // Khởi tạo HGame
        game = new HGame();
        controller.setGame(game);
        game.setController(controller);

        stage.setTitle("H!");
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(game.getGameState() != GameState.ONGOING) stopGame();
            }

            private void stopGame() {
                game.endGame();
                System.out.println("End game.");
                stop();
            }
        };
        timer.start();

    }


    public static void main(String[] args) {
        launch();
    }
}