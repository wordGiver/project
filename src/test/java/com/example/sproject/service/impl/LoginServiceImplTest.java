package com.example.sproject.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginServiceImplTest {
    @Autowired
    private LoginServiceImpl loginService;

    @Test
    //以下测试账号在数据库中

    public void TestUidInDB(){
        assertEquals(true,loginService.checkExistUid(18080123));
    }

    @Test
    public void TestUidInDBPawdAndIdentity() {
        assertEquals(true, loginService.checkPasswd(18080123,"123456",0));
    }

    @Test
    public void TestUidInDBNoPasswdAndIdentity(){
        assertEquals(false,loginService.checkPasswd(18080123,"12346",0));
    }

    //密码正确，身份错误
    @Test
    public void TestUidInDBPasswdAndNoIentity(){
        assertEquals(false,loginService.checkPasswd(18080123,"123456",1));
    }

    //全部错误
    @Test
    public void TestUidInDBNoPasswdAndNoIdentity(){
        assertEquals(false,loginService.checkPasswd(18080123,"1234",2));
    }


    //账号不在数据库
    @Test
    public void TestUidNotInDB(){
        assertEquals(false,loginService.checkExistUid(123456));
    }


}