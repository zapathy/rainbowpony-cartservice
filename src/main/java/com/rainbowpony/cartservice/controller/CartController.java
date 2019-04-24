package com.rainbowpony.cartservice.controller;

import com.rainbowpony.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/products")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/")
    HashMap<Long, Integer> getEntireCart() {
        return cartService.getCartContents();
    }
}
