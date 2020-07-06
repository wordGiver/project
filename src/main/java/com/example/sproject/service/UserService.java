package com.example.sproject.service;


import com.example.sproject.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    boolean insert(User user);

    boolean update(User user);

    boolean delete(Integer uid);

    User getUserById(int uid);
}
