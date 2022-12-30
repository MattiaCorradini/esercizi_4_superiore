package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GuessNumber implements Initializable {

    private final Random random = new Random();
    private int randomNumber;
    private int guessCount = 0;
    @FXML
    private TextField guess;
    @FXML
    private Text guessCounterText;
    @FXML
    private ImageView up;
    @FXML
    private ImageView down;
    @FXML
    private ImageView correct;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        randomNumber = random.nextInt(100);
        down.setVisible(false);
        up.setVisible(false);
        correct.setVisible(false);
    }

    @FXML
    void checkGuess(ActionEvent event) {
        guessCount++;
        guessCounterText.setText("Guesses: " + guessCount);
        if(Integer.parseInt(guess.getText()) == randomNumber){
            down.setVisible(false);
            up.setVisible(false);
            correct.setVisible(true);
            guessCounterText.setText("Guessed in " + guessCount + " tries!");
        } else if(Integer.parseInt(guess.getText()) > randomNumber){
            down.setVisible(true);
            up.setVisible(false);
            correct.setVisible(false);
            guess.setText("");
        } else if(Integer.parseInt(guess.getText()) < randomNumber){
            down.setVisible(false);
            up.setVisible(true);
            correct.setVisible(false);
            guess.setText("");
        }
    }

    @FXML
    void reset(ActionEvent event) {
        guess.setText("");
        randomNumber = random.nextInt(100);
        down.setVisible(false);
        up.setVisible(false);
        correct.setVisible(false);
        guessCount = 0;
        guessCounterText.setText("Guesses: " + guessCount);
    }

    public void onLogOut(ActionEvent actionEvent) {
        Main m = new Main();
        try {
            m.changeScene("menuSecondoAccount.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
