package com.example.sproject.service.impl;

import com.example.sproject.dao.LoginDao;
import com.example.sproject.entity.Login;
import com.example.sproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.sproject.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public List<Login> getAllLogin() {

        return loginDao.findAll();
    }

    @Override
    public boolean  checkExistUid(int uid) {

        return loginDao.findById(uid).isPresent();
    }

    @Override
    public boolean checkPasswd(int uid, String passwd,int identity) {
        if(loginDao.findById(uid).isPresent()) {
            int identity1 = loginDao.findById(uid).get().getIdentity();
            String passwd1 = loginDao.findById(uid).get().getPasswd();
            if(passwd.equals(passwd1) && identity==identity1)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    @Override
    public boolean delete(int uid)
    {
        if(!loginDao.findById(uid).isPresent())
            return false;
        else{
            loginDao.delete(loginDao.findById(uid).get());
            return true;
        }
    }

    @Override
    public boolean insert(Login login) {
        if(login == null)
        {
            System.out.println("null");
            return false;
        }
        if(loginDao.findById(login.getUid()).isPresent())
        {
            System.out.println("user is exist");
            return false;
        }
        loginDao.save(login);
        return true;
    }

}
