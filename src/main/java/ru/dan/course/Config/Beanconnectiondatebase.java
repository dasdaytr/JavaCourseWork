package ru.dan.course.Config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Beanconnectiondatebase {
    private SessionFactory sessionFactory = null;
    public Beanconnectiondatebase(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public SessionFactory getSessionFactory() {
            return sessionFactory;
    }
}
