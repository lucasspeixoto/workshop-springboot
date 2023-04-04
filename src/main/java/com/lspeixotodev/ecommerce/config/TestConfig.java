package com.lspeixotodev.ecommerce.config;

import com.lspeixotodev.ecommerce.entities.Category;
import com.lspeixotodev.ecommerce.entities.Order;
import com.lspeixotodev.ecommerce.entities.User;
import com.lspeixotodev.ecommerce.entities.enums.OrderStatus;
import com.lspeixotodev.ecommerce.repositories.CategoryRepository;
import com.lspeixotodev.ecommerce.repositories.OrderRepository;
import com.lspeixotodev.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Lucas Peixoto", "lspeixotodev@gmail.com", "982621117", "lucas10");
        User u2 = new User(null, "Liana Fernandes", "lianacgf@gmail.com", "981448980", "liana10");

        Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
        Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        try {
            userRepository.save(u1);
            userRepository.save(u2);

            orderRepository.save(o1);
            orderRepository.save(o2);
            orderRepository.save(o3);

            categoryRepository.save(cat1);
            categoryRepository.save(cat2);
            categoryRepository.save(cat3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
