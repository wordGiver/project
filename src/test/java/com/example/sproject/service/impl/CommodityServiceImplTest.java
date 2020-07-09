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

    @Test
    public void getComById() {
        Commodity com = commodityService.getComById(8848);
        System.out.println("===>"+com.getCid());
        Assert.assertNotEquals(null,com);
        Assert.assertEquals(null,commodityService.getComById(0000));
    }

    @Test
    public void insert() {
        Commodity com = new Commodity();
        Assert.assertEquals(null,commodityService.getComById(com.getCid()));
        commodityService.insert(com);
        Assert.assertNotEquals(null,commodityService.getComById(com.getCid()));
    }

    @Test
    public void update() {
        Commodity com = commodityService.getComById(8848);
        com.setName("手机");
        commodityService.update(com);
        Assert.assertEquals("手机",commodityService.getComById(8848).getName());
    }

    @Test
    public void delete() {
        Assert.assertNotEquals(null,commodityService.getComById(8848));
        commodityService.delete(8848);
        Assert.assertEquals(null,commodityService.getComById(8848));
    }


}