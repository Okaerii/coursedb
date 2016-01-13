package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.Class;
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
public class ClassDAOImpl implements ClassDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addClass(edu.buaa.scse.entity.Class _class) {
        getCurrentSession().save(_class);
    }

    public void updateClass(Class _class) {
        getCurrentSession().update(_class);
    }

    public Class getClass(String id) {
        Class _class = (Class) getCurrentSession().get(Class.class,id);
        return _class;
    }

    public void deleteClass(String id) {
        Class _class =getClass(id);
        if(_class!=null){
            getCurrentSession().delete(_class);
        }
    }

    public List<Class> getAll() {
        Criteria criteria = getCurrentSession().createCriteria(Class.class);
        return criteria.list();
    }

}
