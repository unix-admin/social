package md.zorych.social.services;

import md.zorych.social.dao.interfaces.UserDAO;
import md.zorych.social.models.User;
import md.zorych.social.models.UserRoles;
import md.zorych.social.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

/**
 * Created by adm on 17.01.2016.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;


    public HashSet<User> searchUser(String request) {

        return userDAO.searchUser(request);
    }

    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    public void updateUser(int userId, User user){

    }

    public void deleteUser(User user){

    }


    public User getUserByUsername(String username){

     return userDAO.getUserByUsername(username);
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public List<UserRoles> getUserRoles(String username) {

        return null;
    }



}
