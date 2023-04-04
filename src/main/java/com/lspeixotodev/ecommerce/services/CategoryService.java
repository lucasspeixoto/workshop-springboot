package com.lspeixotodev.ecommerce.services;

import com.lspeixotodev.ecommerce.entities.Category;
import com.lspeixotodev.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return this.repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> selectedCategory = this.repository.findById(id);

        if (selectedCategory.isEmpty()) {
            throw new IllegalStateException("There is no category for this id!");
        }

        return selectedCategory.get();
    }


}
