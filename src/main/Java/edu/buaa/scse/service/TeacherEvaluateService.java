package edu.buaa.scse.service;

import edu.buaa.scse.entity.Teacher;
import edu.buaa.scse.entity.TeacherCourse;
import edu.buaa.scse.entity.TeacherEvaluate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
public class TeacherEvaluateService {
    public boolean addTeacherEvaluate(TeacherEvaluate teacherEvaluate){
        insert(teacherEvaluate.getLevel(),teacherEvaluate.getTeacher_id(),teacherEvaluate.getCourse_id());
        return true;
    }
    public List<TeacherEvaluate> getTeacherEvaluates(){
        return selectall();
    }
    public void deleteTeacherEvaluate(String id){
            delete(id);
    }
    final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/coursedb";

    final String USER = "root";
    final String PASS = "";
    public void insert( String level, String teacher_id,String course_id){
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            String sql;
            sql = "{call uloadteacher_course(?,?,?)}";
            cstmt=conn.prepareCall(sql);
            cstmt.setString(1, level);
            cstmt.setString(2, teacher_id);
            cstmt.setString(3, course_id);
            cstmt.execute();
            //System.out.println(sql);
            conn.close();
            cstmt.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }
    // id ,location ,size
    public List<TeacherEvaluate> selectall() {
        List<TeacherEvaluate> list = new ArrayList<TeacherEvaluate>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.print("hello\n");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM teacher_course";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                TeacherEvaluate teacherEvaluater=new TeacherEvaluate();
                teacherEvaluater.setId(rs.getInt("id"));
                teacherEvaluater.setLevel(rs.getString("level"));
                teacherEvaluater.setCourse_id(rs.getString("course_id"));
                teacherEvaluater.setTeacher_id(rs.getString("teacher_id"));
                list.add(teacherEvaluater);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return list;
    }
    public void delete(String id){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "delete from teacher_course where id='"+id+"';";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                System.out.println();
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }
}
