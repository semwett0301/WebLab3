package beans;

import org.hibernate.*;
import org.hibernate.query.Query;
import utils.CreateSessionFactory;

import org.hibernate.Transaction;
import wrappers.Result;

import java.io.Serializable;
import java.util.*;

public class DataManagerBean implements Serializable {

    public void addNewValue(Result result) {
        SessionFactory sessionFactory = CreateSessionFactory.getSessionFact();
        Session session = sessionFactory.openSession();
        session.save(result);
        session.close();
    }

    public void clearTable(String sessionID) {
        SessionFactory sessionFactory = CreateSessionFactory.getSessionFact();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createNativeQuery("DELETE FROM Results WHERE sessionid = :s_id");
        query.setParameter("s_id", sessionID);

        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public List<Result> synchronize(String sessionID) {
        SessionFactory sessionFactory = CreateSessionFactory.getSessionFact();
        Session session = sessionFactory.openSession();
        Query<Result> query = session.createQuery("FROM Result WHERE sessionid =: sessionid");
        query.setParameter("sessionid", sessionID);
        List<Result> list = query.list();
        return list;
    }
}
