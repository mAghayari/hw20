package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {
    SessionFactory sessionFactory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();

    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public List<User> getAllUsers() {
        List<User> users;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        users = session.createQuery("From User", User.class).getResultList();
        transaction.commit();
        session.close();
        return users;
    }

    public User findUser(String userName, String password) {
        User user;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From User u Where u.userName = :userName And u.password= :password", User.class);
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        user = (User) query.uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }
}