package controller.dao;

import controller.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<User> user() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> users= session.createQuery("from User ").list();
        return users;
    }

    public User show(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, email);
        return user;
    }

    public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }

    public void update(String email, User updatedUser) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(updatedUser);
    }
    public void delete(String email) {

        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, email);
        if (null != user) {
            session.delete(user);
        }
    }
}

