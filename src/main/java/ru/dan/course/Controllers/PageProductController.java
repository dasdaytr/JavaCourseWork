package ru.dan.course.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dan.course.Models.Product;
import ru.dan.course.Services.ProductService;


import java.security.Principal;

@Controller
public class PageProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/product/{type}")
    public String viewPageBeef(Model model, @PathVariable("type") String type){
        model.addAttribute("beefPerson",productService.findByType(type));
        model.addAttribute("url","/product/"+type);
        model.addAttribute("type",type);
        return "Beef/viewBeef";
    }
    @PostMapping("/product/{type}")
    public String viewPageBeefPost(@ModelAttribute Product product, Principal principal, @PathVariable("type") String type){
        productService.viewPageProductPost(product, principal);
        return "redirect:/product/"+type;
    }

}
