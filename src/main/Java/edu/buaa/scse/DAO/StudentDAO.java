package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.Student;

import java.util.List;

/**
 * Created by wood on 2016/1/12.
 */
public interface StudentDAO {
    public void addStudent(Student student);
    public  void updateStudent(Student student);
    public Student getStudent(String id);
    public void deleteStudent(String id);
    public List<Student> getAll();
}
