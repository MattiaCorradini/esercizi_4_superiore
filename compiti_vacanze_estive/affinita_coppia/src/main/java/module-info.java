module com.example.affinita_coppia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.affinita_coppia to javafx.fxml;
    exports com.example.affinita_coppia;
}