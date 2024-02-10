package com.matthewbaiamonte.hoppersreceipt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hoppersController {
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
    
        model.addAttribute("name","Grace Hopper");
        model.addAttribute("itemName","Copper wire");
        model.addAttribute("price","5.25");
        model.addAttribute("description","Metal strips, also an illustration of nanoseconds.");
        model.addAttribute("vendor","Little Things Corner Store");
        return "receipt.jsp";
    }
    

}
