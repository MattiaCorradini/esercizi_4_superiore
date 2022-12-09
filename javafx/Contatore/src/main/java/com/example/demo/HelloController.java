package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    public Label n;
    private int n1=0;
    public void onAumentaUnoClick(ActionEvent actionEvent) {
        n1++;
        n.setText(Integer.toString(n1));
    }

    public void onDiminuisciUnoClick(ActionEvent actionEvent) {
        n1--;
        n.setText(Integer.toString(n1));
    }

    public void onAzzeraClick(ActionEvent actionEvent) {
        n1=0;
        n.setText(Integer.toString(n1));
    }
}