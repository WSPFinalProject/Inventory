/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc4380.finalproject;

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
    private static String status;

    public User_bean(Connection c) {
        con = c;
    }

    public static String signup(String uname, String pass) {
        status = "";

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
        status = "";

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
        status = "";
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
        status = "";

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
    
    public static String getStatus() {
        return status;
    }
    
    public static void setStatus(String s) {
        status = s;
    }
    
    public String[][] getCart(int uid) {
        String[][] temp = new String[5][6];
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM cart WHERE UserID = "+uid+"");
            status = "Get Cart Successful";
            
            if(rs.next()) {
                for(int i = 0; i < 5; i++) {
                    String s = rs.getString(i+2);
                    //System.out.println(s);
                    if(s != null) {
                        temp[i] = getBook(Integer.parseInt(s));
                        temp[i][5] = rs.getString(i+7);
                    /*    if(Integer.parseInt(rs.getString(i+7)) > Integer.parseInt(temp[i][5]))
                            temp[i][5] = rs.getString(i+7);
                        if(Integer.parseInt(temp[i][5]) <= 0)
                            temp[i] = null;
                    */
                    } else {
                        temp[i] = null;
                    }
                } 
            }

            } catch (SQLException ex) {
                Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Get Cart Failed");
                status = "Get Cart Failed";
            }
        return temp;
    }
    
    public String[] getBook(int bookID) {
        String[] results = new String[6];
        try {
            st = con.createStatement();
            ResultSet r = st.executeQuery("SELECT * FROM book WHERE BookID = "+bookID+"");

            if(r.next()) {
                for(int i = 0; i < 6; i++) {
                    results[i] = r.getString(i+1);
                }
            }
        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Check By Title Failed");
        }
        return results;
    }
    
    public String checkout(int uid) {
        status = "";
        String[][] temp = getCart(uid);
        
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] == null) {
                temp[i] = new String[] {"NULL","NULL","NULL","NULL","NULL","NULL"};
            }
        }
        
        try {
            st = con.createStatement();
            st.executeUpdate("INSERT INTO orders (UserID,Book1,Book2,Book3,Book4,Book5,B1Quan,B2Quan,B3Quan,B4Quan,B5Quan) VALUES ("+uid+", "+temp[0][0]+", "+temp[1][0]+", "+temp[2][0]+", "+temp[3][0]+", "+temp[4][0]+", "+temp[0][5]+", "+temp[1][5]+", "+temp[2][5]+", "+temp[3][5]+", "+temp[4][5]+")");
            for(int i = 0; i < temp.length; i++) {
                if(!temp[i][0].equals("NULL"))
                    removeQuantity(Integer.parseInt(temp[i][0]),Integer.parseInt(temp[i][5]));
            }
            clearCart(uid);
            
        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Checkout Failed");
        }
        
        return status;
    }
    
    public void removeQuantity(int bookID, int quantity) {
        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE book SET Quantity = Quantity - "+quantity+" WHERE BookID = "+bookID+"");
            
        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Remove Book Quantity Failed");
        }
    }
    
    public void clearCart(int uid) {
        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE cart SET Book1 = NULL, Book2 = NULL, Book3 = NULL, Book4 = NULL, Book5 = NULL, B1Quan = NULL, B2Quan = NULL, B3Quan = NULL, B4Quan = NULL, B5Quan = NULL WHERE UserID = "+uid+"");
            
        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Clear Cart Failed");
        }
    }
}
