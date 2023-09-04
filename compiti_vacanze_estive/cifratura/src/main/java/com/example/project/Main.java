package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class    Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("encrypterer/decrypterer");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        Image image = new Image("C:\\Users\\Studente\\Desktop\\scuola\\informatica\\esercizi_4_superiore\\compiti_vacanze_estive\\cifratura\\src\\img\\logo_trytodecrypt.png");
        stage.getIcons().add(image);
    }

    public static void main(String[] args) {
        launch();
    }
}