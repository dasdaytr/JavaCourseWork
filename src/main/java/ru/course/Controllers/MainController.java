package ru.course.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ru.course.Models.person2;
import ru.course.Models.test;
import ru.course.Services.MainService;


import javax.validation.Valid;

@Controller
public class MainController {
   @Autowired
   private MainService mainService;
    @GetMapping("/")
    public String mainPage() {
        return "sing_Up";
    }

    @GetMapping("/sing_in")
    public String singIn(@ModelAttribute("infoRegistrationUser") test person) {
        return "sing_in";
    }

    @PostMapping("/sing_in")
    public String signInInfo(@ModelAttribute("infoRegistrationUser") @Valid test infoRegistrationUser , BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()){
            return "sing_in";
        }
       return mainService.infoUser(infoRegistrationUser,model);
    }
    @GetMapping("/singUp")
    public String singUp(Model model,@ModelAttribute person2 Person){
        return "sing_up";
    }
   @PostMapping("/singUp")
   public String singUpPost(@ModelAttribute person2 person2){
        return "redirect:/mainPaage";
   }

}

