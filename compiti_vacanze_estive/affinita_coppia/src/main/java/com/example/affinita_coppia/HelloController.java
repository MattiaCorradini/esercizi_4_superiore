package com.example.affinita_coppia;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.Period;

public class HelloController {

    public TextField yoname;
    public TextField cname;
    public DatePicker yobirth;
    public DatePicker cbirth;
    public Label percent;
    public Label frase;

    public void calculator() {
        String yourName = yoname.getText();
        String crushName = cname.getText();
        LocalDate yourBirth = yobirth.getValue();
        LocalDate crushBirth = cbirth.getValue();
        int affinitaCoppia = calcolaAffinitaCoppia(yourName, yourBirth, crushName, crushBirth);
        percent.setText(affinitaCoppia + "%");
        if (affinitaCoppia <= 10) {
            frase.setText("Just friends");
        } else if (affinitaCoppia <= 30) {
            frase.setText("Possibly compatible");
        } else if (affinitaCoppia <= 50) {
            frase.setText("Potential couple");
        } else if (affinitaCoppia <= 70) {
            frase.setText("Good match");
        } else if (affinitaCoppia <= 90) {
            frase.setText("Great couple");
        } else {
            frase.setText("Perfect match");
        }
    }

    public static int calcolaAffinitaCoppia(String nomeRagazzo, LocalDate dataNascitaRagazzo, String nomeRagazza, LocalDate dataNascitaRagazza) {
        int sommaAsciiRagazzo = calcolaSommaAscii(nomeRagazzo);
        int sommaAsciiRagazza = calcolaSommaAscii(nomeRagazza);

        int lunghezzaNomeRagazzo = nomeRagazzo.length();
        int lunghezzaNomeRagazza = nomeRagazza.length();

        int differenzaEta = calcolaDifferenzaEta(dataNascitaRagazzo, dataNascitaRagazza);

        String segnoZodiacaleRagazzo = calcolaSegnoZodiacale(dataNascitaRagazzo);
        String segnoZodiacaleRagazza = calcolaSegnoZodiacale(dataNascitaRagazza);

        int affinitaCoppia = sommaAsciiRagazzo + sommaAsciiRagazza - lunghezzaNomeRagazzo - lunghezzaNomeRagazza + differenzaEta;

        if (segnoZodiacaleRagazzo.equals(segnoZodiacaleRagazza)) {
            affinitaCoppia += 1000;
        }

        affinitaCoppia/=90;
        affinitaCoppia += 50;
        if (affinitaCoppia >= 100)
            affinitaCoppia = 100;

        return affinitaCoppia;
    }

    public static int calcolaSommaAscii(String nome) {
        int sommaAscii = 0;

        for (int i = 0; i < nome.length(); i++) {
            sommaAscii += nome.charAt(i);
        }

        return sommaAscii;
    }

    public static int calcolaDifferenzaEta(LocalDate dataNascita1, LocalDate dataNascita2) {
        Period differenzaPeriodo = Period.between(dataNascita1, dataNascita2);
        int differenzaAnni = Math.abs(differenzaPeriodo.getYears());

        return differenzaAnni * 2;
    }

    public static String calcolaSegnoZodiacale(LocalDate dataNascita) {
        int giorno = dataNascita.getDayOfMonth();
        int mese = dataNascita.getMonthValue();

        if ((mese == 3 && giorno >= 21) || (mese == 4 && giorno <= 19)) {
            return "Ariete";
        } else if (mese == 4 || mese == 5 && giorno <= 20) {
            return "Toro";
        } else if (mese == 5 || mese == 6 && giorno <= 20) {
            return "Gemelli";
        } else if (mese == 6 || mese == 7 && giorno <= 22) {
            return "Cancro";
        } else if (mese == 7 || mese == 8 && giorno <= 22) {
            return "Leone";
        } else if (mese == 8 || mese == 9 && giorno <= 22) {
            return "Vergine";
        } else if (mese == 9 || mese == 10 && giorno <= 22) {
            return "Bilancia";
        } else if (mese == 10 || mese == 11 && giorno <= 21) {
            return "Scorpione";
        } else if (mese == 11 || mese == 12 && giorno <= 21) {
            return "Sagittario";
        } else if (mese == 12 || mese == 1 && giorno <= 19) {
            return "Capricorno";
        } else if (mese == 1 || mese == 2 && giorno <= 18) {
            return "Acquario";
        } else {
            return "Pesci";
        }
    }
}
