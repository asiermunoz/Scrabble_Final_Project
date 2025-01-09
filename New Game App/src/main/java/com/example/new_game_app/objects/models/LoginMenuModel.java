package com.example.new_game_app.objects.models;

import com.example.new_game_app.Player;
import com.example.new_game_app.objects.users.User;

import java.util.LinkedList;

public class LoginMenuModel {
    public boolean validateUser(LinkedList<User> usersLinkedList, User newUser) {
        for (User user : usersLinkedList) {
            if (newUser.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public Player userToPlayer(User user) {
        return new Player(user.getAlias(), 0, null, false);
    }
}
