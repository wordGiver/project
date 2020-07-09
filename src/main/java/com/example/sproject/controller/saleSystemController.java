package com.example.sproject.controller;

import com.example.sproject.entity.Echars;
import com.example.sproject.entity.Log;
import com.example.sproject.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class saleSystemController {
    @Autowired
    private LogService logService;

    @Autowired
    private HttpServletRequest request;


    @GetMapping("/searchBack")
    public String getSearchBack(Model model)
    {
        List<Log> logs = new ArrayList<Log>();
        logs= logService.getAllLog();
        model.addAttribute("logs",logs);
        return "searchBack";
    }

    @PostMapping("/searchBack")
    public String searchBack(@ModelAttribute ArrayList<Integer> lid)
    {

        System.out.println("wakdjkalnk");
        String [] t= request.getParameterValues("lid[]");
        for(int i=0; i<t.length;i++)
        {
           int l=(Integer.valueOf(t[i]).intValue());
           logService.deleteById(l);
        }
        return "redirect:/searchBack";
    }

    @RequestMapping(value = "/EcharsShow")
    @ResponseBody
    public List<Echars> findById(Model model) {
        List<Echars> list = new ArrayList<Echars>();
       List<Log> logs = logService.getAllLog();
        for(int i=0; i<logs.size();i++)
        {
            for(int t=i+1;t<logs.size(); t++)
            {
                if(logs.get(i).getCname().equals(logs.get(t).getCname()))
                {
                    logs.get(i).setQuantity(logs.get(i).getQuantity() + logs.get(t).getQuantity());
                    logs.remove(t);
                }
            }
        }

        for(int i=0; i<logs.size();i++)
        {
            Echars echars = new Echars();
            echars.setName(logs.get(i).getCname());
            echars.setNum(logs.get(i).getQuantity());
            list.add(echars);
        }
        System.err.println(list.toString());

        return list;
    }

    @GetMapping(value = "/echart")
    public String echarts4(Model model){
        System.err.println("========开始");
        return "echart";
    }



}
