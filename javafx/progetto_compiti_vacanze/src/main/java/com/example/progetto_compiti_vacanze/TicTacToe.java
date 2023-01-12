package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TicTacToe implements Initializable{

    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Button button4;
    @FXML
    public Button button5;
    @FXML
    public Button button6;
    @FXML
    public Button button7;
    @FXML
    public Button button8;
    @FXML
    public Button button9;
    @FXML
    public Label xwins;
    @FXML
    public Label owins;
    @FXML
    private Text winnerText;
    int x=0, o=0;
    private int playerTurn = 0;
    ArrayList<Button> buttons;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @FXML
    void restart(ActionEvent event) {
        buttons.forEach(this::reset);
        winnerText.setText("Tic-Tac-Toe");
    }

    public void reset(Button button) {
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setSimboli(button);
            button.setDisable(true);
            winner();
        });
    }

    public void setSimboli(Button button) {
        if (playerTurn % 2 == 0) {
            button.setText("X");
            playerTurn = 1;
            winnerText.setText("O turn");
        } else {
            button.setText("O");
            playerTurn = 0;
            winnerText.setText("X turn");
        }
    }

    public void winner() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = button1.getText() + button2.getText() + button3.getText();
                    if (line.equals("XXX")) {
                        winnerText.setText("X won!");
                        button4.setDisable(true);button5.setDisable(true);button6.setDisable(true);
                        button7.setDisable(true);button8.setDisable(true);button9.setDisable(true);
                        button4.setText("");button5.setText("");button6.setText("");
                        button7.setText("");button8.setText("");button9.setText("");
                    }
                    else if (line.equals("OOO")) {
                        winnerText.setText("O won!");
                        button4.setDisable(true);button5.setDisable(true);button6.setDisable(true);
                        button7.setDisable(true);button8.setDisable(true);button9.setDisable(true);
                        button4.setText("");button5.setText("");button6.setText("");
                        button7.setText("");button8.setText("");button9.setText("");
                    }
                    break;
                case 1:
                    line = button4.getText() + button5.getText() + button6.getText();
                    if (line.equals("XXX")) {
                        winnerText.setText("X won!");
                        button1.setDisable(true);button2.setDisable(true);button3.setDisable(true);
                        button7.setDisable(true);button8.setDisable(true);button9.setDisable(true);
                        button1.setText("");button2.setText("");button3.setText("");
                        button7.setText("");button8.setText("");button9.setText("");
                    }
                    else if (line.equals("OOO")) {
                        winnerText.setText("O won!");
                        button1.setDisable(true);button2.setDisable(true);button3.setDisable(true);
                        button7.setDisable(true);button8.setDisable(true);button9.setDisable(true);
                        button1.setText("");button2.setText("");button3.setText("");
                        button7.setText("");button8.setText("");button9.setText("");
                    }
                    break;
                case 2:
                    line = button7.getText() + button8.getText() + button9.getText();
                    if (line.equals("XXX")) {
                        winnerText.setText("X won!");
                        button1.setDisable(true);button2.setDisable(true);button3.setDisable(true);
                        button4.setDisable(true);button5.setDisable(true);button6.setDisable(true);
                        button1.setText("");button2.setText("");button3.setText("");
                        button4.setText("");button5.setText("");button6.setText("");
                    }
                    else if (line.equals("OOO")) {
                        winnerText.setText("O won!");
                        button1.setDisable(true);button2.setDisable(true);button3.setDisable(true);
                        button4.setDisable(true);button5.setDisable(true);button6.setDisable(true);
                        button1.setText("");button2.setText("");button3.setText("");
                        button4.setText("");button5.setText("");button6.setText("");
                    }
                    break;
                case 3:
                    line = button1.getText() + button5.getText() + button9.getText();
                    if (line.equals("XXX")) {
                        winnerText.setText("X won!");
                        button2.setDisable(true);button3.setDisable(true);button4.setDisable(true);
                        button6.setDisable(true);button7.setDisable(true);button8.setDisable(true);
                        button2.setText("");button3.setText("");button4.setText("");
                        button6.setText("");button7.setText("");button8.setText("");
                    }
                    else if (line.equals("OOO")) {
                        winnerText.setText("O won!");
                        button2.setDisable(true);button3.setDisable(true);button4.setDisable(true);
                        button6.setDisable(true);button7.setDisable(true);button8.setDisable(true);
                        button2.setText("");button3.setText("");button4.setText("");
                        button6.setText("");button7.setText("");button8.setText("");
                    }
                    break;
                case 4:
                    line = button3.getText() + button5.getText() + button7.getText();
                    if (line.equals("XXX")) {
                        winnerText.setText("X won!");
                        button2.setDisable(true);button4.setDisable(true);button6.setDisable(true);
                        button8.setDisable(true);button9.setDisable(true);button1.setDisable(true);
                        button2.setText("");button4.setText("");button6.setText("");
                        button8.setText("");button9.setText("");button1.setText("");
                    }
                    else if (line.equals("OOO")) {
                        winnerText.setText("O won!");
                        button2.setDisable(true);button4.setDisable(true);button6.setDisable(true);
                        button8.setDisable(true);button9.setDisable(true);button1.setDisable(true);
                        button2.setText("");button4.setText("");button6.setText("");
                        button8.setText("");button9.setText("");button1.setText("");
                    }
                    break;
                case 5:
                    line = button1.getText() + button4.getText() + button7.getText();
                    if (line.equals("XXX")) {
                        winnerText.setText("X won!");
                        button2.setDisable(true);button3.setDisable(true);button5.setDisable(true);
                        button6.setDisable(true);button8.setDisable(true);button9.setDisable(true);
                        button2.setText("");button3.setText("");button5.setText("");
                        button6.setText("");button8.setText("");button9.setText("");
                    }
                    else if (line.equals("OOO")) {
                        winnerText.setText("O won!");
                        button2.setDisable(true);button3.setDisable(true);button5.setDisable(true);
                        button6.setDisable(true);button8.setDisable(true);button9.setDisable(true);
                        button2.setText("");button3.setText("");button5.setText("");
                        button6.setText("");button8.setText("");button9.setText("");
                    }
                    break;
                case 6:
                    line = button2.getText() + button5.getText() + button8.getText();
                    if (line.equals("XXX")) {
                        winnerText.setText("X won!");
                        button1.setDisable(true);button3.setDisable(true);button4.setDisable(true);
                        button6.setDisable(true);button7.setDisable(true);button9.setDisable(true);
                        button1.setText("");button3.setText("");button4.setText("");
                        button6.setText("");button7.setText("");button9.setText("");
                    }
                    else if (line.equals("OOO")) {
                        winnerText.setText("O won!");
                        button1.setDisable(true);button3.setDisable(true);button4.setDisable(true);
                        button6.setDisable(true);button7.setDisable(true);button9.setDisable(true);
                        button1.setText("");button3.setText("");button4.setText("");
                        button6.setText("");button7.setText("");button9.setText("");
                    }
                    break;
                case 7:
                    line = button3.getText() + button6.getText() + button9.getText();
                    if (line.equals("XXX")) {
                        winnerText.setText("X won!");
                        button1.setDisable(true);button2.setDisable(true);button4.setDisable(true);
                        button5.setDisable(true);button7.setDisable(true);button8.setDisable(true);
                        button1.setText("");button2.setText("");button4.setText("");
                        button5.setText("");button7.setText("");button8.setText("");
                    }
                    else if (line.equals("OOO")) {
                        winnerText.setText("O won!");
                        button1.setDisable(true);button2.setDisable(true);button4.setDisable(true);
                        button5.setDisable(true);button7.setDisable(true);button8.setDisable(true);
                        button1.setText("");button2.setText("");button4.setText("");
                        button5.setText("");button7.setText("");button8.setText("");
                    }
                    break;
            }
            if (line.equals("XXX")) {
                winnerText.setText("X won!");
                x++;
                xwins.setText(x + "");
                break;
            }
            else if (line.equals("OOO")) {
                winnerText.setText("O won!");
                o++;
                owins.setText(o + "");
                break;
            }
            else if(button1.isDisabled() && button2.isDisabled() && button3.isDisabled() &&
                    button4.isDisabled() && button5.isDisabled() && button6.isDisabled() &&
                    button7.isDisabled() && button8.isDisabled() && button9.isDisabled()) {
                winnerText.setText("Parity.");
            }
        }
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

