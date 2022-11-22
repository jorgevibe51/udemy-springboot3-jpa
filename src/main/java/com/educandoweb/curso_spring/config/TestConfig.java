/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educandoweb.curso_spring.config;

import com.educandoweb.curso_spring.entities.Order;
import com.educandoweb.curso_spring.entities.User;
import com.educandoweb.curso_spring.repositories.OrderRepository;
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

    public TestConfig(UserRepository repository, OrderRepository orderRepository) {
        //construtor que substitui o @autowired por recomendação
        this.userRepository=repository;
        this.orderRepository=orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Browwn", "maria@gmail.com", "48 999486161", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "48 999485454", "123456");
        
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:53:07Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:53:07Z"), u1);
        
        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
               
    }
}
