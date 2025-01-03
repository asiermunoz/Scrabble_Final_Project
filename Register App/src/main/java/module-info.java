module com.example.register_aplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.google.gson;
    requires java.logging;
    requires java.desktop;

    opens com.example.register_aplication to javafx.fxml;
    exports com.example.register_aplication;


    opens users to com.google.gson;

}