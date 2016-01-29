package md.zorych.social.dao;

import md.zorych.social.dao.interfaces.UserRolesDao;
import md.zorych.social.models.User;
import md.zorych.social.models.UserRoles;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by adm on 18.01.2016.
 */
public class UserRolesDaoImpl implements UserRolesDao {
    private SessionFactory sessionFactory;

    public UserRolesDaoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    public List<UserRoles> getAllRoles() {
        return null;
    }

    @Transactional
    public UserRoles getRoleById(int id) {
        return null;
    }

    @Transactional
    public void addRoleToUser(User user) {
        sessionFactory.openSession();
        UserRoles role = new UserRoles();
        role.setUser(user);
        role.setRole("ROLE_USER");
        sessionFactory.getCurrentSession().save(role);
    }

    @Transactional
    public void deleteUserRole(int id) {

    }
}
