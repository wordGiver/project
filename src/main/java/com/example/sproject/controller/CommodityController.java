package com.example.sproject.controller;

import com.example.sproject.entity.Commodity;
import com.example.sproject.entity.User;
import com.example.sproject.service.CommodityService;
import com.example.sproject.service.impl.CommodityServiceImpl;
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

    @GetMapping("/inventory")
    public String inventory(Model model){
        model.addAttribute("commodities",commodityService.getAllCom());
        return "inventory";
    }

    @GetMapping("/insertCommunity")
    public String insertInventory(@ModelAttribute Commodity commodity){
        return "insertCommodity";
    }
    @PostMapping("/insertCommodity")
    public String insertCommodity(@ModelAttribute Commodity commodity){
        commodityService.insert(commodity);
        return "redirect:/inventory";
    }

    @GetMapping("inventory/delete/{cid}")
    public String commodityDelete(@PathVariable Integer cid){
        commodityService.delete(cid);
        return "redirect:/inventory";
    }

    @GetMapping("inventory/update/{cid}")
    public String inventoryUpdate(@PathVariable Integer cid,Model model){
        model.addAttribute("commodity",commodityService.getComById(cid));
        return "commodityUpdate";
    }

    @PostMapping("/commodityUpdate")
    public String commodityUpdate(@ModelAttribute Commodity commodity){
        commodityService.update(commodity);
        return "redirect:/inventory";
    }
}