package md.zorych.social.services.interfaces;

import md.zorych.social.models.User;
import md.zorych.social.models.UserRoles;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

/**
 * Created by adm on 16.01.2016.
 */
public interface UserService {
    public HashSet<User> searchUser (String request);
    public void saveUser(User user);
    public void updateUser(int userId, User user);
    public void deleteUser(User user);
    public User getUserByUsername(String username);
    public User getUserById(int id);
    public List<UserRoles> getUserRoles(String username);
}
