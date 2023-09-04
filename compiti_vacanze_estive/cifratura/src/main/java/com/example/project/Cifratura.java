package com.example.project;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Cifratura implements Initializable {
    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public TextField text;
    public PasswordField key;
    public TextArea output;
    public Label msg;
    private String testoDecifrato = "";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        output.setStyle("-fx-control-inner-background: #e6f7ff;");
    }

    public void codifica() {
        String chiave = key.getText();
        Map<Character, Character> mappaCifratura = creaMappaCifratura(chiave);
        String testo = text.getText();
        String testoCifrato = cifra(testo, mappaCifratura);
        output.setText(testoCifrato);
        //testoDecifrato = decifra(testoCifrato, mappaCifratura);
        testoDecifrato = text.getText();
        msg.setText("encrypted text:");
    }

    public void decodifica() {
        output.setText(testoDecifrato);
        msg.setText("decrypted text:");
    }


    private static Map<Character, Character> creaMappaCifratura(String chiave) {
        Map<Character, Character> mappaCifratura = new HashMap<>();
        int lunghezzaChiave = chiave.length();

        for (int i = 0; i < ALFABETO.length(); i++) {
            char carattereOriginale = ALFABETO.charAt(i);
            char carattereCifrato = chiave.charAt(i % lunghezzaChiave);
            mappaCifratura.put(carattereOriginale, carattereCifrato);
        }

        return mappaCifratura;
    }

    private static String cifra(String testo, Map<Character, Character> mappaCifratura) {
        StringBuilder risultato = new StringBuilder();
        for (char carattere : testo.toCharArray()) {
            if (mappaCifratura.containsKey(Character.toUpperCase(carattere))) {
                char carattereCifrato = mappaCifratura.get(Character.toUpperCase(carattere));
                if (Character.isLowerCase(carattere)) {
                    carattereCifrato = Character.toLowerCase(carattereCifrato);
                }
                risultato.append(carattereCifrato);
            } else {
                risultato.append(carattere);
            }
        }
        return risultato.toString();
    }

    /*
    private static String decifra(String testo, Map<Character, Character> mappaCifratura){
        // Inverte la mappa di cifratura per ottenere la mappa di decifratura
        Map<Character, Character> mappaDecifratura = new HashMap<>();
        for (Map.Entry<Character, Character> entry : mappaCifratura.entrySet()) {
            mappaDecifratura.put(entry.getValue(), entry.getKey());
        }
        // Decifra il testo utilizzando la mappa di decifratura
        return cifra(testo, mappaDecifratura);
    }
    */

    public void pulisci() {
        output.setText("");
        text.setText("");
        key.setText("");
    }
}
