package edu.buaa.scse.service;

/**
 * Created by wood on 2016/1/12.
 */

import edu.buaa.scse.DAO.UserDAO;
import edu.buaa.scse.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDAO userDAO;
    final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/coursedb";

    static final String USER = "root";
    static final String PASS = "";
    public int loginUser(String id, String password) {
        User user = test3(id);
        if(user.getPassword()!=null&&user.getPassword().equals(password)){
            return user.getPower();
        }
        return -1;
    }

    public boolean regsisterUser(User u){
        if(test3(u.getId()).getPassword() !=null) {
            return false;
        }
        userDAO.addUser(u);
        return true;
    }
    public static User test3(String a) {
        Connection conn = null;
        Statement stmt = null;
        String ps=null;
        User user=new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.print("hello\n");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user where id='"+a+"';";

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                user.setPassword( rs.getString("password"));
                user.setPower(rs.getInt("power"));
//                System.out.println("id: " + id);
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
        return user;
    }

}
