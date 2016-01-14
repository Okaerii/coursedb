package edu.buaa.scse.controller;

import edu.buaa.scse.entity.Course;
import edu.buaa.scse.entity.Grade;
import edu.buaa.scse.entity.Student;
import edu.buaa.scse.entity.User;
import edu.buaa.scse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private StudentService studentService;
    @RequestMapping("/info")
    public ModelAndView studeninfo(@ModelAttribute("userObj") User u){
        String id = u.getId();
        Student student = studentService.getStudentinfo(id);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("student",student);
        modelAndView.setViewName("student");

        return modelAndView;
    }
    @RequestMapping("/course/chosen")
    public ModelAndView studentCourseChosen(@ModelAttribute("userObj") User u){
        String id = u.getId();
        List<Course> courses = studentService.getStudentChosenCourse(id);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("courses",courses);
        modelAndView.setViewName("studentCourseSelected");
        return modelAndView;
    }
    @RequestMapping("/course/chosen/delete/{id}")
    public ModelAndView studentCourseChosenDelete(@ModelAttribute("userObj") User u,@PathVariable("id") String id){
        String uid = u.getId();
        studentService.deleteStudentCourse(uid, id);
        List<Course> courses = studentService.getStudentChosenCourse(id);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("courses",courses);
        modelAndView.setViewName("studentCourseSelected");
        return modelAndView;
    }

    @RequestMapping("/course/grade")
    public ModelAndView studentCoursegrade(@ModelAttribute("userObj") User u){
        String id = u.getId();
        List<Grade> grades = studentService.getStudentGrades(id);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("studentGrade");
        modelAndView.addObject("grades", grades);
        return modelAndView;
    }
    @RequestMapping("/course/unchosen")
    public ModelAndView studentCourseUnchosen(@ModelAttribute("userObj") User u){
        String id = u.getId();
        List<Course> courses = studentService.getStudentChosenCourse(id);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("courses", courses);
        modelAndView.setViewName("studentCourseUnchosen");
        return modelAndView;
    }

    @RequestMapping("/course/unchosen/add/{id}")
    public ModelAndView studentCourseUnchosenAdd(@ModelAttribute("userObj") User u,@PathVariable("id") String id){
        String uid = u.getId();
        studentService.addStudentCourse(uid,id);
        List<Course> courses = studentService.getStudentChosenCourse(id);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("courses",courses);
        modelAndView.setViewName("studentCourseUnchosen");
        return modelAndView;
    }
}
