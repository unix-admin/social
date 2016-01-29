package md.zorych.social.dao;

import md.zorych.social.dao.interfaces.FriendsDao;
import md.zorych.social.models.Friendship;
import md.zorych.social.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 19.01.2016.
 */
public class FriendsDaoImpl implements FriendsDao{
    private SessionFactory sessionFactory;

    public FriendsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }
    @Transactional
    public Friendship getFriendById(int userId, int friendId) {
        List<Friendship> friend = new ArrayList<Friendship>(0);
         friend = (ArrayList<Friendship>)sessionFactory.getCurrentSession().
                createQuery("from Friendship where user_id=? and friend_id=?").setParameter(0,userId).
                setInteger(1,friendId).list();
        if (friend.size() > 0) {
            return friend.get(0);
        } else {
            return null;
        }

    }
    @Transactional
    public void setFriendship(User user, User friend) {
        Friendship friendship = new Friendship();
        Friendship friendship1 = new Friendship();
        friendship.setUser(user);
        friendship.setFriend(friend);
        Session session = sessionFactory.getCurrentSession();
        session.save(friendship);
        friendship1.setUser(friend);
        friendship1.setFriend(user);
        session.save(friendship1);
    }
    @Transactional
    public void deleteFriendship(User user, User friend) {
        Session session = sessionFactory.getCurrentSession();
        Friendship friendship = getFriendById(user.getId(),friend.getId());
        Friendship friendship1 = getFriendById(friend.getId(),user.getId());
        session.delete(friendship);
        session.delete(friendship1);
    }
}
