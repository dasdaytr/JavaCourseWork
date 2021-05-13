package ru.dan.course.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dan.course.Models.Product;
import ru.dan.course.Models.person2;
import ru.dan.course.Services.AdminService;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/adminPage")
    public String adminPage(){

        return "Admin/adminPage";
    }






    @GetMapping("adminPage/addProduct")
    public String addAdminProductGet(){
        return "Admin/addProduct";
    }
    @PostMapping("adminPage/addProduct")
    public String addAdminProductPost(@ModelAttribute Product product){
        adminService.addProduct(product);
        return "Admin/addProduct";
    }

    @GetMapping("adminPage/infoPerson")
    public String infoPerson(Model model){
        model.addAttribute("allPerson",adminService.infoPerson());
       return "Admin/info";
    }
    @PostMapping("adminPage/infoPerson")
    public String DeletePerson(@ModelAttribute person2 Person){
        adminService.deletePerson(Person);
        return "redirect:infoPerson";
    }
}
