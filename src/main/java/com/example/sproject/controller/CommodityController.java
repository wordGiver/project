package com.example.sproject.controller;

import com.example.sproject.entity.Commodity;
import com.example.sproject.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping("/insertCommunity")
    public String insertCommdity(){
        return null;
    }

    @GetMapping("/inventory")
    public String inventory(Model model){
        model.addAttribute("commodities",commodityService.getAllCom());
        return "inventory";
    }

    @GetMapping("inventory/delete/{Cid}")
    public String commodityDelete(@PathVariable Integer cid){
        commodityService.delete(cid);
        return "redirect:/inventory";
    }

    @GetMapping("inventory/update/{Cid}")
    public String inventoryUpdate(@PathVariable Integer cid,Model model){
        model.addAttribute("commodity",commodityService.getComById(cid));
        return "commodityUpdate";
    }

    @PostMapping("/commodity")
    public String commodityUpdate(@ModelAttribute Commodity commodity){
        commodityService.update(commodity);
        return "redirect:/inventory";
    }
}