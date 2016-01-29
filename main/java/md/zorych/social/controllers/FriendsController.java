package md.zorych.social.controllers;

import md.zorych.social.models.User;
import md.zorych.social.services.interfaces.FriendsService;
import md.zorych.social.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by adm on 19.01.2016.
 */
@Controller
@SessionAttributes("loggeduser")
public class FriendsController {

    @Autowired
    UserService userService;
    @Autowired
    FriendsService friendsService;

    @RequestMapping(value="/friends/user={id}", method= RequestMethod.GET)
    public ModelAndView displayFriends(@PathVariable("id")int id,  HttpSession session){
        User loggedUser = (User)session.getAttribute("loggeduser");
        User user = userService.getUserById(loggedUser.getId());
        ModelAndView userModel = new ModelAndView("friends");
        userModel.addObject("friends", user);
        return userModel;
    }

    @RequestMapping(value="/friends/delete/user={id}", method= RequestMethod.GET)
    public ModelAndView editContent(@PathVariable("id")int id,  HttpSession session){
        User loggedUser = (User)session.getAttribute("loggeduser");
        friendsService.deleteFriendship(loggedUser,userService.getUserById(id));
        return new ModelAndView("redirect:/index");
    }

}
