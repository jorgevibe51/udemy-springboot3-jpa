/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educandoweb.curso_spring.resources;

import com.educandoweb.curso_spring.entities.Order;
import com.educandoweb.curso_spring.services.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    
    @Autowired
    private OrderService service;
    
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        //Order u = new Order(1L, "Maria", "maria@gmail.com",  "999999", "12345");
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
}


//continua na aula 300