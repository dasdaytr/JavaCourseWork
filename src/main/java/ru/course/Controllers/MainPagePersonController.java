package ru.course.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.course.repo.PersonRepository;
import ru.course.Models.person2;

import java.security.Principal;

@Controller
public class MainPagePersonController {
    PersonRepository personRepository;

    @Autowired
    public MainPagePersonController (PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @GetMapping("/mainPaage")
    public String mainPagePerson(Model model, Principal principal) {
        person2 person = personRepository.findByEmail(principal.getName());
        model.addAttribute("info",personRepository.findByEmail(person.getEmail()));
        return "person/mainPage";
    }

}
