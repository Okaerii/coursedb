package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.StudentCourse;

import java.util.List;

/**
 * Created by wood on 2016/1/12.
 */
public interface StudentCourseDAO {
    public void addStudentCourse(StudentCourse studentCourse);
    public  void updateStudentCourse(StudentCourse studentCourse);
    public StudentCourse getStudentCourse(Integer id);
    public void deleteStudentCourse(Integer id);
    public List<StudentCourse> getAll();
}
