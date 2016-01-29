package md.zorych.social.services;

import md.zorych.social.dao.interfaces.FriendshipRequestsDao;
import md.zorych.social.models.FriendshipRequests;
import md.zorych.social.services.interfaces.FriendshipRequestsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by adm on 20.01.2016.
 */
public class FriendshipRequestServiceImpl implements FriendshipRequestsService {

    @Autowired
    FriendshipRequestsDao friendshipRequestsDao;

    public List<FriendshipRequests> getRequests(Integer toUserId) {
        return friendshipRequestsDao.getRequests(toUserId);
    }

    public FriendshipRequests getRequestById(Integer id) {
        return friendshipRequestsDao.getRequestById(id);
    }

    public void addFriendshipRequest(FriendshipRequests request) {
        friendshipRequestsDao.addFriendshipRequest(request);
    }

    public void deleteRequest(FriendshipRequests request) {
        friendshipRequestsDao.deleteRequest(request);
    }

    public int getRequestsCount(Integer toUserId) {
        return friendshipRequestsDao.getRequestsCount(toUserId);
    }
}
