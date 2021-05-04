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
    @GetMapping("/product/beef")
    public String viewPageBeef(Model model){

        model.addAttribute("beefPerson",beefRepository.findAll());
        return "Beef/viewBeef";
    }
    @PostMapping("/product/beef")
    public String viewPageBeefPost(@ModelAttribute Beef beef,Principal principal){
        person2 person = personRepository.findByEmail(principal.getName());

        personRepository.findById(person.getId()).map(person2 -> {
                System.out.println(basketRepository.findByNameProductAndPerson2(beef.getNameProduct(),person2));
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
                       System.out.println(basket);
                       basket.setSumPrice(basket.getSumPrice()+beef.getCount()*beef.getPrice());
                       basket.setCount(basket.getCount()+beef.getCount());
                        return basketRepository.save(basket);
                   });
                }
                });
        return "redirect:/product/beef";
    }

}
