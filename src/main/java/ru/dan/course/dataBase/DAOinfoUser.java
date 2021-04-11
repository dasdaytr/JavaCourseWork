package ru.dan.course.dataBase;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.dan.course.Config.ApplicationContext;
import ru.dan.course.Config.SpringConfig;
import ru.dan.course.Models.infoRegistrationUser;
@Component
public class DAOinfoUser {
    private static SessionFactory factory;
    final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    ApplicationContext applicationContext;

    public DAOinfoUser (@NotNull final SessionFactory factory) {
        this.factory = factory;
        applicationContext =  new ApplicationContext(context);

    }
    public DAOinfoUser(){}


    public static void create(@NotNull final infoRegistrationUser engine) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(engine);

            session.getTransaction().commit();
        }
    }


    public infoRegistrationUser read(@NotNull final String model) {
        try (final Session session = factory.openSession()) {

            final infoRegistrationUser result = session.get(infoRegistrationUser.class, model);

            return result != null ? result : new infoRegistrationUser();
        }
    }


    public void update(@NotNull final infoRegistrationUser engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(engine);

            session.getTransaction().commit();
        }
    }



    public void delete(@NotNull final infoRegistrationUser engine) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(engine);

            session.getTransaction().commit();
        }
    }
}
