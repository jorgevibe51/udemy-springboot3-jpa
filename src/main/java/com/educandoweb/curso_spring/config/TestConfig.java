/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educandoweb.curso_spring.config;

import com.educandoweb.curso_spring.entities.User;
import com.educandoweb.curso_spring.repositories.UserRepository;
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
    
    private UserRepository repository;

    public TestConfig(UserRepository repository) {
        //construtor que substitui o @autowired por recomendação
        this.repository=repository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Browwn", "maria@gmail.com", "48 999486161", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "48 999485454", "123456");
        
        repository.saveAll(Arrays.asList(u1,u2));
               
    }
}
