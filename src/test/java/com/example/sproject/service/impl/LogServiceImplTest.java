package com.example.sproject.service.impl;

import com.example.sproject.entity.Log;
import com.example.sproject.service.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.PublicKey;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LogServiceImplTest {
    @Autowired
    private LogServiceImpl logService;

    @Test
    public void  TestGetAllLog()
    {
        List<Log> logs = logService.getAllLog();
        for(Log log : logs)
        {
           System.out.print(log.getLid());
            System.out.print(log.getCname());
            System.out.print(log.getQuantity());
            System.out.println(log.getDate());
        }
    }



}