package edu.buaa.scse.entity;

import org.hibernate.validator.constraints.Range;

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
public class Teacher implements Serializable {
    private String id;
    private String name;
    private String gender;
    private long age;
    private String title;
    private String phonenum;
    private List<Course> courses =new ArrayList<Course>();


    @Id
    @Column(nullable = false,unique = true)
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    @Pattern(regexp = "[fm]{1}")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    @Range(max = 120,min=0)
    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column
    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_course",joinColumns = @JoinColumn(name = "teacher_id",referencedColumnName = "id",nullable = false)
            ,inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id",nullable = false))
    public List<Course> getCourses(){
        return this.courses;
    }

    public void setCourses(List<Course> courses){
        this.courses = courses;
    }

}
