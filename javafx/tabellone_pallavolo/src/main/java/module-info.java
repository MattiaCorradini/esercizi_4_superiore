module com.example.tabellone_pallavolo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tabellone_pallavolo to javafx.fxml;
    exports com.example.tabellone_pallavolo;
}