package ru.dan.course.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BasketController {

    @GetMapping("/mainPage/basket")
    public String GetBasket(Model model, @PathVariable("id") int id){
        return "";
    }
}
