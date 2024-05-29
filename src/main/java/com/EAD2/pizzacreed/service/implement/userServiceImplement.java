package com.EAD2.pizzacreed.service.implement;

import com.EAD2.pizzacreed.entity.user;
import com.EAD2.pizzacreed.repository.userRepository;
import com.EAD2.pizzacreed.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImplement implements userService {

    @Autowired
    private userRepository userRepository;

    @Override
    public void addUser(user user) {
        userRepository.save(user);
    }

    @Override
    public List<user> getUser() {
        return userRepository.findAll();
    }

    @Override
    public user authenticateUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
