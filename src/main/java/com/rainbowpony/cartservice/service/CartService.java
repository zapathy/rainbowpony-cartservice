package com.rainbowpony.cartservice.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CartService {
    private HashMap<Long, Integer> cart = new HashMap<>();

    public void addToCart(Long id) {
        if (cart.containsKey(id)) cart.put(id, cart.get(id)+1);
        else cart.put(id, 1);
    }

    public HashMap<Long, Integer> getCartContents() {
        return cart;
    }

    public void deleteEntireCart() {
        cart = new HashMap<>();
    }

    public void deleteItem(Long id) {
        if (cart.get(id) > 1) cart.put(id, cart.get(id) - 1);
        else cart.remove(id);
    }
}
