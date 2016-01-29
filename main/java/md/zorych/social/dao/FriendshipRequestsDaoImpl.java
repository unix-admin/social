package md.zorych.social.dao;

import md.zorych.social.models.Friendship;
import md.zorych.social.models.FriendshipRequests;
import md.zorych.social.dao.interfaces.FriendshipRequestsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 20.01.2016.
 */
public class FriendshipRequestsDaoImpl implements FriendshipRequestsDao {
    private SessionFactory sessionFactory;

    public FriendshipRequestsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }
    @Transactional
    public List<FriendshipRequests> getRequests(Integer toUserId) {
        List<FriendshipRequests> requests = new ArrayList<FriendshipRequests>(0);
        requests = (ArrayList<FriendshipRequests>)sessionFactory.getCurrentSession().
                createQuery("from FriendshipRequests where to_user_id=:toUserId").setParameter("toUserId",toUserId).list();
            return requests;
    }
    @Transactional
    public FriendshipRequests getRequestById(Integer id) {
        List<FriendshipRequests> request = new ArrayList<FriendshipRequests>(0);
        request = (ArrayList<FriendshipRequests>)sessionFactory.getCurrentSession().
                createQuery("from FriendshipRequests where id=:id").setParameter("id",id).list();
        return request.get(0);
    }
    @Transactional
    public void addFriendshipRequest(FriendshipRequests request) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.save(request);
    }

    @Transactional
    public void deleteRequest(FriendshipRequests request) {
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.delete(request);
    }
    @Transactional
    public int getRequestsCount(Integer toUserId) {
        List<FriendshipRequests> requests = new ArrayList<FriendshipRequests>(0);
        requests = getRequests(toUserId);
        return requests.size();
    }
}
