package ru.dan.course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dan.course.Config.ApplicationContext;
import ru.dan.course.Config.SpringConfig;
import ru.dan.course.DAO.DAOinfoUser;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
