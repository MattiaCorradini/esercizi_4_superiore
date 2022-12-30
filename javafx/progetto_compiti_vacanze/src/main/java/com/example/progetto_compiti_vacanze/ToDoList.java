package com.example.progetto_compiti_vacanze;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class ToDoList {

    @FXML
    public DatePicker date;
    @FXML
    private ListView<String> ListOfCommits;
    @FXML
    private TextField commit;

    @FXML
    void addName(MouseEvent event) {
        ListOfCommits.getItems().add(date.getValue() + "   ->   " + commit.getText());
        ListOfCommits.setStyle("-fx-control-inner-background: #C4C4C4;");
        commit.setText("");
        date.setValue(null);
    }

    @FXML
    void removeName(MouseEvent event) {
        int selected = ListOfCommits.getSelectionModel().getSelectedIndex();
        ListOfCommits.getItems().remove(selected);
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
