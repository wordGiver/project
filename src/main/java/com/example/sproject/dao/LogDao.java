package com.example.sproject.dao;


import com.example.sproject.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogDao extends JpaRepository<Log,Integer>{

    @Query(nativeQuery = true, value = "SELECT Max(lid) FROM Log ")
    Integer getLastlid();

    List<Log> findAllByCname(String cname);


}
