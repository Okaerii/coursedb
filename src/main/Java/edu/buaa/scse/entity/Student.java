package edu.buaa.scse.entity;

import org.hibernate.validator.constraints.Range;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wood on 2016/1/11.
 */
@Entity
@Table
public class Student implements Serializable{
    private String id;
    private String name;
    private String gender;
    private long age;
    private Class classid;
    private List<Course> courses =new ArrayList<Course>();
    @Id
    @Column(nullable = false,length = 5,unique = true)
   public String getId(){
       return this.id;
   }
    public  void setId(String id){
        this.id = id;
    }
    @Column(length = 20 ,nullable = false)
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    @Column(length = 1,nullable = false)
    @Pattern(regexp = "[fm]{1}")
    public String getGender() {
        return this.gender;
    }
    public  void  setGender(String gender){
        this.gender = gender;
    }
    @Range(max = 120,min=0)
    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public Class getClassid(){
        return this.classid;
    }
    public void setClassid(Class classid){
        this.classid = classid;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_course",joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id",nullable = false)
            ,inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id",nullable = false))
    public List<Course> getCourses(){
        return this.courses;
    }

    public void setCourses(List<Course> courses){
        this.courses = courses;
    }
}
