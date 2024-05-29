package com.EAD2.pizzacreed.controller;

import com.EAD2.pizzacreed.entity.user;
import com.EAD2.pizzacreed.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody user user) {
        userService.addUser(user);
        return "User added successfully";
    }

    @PostMapping("/login")
    public user loginUser(@RequestBody user user) {
        return userService.authenticateUser(user.getUsername(), user.getPassword());
    }

    @GetMapping("/get")
    public List<user> getUser() {
        return userService.getUser();
    }
}
