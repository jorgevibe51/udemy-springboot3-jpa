/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educandoweb.curso_spring.services;

import com.educandoweb.curso_spring.entities.Category;
import com.educandoweb.curso_spring.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;
    
    public List<Category> findAll(){
        return repository.findAll();
    }
    
    public Optional<Category> findById(Long id){
        return repository.findById(id);
    }
}
