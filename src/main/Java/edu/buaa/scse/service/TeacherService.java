package edu.buaa.scse.service;

import edu.buaa.scse.entity.Student;
import edu.buaa.scse.entity.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
public class TeacherService {
    public boolean addTeacher(Teacher teacher){
        insert(teacher.getId(),teacher.getAge(),teacher.getGender(),teacher.getName(),teacher.getPhonenum(),teacher.getTitle());
        return true;
    }
    public List<Teacher> getTeachers(){
        return selectall();
    }
    public void deleteTeacher(String id){
            delete(id);
    }
    final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/coursedb";

    final String USER = "root";
    final String PASS = "";
    public void insert(String id, long age, String gender,String name,String Phonenum,String title){
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            String sql;
            sql = "{call uloadteacher(?,?,?,?,?,?)}";
            cstmt=conn.prepareCall(sql);
            cstmt.setString(1,id);
            cstmt.setLong(2, age);
            cstmt.setString(3, gender);
            cstmt.setString(4, name);
            cstmt.setString(5,Phonenum);
            cstmt.setString(6,title);
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
        List<Teacher> list = new ArrayList<Teacher>();
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
            sql = "SELECT * FROM teacher";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Teacher teacher=new Teacher();
                teacher.setId(rs.getString("id"));
                teacher.setGender(rs.getString("gender"));
                teacher.setName(rs.getString("name"));
                teacher.setAge(rs.getInt("age"));
                teacher.setTitle(rs.getString("title"));
                teacher.setPhonenum(rs.getString("phonenum"));
                list.add(teacher);
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
            sql = "delete from teacher where id='"+id+"';";
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
