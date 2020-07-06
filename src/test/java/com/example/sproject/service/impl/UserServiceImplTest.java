package com.example.sproject.service.impl;

import com.example.sproject.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void TestGetAllUser()
    {
        List<User> T = userService.getAllUser();
        for(User user: T)
        {
            System.out.print(user.getUid() + " ");
            System.out.print(user.getName()+ " ");
            System.out.print(user.getIdentity()+ " ");
            System.out.println(user.getSalary());
        }
    }
    @Test
    @Transactional
    public void TestInsert()
    {
        User user =new User();
        user.setUid(123456);
        user.setIdentity(2);
        user.setName("我八卦");
        user.setSalary(1200);

        assertEquals(true,userService.insert(user));
    }

}