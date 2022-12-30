package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;

public class Calculator {

    @FXML
    private TextField output;
    private long number1 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    public long calculate(long number1, long number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0)
                    return 1;

                return number1 / number2;
        }
        return 0;
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;
            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        }
        else {
            if (operator.isEmpty())
                return;
            if (calculate(number1, Long.parseLong(output.getText()), operator)==1){
                output.setText("error");
            }else {
                output.setText(String.valueOf(calculate(number1, Long.parseLong(output.getText()), operator)));
                operator = "";
                start = true;
            }
        }
    }

    public void onLogOut(ActionEvent actionEvent) {
        Main m = new Main();
        try {
            m.changeScene("menuPrimoAccount.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
