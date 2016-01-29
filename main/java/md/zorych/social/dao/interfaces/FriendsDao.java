package md.zorych.social.dao.interfaces;

import md.zorych.social.models.Friendship;
import md.zorych.social.models.User;

/**
 * Created by adm on 19.01.2016.
 */
public interface FriendsDao {
    public Friendship getFriendById(int userId, int friendId);
    public void  setFriendship(User user, User friend);
    public void  deleteFriendship(User user, User friend);


}
