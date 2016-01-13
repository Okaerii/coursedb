package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.Classroom;
import edu.buaa.scse.entity.Course;

import java.util.List;

/**
 * Created by wood on 2016/1/12.
 */
public interface CourseDAO {
    public void addCourse(Course course);
    public  void updateCourse(Course course);
    public Course getCourse(String id);
    public void deleteCourse(String id);
    public List<Course> getAll();


}
