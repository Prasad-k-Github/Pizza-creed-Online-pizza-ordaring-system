package com.EAD2.pizzacreed.controller;

import com.EAD2.pizzacreed.entity.cart;
import com.EAD2.pizzacreed.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class cartController {

    @Autowired
    private cartService cartService;

    @PostMapping("/add")
    private String addToCart(@RequestBody cart cart) {
        cartService.addToCart(cart);
        return "cart Added successful";
    }

    @GetMapping("/get")
    public List<cart> getProduct() {
        return cartService.getCart();
    }

    @DeleteMapping("/Delete_cart/{cartId}")
    public ResponseEntity<Void> deleteToCart(@PathVariable Integer cartId) {
        cartService.deleteToCart(cartId);
        return ResponseEntity.noContent().build();
    }
}
