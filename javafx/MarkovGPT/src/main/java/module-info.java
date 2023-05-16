module com.example.markovgpt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.markovgpt to javafx.fxml;
    exports com.example.markovgpt;
}