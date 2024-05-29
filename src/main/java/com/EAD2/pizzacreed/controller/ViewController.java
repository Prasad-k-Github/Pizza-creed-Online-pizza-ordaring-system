package com.EAD2.pizzacreed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/addProductForm")
    public String addProductForm() {
        return "addProduct";  // This will return index.html from the templates folder
    }
}
