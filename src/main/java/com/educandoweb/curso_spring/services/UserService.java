/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educandoweb.curso_spring.services;

import com.educandoweb.curso_spring.entities.User;
import com.educandoweb.curso_spring.repositories.UserRepository;
import com.educandoweb.curso_spring.services.exceptions.ResourceNotFoundException;
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
    
    public User findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
    
    public User insert(User user){
        return repository.save(user);
    }
    
    public void delete(Long id){
        repository.deleteById(id);
    }
    
    public User update(Long id, User user){
        User entity = repository.getReferenceById(id);
        updateData(entity, user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user) {
        //só atualize os campos necessários
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setTelefone(user.getTelefone());
    }
}
