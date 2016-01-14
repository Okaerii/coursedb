package edu.buaa.scse.entity;

/**
 * Created by wood on 2016/1/13.
 */
public class Grade extends StudentCourse {
    private String student_id;
    private String course_id;
    private String course_name;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCourse_id() {
        return course_id;
    }
    public void  setCourse_id(String course_id){
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
