package edu.buaa.scse.service;

import edu.buaa.scse.entity.*;
import edu.buaa.scse.entity.Class;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wood on 2016/1/13.
 */
public class DepartmentService {
    public boolean addDepartment(Department department){
        insert(department.getId(),department.getChairman(),department.getName(),department.getPhonenum());
        return true;
    }
    public List<Department> getDepartments(){
            return   selectall();

    }
    public void deleteDepartment(String id){
        delete(id);
    }

    final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/coursedb";

    final String USER = "root";
    final String PASS = "";
    public void insert(String id, String chairman, String name,String Phonenum){
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            String sql;
            sql = "{call uloaddepartment(?,?,?,?)}";
            cstmt=conn.prepareCall(sql);
            cstmt.setString(1,id);
            cstmt.setString(2,chairman);
            cstmt.setString(3,name);
            cstmt.setString(4,Phonenum);
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
        List<Department> list = new ArrayList<Department>();
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
            sql = "SELECT * FROM department";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Department department=new Department();
                department.setId(rs.getString("id"));
                department.setChairman(rs.getString("chairman"));
                department.setName(rs.getString("name"));
                department.setPhonenum(rs.getString("phonenum"));
                list.add(department);
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
            sql = "delete from department where id='"+id+"';";
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
