package com.example.new_game_app;

import com.example.new_game_app.objects.PlayerManager;
import com.example.new_game_app.objects.models.LoginMenuModel;
import com.example.new_game_app.objects.users.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class LoginMenuController {

    //FXML Variables

    @FXML
    private TextField usernameField1;
    @FXML
    private TextField emailField1;
    @FXML
    private TextField usernameField2;
    @FXML
    private TextField emailField2;
    @FXML
    private Button loginButton;
    @FXML
    private Button loginExit;
    @FXML
    private Label errorMessage;


    //Java Variables

    private String alias1;
    private String alias2;
    private LinkedList<User> usersLinkedList;
    private LoginMenuModel model;

    private final ChangeSceneStrategy strategy = new ChangeSceneryToMainMenu();
    private final ChangeSceneryToContext context = new ChangeSceneryToContext();


    //Constructors and Getters y Setters

    public LoginMenuController() {
        this.model = new LoginMenuModel();
    }

    public void setUsersLinkedList(LinkedList<User> usersLinkedList) {
        this.usersLinkedList = usersLinkedList;
    }

    //Methods

    @FXML
    private void startLogin(javafx.event.ActionEvent actionEvent) {
        alias1 = usernameField1.getText();
        String email1 = emailField1.getText();
        alias2 = usernameField2.getText();
        String email2 = emailField2.getText();

        User user1 = new User(alias1, email1);
        User user2 = new User(alias2, email2);

        if(model.validateUser(usersLinkedList, user1) && model.validateUser(usersLinkedList, user2)) {
            context.setStrategy(strategy);
            Player player1 = model.userToPlayer(user1);
            Player player2 = model.userToPlayer(user2);
            PlayerManager.player1 = player1;
            PlayerManager.player2 = player2;
            context.change(actionEvent);
        } else {
            errorMessage.setText("User not found");
            usernameField1.clear();
            emailField1.clear();
            usernameField2.clear();
            emailField2.clear();
        }
    }

    @FXML
    private void exitLogin() {
        System.exit(0);
    }

}
