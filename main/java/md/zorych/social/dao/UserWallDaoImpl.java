package md.zorych.social.dao;

import md.zorych.social.dao.interfaces.UserWallDao;
import md.zorych.social.models.User;
import md.zorych.social.models.UserWall;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 19.01.2016.
 */
public class UserWallDaoImpl implements UserWallDao {

    private SessionFactory sessionFactory;

    public UserWallDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Transactional
    public void addMessage(UserWall wall) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.save(wall);
    }
    @Transactional
    public void deleteMessage(UserWall wall) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.delete(wall);
    }
    @Transactional
    public UserWall getWall(int id) {
        List<UserWall> post = new ArrayList<UserWall>(0);
        post = (List<UserWall>) sessionFactory.getCurrentSession().
                createQuery("from UserWall where id=?").setParameter(0, id).list();

        if (post.size() > 0) {
            return post.get(0);
        } else {
            return null;
        }
    }

}
