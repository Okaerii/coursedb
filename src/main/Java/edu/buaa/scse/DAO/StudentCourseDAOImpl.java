package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.StudentCourse;
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
public class StudentCourseDAOImpl implements  StudentCourseDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addStudentCourse(StudentCourse studentCourse) {
        getCurrentSession().save(studentCourse);
    }

    public void updateStudentCourse(StudentCourse studentCourse) {
        getCurrentSession().update(studentCourse);
    }

    public StudentCourse getStudentCourse(Integer id) {
        StudentCourse studentCourse =(StudentCourse) getCurrentSession().get(StudentCourse.class,id);
        return studentCourse;
    }

    public void deleteStudentCourse(Integer id) {
        StudentCourse studentCourse = getStudentCourse(id);
        getCurrentSession().delete(studentCourse);
    }

    public List<StudentCourse> getAll() {
        Criteria criteria = getCurrentSession().createCriteria(StudentCourse.class);
        return criteria.list();
    }
}
