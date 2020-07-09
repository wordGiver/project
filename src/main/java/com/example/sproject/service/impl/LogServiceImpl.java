package com.example.sproject.service.impl;

import com.example.sproject.dao.LogDao;
import com.example.sproject.entity.Log;
import com.example.sproject.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public List<Log>  getAllLog()
    {
        return logDao.findAll();
    }

    @Override
    public List<Log> getLogsByCname(String cname)
    {
        return logDao.findAllByCname(cname);
    }
    @Override
    public boolean insert(Date date, String oname, Integer cid, String cname, Integer quantity)
    {
        Log logOfCommodity = new Log();

        logOfCommodity.setDate(getDateString());
        logOfCommodity.setCname(cname);
        logOfCommodity.setQuantity(quantity);
        logOfCommodity.setCid(cid);
        logOfCommodity.setOname(oname);
        int tempLid;
        if(logDao.getLastlid() == null)
            tempLid=0;
        else
            tempLid=logDao.getLastlid();
        logOfCommodity.setLid(tempLid+1);
        logDao.save(logOfCommodity);
        return true;
    }

    @Override
    public boolean deleteBefDate(Date date)
    {
        return true;
    }

    @Override
    public String getDateString(){
        Date cDate = new Date();
        SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd");
        return ft.format(cDate);
    }

    @Override
    public boolean deleteById(int lid)
    {
        if(logDao.findById(lid).isPresent())
        {
            logDao.deleteById(lid);
            return  true;
        }
        else
            return false;
    }
}
