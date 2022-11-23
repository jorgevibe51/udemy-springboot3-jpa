/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educandoweb.curso_spring.services;

import com.educandoweb.curso_spring.entities.User;
import com.educandoweb.curso_spring.repositories.UserRepository;
import com.educandoweb.curso_spring.services.exceptions.DatabaseException;
import com.educandoweb.curso_spring.services.exceptions.ResourceNotFoundException;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            repository.deleteById(id);
            
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
            
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
    
    public User update(Long id, User user){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, user);
            return repository.save(entity);
            
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        //só atualize os campos necessários
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setTelefone(user.getTelefone());
    }
}
