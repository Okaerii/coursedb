package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.TeacherCourse;
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
public class TeacherCourseDAOImpl implements TeacherCourseDAO{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addTeacherCourse(TeacherCourse teacherCourse) {
        getCurrentSession().save(teacherCourse);
    }

    public void updateTeacherCourse(TeacherCourse teacherCourse) {
        getCurrentSession().update(teacherCourse);
    }

    public TeacherCourse getTeacherCourse(Integer id) {
        TeacherCourse teacherCourse =(TeacherCourse) getCurrentSession().get(TeacherCourse.class,id);
        return teacherCourse;
    }

    public void deleteTeacherCourse(Integer id) {
        TeacherCourse teacherCourse = getTeacherCourse(id);
        getCurrentSession().delete(teacherCourse);
    }

    public List<TeacherCourse> getAll() {
        Criteria criteria = getCurrentSession().createCriteria(TeacherCourse.class);
        return criteria.list();
    }
}
