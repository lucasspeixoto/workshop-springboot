package com.lspeixotodev.ecommerce.resourses;

import com.lspeixotodev.ecommerce.entities.Category;
import com.lspeixotodev.ecommerce.entities.Order;
import com.lspeixotodev.ecommerce.services.CategoryService;
import com.lspeixotodev.ecommerce.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        List<Category> categories = this.service.findAll();

        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {

        Category selectedCategory = this.service.findById(id);

        return ResponseEntity.ok().body(selectedCategory);
    }
}
