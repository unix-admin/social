package md.zorych.social.services;

import md.zorych.social.dao.interfaces.FriendsDao;
import md.zorych.social.models.Friendship;
import md.zorych.social.models.User;
import md.zorych.social.services.interfaces.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by adm on 19.01.2016.
 */
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    FriendsDao friendsDao;

    public Friendship getFriendById(int userId, int friendId) {
        return friendsDao.getFriendById(userId, friendId);
    }

    public void setFriendship(User user, User friend) {
        friendsDao.setFriendship(user, friend);
    }

    public void deleteFriendship(User user, User friend) {
        friendsDao.deleteFriendship(user, friend);
    }
}
