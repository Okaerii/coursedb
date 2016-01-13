package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.TeacherCourse;

import java.util.List;

/**
 * Created by wood on 2016/1/12.
 */
public interface TeacherCourseDAO {
    public void addTeacherCourse(TeacherCourse teacherCourse);
    public  void updateTeacherCourse(TeacherCourse teacherCourse);
    public TeacherCourse getTeacherCourse(Integer id);
    public void deleteTeacherCourse(Integer id);
    public List<TeacherCourse> getAll();
}
