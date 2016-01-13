package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.Student;
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
public class StudentDAOImpl implements  StudentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addStudent(Student student) {
        getCurrentSession().save(student);
    }

    public void updateStudent(Student student) {
        getCurrentSession().update(student);
    }

    public Student getStudent(String id) {
        Student student =(Student) getCurrentSession().get(Student.class,id);
        return student;
    }

    public void deleteStudent(String id) {
        Student student = getStudent(id);
        getCurrentSession().delete(student);
    }

    public List<Student> getAll() {
        Criteria criteria = getCurrentSession().createCriteria(Student.class);
        return criteria.list();
    }
}
