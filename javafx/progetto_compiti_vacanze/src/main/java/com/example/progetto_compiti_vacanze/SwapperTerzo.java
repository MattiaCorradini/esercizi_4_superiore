package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;

import java.io.IOException;

public class SwapperTerzo {
    Main m = new Main();

    public void goBouncingBall(ActionEvent actionEvent) {
        try {
            m.changeScene("eqSolver.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToDoList(ActionEvent actionEvent) {
        try {
            m.changeScene("toDoList.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToDiceROll(ActionEvent actionEvent) {
        try {
            m.changeScene("diceRoll.fxml");
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
