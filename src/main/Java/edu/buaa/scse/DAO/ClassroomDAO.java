package edu.buaa.scse.DAO;

import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.Class;

import java.util.List;

/**
 * Created by wood on 2016/1/12.
 */
public interface ClassroomDAO {
    public void addClassroom(Classroom classroom);
    public  void updateClassroom(Classroom classroom);
    public Classroom getClassroom(String id);
    public void deleteClassroom(String id);
    public List<Classroom> getAll();
}
