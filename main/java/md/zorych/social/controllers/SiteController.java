package md.zorych.social.controllers;

import md.zorych.social.models.User;
import md.zorych.social.services.interfaces.UserPhotosService;
import md.zorych.social.services.interfaces.UserRoleService;
import md.zorych.social.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;

/**
 * Created by adm on 16.01.2016.
 */
@Controller
@SessionAttributes("loggeduser")
public class SiteController {


    @Autowired
    UserService userService;

    @Autowired
    UserRoleService roleService;

    @Autowired
    ServletContext context;

    @Autowired
    UserPhotosService userPhotosService;
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String start(HttpSession session)
    {
        User user = new User();
        user =userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        session.setAttribute("loggeduser", user);
        return "redirect:user/id="+ user.getId();
    }

    @RequestMapping("/myphoto")
    public ModelAndView viewPhoto(HttpSession session) {
        ModelAndView photos = new ModelAndView("photos");
        User user = (User)session.getAttribute("loggeduser");
        photos.addObject("user",user);
        return photos;
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
    public ModelAndView registartionPage()
    {
        User user = new User();
        return new ModelAndView("registration","user",user);
    }

    @RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
    public String registrationPage(@Valid User userModel, BindingResult bindingResult, @ModelAttribute User user)
    {
        if(bindingResult.hasErrors()){
            return "redirect:/registration";
        }
        else {
            user.setAvatar("empty_avatar.jpg");
            userService.saveUser(user);
            roleService.addRoleToUser(user);
            return "redirect:index";
        }
    }


    @RequestMapping(value = { "/search" }, method = RequestMethod.GET)
    public ModelAndView searchPage()
    {
        User user = new User();
        HashSet<User> users = new HashSet<User>(0);
        ModelAndView searchModel = new ModelAndView("search");
        searchModel.addObject("user",user);
        searchModel.addObject("users",users);
        return searchModel;
    }

    @RequestMapping(value = { "/search" }, method = RequestMethod.POST)
    public ModelAndView searchPage(@ModelAttribute User user)
    {
        HashSet<User> users = userService.searchUser(user.getUsername());
        ModelAndView searchModel = new ModelAndView("search");

        searchModel.addObject("user",user);
        searchModel.addObject("users",users);
        return searchModel;
    }


    @RequestMapping("/logout")
    public String logout() {

        return "redirect:j_spring_security_logout";
    }

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody
    String provideUploadInfo() {
        return "redirect:/index";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file, HttpSession session){
        User user = (User)session.getAttribute("loggeduser");
        String path = context.getRealPath("WEB-INF/photo/"+user.getId()+"/");
        File dir = new File(path);
        if (!dir.exists())
        {
            dir.mkdir();
        }
        String name = path+file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                userPhotosService.addPhoto("/photo/"+user.getId()+"/"+file.getOriginalFilename(),user.getId());
                return "redirect:/";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }


}
