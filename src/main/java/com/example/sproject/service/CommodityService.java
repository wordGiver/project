package com.example.sproject.service;

import com.example.sproject.entity.Commodity;
import com.example.sproject.entity.User;

import java.util.List;
public interface CommodityService {
    List<Commodity> getAllCom();

    boolean insert(Commodity commodity);

    boolean update(Commodity commodity);

    boolean delete(Integer cid);

    Commodity getComById(int cid);

}
