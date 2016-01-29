package md.zorych.social.dao.interfaces;

import md.zorych.social.models.FriendshipRequests;

import java.util.List;

/**
 * Created by adm on 20.01.2016.
 */
public interface FriendshipRequestsDao {

    public List<FriendshipRequests> getRequests(Integer toUserId);
    public FriendshipRequests getRequestById(Integer id);
    public void addFriendshipRequest(FriendshipRequests request);
    public void deleteRequest(FriendshipRequests request);
    public int getRequestsCount(Integer toUserId);
}
