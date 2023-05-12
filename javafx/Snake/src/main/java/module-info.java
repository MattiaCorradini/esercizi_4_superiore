module com.example.progetto_finale {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.progetto_finale to javafx.fxml;
    exports com.example.progetto_finale;
}