module com.example.new_game_app {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires jdk.jconsole;
    requires com.google.gson;
    requires java.logging;
    requires org.jsoup;

    opens com.example.new_game_app to javafx.fxml, com.google.gson;
    opens com.example.new_game_app.objects.users to com.google.gson;
    exports com.example.new_game_app;
}