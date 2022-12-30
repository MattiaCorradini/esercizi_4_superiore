package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.*;

public class Counter implements Serializable{

    @FXML
    public Label n;
    private int n1=0;

    /*
    ObjectInputStream in;
    {
        try {
            in = new ObjectInputStream(new ObjectInputStream(new FileInputStream("counter.bin")));
            n = (Label) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    */

    public void onPlusOneClick(ActionEvent actionEvent) {
        n1++;
        n.setText(Integer.toString(n1));
    }
    public void onMenusOneClick(ActionEvent actionEvent) {
        n1--;
        n.setText(Integer.toString(n1));
    }
    public void onResetClick(ActionEvent actionEvent) {
        n1=0;
        n.setText(Integer.toString(n1));
    }

    public void onLogOut(ActionEvent actionEvent) {
        Main m = new Main();
        try {
            m.changeScene("menuPrimoAccount.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    ObjectOutputStream out;
    {
        try {
            out = new ObjectOutputStream(new FileOutputStream("counter.bin"));
            out.writeObject(n);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     */

}

