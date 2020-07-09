package com.example.sproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Data
@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lid;
    private String oname;     //操作名
    private Integer cid;            //操作元组
    private Integer quantity;       //操作数量
    private String cname;          //操作商品名称
    private String date;              //操作时间


}



