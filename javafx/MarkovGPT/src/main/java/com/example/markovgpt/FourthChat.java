package com.example.markovgpt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.ResourceBundle;

public class FourthChat implements Initializable {
    @FXML
    public TextField txtfield;
    @FXML
    public TextArea out;
    @FXML
    public TextField picker;
    private final ArrayList<String> catena;
    private final GenerazioneTesto gt;

    public void serializeData(String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(txtfield.getText());
            outputStream.writeObject(out.getText());
            outputStream.writeObject(picker.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeData(String filePath) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            txtfield.setText((String) inputStream.readObject());
            out.setText((String) inputStream.readObject());
            picker.setText((String) inputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String filePath = "fourth.bin";
        deserializeData(filePath);
        out.setStyle("-fx-control-inner-background: #353740;");
    }

    public FourthChat() {
        this.catena = new ArrayList<>();
        this.gt = new GenerazioneTesto();
    }

    public void send() {
        String testo = txtfield.getText();
        String [] paroleArray = testo.split(" ");
        Collections.addAll(catena, paroleArray);
        gt.allena(catena);
        ArrayList<String> testoGenerato = gt.genera(Integer.parseInt(picker.getText()));
        int i = 0;
        StringBuilder output = new StringBuilder();
        for (String word : testoGenerato) {
            if (Objects.equals(word, "."))
                output.delete(output.length()-1, output.length());
            output.append(word).append(' ');
            if (i == 0){
                char c = output.charAt(0);
                c -= 32;
                output.deleteCharAt(0);
                output.insert(0, c);
            }
            i++;
            if (i==10){
                output.append("\n");
                i=1;
            }

        }
        output.delete(output.length()-1, output.length());
        output.append(".");
        out.setText(String.valueOf(output));
    }

    public void delete(ActionEvent actionEvent) {
        txtfield.setText("");
        picker.setText("");
        out.setText("");
    }

    public void secondChat(ActionEvent actionEvent) {
        String filePath = "fourth.bin";
        serializeData(filePath);
        Main m = new Main();
        try {
            m.changeScene("secondchat.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void thirdChat(ActionEvent actionEvent) {
        String filePath = "fourth.bin";
        serializeData(filePath);
        Main m = new Main();
        try {
            m.changeScene("thirdchat.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void firstChat(ActionEvent actionEvent) {
        String filePath = "fourth.bin";
        serializeData(filePath);
        Main m = new Main();
        try {
            m.changeScene("firstchat.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fifthChat(ActionEvent actionEvent) {
        String filePath = "fourth.bin";
        serializeData(filePath);
        Main m = new Main();
        try {
            m.changeScene("fifthchat.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}