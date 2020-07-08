package com.example.sproject.controller;

import com.example.sproject.service.CommodityService;
import com.example.sproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private MemberService memberService;


}
