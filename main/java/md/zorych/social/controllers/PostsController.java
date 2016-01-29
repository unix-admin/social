package md.zorych.social.controllers;

import md.zorych.social.models.User;
import md.zorych.social.models.UserWall;
import md.zorych.social.services.interfaces.UserWallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by adm on 21.01.2016.
 */
@Controller
public class PostsController {

    @Autowired
    UserWallService userWallService;

    @RequestMapping(value = "/post/new", method = RequestMethod.POST)
    public ModelAndView addPost(@Valid UserWall post, BindingResult bindingResult, @ModelAttribute UserWall posts, HttpSession session){
        if(bindingResult.hasErrors()){
            return new ModelAndView("redirect:/index");
        }
        else {
            User loggedUser = (User) session.getAttribute("loggeduser");
            posts.setUser_id(loggedUser.getId());
            userWallService.addMessage(posts);
            return new ModelAndView("redirect:/index");
        }
    }

    @RequestMapping(value = "/post/delete/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") int id, HttpSession session)
    {
        User loggedUser = (User) session.getAttribute("loggeduser");
        UserWall post = userWallService.getWall(id);
        if (post.getUser_id() == loggedUser.getId())
            userWallService.deleteMessage(post);
        return "redirect:/index";
    }


}
