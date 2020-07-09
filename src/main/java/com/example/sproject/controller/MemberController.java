package com.example.sproject.controller;

import com.example.sproject.entity.Commodity;
import com.example.sproject.entity.Member;
import com.example.sproject.service.CommodityService;
import com.example.sproject.service.MemberService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private CommodityService commodityService;

    @GetMapping("/memberManagement")
    public String initialize(Model model){
        model.addAttribute("members",memberService.getAllMember());
        return "memberManagement";
    }

    @GetMapping("memberManagement/delete/{mid}")
    public String memberDelete(@PathVariable Integer mid){
        memberService.delete(mid);
        return "redirect:/memberManagement";
    }

    @GetMapping("memberManagement/update/{mid}")
    public String memberUpdate(@PathVariable Integer mid,Model model){
        model.addAttribute("member",memberService.getUserById(mid));
        return "memberUpdate";
    }
    @PostMapping("/memberUpdate")
    public String memberUpdate(@ModelAttribute Member member){
        memberService.update(member);
        return "redirect:/memberManagement";
    }

    @GetMapping("/memberInsert")
    public String insertInventory(@ModelAttribute Member member){
        return "memberInsert";
    }
    @PostMapping("/memberInsert")
    public String insertCommodity(@ModelAttribute Member member){
        memberService.insert(member);
        return "redirect:/memberManagement";
    }

    @GetMapping("memberManagement/sendGifts/{mid}")
    public String sendGifts(@PathVariable Integer mid,Model model){
        model.addAttribute("commodities",commodityService.getAllCom());
        model.addAttribute("commod",new Commodity());
        return "sendGifts";
    }
    @PostMapping("/sendGifts")
    public String memberGifts(@ModelAttribute Commodity commodity){
        Commodity origin = commodityService.getComById(commodity.getCid());
        origin.setQuantity(origin.getQuantity()-commodity.getQuantity());
        commodityService.update(origin);
        return "redirect:/memberManagement";
    }
}
