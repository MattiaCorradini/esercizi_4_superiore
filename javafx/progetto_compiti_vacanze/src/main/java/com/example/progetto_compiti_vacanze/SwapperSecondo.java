package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;

import java.io.IOException;

public class SwapperSecondo {

    Main m = new Main();

    public void goToTicTacToe(ActionEvent actionEvent) {
        try {
            m.changeScene("tictactoe.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goMagic8Ball(ActionEvent actionEvent) {
        try {
            m.changeScene("magic8ball.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goGuessNumber(ActionEvent actionEvent) {
        try {
            m.changeScene("guessNumber.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logOut(ActionEvent actionEvent) {
        try {
            m.changeScene("logInPage.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
