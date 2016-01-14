package edu.buaa.scse.service;

import edu.buaa.scse.entity.Course;
import edu.buaa.scse.entity.Grade;
import edu.buaa.scse.entity.Student;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{
    public Student getStudentinfo(String id) {
        return new StudentsService().getStudent(id);
    }

    public List<Grade> getStudentGrades(String id) {
        return new GradeService().getStudentGrades(id);
    }

    public List<Course> getStudentChosenCourse(String id) {
        return new CourserService().getStudentChosenCourse(id);
    }

    public List<Course> getStudentUnchosenCourse(String id) {
        return new CourserService().getStudentUnchosenCourse(id);
    }

    public boolean deleteStudentCourse(String studentid, String courseid) {
        return new CourserService().deleteStudentCourse(studentid,courseid);
    }

    public boolean addStudentCourse(String studentid, String courseid) {
        return new CourserService().addStudentCourse(studentid,courseid);
    }
}
