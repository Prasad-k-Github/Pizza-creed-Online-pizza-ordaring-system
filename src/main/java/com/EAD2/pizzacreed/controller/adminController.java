package com.EAD2.pizzacreed.controller;

import com.EAD2.pizzacreed.entity.admin;
import com.EAD2.pizzacreed.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private adminService adminService;

    @GetMapping("/get")
    public List<admin> getAdmin(){
        return adminService.getAdmin();
    }
}
