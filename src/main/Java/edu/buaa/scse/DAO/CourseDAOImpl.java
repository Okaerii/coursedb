package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.Classroom;
import edu.buaa.scse.entity.Course;
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
public class CourseDAOImpl implements CourseDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addCourse(Course course) {
        getCurrentSession().save(course);
    }

    public void updateCourse(Course course) {
        getCurrentSession().update(course);
    }

    public Course getCourse(String id) {
        Course course =(Course) getCurrentSession().get(Course.class,id);
        return course;
    }

    public void deleteCourse(String id) {
        Course course = getCourse(id);
        getCurrentSession().delete(course);
    }

    public List<Course> getAll() {
        Criteria criteria = getCurrentSession().createCriteria(Course.class);
        return criteria.list();
    }
}
