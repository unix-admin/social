package md.zorych.social.services;

import md.zorych.social.dao.interfaces.UserRolesDao;
import md.zorych.social.models.User;
import md.zorych.social.models.UserRoles;
import md.zorych.social.services.interfaces.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by adm on 18.01.2016.
 */
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRolesDao userRolesDao;

    public List<UserRoles> getAllRoles() {
        return null;
    }

    public UserRoles getRoleById(int id) {
        return null;
    }

    public void addRoleToUser(User user) {
        userRolesDao.addRoleToUser(user);
    }

    public void deleteUserRole(int id) {

    }
}
