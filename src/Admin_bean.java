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
    private static String status;

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
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Exception Caught");
        }

        return results;
    }

    public static String editBook(int bookID, String title, String author, String genre, String pub, int quantity) {
        status = "";

        try {
            st = con.createStatement();
            st.executeUpdate("UPDATE book SET Title = \""+title+"\", Author = '"+author+"', Genre = '"+genre+"', Publisher = \""+pub+"\", Quantity = "+quantity+" WHERE BookID = "+bookID+"");
            status = "Update Successful";

        } catch (SQLException ex) {
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Update Failed");
               status = "Update Failed";
        }

        return status;
    }

    public static String addBook(String title, String author, String genre, String pub, int quantity) {
        status = "";

        try {
            st = con.createStatement();
            if(!bookExists(title, author, genre, pub)) {
                st.executeUpdate("INSERT INTO book SET Title = \""+title+"\", Author = '"+author+"', Genre = '"+genre+"', Publisher = \""+pub+"\", Quantity = "+quantity+"");
                status = "Add Book Successful";
            } else {
                status = "Add Book Failed";
            }

        } catch (SQLException ex) {
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Add Book Failed");
               status = "Add Book Failed";
        }

        return status;
    }

    public static boolean bookExists(String title, String author, String genre, String pub) {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM book WHERE Title = \""+title+"\" AND Author = '"+author+"' AND Genre = '"+genre+"' AND Publisher = \""+pub+"\"");

            if(rs.next()) {
                System.out.println("Book Already Exists");
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Book Check Failed");
               return false;
        }
    }

    public static String deleteBook(int bookID) {
        status = "";

        try {
            st = con.createStatement();
            st.executeUpdate("DELETE FROM book WHERE BookID = "+bookID+"");
            status = "Delete Book Successful";

        } catch (SQLException ex) {
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Delete Book Failed");
               status = "Delete Book Failed";
        }

        return status;
    }

    public static String[][] checkByAuthor(String author) {
        String[][] results = {};
        String temp = "";
        ArrayList<String[]> s = new ArrayList<String[]>();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM book WHERE Author LIKE \'%"+author+"%\'");

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

            System.out.println(""+s.size()+" books found with author containing "+author+".");

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Check By Author Failed");
        }

        return results;
    }

    public static String[][] checkByTitle(String title) {
        String[][] results = {};
        String temp = "";
        ArrayList<String[]> s = new ArrayList<String[]>();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM book WHERE Title LIKE \'%"+title+"%\'");

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

            System.out.println(""+s.size()+" books found with title containing "+title+".");

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Check By Title Failed");
        }

        return results;
    }
    
    public String[] getBook(int bookID) {
        String[] results = new String[6];
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM book WHERE BookID = "+bookID+"");

            if(rs.next()) {
                for(int i = 0; i < 6; i++) {
                    results[i] = rs.getString(i+1);
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
    
    public String[][] getOrders() {
        String[][] results = new String[0][11];
        ArrayList<String[]> temp = new ArrayList<String[]>();
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM orders");

            while(rs.next()) {
                temp.add(new String[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11)
                });
            }
            
            results = new String[temp.size()][11];
            
            for(int i = 0; i < results.length; i++) {
                results[i] = temp.get(i);
            }
        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Admin_bean.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Check By Title Failed");
        }
        return results;
    }
    
    public String getStatus() {
        return status;
    }
}
