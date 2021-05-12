package ru.dan.course.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dan.course.Models.Product;
import ru.dan.course.Services.BasketService;


import java.security.Principal;


@Controller
public class BasketController {
    @Autowired
    private BasketService basketService;
    @GetMapping("/mainPage/basket")
    public String GetBasket(Model model, Principal principal){
        model.addAttribute("sum",basketService.getSum(principal));
        model.addAttribute("count",basketService.getSum(principal));
        model.addAttribute("basketPerson",basketService.getPersonBasket(principal));

        return "/Basket/BasketPerson";
    }
    @PostMapping("/mainPage/baskett")
    public String deleteProduct(Principal principal, @ModelAttribute Product product){
         basketService.deleteProduct(principal,product);
        return "redirect:/mainPage/basket";
    }
    @PostMapping("/mainPage/basket2")
    public String AddChangeProduct(Principal principal,@ModelAttribute Product product){
        return "";
    }

}
