package ru.course.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.course.Models.Product;
import ru.course.Models.PublishingHouse;
import ru.course.Services.ProductService;
import ru.course.repo.ProductRepository;
import ru.course.repo.PublishingRepository;


import java.security.Principal;

@Controller
public class PageProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private PublishingRepository publishingRepository;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping(value = "/books/publishing",produces = "text/html; charset=utf-8")
    public String viewPageBeef(Model model,@RequestParam("id") int id){
        PublishingHouse p =publishingRepository.findById(id);
        model.addAttribute("beefPerson",productRepository.findByPublishingHouse(p));
        model.addAttribute("url","/books/publishing?id="+id);
        model.addAttribute("type",p.getTitlePublishing());
        return "Beef/viewBeef";
    }

    @RequestMapping(value = "/books/publishing", method = RequestMethod.POST,
            produces = "text/html; charset=utf-8")
    public RedirectView viewPageBeefPost(@ModelAttribute Product product, Principal principal, @RequestParam("id") int id){
        System.out.println(product.toString());
        productService.viewPageProductPost(product, principal);

        return new RedirectView("/books/publishing?id="+id);
    }

}
