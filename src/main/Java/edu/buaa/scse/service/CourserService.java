package edu.buaa.scse.service;

import edu.buaa.scse.entity.Classroom;
import edu.buaa.scse.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
public class CourserService {
    public boolean addCourse(Course course){
       insert(course.getId(),course.getName(),course.getTime(),course.getClassroom().getId());
        return true;
    }
    public List<Course> getCourse(){
        return selectall();
    }
    public void deleteCourse(String id){
        delete(id);
    }
    public List<Course> getStudentChosenCourse(String id){
        return selectallChosen(id);
    }
    public List<Course> getStudentUnchosenCourse(String id){

        return selectallUnchosen(id);
    }

    public boolean deleteStudentCourse(String studentid, String courseid) {
         deleteCourseChosen(courseid,studentid);
         return true;
    }

    public boolean addStudentCourse(String studentid, String courseid) {

        selectCourse(studentid,courseid);
        return  true;
    }


    final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/coursedb";

    final String USER = "root";
    final String PASS = "";
    public void insert(String id,String name,long time,String classroom_id){
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            String sql;
            sql = "{call uloadcourse(?,?,?,?)}";
            cstmt=conn.prepareCall(sql);
            cstmt.setString(1, id);
            cstmt.setString(2, name);
            cstmt.setLong(3, time);
            cstmt.setString(4, classroom_id);
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
        List<Course> list = new ArrayList<Course>();
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
            sql = "SELECT * FROM course";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Course course=new Course();
                course.setId(rs.getString("id"));
                Classroom classroom=new Classroom();
                classroom.setId(rs.getString("classroom_id"));
                course.setClassroom(classroom);
                course.setTime(rs.getInt("time"));
                course.setName(rs.getString("name"));
                list.add(course);
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
            sql = "delete from course where id='"+id+"';";
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

    public List selectallChosen(String id) {
        List<Course> list = new ArrayList<Course>();
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
            sql = "SELECT * FROM course where id in (select course_id from student_course where student_id="+id+");";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Course scoursed=new Course();
                Classroom classroom =new Classroom();
                classroom.setId(rs.getString("classroom_id"));
                scoursed.setClassroom(classroom);
                scoursed.setId(rs.getString("id"));
                scoursed.setName(rs.getString("name"));
                scoursed.setTime(rs.getInt("time"));
                list.add(scoursed);
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
    public void deleteCourseChosen(String id,String student_id){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "delete from student_course where course_id='"+id+"' and student_id='"+student_id+"';";
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

    public List selectallUnchosen(String id) {  //ÁÐ³öÎ´Ñ¡¿Î
        List<Course> list = new ArrayList<Course>();
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
            sql = "SELECT * FROM course where id not in (select course_id from student_course where student_id="+id+");";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Course scoursed=new Course();
                Classroom classroom =new Classroom();
                classroom.setId(rs.getString("classroom_id"));
                scoursed.setClassroom(classroom);
                scoursed.setId(rs.getString("id"));
                scoursed.setName(rs.getString("name"));
                scoursed.setTime(rs.getInt("time"));
                list.add(scoursed);
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
    public void selectCourse( String student_id,String course_id){ //Ñ¡¿Î
        Connection conn = null;
        CallableStatement cstmt = null;
        long grades =0;
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
}
