package com.example.markovgpt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author Mattia Corradini
 */

public class Main extends Application {
    private static Stage stg;

    public static Stage getStg() {
        return stg;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("firstchat.fxml")));
        primaryStage.setTitle("Corradini AI - MarkovGPT");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Image image = new Image("logo.png");
        primaryStage.getIcons().add(image);
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}