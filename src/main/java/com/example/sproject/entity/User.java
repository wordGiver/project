package com.example.sproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @description
 * @author Tim Lin
 * @create 2018-07-01
 **/

@Data
@Entity
//员工实体类 （identity (0:经理; 1:系统管理员; 2:库存管理员; 3:售货员

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String name;
    private int identity;
    private int salary;


}

