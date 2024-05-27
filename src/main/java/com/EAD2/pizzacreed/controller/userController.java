package com.EAD2.pizzacreed.controller;

import com.EAD2.pizzacreed.entity.user;
import com.EAD2.pizzacreed.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/add")
    private String addUser(@RequestBody user user){
        userService .addUser(user);

        return "user Add succeccfull";
    }

}
