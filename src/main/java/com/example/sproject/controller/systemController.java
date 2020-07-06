package com.example.sproject.controller;

import com.example.sproject.entity.Login;
import com.example.sproject.entity.User;
import com.example.sproject.service.LoginService;
import com.example.sproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class systemController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @GetMapping("/employeeManage")
    public String employeeManage(Model model)
    {
        model.addAttribute("Users",userService.getAllUser());
        return "employeeManage";
    }

    @GetMapping("employeeManage/delete/{uid}")
    public String employeeManageDelete(@PathVariable Integer uid)
    {
        userService.delete(uid);
        loginService.delete(uid);
        return "redirect:/employeeManage";
    }
    @GetMapping("/insertUser")
    public String getInsertUser(@ModelAttribute User user)
    {
        return "insertUser";
    }
    @PostMapping("/insertUser")
    public String insertUser(@ModelAttribute User user)
    {
        userService.insert(user);
        return "redirect:/employeeManage";
    }

    @GetMapping("/employeeManage/update/{uid}")
    public String employeeManageUpdate(@PathVariable Integer uid,Model model)
    {
        model.addAttribute("user",userService.getUserById(uid));
        return "updateUser";
    }


    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user)
    {
        System.out.println(user.getSalary());
        userService.update(user);

        return "redirect:/employeeManage";
    }





}
