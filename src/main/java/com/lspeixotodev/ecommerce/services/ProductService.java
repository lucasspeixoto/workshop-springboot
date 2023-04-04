package com.lspeixotodev.ecommerce.services;

import com.lspeixotodev.ecommerce.entities.Product;
import com.lspeixotodev.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return this.repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> selectedCategory = this.repository.findById(id);

        if (selectedCategory.isEmpty()) {
            throw new IllegalStateException("There is no product for this id!");
        }

        return selectedCategory.get();
    }


}
