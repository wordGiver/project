package com.example.sproject.service;

import com.example.sproject.entity.Log;

import java.util.Date;
import java.util.List;

public interface LogService {
    List<Log> getAllLog();
    List<Log> getLogsByCname(String cname);
    boolean insert(Date date, String oname, Integer mid,String cname, Integer quantity);
    boolean deleteBefDate(Date date);                           //删除date时间前的数据
    String getDateString();

    boolean deleteById(int lid);
}
