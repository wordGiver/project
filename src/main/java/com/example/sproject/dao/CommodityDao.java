package com.example.sproject.dao;

import com.example.sproject.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityDao extends JpaRepository<Commodity,Integer>{
}
