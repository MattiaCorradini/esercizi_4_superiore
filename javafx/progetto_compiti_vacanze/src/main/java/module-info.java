module com.example.progetto_compiti_vacanze {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.progetto_compiti_vacanze to javafx.fxml;
    exports com.example.progetto_compiti_vacanze;
}