/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.educandoweb.curso_spring.entities.enums;

/**
 *
 * @author Jorge
 */
public enum OrderStatus{
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);
    
    private final int code;
    private OrderStatus(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
    
    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values())
            if(value.getCode() == code)
                return value;
        throw new IllegalArgumentException("Not valid OrderStatus code.");
    }
}
