package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.Class;

import java.util.List;

/**
 * Created by wood on 2016/1/12.
 */
public interface ClassDAO {
    public void addClass(edu.buaa.scse.entity.Class _class);
    public  void updateClass(Class _class);
    public Class getClass(String id);
    public void deleteClass(String id);
    public List<Class> getAll();

}
