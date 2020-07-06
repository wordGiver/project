package com.example.sproject.dao;

import com.example.sproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserDao extends JpaRepository<User,Integer>{

}
