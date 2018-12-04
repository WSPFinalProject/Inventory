/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc4380.finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class DB_bean {
    private static Connection con;
    private java.sql.Statement st;
    private ResultSet rs;
    private String  jdbc_drivers, url, user, password = "";
    private String current_user, current_native, current_lastConver;
    private String status;
    
    public DB_bean() {
        con = null;
        st = null;
        rs = null;
        
        jdbc_drivers = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/book_inventory";
        user = "root";
        password = "";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_inventory", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(DB_bean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Failed");
        }
    }
    
    public static Connection getCon() {
        return con;
    }
    
}
