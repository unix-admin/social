package md.zorych.social.dao.interfaces;

import md.zorych.social.models.UserWall;

/**
 * Created by adm on 19.01.2016.
 */
public interface UserWallDao {

    public void addMessage(UserWall wall);
    public void deleteMessage(UserWall wall);
    public UserWall getWall(int id);

}
