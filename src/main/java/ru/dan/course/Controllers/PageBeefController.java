package ru.dan.course.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dan.course.Models.Basket;
import ru.dan.course.Models.Beef;
import ru.dan.course.Models.person2;
import ru.dan.course.repo.BasketRepository;
import ru.dan.course.repo.BeefRepository;
import ru.dan.course.repo.PersonRepository;

import java.security.Principal;

@Controller
public class PageBeefController {
    @Autowired
    private BeefRepository beefRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BasketRepository basketRepository;
    @GetMapping("/product/{type}")
    public String viewPageBeef(Model model, @PathVariable("type") String type){
        model.addAttribute("beefPerson",beefRepository.findByType(type));
        model.addAttribute("url","/product/"+type);
        model.addAttribute("type",type);
        return "Beef/viewBeef";
    }
    @PostMapping("/product/{type}")
    public String viewPageBeefPost(@ModelAttribute Beef beef,Principal principal,@PathVariable("type") String type){
        person2 person = personRepository.findByEmail(principal.getName());
        personRepository.findById(person.getId()).map(person2 -> {
                if(basketRepository.findByNameProductAndPerson2(beef.getNameProduct(),person2).isEmpty()){
                    Basket basket = new Basket();
                    basket.setCount(beef.getCount());
                    basket.setNameProduct(beef.getNameProduct());
                    basket.setPrice(beef.getPrice());
                    basket.setPerson2(person2);
                    basket.setSumPrice(beef.getCount()*beef.getPrice());
                    System.out.println("Первый случай");
                    return basketRepository.save(basket);
                }
               else{
                   return basketRepository.findByNameProductAndPerson2(beef.getNameProduct(),person2).map(basket -> {
                       basket.setSumPrice(basket.getSumPrice()+beef.getCount()*beef.getPrice());
                       basket.setCount(basket.getCount()+beef.getCount());
                        return basketRepository.save(basket);
                   });
                }
                });
        return "redirect:/product/"+type;
    }

}
