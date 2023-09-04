module com.example.forza_4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.forza_4 to javafx.fxml;
    exports com.example.forza_4;
}