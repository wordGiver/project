package com.example.sproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid; //商品编号
    private String name;       //商品名称
    private double price;       //商品价格
    private int quantity;       //商品数量
    private double discount=1;    //折扣
}
