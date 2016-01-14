package edu.buaa.scse.service;

import edu.buaa.scse.entity.Classroom;
import edu.buaa.scse.entity.Course;

import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
public class CourserService {
    public boolean addCourse(Course course){
        return true;
    }
    public List<Course> getCourse(){
        return null;
    }
    public void deleteCourse(String id){

    }
    public List<Course> getStudentChosenCourse(String id){
        return null;
    }
    public List<Course> getStudentUnchosenCourse(String id){
        return null;
    }

    public boolean deleteStudentCourse(String studentid, String courseid) {
        return false;
    }

    public boolean addStudentCourse(String studentid, String courseid) {
        return false;
    }
}
