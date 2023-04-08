package com.lspeixotodev.ecommerce.services;

import com.lspeixotodev.ecommerce.entities.User;
import com.lspeixotodev.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return this.repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> selectedUser = this.repository.findById(id);

        if (selectedUser.isEmpty()) {
            throw new IllegalStateException("There is no user with for this id!");
        }

        return selectedUser.get();
    }


    public User insert(User user) {
        return this.repository.save(user);
    }


}
