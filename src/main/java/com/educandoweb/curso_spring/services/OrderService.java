/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educandoweb.curso_spring.services;

import com.educandoweb.curso_spring.entities.Order;
import com.educandoweb.curso_spring.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;
    
    public List<Order> findAll(){
        return repository.findAll();
    }
    
    public Optional<Order> findById(Long id){
        return repository.findById(id);
    }
}
