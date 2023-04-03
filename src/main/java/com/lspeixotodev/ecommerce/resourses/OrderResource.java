package com.lspeixotodev.ecommerce.resourses;

import com.lspeixotodev.ecommerce.entities.Order;
import com.lspeixotodev.ecommerce.entities.User;
import com.lspeixotodev.ecommerce.services.OrderService;
import com.lspeixotodev.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {

        List<Order> users = this.service.findAll();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {

        Order selectedOrder = this.service.findById(id);

        return ResponseEntity.ok().body(selectedOrder);
    }
}
