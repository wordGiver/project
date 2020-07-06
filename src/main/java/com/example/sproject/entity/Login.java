package com.example.sproject.entity;


import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//员工实体类 （identity (0:经理; 1:系统管理员; 2:库存管理员; 3:售货员
@Data
@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String passwd;
    private int identity;




}

