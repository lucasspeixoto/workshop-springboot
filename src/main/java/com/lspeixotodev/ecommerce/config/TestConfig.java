package com.lspeixotodev.ecommerce.config;

import com.lspeixotodev.ecommerce.entities.User;
import com.lspeixotodev.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(2L, "Lucas Peixoto", "lspeixotodev@gmail.com", "982621117", "lucas10");
        User user2 = new User(3L, "Liana Fernandes", "lianacgf@gmail.com", "981448980", "liana10");

        try {
            userRepository.save(user1);
            userRepository.save(user2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
