package edu.buaa.scse.service;

import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.Class;

import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
public interface ManagerService {
    public boolean addClassroom(Classroom classroom);
    public List<Classroom> getClassrooms();
    public void deleteClassroom(String id);
    public boolean addCourse(Course course);
    public List<Course> getCourses();
    public void deleteCourse(String id);
    public boolean addStudent(Student student);
    public void  deleteStudent(String id);
    public List<Student> getStudents();
    public boolean addTeacher(Teacher teacher);
    public void  deleteTeacher(String id);
    public List<Teacher> getTeachers();
    public boolean addTeacherEvaluate(TeacherEvaluate teacherEvaluate);
    public List<TeacherEvaluate> getTeacherEvaluates();
    public void deleteTeacherEvaluate(String id);
    public boolean addClass(edu.buaa.scse.entity.Class _class);
    public List<Class> getClasses();
    public void deleteClass(String id);

    public boolean addDepartment(Department department);
    public List<Department> getDepartments();
    public void deleteDepartment(String id);
    public boolean addGrade(Grade grade);
    public List<Grade> getGrades();
    public void deleteGrade(String id);
}
