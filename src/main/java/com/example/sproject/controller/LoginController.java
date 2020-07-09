package com.example.sproject.controller;

import com.example.sproject.entity.Login;
import com.example.sproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;


    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }


    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute Login login) {
        if(loginService.checkExistUid(login.getUid())  && loginService.checkPasswd(login.getUid(), login.getPasswd(), login.getIdentity()) )
        {
            switch (login.getIdentity())
            {
                case 0:
                    return "saleSystem";                    //经理 进入销售后台管理系统

                case 1:
                    return "employeeSystem";
                case 2:
                    return "customerManeger";
                case 3:
                    return "cashier";

            }

        }
        else
            System.out.println("Hello World");

        return "login";
    }




}
