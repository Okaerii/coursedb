package edu.buaa.scse.service;

import edu.buaa.scse.entity.Course;
import edu.buaa.scse.entity.Grade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
public class GradeService {
    public boolean addGrade(Grade grade){
        insert(grade.getGrades(),grade.getStudent_id(),grade.getCourse_id());
        return true;
    }
    public List<Grade> getGrades(){
       return  selectall();
    }
    public void deleteGrade(String id){
        delete(id);
    }
    public List<Grade> getStudentGrades(String student_id){
        List<Grade> list = new ArrayList<Grade>();
        Connection conn = null;
        Statement stmt = null,stmt1=null;
        ResultSet rs=null,rs1=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql,sql2;
            sql = "SELECT student_course.course_id,course.name, student_course.grades from student_course,course where student_course.course_id=course.id and student_course.student_id="+student_id+";";
//            sql = "SELECT  student_course.course_id,course.name, student_course.grades ";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Grade gradeTale_a=new Grade();
                gradeTale_a.setCourse_id(rs.getString("course_id"));
                gradeTale_a.setCourse_name(rs.getString("name"));
                gradeTale_a.setGrades(rs.getLong("grades"));
                list.add(gradeTale_a);
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


    final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/coursedb";

    final String USER = "root";
    final String PASS = "";
    public void insert(long grades, String student_id,String course_id){
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            String sql;
            sql = "{call uloadstudent_course(?,?,?)}";
            cstmt=conn.prepareCall(sql);
            cstmt.setLong(1, grades);
            cstmt.setString(2, student_id);
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
    public List selectall() {
        List<Grade> list = new ArrayList<Grade>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM student_course";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Grade grade=new Grade();
                grade.setId(rs.getInt("id"));
                grade.setGrades(rs.getInt("grades"));
                grade.setCourse_id(rs.getString("course_id"));
                grade.setStudent_id(rs.getString("student_id"));
                list.add(grade);
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
            sql = "delete from student_course where id='"+id+"';";
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
