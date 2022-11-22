/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educandoweb.curso_spring.config;

import com.educandoweb.curso_spring.entities.Category;
import com.educandoweb.curso_spring.entities.Order;
import com.educandoweb.curso_spring.entities.Product;
import com.educandoweb.curso_spring.entities.User;
import com.educandoweb.curso_spring.entities.enums.OrderStatus;
import com.educandoweb.curso_spring.repositories.CategoryRepository;
import com.educandoweb.curso_spring.repositories.OrderRepository;
import com.educandoweb.curso_spring.repositories.ProductRepository;
import com.educandoweb.curso_spring.repositories.UserRepository;
import java.time.Instant;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Jorge
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public TestConfig(UserRepository repository,
            OrderRepository orderRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository) {
        //construtor que substitui o @autowired por recomendação
        this.userRepository = repository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Browwn", "maria@gmail.com", "48 999486161", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "48 999485454", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:53:07Z"), u2, OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
