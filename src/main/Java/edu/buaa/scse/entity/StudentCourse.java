package edu.buaa.scse.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wood on 2016/1/12.
 */
@Entity
@Table(name = "student_course")
public class StudentCourse implements Serializable {
    //    private Student student;
//    private Course  course;
    private long grades;

    @Id                                             //在表中的名称
    @GeneratedValue(strategy= GenerationType.AUTO) //自动增长
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }
    //    @ManyToOne(fetch =FetchType.EAGER )
//    public Student getStudent(){
//        return this.student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
    @Column(nullable = true)
    public long getGrades() {
        return grades;
    }

    public void setGrades(long grades) {
        this.grades = grades;
    }
}
