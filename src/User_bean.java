/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectwspt;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    //private String  jdbc_drivers, url, user, password = "";
    private static int current_user;

    public User_bean(Connection c) {
        con = c;
    }

    public static String signup(String uname, String pass) {
        String status = "";

        try {
            st = con.createStatement();
            if(!userExists(uname)) {
                st.executeUpdate("INSERT INTO users (Username, Password) VALUES ('"+uname+"', '"+pass+"')");
                addCart();
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

    public static void addCart() {
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO cart (Book1, Book2, Book3, Book4, Book5, B1Quan, B2Quan, B3Quan, B4Quan, B5Quan) VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)");
        } catch (SQLException ex) {
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Add Cart Failed");
        }
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
                current_user = Integer.parseInt(rs.getString(1));
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

    public static int getCurrentUser() {
        return current_user;
    }

    public static String[][] getAvailableBooks() {
        String[][] results = {};
        String temp = "";
        ArrayList<String[]> s = new ArrayList<String[]>();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM book");

            for(int i = 0; rs.next(); i++) {
                if(Integer.parseInt(rs.getString(6)) > 0) {
                    for(int j = 1; j <= 6; j++) {
                        temp += rs.getString(j)+"@";
                    }
                    s.add(temp.split("@"));
                    temp = "";
                }
            }

            results = new String[s.size()][6];

            for(int i = 0; i < s.size(); i++) {
                for(int j = 0; j < 6; j++) {
                    results[i][j] = s.get(i)[j];
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Get Available Books Failed");
        }

        return results;
    }

    public static String addToCart(int bookID, int quantity) {
        String status = "";
        int slot = getNextCartSlot();

        if(slot > 0) {
            try {
            st = con.createStatement();
            st.executeUpdate("UPDATE cart SET Book"+slot+" = "+bookID+", B"+slot+"Quan = "+quantity+" WHERE UserID = "+current_user+"");
            status = "Add to Cart Successful";

            } catch (SQLException ex) {
                Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Add to Cart Failed");
                status = "Add to Cart Failed";
            }
        }

        return status;
    }

    public static int getNextCartSlot() {
        int slot = -1;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM cart WHERE UserID = "+current_user+"");

            if(rs.next()) {
                for(int i = 2; i <= 6; i++) {
                    if(rs.getString(i) == null) {
                        slot = i-1;
                        System.out.println("Next Cart Slot is "+(i-1));
                        break;
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Get Cart Slot Failed");
        }


        return slot;
    }

    public static boolean isEnough(int bookID, int quantity) {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM book WHERE BookID = "+bookID+"");

            if(rs.next()) {
                if(Integer.parseInt(rs.getString(6)) >= quantity) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Get Enoguh Books Failed");
            return false;
        }
        return false;
    }

    public static String removeFromCart(int cart_slot) {
        String status = "";

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE cart SET Book"+cart_slot+" = NULL, B"+cart_slot+"Quan = NULL WHERE UserID = "+current_user+"");
            status = "Remove from Cart Successful";

            } catch (SQLException ex) {
                Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Remove from Cart Failed");
                status = "Remove from Cart Failed";
            }

        return status;
    }
}
