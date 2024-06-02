package com.EAD2.pizzacreed.controller;

import com.EAD2.pizzacreed.entity.basket;
import com.EAD2.pizzacreed.service.basketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/basket")
public class basketController {

    @Autowired
    private basketService basketService;

    @PostMapping("/add")
    public String addToBasket(@RequestBody basket basket) {
        basketService.addToBasket(basket);
        return "Basket added successfully";
    }

    @GetMapping("/get")
    public List<basket> getBasket() {
        return basketService.getBasket();
    }

    @DeleteMapping("/delete/{basketId}")
    public ResponseEntity<String> deleteFromBasket(@PathVariable Integer basketId) {
        basketService.deleteFromBasket(basketId);
        return ResponseEntity.ok("Basket deleted successfully");
    }

    @PostMapping("/checkout")
    public ResponseEntity<Map<String, Object>> checkout() {
        Map<String, Object> response = basketService.checkout();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/checkout/{basketId}")
    public ResponseEntity<Map<String, Object>> checkoutWithBasketId(@PathVariable Integer basketId) {
        Map<String, Object> response = basketService.checkoutWithBasketId(basketId);
        return ResponseEntity.ok(response);
    }
}
