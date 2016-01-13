package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.User;

import java.util.List;

/**
 * Created by wood on 2016/1/12.
 */
public interface UserDAO {
    public void addUser(edu.buaa.scse.entity.User user);
    public  void updateUser(edu.buaa.scse.entity.User user);
    public User getUser(String id);
    public void deleteUser(String id);
    public List<User> getAll();
}
