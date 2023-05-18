module com.example.markovgpt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.markovgpt to javafx.fxml;
    exports com.example.markovgpt;
}