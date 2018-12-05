/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc4380.finalproject;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nikhitak
 */
public class Controller {
    private static Admin_bean a;
    private static User_bean u;
    private static DB_bean db;
    private static String books [][];
    private static int numOfBooks;
    private static int checkOutBooks[] ;
    private static view vw;
    
    public Controller(DB_bean data, User_bean ub, Admin_bean ab)
    {
        db = data;
        u = ub;
        a = ab;
    }
    
    public void setView(view x) {
        vw = x;
    }
    
    public void showLogin(view v) {
        v.showLoginDialog();
    }
    
    public void btnLogin(view v){
        
        u.login(v.getUserLoginInput(), v.getPasswordLoginInput());
        v.setStatus(u.getStatus());
        System.out.println(u.getStatus());
        if(u.getStatus().equals("Admin Login Successful")) {
            v.showAdmin();
            v.setStatus("Admin Login Successful", "PASS");
            v.addToTable(showInventory());
        } else if(u.getStatus().equals("Login Successful")) {
            v.showUser();
            v.setStatus("Login Successful", "PASS");
            v.addToTable(showInventory());
        } else {
            v.setStatus("Login Failed", "FAIL");
        }
        v.closeLogin();
    }
    
    public void showSignup(view v) {
        v.showSignupDialog();
    }
    
    public void btnSignUp(view v){
        u.signup(v.getUNSignup(), v.getPWSignup());
        v.setStatus(u.getStatus());
        System.out.println(u.getStatus());
        u.userExists(v.getStatus());
        v.setStatus(u.getStatus(),u.getStatus().contains("Successful")? "PASS":"FAIL");
        v.closeSignup();
    }
    public int getTotalNumOfBooks(){
        String books [][] = a.getInventory();
        numOfBooks= books.length;
        return numOfBooks;
    }

    public void showAddBook(view v) {
        v.showAdd();
    }
    public void btnAddBook(view v){
       a.addBook(v.getTitleAdd(),v.getAuthorAdd(),v.getGenreAdd(),v.getPublisherAdd(),Integer.parseInt(v.getQuantityAdd()));
       v.closeAdd();
       v.setStatus(a.getStatus(),a.getStatus().contains("Successful")? "PASS":"FAIL");
       v.addToTable(showInventory());
    }
    public void btnDeleteBook(view v){
       a.deleteBook(Integer.parseInt(v.getDeleteID()));
       v.setStatus(a.getStatus(),a.getStatus().contains("Successful")? "PASS":"FAIL");
       v.addToTable(showInventory());
    }
    
    public void showUpdateBook(view v) {
        v.showUpdate();
    }
    
    public void showOrderDialog(view v) {
        v.showOrder();
    }
    
    public void btnAddtoCart(view v) {
        u.addToCart(Integer.parseInt(v.getOrderID()), Integer.parseInt(v.getOrderQuantity()));
        v.closeOrder();
        v.setStatus(u.getStatus(),u.getStatus().contains("Successful")? "PASS":"FAIL");
        showCart(v);
    }
    
    public void btnUpdateBook(view v){
        String[] temp = a.getBook(Integer.parseInt(v.getBookIDEdit()));
        if(!temp[1].equals(v.getTitleEdit()) && !v.getTitleEdit().isEmpty())
            temp[1] = v.getTitleEdit();
        if(!temp[2].equals(v.getAuthorEdit()) && !v.getAuthorEdit().isEmpty())
            temp[2] = v.getAuthorEdit();
        if(!temp[3].equals(v.getGenreEdit()) && !v.getGenreEdit().isEmpty())
            temp[3] = v.getGenreEdit();
        if(!temp[4].equals(v.getPublisherEdit()) && !v.getPublisherEdit().isEmpty())
            temp[4] = v.getPublisherEdit();
        if(!temp[5].equals(v.getQuantityEdit()) && !v.getQuantityEdit().isEmpty())
            temp[5] = v.getQuantityEdit();
        
        
        a.editBook(Integer.parseInt(temp[0]),temp[1],temp[2],temp[3],temp[4],Integer.parseInt(temp[5]));
        v.setStatus(a.getStatus(),a.getStatus().contains("Successful")? "PASS":"FAIL");
        v.addToTable(showInventory());
        v.closeUpdate();
    }
    public void btnCheckOutBook(view v){
        for(int i =0;i<Integer.parseInt(v.getQuantityAdd());i++){
            checkOutBooks[i]=(Integer.parseInt(v.getBookIDEdit()));
        }
        for(int i =0;i<Integer.parseInt(v.getQuantityAdd());i++){
            a.deleteBook(checkOutBooks[i]);
        }
        v.setStatus(u.getStatus(),u.getStatus().contains("Successful")? "PASS":"FAIL");        
    }
    
    public String[][] showInventory() {
        return a.checkByTitle("");
        
    }
    
    public void btnSearchBooks(view v, int method){
        String[][] results;
        if(method == 1)
            results = a.checkByTitle(v.getSearch());
        else
            results = a.checkByAuthor(v.getSearch());
        v.addToTable(results);
    }
    
    public void showCart(view v) {
        String[][] temp = u.getCart(u.getCurrentUser());
        v.addToTable(temp);
    }
    
    public void showCheckout(view v) {
        v.showCheckout();
        setCheckoutList(v);
    }
    
    public void setCheckoutList(view v) {
        String[] results;
        String[][] temp = u.getCart(u.getCurrentUser());
        ArrayList<String> r = new ArrayList<String>();
        
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] != null) {
                r.add("("+temp[i][5]+") "+(Integer.parseInt(temp[i][5]) > 9? "" :" ")+temp[i][1]);
            }
        }
        
        results = new String[r.size()];
        
        for(int i = 0; i < r.size(); i++) {
            results[i] = r.get(i);
        }
        
        v.showCheckoutCart(results);
    }
    
    public void placeOrder(view v) {
        String message = u.checkout(u.getCurrentUser());
        v.closeCheckout();
        v.setStatus(u.getStatus(),u.getStatus().contains("Successful")? "PASS":"FAIL");
    }
    
    public void remove(view v) {
        int x = v.getSelected();
        u.removeFromCart(u.getCurrentUser(), x+1);
        //v.closeCheckout();
        setCheckoutList(v);
    }
    
    public void getOrders(view v) {
        v.viewOrders(a.getOrders());
    }
    
    public void close() {
        System.exit(0);
    }
}
    

