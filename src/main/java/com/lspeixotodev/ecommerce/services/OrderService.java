package com.lspeixotodev.ecommerce.services;

import com.lspeixotodev.ecommerce.entities.Order;
import com.lspeixotodev.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return this.repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> selectedOrder = this.repository.findById(id);

        if (selectedOrder.isEmpty()) {
            throw new IllegalStateException("There is no order for this id!");
        }

        return selectedOrder.get();
    }


}
