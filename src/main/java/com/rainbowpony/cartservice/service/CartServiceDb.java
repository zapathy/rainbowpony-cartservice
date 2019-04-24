package com.rainbowpony.cartservice.service;

import com.rainbowpony.cartservice.exceptions.ItemNotFoundException;
import com.rainbowpony.cartservice.model.CartItem;
import com.rainbowpony.cartservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceDb {

    @Autowired
    ProductRepository repository;


    public void addToCart(Long id) {
        Optional<CartItem> cartItem = repository.findById(id);
        if (cartItem.isPresent()) repository.updateCartItemById(id, cartItem.get().getAmount() + 1);
        else repository.save(new CartItem(id, 1));
    }

    public List<CartItem> getCartContents() {
        return repository.findAll();
    }

    public void deleteEntireCart() {
        repository.deleteAll();
    }

    public void deleteItem(Long id) throws ItemNotFoundException {
        Optional<CartItem> cartItem = repository.findById(id);
        if (cartItem.isPresent())
            if (cartItem.get().getAmount() > 1) repository.updateCartItemById(id, cartItem.get().getAmount() - 1);
            else repository.delete(cartItem.get());
        else throw new ItemNotFoundException();
    }

}
