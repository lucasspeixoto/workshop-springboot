package com.lspeixotodev.ecommerce.services;

import com.lspeixotodev.ecommerce.entities.User;
import com.lspeixotodev.ecommerce.repositories.UserRepository;
import com.lspeixotodev.ecommerce.services.exceptions.ResourceNotFoundException;
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

        return selectedUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return this.repository.save(user);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public User update(Long id, User user) {
        /**
         * o getReferenceById, diferente do getById, retorna
         * um objeto monitorado pelo Jpa para somente depois
         * efetuarmos alguma operação com ele no banco.
         */
        User entity = this.repository.getReferenceById(id);

        this.updateUserData(entity, user);

        return this.repository.save(entity);

    }

    public void updateUserData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }


}
