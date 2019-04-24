package com.rainbowpony.cartservice.repository;

import com.rainbowpony.cartservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<CartItem, Long> {

//    @Query("SELECT t FROM Todo1 t WHERE t.id = :id")
//    ArrayList<Todo1> findTodoById(@Param("id") Long id);
//
//    @Query("SELECT t FROM Todo1 t WHERE t.status = :status")
//    ArrayList<Todo1> findTodoByStatus(@Param("status") Status status);
//
//    @Query("SELECT t FROM Todo1 t WHERE t.status = :statusstring")
//    ArrayList<Todo1> findTodoByStatusString(@Param("statusstring") String statusstring);
//
//    @Modifying
//    @Query("DELETE FROM Todo1 t WHERE t.id = :id")
//    @Transactional
//    void deleteTodo(@Param("id") Long id);
//
//    @Modifying
//    @Query("UPDATE Todo1 t SET t.title = :title WHERE t.id = :id")
//    @Transactional
//    void updateTitle(@Param("title") String title, @Param("id") Long id);
}