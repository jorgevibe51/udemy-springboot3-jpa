/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educandoweb.curso_spring.repositories;

import com.educandoweb.curso_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jorge
 */
public interface UserRepository  extends JpaRepository<User, Long>{
}
