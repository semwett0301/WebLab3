package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import wrappers.Result;

public class CreateSessionFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFact() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Result.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                sessionFactory = null;
                System.out.println("Исключение коннекта: " + e);
            }
        }
        return sessionFactory;
    }
}
