package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class DiceRoll {

    Random random = new Random();
    @FXML
    private ImageView diceImage;
    @FXML
    private Button rollButton;

    @FXML
    void roll(ActionEvent event) {

        rollButton.setDisable(true);

        Thread thread = new Thread(() -> {
            try {
                for (int i = 0; i < 15; i++) {
                    File file = new File("C:\\Users\\Studente\\Desktop\\informatica\\esercizi_4_superiore\\javafx\\progetto_compiti_vacanze\\src\\main\\java\\com\\dice\\dice" + (random.nextInt(6)+1)+".png");
                    diceImage.setImage(new Image(file.toURI().toString()));
                    Thread.sleep(100);
                }
                rollButton.setDisable(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void onLogOut(ActionEvent actionEvent) {
        Main m = new Main();
        try {
            m.changeScene("menuTerzoAccount.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
