package com.example.sproject.service.impl;

import com.example.sproject.dao.UserDao;
import com.example.sproject.entity.User;
import com.example.sproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public boolean insert(User user) {
        if(user == null)
        {
            System.out.println("null");
            return false;
        }
        if(userDao.findById(user.getUid()).isPresent())
        {
            System.out.println("user is exist");
            return false;
        }
        userDao.save(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        if(user == null)
            return false;
        if(userDao.findById(user.getUid()).isPresent()) {
            userDao.save(user);
            return true;
        }
        return false;



    }
    @Override
    public boolean delete(Integer uid)
    {
        if(!userDao.findById(uid).isPresent())
            return false;
        else
        {
            userDao.delete(userDao.findById(uid).get());
            return true;
        }
    }
    @Override
    public User getUserById(int uid)
    {
        if(userDao.findById(uid).isPresent())
            return userDao.findById(uid).get();
        else
            return null;
    }
}
