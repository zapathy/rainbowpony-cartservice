package com.rainbowpony.cartservice.controller;

import com.rainbowpony.cartservice.exceptions.ItemNotFoundException;
import com.rainbowpony.cartservice.model.CartItem;
import com.rainbowpony.cartservice.service.CartServiceDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("")
    public ResponseEntity<List<CartItem>> getEntireCart() {
        return new ResponseEntity<>(cartService.getCartContents(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> uploadNewShoppingCart(@PathVariable("id") Long id) {
        cartService.addToCart(id);
        return new ResponseEntity<>("Request processed successfully", HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteEntireCart() {
        cartService.deleteEntireCart();
        return new ResponseEntity<>("Request processed successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneItem(@PathVariable("id") Long id) {
        try {
            cartService.deleteItem(id);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Item Not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Request processed successfully", HttpStatus.OK);
    }
}
