package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Random;

public class Magic8Ball {

    @FXML
    public Label number8;
    @FXML
    public Label answer;
    @FXML
    public TextField question;
    private final String[] answers = {
            " As I\n see it,\n yes",
            " It is\n certain",
            " It is\n decidedly so",
            " Most likely",
            " Outlook good",
            " Signs point\n to yes",
            " Without a\n doubt",
            " Yes",
            " Yes,\n definitely",
            " You may rely\n on it",
            " Reply hazy,\n try again",
            " Ask again\n later",
            " Better not\n tell you\n now",
            " Cannot\n predict\n now",
            " Concentrate\n and\n ask again",
            " Don't count\n on it",
            " My reply\n is no",
            " My sources\n say no",
            " Outlook not\n so good",
            " Very doubtful"
    };

    private final Random random = new Random();

    public void btnQuestion(ActionEvent actionEvent) {
        number8.setOpacity(0);
        answer.setText(answers[random.nextInt(answers.length)]);
    }

    public void reset(ActionEvent actionEvent) {
        question.setText("");
        number8.setOpacity(1);
        answer.setText("");
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
