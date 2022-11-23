/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educandoweb.curso_spring.services;

import com.educandoweb.curso_spring.entities.User;
import com.educandoweb.curso_spring.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    public List<User> findAll(){
        return repository.findAll();
    }
    
    public Optional<User> findById(Long id){
        return repository.findById(id);
    }
    
    public User insert(User user){
        return repository.save(user);
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }
}
