package edu.buaa.scse.controller;

import edu.buaa.scse.entity.Course;
import edu.buaa.scse.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Contended;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */

@Controller
@SessionAttributes("userObj")
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/info")
    public ModelAndView studeninfo(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("student");
        return modelAndView;
    }
    @RequestMapping("/course/chosen")
    public ModelAndView studentCourseChosen(@ModelAttribute("userObj") User u){
        Course course1 = new Course();
        course1.setId("123");
        course1.setName("MVC");
        Course course2 = new Course();
        course2.setId("132");
        course2.setName("DB");
        Course course3 = new Course();
        course3.setId("231");
        course3.setName("ER");
        List<Course> courses = new ArrayList<Course>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("courses",courses);
        modelAndView.setViewName("studentCourseSelected");
        return modelAndView;
    }
    @RequestMapping("/course/grade")
    public ModelAndView studentCoursegrade(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("studentGrade");
        return modelAndView;
    }
    @RequestMapping("/course/unchosen")
    public ModelAndView studentCourseUnchosen(@ModelAttribute("userObj") User u){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("studentCourseUnchosen");
        return modelAndView;
    }
}
