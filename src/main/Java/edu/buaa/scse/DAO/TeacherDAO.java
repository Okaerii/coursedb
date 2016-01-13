package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.Teacher;

import java.util.List;

/**
 * Created by wood on 2016/1/12.
 */
public interface TeacherDAO {
    public void addTeacher(Teacher teacher);
    public  void updateTeacher(Teacher teacher);
    public Teacher getTeacher(String id);
    public void deleteTeacher(String id);
    public List<Teacher> getAll();
}
