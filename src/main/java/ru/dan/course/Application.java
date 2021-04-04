package ru.dan.course;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.dan.course.DAO.DAOinfoUser;
import ru.dan.course.Models.infoRegistrationUser;
import org.hibernate.cfg.Configuration;
//@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SessionFactory factory = null;

        try {

            factory = new Configuration().configure().buildSessionFactory();
            DAOinfoUser infoRegistrationUser = new DAOinfoUser(factory);

            final infoRegistrationUser infoRegistrationUser1 = new infoRegistrationUser();
            infoRegistrationUser1.setEmail("ikbo13@mail.ru");
            infoRegistrationUser1.setFirstname("katia");
            infoRegistrationUser1.setLastname("Cheban");
            infoRegistrationUser1.setPassword("123456");
            infoRegistrationUser1.setLogin("hel");
            DAOinfoUser.create(infoRegistrationUser1);

           /* final Engine result = engineDAO.read("engine_model_03");
            System.out.println("Created : " + result);
            System.out.println();

            result.setPower(54321);
            engineDAO.update(result);

            final Engine update = engineDAO.read("engine_model_03");
            System.out.println("Updated : " + update);
            System.out.println();

            engineDAO.delete(new Engine("engine_model_03", 54321));

            System.out.println("Deleted(empty obj) : " + engineDAO.read("engine_model_03"));*/
        } finally {
            if (factory != null) {
                factory.close();
            }
        }

    }
}
