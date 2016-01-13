package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.Course;
import edu.buaa.scse.entity.Department;
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
public class DepartmentDAOImpl implements DepartmentDAO{
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    public void addDepartment(Department department) {
        getCurrentSession().save(department);
    }

    public void updateDepartment(Department department) {
        getCurrentSession().update(department);
    }

    public Department getDepartment(String id) {
        Department department =(Department) getCurrentSession().get(Department.class,id);
        return department;
    }

    public void deleteDepartment(String id) {
        Department department = getDepartment(id);
        getCurrentSession().delete(department);
    }

    public List<Department> getAll() {
        Criteria criteria = getCurrentSession().createCriteria(Department.class);
        return criteria.list();
    }
}
