package edu.buaa.scse.controller;

import edu.buaa.scse.entity.User;
import edu.buaa.scse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
* Created by wood on 2016/1/11.
        */
@Controller
public class MainController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/")
    public String welcome()
    {
        return "welcome";

    }



}
