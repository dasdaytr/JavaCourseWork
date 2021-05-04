package ru.dan.course.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dan.course.Models.Basket;
import ru.dan.course.Models.Beef;
import ru.dan.course.Models.Product;
import ru.dan.course.repo.BasketRepository;
import ru.dan.course.repo.PersonRepository;

import java.security.Principal;
import java.util.Optional;

@Controller
public class BasketController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BasketRepository basketRepository;
    @GetMapping("/mainPage/basket")
    public String GetBasket(Model model, Principal principal){
        model.addAttribute("basketPerson",personRepository.findByEmail(principal.getName()).getBaskets());
        return "/Basket/BasketPerson";
    }
    @PostMapping("/mainPage/baskett")
    public String deleteProduct(Principal principal, @ModelAttribute Product product,Model model){
         basketRepository.findByNameProductAndPerson2(product.getNameProduct(), personRepository.findByEmail(principal.getName())).map(basket1 -> {
            basketRepository.delete(basket1);
            return null;
        });
        return "redirect:/mainPage/basket";
    }
}
