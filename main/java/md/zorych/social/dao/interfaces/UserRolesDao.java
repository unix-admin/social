package md.zorych.social.dao.interfaces;

import md.zorych.social.models.User;
import md.zorych.social.models.UserRoles;

import java.util.List;

/**
 * Created by adm on 18.01.2016.
 */
public interface UserRolesDao {

    public List<UserRoles> getAllRoles();
    public UserRoles getRoleById(int id);
    public void addRoleToUser(User user);
    public void deleteUserRole(int id);
}
