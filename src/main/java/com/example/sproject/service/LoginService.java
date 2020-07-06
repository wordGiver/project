package com.example.sproject.service;


import com.example.sproject.entity.Login;

import java.util.List;

public interface LoginService {

    List<Login> getAllLogin();

    boolean checkExistUid(int uid);
    boolean insert(Login login);
    boolean delete(int uid);
    boolean checkPasswd(int uid, String passwd, int identity);
}
