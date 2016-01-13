package edu.buaa.scse.entity;

/**
 * Created by wood on 2016/1/13.
 */
public class TeacherEvaluate extends  TeacherCourse {
    private String teacher_id;
    private String course_id;

    public String getCourse_id() {
        return course_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }
}
