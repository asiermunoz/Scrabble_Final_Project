module com.example.scrabble_final_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.scrabble_final_project to javafx.fxml;
    exports com.example.scrabble_final_project;
}