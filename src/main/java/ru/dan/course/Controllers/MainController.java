package ru.dan.course.Controllers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dan.course.Config.ApplicationContext;
import ru.dan.course.Config.SpringConfig;
import ru.dan.course.Models.infoRegistrationUser;
import ru.dan.course.dataBase.DAOinfoUser;

@Controller
public class MainController {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private DAOinfoUser daOinfoUser;
    ApplicationContext applicationContext;


    public MainController() {
        applicationContext = new ApplicationContext(context);

        daOinfoUser = new DAOinfoUser(applicationContext.getSesseion());
    }

    @GetMapping("/mainPage/{login}")
    public String mainPagePerson(Model model, @PathVariable("login") String login) {
        model.addAttribute("info",daOinfoUser.read(login));
        return "person/mainPage";
    }
    @GetMapping("/")
    public String mainPage() {
        return "home";
    }

    @GetMapping("/sing_in")
    public String singIn(Model model) {
        model.addAttribute("error", "");
        model.addAttribute("errorEmail", "");
        model.addAttribute("errorPassword", "");
        model.addAttribute("errorAll", "");
        return "sing_in";
    }

    @PostMapping("/sing_in")
    public String signInInfo(@ModelAttribute infoRegistrationUser infoRegistrationUser, Model model) {
        if (daOinfoUser.read(infoRegistrationUser.getLogin()).getLogin() != null) {
            model.addAttribute("error", "Такой логин уже существует");
            return "sing_in";
        }
        if (daOinfoUser.read(infoRegistrationUser.getEmail()).getEmail() != null) {
            model.addAttribute("errorEmail", "Под такой почта уже зарегистрированы");
            return "sing_in";
        }
        if (!infoRegistrationUser.getPassword().equals(infoRegistrationUser.getPasswordReturn())) {
            model.addAttribute("errorPassword", "Пароли не совпадают");
            return "sing_in";
        }
        if (infoRegistrationUser.checkClass(infoRegistrationUser) == null) {
            model.addAttribute("errorAll", "Есть не заполненное поле");
            return "sing_in";
        }
        daOinfoUser.create(infoRegistrationUser);
        return "redirect:/mainPage/" +infoRegistrationUser.getLogin();
    }
    @GetMapping("/singUp")
    public String singUp(Model model){
        model.addAttribute("error","");
        return "sing_up";
    }
    @PostMapping("/sing_up")
    public String singUpPost(@ModelAttribute infoRegistrationUser infoRegistrationUser,Model model){
        if(daOinfoUser.read(infoRegistrationUser.getLogin()).getLogin() == null){
            model.addAttribute("error","Неправильный пароль или логин");
            return "sing_up";
        }
        else{
            if(!daOinfoUser.read(infoRegistrationUser.getLogin()).getPassword().equals(infoRegistrationUser.getPassword())){
                model.addAttribute("error","Неправильный пароль или логин");
                return "sing_up";
            }
        }
        return "redirect:/mainPage/" +infoRegistrationUser.getLogin();
    }

}

