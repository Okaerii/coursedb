package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.Department;

import java.util.List;

/**
 * Created by wood on 2016/1/12.
 */
public interface DepartmentDAO {
    public void addDepartment(Department department);
    public  void updateDepartment(Department department);
    public Department getDepartment(String id);
    public void deleteDepartment(String id);
    public List<Department> getAll();
}
