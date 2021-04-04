package ru.dan.course.Controllers;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.dan.course.Config.ApplicationContext;
import ru.dan.course.Config.SpringConfig;

@Controller
public class MainController {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    @GetMapping
    public String mainPage(){
        ApplicationContext applicationContext = new ApplicationContext(context);
        applicationContext.getSesseion().close();
        return "";
    }
}
