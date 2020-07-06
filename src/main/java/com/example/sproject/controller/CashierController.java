package com.example.sproject.controller;



import com.example.sproject.entity.Commodity;
import com.example.sproject.entity.Member;
import com.example.sproject.service.CommodityService;
import com.example.sproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CashierController {
    @Autowired
    private CommodityService commodityService;
    @Autowired
    private MemberService memberService;
    private List<Commodity>  checkOut;





    @GetMapping("/cashier")
    public String getcashier(Model model){
        model.addAttribute("Commoditys",checkOut);
        return "cashier";
    }

    @GetMapping("/addCommodity")
    public String addCommodity(@ModelAttribute  Commodity commodity){

        return "addCommodity";

    }

    @PostMapping("/addCommodity")
    public String addCommodityPost(@ModelAttribute Commodity commodity )
    {
        if(checkOut == null)
            checkOut = new ArrayList<Commodity>();

        System.out.println(commodity.getCid());

        Commodity com = commodityService.getComById(commodity.getCid());
        com.setQuantity(commodity.getQuantity());
        int flag=0;
        if(com != null)
        {
            int i=0;
            for(; i<checkOut.size(); i++)
            {
                if(checkOut.get(i).getCid() == commodity.getCid())
                {
                    checkOut.get(i).setQuantity(checkOut.get(i).getQuantity()+com.getQuantity());
                    flag=1;
                    break;
                }

            }
            if(flag==0)
                checkOut.add(com);
            return "redirect:/cashier";
        }
        else
            return "redirect:/cashier";

    }

    @GetMapping("cashier/delete/{cid}")
    public String employeeManageDelete(@PathVariable Integer cid)
    {

        for(int i=0; i<checkOut.size();i++)
        {
            if(checkOut.get(i).getCid() == cid) {
                checkOut.remove(i);
                return "redirect:/cashier";
            }
        }

        return "redirect:/cashier";

    }

    private double getPrice(List<Commodity> list, int discount)
    {
        double price=0;
        for(int i=0; i<list.size();i++)
        {
            price +=(list.get(i).getPrice()*discount*list.get(i).getQuantity()*0.1);
        }
        return price;
    }

    @GetMapping("/settleAccounts")
    public String getSettleAccounts(Model model)
    {
        if(checkOut == null)
            return "redirect:/cashier";
        double price = getPrice(checkOut,10);
        System.out.println(price);
        model.addAttribute("price",(int)price);
        return "settleAccounts";
    }

    @GetMapping("/checkOutSuccess")
    public String checkOutSuccess(){
        for(int i=0; i<checkOut.size(); i++)
        {
            Commodity com = commodityService.getComById(checkOut.get(i).getCid());
            com.setQuantity(com.getQuantity() - checkOut.get(i).getQuantity());
            commodityService.update(com);
        }
        checkOut.clear();
        return "redirect:/cashier";
    }

    @GetMapping("/checkOutSuccess/{mid}/{score}")
    public String checkOutSuccess(@PathVariable Integer mid, @PathVariable double score)
    {
        for(int i=0; i<checkOut.size(); i++)
        {
            Commodity com = commodityService.getComById(checkOut.get(i).getCid());
            com.setQuantity(com.getQuantity() - checkOut.get(i).getQuantity());
            commodityService.update(com);
            Member mem = memberService.getUserById(mid);
            mem.setScore(score);
            memberService.update(mem);
        }
        checkOut.clear();
        return "redirect:/cashier";
    }



    @GetMapping("/settleAccountsMember")
    public String getSettleAccountsMember(@ModelAttribute Member member){

        return "settleAccountsMember";

    }
    @PostMapping("/settleAccountsMember")
    public String settleAccountsMember(@ModelAttribute Member member, Model model)
    {
        if(memberService.getUserById(member.getMid()) != null)
        {
            double score =memberService.getUserById(member.getMid()).getScore();

            double price = getPrice(checkOut,9)  ;   //后续由经理设定
            double score1 = score + price * 0.1;
            member.setScore(score1);
            model.addAttribute("price",(int)price);
            model.addAttribute("mess","尊敬的会员:"+memberService.getUserById(member.getMid()).getName() +", 您的会员积分当前为:" + score+ "结账后为:"+score1+"  请关注本店优惠活动");
            model.addAttribute("member",member);
            System.out.println(member.getScore());
            return "settleAccounts";
        }
        else
        {
            double price = getPrice(checkOut,10);
            model.addAttribute("price",(int)price);
            return "settleAccounts";
        }
    }

    @GetMapping("/registerMember")
    public String getRegisterMember(@ModelAttribute Member member){

        return "registerMember";

    }

    @PostMapping("/registerMember")
    public String registerMember(@ModelAttribute Member member,Model model)
    {
           member.setScore(0.0);
           member.setMid(memberService.getLastMid()+ 1);
           System.out.println(member.getMid());
           if(memberService.insert(member))
           {
               model.addAttribute("mid",member.getMid());

               return "registerMemberSucc";
           }
           else
               return "registerMemberFailed";


    }







}
