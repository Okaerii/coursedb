package edu.buaa.scse.service;

import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.Class;

import java.util.List;

/**
 * Created by wood on 2016/1/14.
 */
public class Test {
    public static void main(String [] args){
       List <edu.buaa.scse.entity.Class> classes = new ClassService().selectall();
        for (Class c:classes){
            System.out.println(c.getId());
            System.out.println(c.getDepartmentid());
            System.out.println(c.getMonitorid());
        }
    }
}
