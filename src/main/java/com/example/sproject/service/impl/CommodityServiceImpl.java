package com.example.sproject.service.impl;

import com.example.sproject.dao.CommodityDao;
import com.example.sproject.entity.Commodity;
import com.example.sproject.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    private CommodityDao commodityDao;

    @Override
    public List<Commodity> getAllCom(){
    return commodityDao.findAll();
    }

    @Override
    public boolean insert(Commodity commodity) {
        if(commodity == null)
        {
            System.out.println("null");
            return false;
        }
        if(commodityDao.findById(commodity.getCid()).isPresent())
        {
            System.out.println("user is exist");
            return false;
        }
        commodityDao.save(commodity);
        return true;
    }

    @Override
    public boolean update(Commodity commodity) {
        if (commodity == null)
            return false;
        if (commodityDao.findById(commodity.getCid()).isPresent()) {
            commodityDao.save(commodity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer cid) {
            if(!commodityDao.findById(cid).isPresent())
                return false;
            else
            {
                commodityDao.delete(commodityDao.findById(cid).orElse(null));
                return true;
            }
    }

    @Override
    public Commodity getComById(int cid) {
        if(commodityDao.findById(cid).isPresent())
            return commodityDao.findById(cid).orElse(null);
        else
            return null;
    }

}
