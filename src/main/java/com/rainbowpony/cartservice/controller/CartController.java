package com.rainbowpony.cartservice.controller;

import com.rainbowpony.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/products")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/")
    public HashMap<Long, Integer> getEntireCart() {
        return cartService.getCartContents();
    }

    @PostMapping("/{id}")
    public void uploadNewShoppingCart(@PathVariable("id") Long id) {
        cartService.addToCart(id);
    }

    @DeleteMapping("/")
    public void deleteEntireCart() {
        cartService.deleteEntireCart();
    }

    @DeleteMapping("/{id}")
    public void deleteOneItem(@PathVariable("id") Long id) {
        cartService.deleteItem(id);
    }
}
