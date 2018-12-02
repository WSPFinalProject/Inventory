/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectwsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael
 */
public class Admin_bean {
    private static Connection con;
    private static java.sql.Statement st;
    private static ResultSet rs;
    private String  jdbc_drivers, url, user, password = "";
    private String current_user, current_native, current_lastConver;
    private String status;

    public Admin_bean(Connection c) {
        con = c;
    }

    public static String[][] getInventory() {
        String[][] results = {};
        String temp = "";
        ArrayList<String[]> s = new ArrayList<String[]>();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM book");

            for(int i = 0; rs.next(); i++) {
                for(int j = 1; j <= 6; j++) {
                    temp += rs.getString(j)+"@";
                }
                s.add(temp.split("@"));
                temp = "";
            }

            results = new String[s.size()][6];

            for(int i = 0; i < s.size(); i++) {
                for(int j = 0; j < 6; j++) {
                    results[i][j] = s.get(i)[j];
                }
            }

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Exception Caught");
        }

        return results;
    }
}
