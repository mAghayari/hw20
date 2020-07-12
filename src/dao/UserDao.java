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
        users = session.createQuery("From user", User.class).getResultList();
        transaction.commit();
        session.close();
        return users;
    }

    public User findUser(String userName, String password) {
        User user;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From user u Where u.userName = :userName And u.password= :password");
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        user = (User) query.uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }

    public String checkUserNameRepetition(String desiredUserName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("Select u.userName From user u where u.userName= :userName");
        query.setParameter("userName", desiredUserName);
        String userName = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        return userName;
    }

    public String checkEmailRepetition(String desiredEmail) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("Select u.email From user u where u.email= :desiredEmail");
        query.setParameter("desiredEmail", desiredEmail);
        String email = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        return email;
    }

    public String checkMobileRepetition(String desiredMobile) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("Select u.mobileNumber From user u where u.mobileNumber= :desiredMobile");
        query.setParameter("desiredMobile", desiredMobile);
        String mobile = (String) query.uniqueResult();
        transaction.commit();
        session.close();
        return mobile;
    }
}