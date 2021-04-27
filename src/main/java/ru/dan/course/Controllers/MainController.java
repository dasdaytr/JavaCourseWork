package ru.dan.course.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.dan.course.Config.WebSecurityConfig;
import ru.dan.course.Models.Role;
import ru.dan.course.Models.Status;
import ru.dan.course.Models.person2;
import ru.dan.course.Models.test;
import ru.dan.course.repo.PersonRepository;
import ru.dan.course.repo.PostBasketRepository;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    PersonRepository personRepository;

    public MainController(PersonRepository personRepository){
        this.personRepository = personRepository;

    }

    @GetMapping("/mainPage/{id}")
    public String mainPagePerson(Model model, @PathVariable("id") int id) {
        return "person/mainPage";
    }
    @GetMapping("/")
    public String mainPage() {
        return "home";
    }

    @GetMapping("/sing_in")
    public String singIn(@ModelAttribute("infoRegistrationUser") test person) {
        return "sing_in";
    }

    @PostMapping("/sing_in")
    public String signInInfo(@ModelAttribute("infoRegistrationUser") @Valid test infoRegistrationUser , BindingResult bindingResult,Model model) {
        if(personRepository.findByEmail(infoRegistrationUser.getEmail()) == null &&
           infoRegistrationUser.getPassword().equals(infoRegistrationUser.getPasswordReturn()) ){
            if(bindingResult.hasErrors()){
                return "sing_in";
            }
        }
        else
            return "sing_in";
        savePerson(infoRegistrationUser);
        return "redirect:/mainPaage";
    }
    @GetMapping("/singUp")
    public String singUp(Model model,@ModelAttribute person2 Person){
        return "sing_up";
    }
   @PostMapping("/singUp")
   public String singUpPost(@ModelAttribute person2 person2){
        System.out.println(personRepository.findByEmail(person2.getEmail()).getId());
        return "redirect:/mainPaage";
   }
    private void savePerson(test person){
        person2 person3 = new person2();
        person3.setEmail(person.getEmail());
        person3.setLogin(person.getLogin());
        person3.setFirstname(person.getFirstname());
        person3.setLastname(person.getLastname());
        person3.setRole(Role.USER);
        person3.setStatus(Status.ACTIVE);
        person3.setPassword(new BCryptPasswordEncoder().encode(person.getPassword()));
        System.out.println(person3);
        personRepository.save(person3);
    }
}

