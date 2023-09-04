package com.example.forza_4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) {
        Button[][] buttons = new Button[6][7];
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: #77dd77;");
        gridPane.setPadding(new Insets(40));
        gridPane.setHgap(40);
        gridPane.setVgap(40);

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                buttons[row][col] = new Button();
                buttons[row][col].setMinSize(80, 80);
                buttons[row][col].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                buttons[row][col].setStyle("-fx-background-color: #d4d4d4; -fx-text-fill: black; -fx-font-size: 38px;");
                gridPane.add(buttons[row][col], col, row);
            }
        }

        Forza4 forza4 = new Forza4();
        forza4.gioca(buttons);
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Forza 4");
        primaryStage.show();
    }
}