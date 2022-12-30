package com.example.progetto_compiti_vacanze;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LogIn {

    @FXML
    private Label errate_fields;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogIn() throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        Main m = new Main();

        if(username.getText().equals("PrimoAccount") && password.getText().equals("CSapplication2021")) {
            errate_fields.setText("Success!");
            m.changeScene("menuPrimoAccount.fxml");
        } if(username.getText().equals("PrimoAccount") && password.getText().equals("CSapplication2022")) {
            errate_fields.setText("Unclear credentials, try again.");
            username.setText("");
            password.setText("");
        } if(username.getText().equals("PrimoAccount") && password.getText().equals("CSapplication2023")) {
            errate_fields.setText("Unclear credentials, try again.");
            username.setText("");
            password.setText("");
        } else if (username.getText().equals("PrimoAccount") && !password.getText().equals("CSapplication2021")){
            errate_fields.setText("Wrong password!");
            username.setText("");
        } else if (!username.getText().equals("PrimoAccount") && password.getText().equals("CSapplication2021")){
            errate_fields.setText("Wrong username!");
            password.setText("");
        }

        if(username.getText().equals("SecondoAccount") && password.getText().equals("CSapplication2022")) {
            errate_fields.setText("Success!");
            m.changeScene("menuSecondoAccount.fxml");
        } if(username.getText().equals("SecondoAccount") && password.getText().equals("CSapplication2021")) {
            errate_fields.setText("Unclear credentials, try again.");
            username.setText("");
            password.setText("");
        } if(username.getText().equals("SecondoAccount") && password.getText().equals("CSapplication2023")) {
            errate_fields.setText("Unclear credentials, try again.");
            username.setText("");
            password.setText("");
        } else if (username.getText().equals("SecondoAccount") && !password.getText().equals("CSapplication2022")){
            errate_fields.setText("Wrong password!");
            username.setText("");
        } else if (!username.getText().equals("SecondoAccount") && password.getText().equals("CSapplication2022")){
            errate_fields.setText("Wrong username!");
            password.setText("");
        }

        if(username.getText().equals("TerzoAccount") && password.getText().equals("CSapplication2023")) {
            errate_fields.setText("Success!");
            m.changeScene("menuTerzoAccount.fxml");
        } if(username.getText().equals("TerzoAccount") && password.getText().equals("CSapplication2021")) {
            errate_fields.setText("Unclear credentials, try again.");
            username.setText("");
            password.setText("");
        } if(username.getText().equals("TerzoAccount") && password.getText().equals("CSapplication2021")) {
            errate_fields.setText("Unclear credentials, try again.");
            username.setText("");
            password.setText("");
        } else if (username.getText().equals("TerzoAccount") && !password.getText().equals("CSapplication2023")){
            errate_fields.setText("Wrong password!");
            username.setText("");
        } else if (!username.getText().equals("TerzoAccount") && password.getText().equals("CSapplication2023")){
            errate_fields.setText("Wrong username!");
            password.setText("");
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            errate_fields.setText("Please enter your data.");
        }

        else {
            errate_fields.setText("Wrong username and password!");
            username.setText("");
            password.setText("");
        }
    }


}