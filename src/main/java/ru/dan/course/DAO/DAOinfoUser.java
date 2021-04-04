package ru.dan.course.DAO;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.dan.course.Models.infoRegistrationUser;

public class DAOinfoUser {
    private static SessionFactory factory;

    public DAOinfoUser (@NotNull final SessionFactory factory) {
        this.factory = factory;
    }


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
