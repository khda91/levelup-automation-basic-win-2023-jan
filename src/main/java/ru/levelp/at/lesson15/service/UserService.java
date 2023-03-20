package ru.levelp.at.lesson15.service;

import java.util.ArrayList;
import java.util.List;
import ru.levelp.at.lesson15.model.User;

public class UserService {

    private static List<User> users = new ArrayList<>();

    public void addUser(final User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
