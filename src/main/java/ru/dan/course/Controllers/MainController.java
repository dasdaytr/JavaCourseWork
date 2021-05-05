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

import ru.dan.course.Models.Role;
import ru.dan.course.Models.Status;
import ru.dan.course.Models.person2;
import ru.dan.course.Models.test;
import ru.dan.course.repo.PersonRepository;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    public MainController(PersonRepository personRepository){
        this.personRepository = personRepository;

    }
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
        if (personRepository.findByEmail(infoRegistrationUser.getEmail()) == null ){
            if (infoRegistrationUser.getPassword().equals(infoRegistrationUser.getPasswordReturn())){
                savePerson(infoRegistrationUser);
                return "redirect:/mainPaage";
            }
            else{
                model.addAttribute("error","Пароли не совпадают");
                return "sing_in";
            }
        }
        else{
            model.addAttribute("errorEmail","Такой email уже существует");
            return "sing_in";
        }
    }
    @GetMapping("/singUp")
    public String singUp(Model model,@ModelAttribute person2 Person){
        return "sing_up";
    }
   @PostMapping("/singUp")
   public String singUpPost(@ModelAttribute person2 person2){
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
        personRepository.save(person3);
    }
}

