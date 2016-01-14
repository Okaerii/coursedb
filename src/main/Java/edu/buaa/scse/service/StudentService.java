package edu.buaa.scse.service;

import edu.buaa.scse.entity.Course;
import edu.buaa.scse.entity.Grade;
import edu.buaa.scse.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
public interface StudentService  {
    public Student getStudentinfo(String id);

    public List<Grade>  getStudentGrades(String id);
    public List<Course> getStudentChosenCourse(String id);
    public List<Course> getStudentUnchosenCourse(String id);

    public boolean deleteStudentCourse(String studentid,String courseid);
    public boolean addStudentCourse(String studentid,String courseid);
}
