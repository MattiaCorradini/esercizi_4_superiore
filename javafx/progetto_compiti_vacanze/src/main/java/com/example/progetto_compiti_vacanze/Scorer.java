package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.io.IOException;

public class Scorer {

    @FXML
    public Label lblPtHome;
    @FXML
    public Label lblSetHome;
    @FXML
    public Circle servGuest;
    @FXML
    public Label lblPtGuest;
    @FXML
    public Label lblSetGuest;
    @FXML
    public Circle servHome;
    private int pt_home;
    private int set_home;
    private int pt_guest;
    private int set_guest;

    public static boolean endGame(int ph, int pg){
        return ph >= 25 || pg >= 25;
    }

    private static boolean deuce(int ph, int pg){
        if (endGame(ph, pg)){
            return Math.abs(ph - pg) < 2;
        }
        return true;
    }

    public void plusPtHome(ActionEvent actionEvent) {
        if (deuce(pt_home, pt_guest)) {
            pt_home++;
            lblPtHome.setText(pt_home + "");
            servGuest();
        }else {
            pt_home =0;
            lblPtHome.setText(pt_home + "");
            pt_guest =0;
            lblPtGuest.setText(pt_guest + "");
            servReset();
            set_home++;
            lblSetHome.setText(set_home + "");
        }
    }

    public void oneBackHome(ActionEvent actionEvent) {
        pt_home--;
        lblPtHome.setText(pt_home + "");
    }

    public void plusPtGuest(ActionEvent actionEvent) {
        if (deuce(pt_home, pt_guest)) {
            pt_guest++;
            lblPtGuest.setText(pt_guest + "");
            servHome();
        }else {
            pt_guest =0;
            lblPtGuest.setText(pt_guest + "");
            pt_home =0;
            lblPtHome.setText(pt_home + "");
            servReset();
            set_guest++;
            lblSetGuest.setText(set_guest + "");
        }
    }

    public void oneBackGuest(ActionEvent actionEvent) {
        pt_guest--;
        lblPtGuest.setText(pt_guest + "");
    }

    public void servGuest() {
        servGuest.setFill(Color.RED);
        servHome.setFill(Color.GRAY);
    }

    public void servHome() {
        servHome.setFill(Color.RED);
        servGuest.setFill(Color.GRAY);
    }

    public void servReset() {
        servGuest.setFill(Color.GRAY);
        servHome.setFill(Color.GRAY);
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