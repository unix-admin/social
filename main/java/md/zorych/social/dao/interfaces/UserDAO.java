package md.zorych.social.dao.interfaces;

import md.zorych.social.models.User;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

/**
 * Created by adm on 16.01.2016.
 */
public interface UserDAO {

        public HashSet<User> searchUser (String request);
        public List<User> getUserFriends(int id);
        public User getUserById(int id);
        public User getUserByUsername(String username);
        public void saveUser(User user);


}
