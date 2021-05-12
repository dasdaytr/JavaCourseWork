package ru.dan.course.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ru.dan.course.Models.Role;
import ru.dan.course.Models.Status;
import ru.dan.course.Models.person2;
import ru.dan.course.Models.test;
import ru.dan.course.repo.PersonRepository;

import java.beans.PersistenceDelegate;

@Service
public class MainService {
    @Autowired

    private PersonRepository personRepository;
    public String infoUser(test infoRegistrationUser, Model model ){

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
