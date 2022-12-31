package com.example.progetto_compiti_vacanze;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private void credenziali(){
        System.out.println("\nLogin credentials:\n" +
                           "Nome utente: PrimoAccount - Password: CSapplication2021\n" +
                           "Nome utente: SecondoAccount - Password: CSapplication2022\n" +
                           "Nome utente: TerzoAccount - Password: CSapplication2023\n");
    }

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logInPage.fxml")));
        primaryStage.setTitle("Corradini applications");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        Image image = new Image("C:\\Users\\Studente\\Desktop\\informatica\\esercizi_4_superiore\\javafx\\progetto_compiti_vacanze\\src\\img\\mc.png");
        primaryStage.getIcons().add(image);
        credenziali();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) { launch(args); }
}