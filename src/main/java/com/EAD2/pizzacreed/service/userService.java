package com.EAD2.pizzacreed.service;

import com.EAD2.pizzacreed.entity.user;

import java.util.List;

public interface userService {
    void addUser(user user);

    List<user> getUser();

    user authenticateUser(String username, String password);
}
