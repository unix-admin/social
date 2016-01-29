package md.zorych.social.dao;

import md.zorych.social.dao.interfaces.UserDAO;
import md.zorych.social.models.User;
import md.zorych.social.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


/**
 * Created by adm on 16.01.2016.
 */
public class UserDAOImpl implements UserDAO {
 private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }


    @Transactional
    public HashSet<User> searchUser(String request) {
        List<User> user = new ArrayList<User>();
        user = (List<User>)sessionFactory.getCurrentSession().
                createQuery("from User where username like :request or name like :request or surname like :request")
                .setParameter("request","%"+request+"%").list();

        HashSet<User> result = new HashSet<User>(user);

        return result;
    }

    public List<User> getUserFriends(int id) {
        List<User> user = new ArrayList<User>();
        user = (List<User>)sessionFactory.getCurrentSession().
                createQuery("from User where id=?").setParameter(0,id).list();

        return user;
    }

    @Transactional
    public User getUserById(int id) {
        List<User> user = new ArrayList<User>();
        user = (List<User>)sessionFactory.getCurrentSession().
                createQuery("from User where id=?").setParameter(0,id).list();

        if (user.size() > 0) {
            return user.get(0);
        } else {
            return null;
        }

    }
    @Transactional
    public User getUserByUsername(String username) {
        List<User> user = new ArrayList<User>(0);
        user = (ArrayList<User>)sessionFactory.getCurrentSession().
                createQuery("FROM User WHERE username=?").setParameter(0,username).list();

        if (user.size() > 0) {
            return user.get(0);
        } else {
            return null;
        }
    }

    @Transactional
    public void saveUser(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.save(user);
    }


}
