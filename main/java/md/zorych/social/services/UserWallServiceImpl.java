package md.zorych.social.services;

import md.zorych.social.dao.interfaces.UserWallDao;
import md.zorych.social.models.User;
import md.zorych.social.models.UserWall;
import md.zorych.social.services.interfaces.UserWallService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by adm on 19.01.2016.
 */
public class UserWallServiceImpl implements UserWallService {

    @Autowired
    UserWallDao userWallDao;


    public void addMessage(UserWall wall) {
        userWallDao.addMessage(wall);
    }

    public void deleteMessage(UserWall userWall) {
        userWallDao.deleteMessage(userWall);
    }

    public UserWall getWall(int id) {
        return userWallDao.getWall(id);
    }


}
