package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.User;
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
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addUser(edu.buaa.scse.entity.User user) {
        getCurrentSession().save(user);
    }

    public void updateUser(edu.buaa.scse.entity.User user) {
        getCurrentSession().update(user);
    }

    public User getUser(String id) {
        User user = (User) getCurrentSession().get(User.class,id);
        return user;
    }

    public void deleteUser(String id) {
        User user =getUser(id);
        if(user!=null){
            getCurrentSession().delete(user);
        }
    }

    public List<User> getAll() {
        Criteria criteria = getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }
}
