package md.zorych.social.controllers;

import md.zorych.social.models.Friendship;
import md.zorych.social.models.User;
import md.zorych.social.models.UserWall;
import md.zorych.social.services.interfaces.FriendsService;
import md.zorych.social.services.interfaces.FriendshipRequestsService;
import md.zorych.social.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;

/**
 * Created by adm on 18.01.2016.
 */
@Controller
//@SessionAttributes("loggeduser")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    FriendsService friendsService;

    @Autowired
    FriendshipRequestsService friendshipRequestsService;

    @RequestMapping(value = "/user/id={id}", method = RequestMethod.GET)
    public ModelAndView userPage(@PathVariable("id") int id, HttpSession session) {
        User user = new User();
        User loggedUser = (User)session.getAttribute("loggeduser");
        UserWall posts = new UserWall();
        if (userService.getUserById(id) !=null) {
           user = userService.getUserById(id);
        }
        else return new ModelAndView("redirect:/index");

        Friendship b= friendsService.getFriendById(loggedUser.getId(), id);
        if (user.getId() == loggedUser.getId()) {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            ModelAndView userModel = new ModelAndView("index");

            userModel.addObject("user", user);
            userModel.addObject("dateBirth", dateFormat.format(user.getDate_birth()));
            userModel.addObject("posts",posts);
            userModel.addObject("loggeduserId", loggedUser.getId());
            return userModel;
        } else if (friendsService.getFriendById(loggedUser.getId(), id) != null) {
            User friend = userService.getUserById(id);
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            ModelAndView userModel = new ModelAndView("index");
            userModel.addObject("user", friend);
            userModel.addObject("posts",posts);
            userModel.addObject("dateBirth", dateFormat.format(friend.getDate_birth()));
            return userModel;
        } else {
            return new ModelAndView("redirect:/friendshiprequest/id="+id);
        }


    }


}