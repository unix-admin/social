package md.zorych.social.controllers;

import md.zorych.social.models.FriendshipRequests;
import md.zorych.social.models.User;
import md.zorych.social.services.interfaces.FriendsService;
import md.zorych.social.services.interfaces.FriendshipRequestsService;
import md.zorych.social.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by adm on 20.01.2016.
 */
@Controller
@SessionAttributes("loggeduser")
public class FrendshipRequestController {
    @Autowired
    UserService userService;
    @Autowired
    FriendshipRequestsService friendshipRequestsService;
    @Autowired
    FriendsService friendsService;

    @RequestMapping(value = "/friendshiprequest/id={id}", method = RequestMethod.GET)
    public ModelAndView friendRequets(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        ModelAndView requestModel = new ModelAndView("request");
        requestModel.addObject("user", user);
        return requestModel;

    }

    @RequestMapping(value = "/friendshiprequest/addrequest/user={id}", method = RequestMethod.GET)
    public ModelAndView addRequets(@PathVariable("id") int id,  HttpSession session) {
        User loggedUser = (User)session.getAttribute("loggeduser");
        FriendshipRequests request = new FriendshipRequests();
        request.setFromUser(loggedUser);
        request.setToUrer(userService.getUserById(id));
        friendshipRequestsService.addFriendshipRequest(request);
        return null;

    }

    @RequestMapping(value = "/friendshiprequest/getrequestcount", method = RequestMethod.GET)
    public ModelAndView getRequestsCount(HttpSession session, SessionStatus status) {
        User loggedUser = (User)session.getAttribute("loggeduser");
        loggedUser.setFriendshipRequestCount(friendshipRequestsService.getRequestsCount(loggedUser.getId()));
        session.removeAttribute("loggeduser");
        User newUser = new User();
        newUser = userService.getUserById(loggedUser.getId());
        session.setAttribute("loggeduser",newUser);
        return null;
    }

    @RequestMapping(value = "/friendshiprequest/accept/request={id}", method = RequestMethod.GET)
    public ModelAndView acceptFriendshipRequest(@PathVariable("id") int id,  HttpSession session){
        FriendshipRequests request = friendshipRequestsService.getRequestById(id);
        friendsService.setFriendship(request.getFromUser(),request.getToUrer());
        friendshipRequestsService.deleteRequest(request);
        return new ModelAndView("redirect:/user/id="+request.getFromUser().getId());
    }

    @RequestMapping(value = "/friendshiprequest/reject/request={id}", method = RequestMethod.GET)
    public ModelAndView rejectFriendshipRequest(@PathVariable("id") int id,  HttpSession session){
        User loggedUser = (User)session.getAttribute("loggeduser");
        friendshipRequestsService.deleteRequest(friendshipRequestsService.getRequestById(id));
        return new ModelAndView("redirect:/index");
    }

}
