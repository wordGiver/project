package com.example.sproject.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mid;
    private   String name;
    private   Double price;
    private   Integer quantity;
    private   Double discount;

    public double getTruePrice()
    {
        return price*discount;
    }

}
