package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;

import java.io.IOException;

public class SwapperPrimo {

    Main m =  new Main();
    public void goToCounter(ActionEvent actionEvent) {
        try {
            m.changeScene("counter.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToScorer(ActionEvent actionEvent) {
        try {
            m.changeScene("scorer.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToCalculator(ActionEvent actionEvent) {
        try {
            m.changeScene("calculator.fxml");
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
