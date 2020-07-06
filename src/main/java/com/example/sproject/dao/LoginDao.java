package com.example.sproject.dao;

import com.example.sproject.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LoginDao extends JpaRepository<Login,Integer>{

}
