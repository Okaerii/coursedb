package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.*;
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
public class ClassroomDAOImpl implements ClassroomDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addClassroom(Classroom classroom) {
        getCurrentSession().save(classroom);
    }

    public void updateClassroom(Classroom classroom) {
        getCurrentSession().update(classroom);
    }

    public Classroom getClassroom(String id) {
        Classroom classroom =(Classroom) getCurrentSession().get(Classroom.class,id);
        return classroom;
    }

    public void deleteClassroom(String id) {
        Classroom classroom = getClassroom(id);
        getCurrentSession().delete(classroom);
    }

    public List<Classroom> getAll() {
        Criteria criteria = getCurrentSession().createCriteria(Classroom.class);
        return criteria.list();
    }
}
