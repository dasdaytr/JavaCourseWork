package ru.dan.course;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.dan.course.Models.infoRegistrationUser;
import ru.dan.course.dataBase.DAOinfoUser;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
       /* SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        DAOinfoUser daOinfoUser = new DAOinfoUser(sessionFactory);
        infoRegistrationUser in = new infoRegistrationUser();
        in.setLogin("assdfsdfsdfd");
        in.setPassword("adasdasdasd");
        in.setLastname("asdasd");
        in.setFirstname("asd");
        in.setEmail("asdasda");
       *//* in.setPasswordReturn("asdasdasd");*//*
        daOinfoUser.create(in);*/
        SpringApplication.run(Application.class,args);


    }
}
