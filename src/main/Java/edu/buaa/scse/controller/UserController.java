package edu.buaa.scse.controller;

import edu.buaa.scse.entity.User;
import edu.buaa.scse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wood on 2016/1/13.
 */
@Controller
@RequestMapping("/welcome")
@SessionAttributes("userObj")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("name") String name,
                        @RequestParam("pwd") String pwd){
        ModelAndView modelAndView = new ModelAndView();
        int power =  userService.loginUser(name,pwd);
        User u = new User();
        u.setPassword(pwd);
        u.setId(name);
        u.setPower(power);
        if(power == -1){
            modelAndView.setViewName( "welcome");
        }
        else{
            modelAndView.addObject("userObj",u);
            if(power == 1){
                modelAndView.setViewName( "student");
            }
            else{
                modelAndView.setViewName( "teacherinfoROOT");
            }
        }
        return  modelAndView;
    }
    @RequestMapping("/toregister")
    public String toregister(){
        return "register";
    }
    @RequestMapping("/register")
    public String register(@RequestParam("name") String name,
                           @RequestParam("pwd") String pwd){
        User u = new User();
        u.setId(name);
        u.setPassword(pwd);
        u.setPower(1);
        userService.regsisterUser(u);
        return "welcome";
    }
    @RequestMapping("/logout")
    public String logout(@ModelAttribute("userObj") User u,SessionStatus sessionStatus)
    {
        if(u!=null)
        sessionStatus.setComplete();
        return "welcome";
    }
}
