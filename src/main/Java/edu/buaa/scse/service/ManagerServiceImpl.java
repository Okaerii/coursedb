package edu.buaa.scse.service;

import edu.buaa.scse.DAO.ClassroomDAO;
import edu.buaa.scse.DAO.CourseDAO;
import edu.buaa.scse.DAO.StudentDAO;
import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
@Service("managerService")
public class ManagerServiceImpl implements  ManagerService {

    @Autowired
    private ClassroomDAO classroomDAO;
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private StudentDAO studentDAO;
//    student
    public boolean addStudent(Student student){
     return    new StudentsService().addStudent(student);
    }

    public List<Student> getStudents(){
        return new StudentsService().getStudents();
    }

    public void deleteStudent(String id){
        new StudentsService().deleteStudent(id);
    }

//    教室
    public boolean addClassroom(Classroom classroom) {
       new ClassroomService().insert(classroom.getId(),classroom.getLocation(),classroom.getSize());
        return true;
    }
    public List<Classroom> getClassrooms(){
        return new ClassroomService().selectall();
    }

    public void deleteClassroom(String id){
        new ClassroomService().delete(id);
    }
//课程
    public  boolean addCourse(Course course){
        return new CourserService().addCourse(course);
    }
    public List<Course> getCourses(){
        return new CourserService().getCourse();
    }
    public void deleteCourse(String id){
        new CourserService().deleteCourse(id);
    }
//教师信息
    public boolean addTeacher(Teacher teacher){
        return new TeacherService().addTeacher(teacher);
    }
    public void  deleteTeacher(String id){
        new TeacherService().deleteTeacher(id);
    }
    public List<Teacher> getTeachers(){
        return new TeacherService().getTeachers();
    }

    public boolean addTeacherEvaluate(TeacherEvaluate teacherEvaluate) {
        return new TeacherEvaluateService().addTeacherEvaluate(teacherEvaluate);
    }

    public List<TeacherEvaluate> getTeacherEvaluates() {
        return new TeacherEvaluateService().getTeacherEvaluates();
    }

    public void deleteTeacherEvaluate(String id) {
        new TeacherEvaluateService().deleteTeacherEvaluate(id);
    }

    public boolean addClass(Class _class) {
        return new ClassService().addClass(_class);
    }

    public List<Class> getClasses() {
        return new ClassService().getClasses();
    }

    public void deleteClass(String id) {
        new ClassService().deleteClass(id);
    }

    public boolean addDepartment(Department department) {
        return new DepartmentService().addDepartment(department);
    }

    public List<Department> getDepartments() {
        return new DepartmentService().getDepartments();
    }

    public void deleteDepartment(String id) {
        new DepartmentService().deleteDepartment(id);
    }

    public boolean addGrade(Grade grade) {
        return new GradeService().addGrade(grade);
    }

    public List<Grade> getGrades() {
        return new GradeService().getGrades();
    }

    public void deleteGrade(String id) {
        new GradeService().deleteGrade(id);
    }

}
