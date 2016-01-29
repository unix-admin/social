package md.zorych.social.services;


import md.zorych.social.dao.UserDAOImpl;
import md.zorych.social.dao.interfaces.UserDAO;
import md.zorych.social.models.UserRoles;
import md.zorych.social.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adm on 17.01.2016.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        md.zorych.social.models.User user = userService.getUserByUsername(username);
        if (user ==null)
        {
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), true,true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(md.zorych.social.models.User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserRoles userRoles : user.getUserRole()){
            authorities.add(new SimpleGrantedAuthority(userRoles.getRole()));
        }
        return authorities;
    }



}
