package edu.buaa.scse.service;

import edu.buaa.scse.entity.User;

/**
 * Created by wood on 2016/1/12.
 */
public interface UserService {
    public int loginUser(String id,String password);
    public boolean regsisterUser(User u);
}
