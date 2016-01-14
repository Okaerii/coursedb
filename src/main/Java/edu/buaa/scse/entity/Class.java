package edu.buaa.scse.entity;

import javax.persistence.*;

/**
 * Created by wood on 2016/1/11.
 */
@Entity
@Table
public class Class {
    private String id;
    private Department departmentid;
   private String  monitorid;
    @Id
    @Column(nullable = false,unique = true)
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id= id;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public Department getDepartmentid(){
        return this.departmentid;
    }
    public void  setDepartmentid(Department departmentid){
        this.departmentid = departmentid;
    }

    @Column(nullable = true)
    public String getMonitorid(){
        return monitorid;
    }

    public void setMonitorid(String  monitorid){
        this.monitorid= monitorid;
    }

    public static void forName(String s) {

    }
}
