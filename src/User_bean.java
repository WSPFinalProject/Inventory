/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc4380.finalproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class User_bean {
    private static Connection con;
    private static java.sql.Statement st;
    private static ResultSet rs;
    private String  jdbc_drivers, url, user, password = "";
    private String current_user;
    
    public User_bean(Connection c) {
        con = c;
    }
    
    public static String signup(String uname, String pass) {
        String status = "";
        
        try {
            st = con.createStatement();
            if(!userExists(uname)) {
                st.executeUpdate("INSERT into users (Username, Password) VALUES ('"+uname+"', '"+pass+"')");
                status = "Signup Successful";
            } else {
                status = "User Already Exists";
            }
            
            
        } catch (SQLException ex) {
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Signup Failed");
               status = "Signup Failed";
        }
        
        return status;
    }
    
    public static boolean userExists(String uname) {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM users WHERE Username = '"+uname+"'");
            if (rs.next())
                return true;
            else
                return false;
            
        } catch (SQLException ex) {
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("User Check Failed");
        }
        
        return false;
    }
    
    public static String login(String uname, String pass) {
        String status = "";
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM users WHERE Username = '"+uname+"' AND Password = '"+pass+"'");
            
            if(rs.next()) {
                if(uname.equals("admin")) {
                    status = "Admin Login Successful";
                } else {
                    status = "Login Successful";
                }
            } else {
                status = "Login Failed";
            }
            
        } catch (SQLException ex) {
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Login Failed");
               status = "Login Failed";
        }
        
        return status;
    }
}
