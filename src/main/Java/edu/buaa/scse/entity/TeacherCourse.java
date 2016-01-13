package edu.buaa.scse.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wood on 2016/1/11.
 */
@Entity
@Table(name = "teacher_course")
public class TeacherCourse implements Serializable {


    //    private Teacher teacher;
//    private Course  course;
    private String level;
    @Id //在表中的名称
    @GeneratedValue(strategy=GenerationType.AUTO) //自动增长
    private Integer id;
    public Integer getId(){
        return this.id;
    }

    //    @ManyToOne(fetch =FetchType.EAGER )
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//    @ManyToOne(fetch = FetchType.EAGER)
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
    @Column(nullable = true,length = 1)
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
