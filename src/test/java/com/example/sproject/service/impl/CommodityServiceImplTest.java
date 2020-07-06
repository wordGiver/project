package com.example.sproject.service.impl;

import com.example.sproject.entity.Commodity;
import com.example.sproject.service.CommodityService;
import lombok.val;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityServiceImplTest {
    @Autowired
    private CommodityService commodityService;
    @Test
    public void getAllCom() {
        List<Commodity> allCom = commodityService.getAllCom();
        System.out.println("===>"+allCom.size());
        Assert.assertNotEquals(0, allCom.size());
    }
}