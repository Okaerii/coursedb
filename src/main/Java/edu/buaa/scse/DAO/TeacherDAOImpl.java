package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.Teacher;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wood on 2016/1/12.
 */
@Repository
public class TeacherDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addTeacher(Teacher teacher) {
        getCurrentSession().save(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        getCurrentSession().update(teacher);
    }

    public Teacher getTeacher(String id) {
        Teacher teacher =(Teacher) getCurrentSession().get(Teacher.class,id);
        return teacher;
    }

    public void deleteTeacher(String id) {
        Teacher teacher = getTeacher(id);
        getCurrentSession().delete(teacher);
    }

    public List<Teacher> getAll() {
        Criteria criteria = getCurrentSession().createCriteria(Teacher.class);
        return criteria.list();
    }
}
