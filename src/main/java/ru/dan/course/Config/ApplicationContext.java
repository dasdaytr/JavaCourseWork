package ru.dan.course.Config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContext {
    AnnotationConfigApplicationContext context;
    public ApplicationContext(AnnotationConfigApplicationContext context){
        this.context = context;
    }
    public SessionFactory getSesseion(){
        Beanconnectiondatebase ios = context.getBean("beanconnectiondatebase", Beanconnectiondatebase.class);
        return ios.getSessionFactory();
    }
}
