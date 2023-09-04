module com.example.forza4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.forza4 to javafx.fxml;
    exports com.example.forza4;
}