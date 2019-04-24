package com.rainbowpony.cartservice.service;

import com.rainbowpony.cartservice.exceptions.DuplicateItemException;
import com.rainbowpony.cartservice.model.CartItem;
import com.rainbowpony.cartservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceDb {

    @Autowired
    ProductRepository productRepository;


//    public void addToCart(Long id) {
//        if (cart.containsKey(id)) cart.put(id, cart.get(id)+1);
//        else cart.put(id, 1);
//    }

    public List<CartItem> getCartContents() {
        return productRepository.findAll();
    }

    public void deleteEntireCart() {
        productRepository.deleteAll();
    }

//    public void deleteItem(Long id) throws DuplicateItemException {
//        List<CartItem> cartItems = getCartContents().stream().filter(cartItem -> cartItem.getId().equals(id)).collect(Collectors.toList());
//        if (cartItems.size() > 1) throw new DuplicateItemException();
//
//        if (getCartContents().stream().anyMatch(cartItem -> cartItem.getId() == id)) cart.put(id, cart.get(id) - 1);
//        else cart.remove(id);
//    }

    public boolean idIsInCart(Long id) throws DuplicateItemException {
        int numberOfIds = productRepository.findCartItemById(id).size();
        if (numberOfIds == 0) return false;
        else if (numberOfIds == 1) return true;
        else throw new DuplicateItemException();
    }
}
