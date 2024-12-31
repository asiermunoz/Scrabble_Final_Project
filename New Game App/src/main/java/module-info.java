module com.example.new_game_app {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires jdk.jconsole;

    opens com.example.new_game_app to javafx.fxml;
    exports com.example.new_game_app;
}