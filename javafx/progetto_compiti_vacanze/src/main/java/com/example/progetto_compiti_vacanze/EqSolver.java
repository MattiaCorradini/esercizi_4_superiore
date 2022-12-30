package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EqSolver {

    @FXML
    private TextField quadraticEquation;
    @FXML
    private TextArea output;

    @FXML
    void solve(ActionEvent event) {
        List<Double> coefficients = findCoefficients(quadraticEquation.getText());

        if(coefficients != null){
            List<Double> solutions = solve(coefficients);

            if(solutions.size() == 1){
                output.setText("No solutions, Δ= " + solutions.get(0));
            } else if(solutions.size() == 2){
                output.setText("1 solution,\nΔ= " + solutions.get(1) + "\nx = " + solutions.get(1));
            } else if(solutions.size() == 3){
                output.setText("2 solutions,\nΔ=" + solutions.get(1) + ", \nx₁=" + solutions.get(1) + "\nx₂=" + solutions.get(2));
            }
        } else {
            output.setText("Input not valid use the form:\nax^2+bx+c,\n(also specifies the coefficients 1)");
            quadraticEquation.setText("ax^2+bx+c");
        }
    }

    private List<Double> findCoefficients(String equation){
        List<Double> matches = new ArrayList<>();
        String regex = "(-?\\d+)x\\^2([+-]\\d+)x([+-]\\d+)"; //this string solves the 2nd grade equations

        Matcher m = Pattern.compile(regex).matcher(equation);
        if(m.matches()) {
            for (int i = 1; i < m.groupCount()+1; i++) {
                matches.add(Double.parseDouble(m.group(i)));
            }
            return matches;
        }
        return null;
    }

    private ArrayList<Double> solve(List<Double> coefficients){
        //coefficients:
        double a = coefficients.get(0);
        double b = coefficients.get(1);
        double c = coefficients.get(2);

        ArrayList<Double> solutions = new ArrayList<>();

        double d = Math.pow(b,2) - (4 * a * c); //d = Δ

        solutions.add((double) Math.round(d*100)/100);

        if(d == 0){ //1 solution
            double x1 = (-b) / (2 * a);
            solutions.add((double) Math.round(x1*100)/100);
        }else if (d > 0){ //2 solutions
            double x1 = ((-b) + Math.sqrt(d)) / (2 * a);
            solutions.add((double) Math.round(x1*100)/100);

            double x2 = ((-b) - Math.sqrt(d)) / (2 * a);
            solutions.add((double) Math.round(x2*100)/100);
        }
        return solutions;
    }

    public void onLogOut(ActionEvent actionEvent) {
        Main m = new Main();
        try {
            m.changeScene("menuTerzoAccount.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
