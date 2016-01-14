package edu.buaa.scse.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wood on 2016/1/11.
 */
@Entity
@Table
public class Course implements Serializable{
    private String id;
    private String name;
    private long time;
    private Classroom classroom;
    private List<Teacher> teachers;
    private List<Student> students;
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
    @Column(nullable = true)
    @Range(min=0)
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public Classroom getClassroom(){
        return this.classroom;
    }

    public void setClassroom(Classroom classroom){
        this.classroom = classroom;
    }
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_course",joinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id",nullable = false)
            ,inverseJoinColumns = @JoinColumn(name = "teacher_id",referencedColumnName = "id",nullable = false))
    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_course",joinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id",nullable = false)
            ,inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id",nullable = false))
    public List<Student> getStudents(){
        return this.students;
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }
}

