package com.rainbowpony.cartservice.repository;

import com.rainbowpony.cartservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<CartItem, Long> {

    @Query("SELECT c FROM CartItem c WHERE c.id = :id")
    ArrayList<CartItem> findCartItemById(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.id = :id")
    @Transactional
    void deleteCartItemById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE CartItem c SET c.amount = :amount WHERE c.id = :id")
    @Transactional
    void updateCartItemById(@Param("id") Long id, @Param("amount") Integer amount);


}