/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc4380.finalproject;

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
    
    public Controller()
    {
        db = new DB_bean();
        u = new User_bean(db.getCon());
        a = new Admin_bean(db.getCon());
        view v = new view(this);
    }
    
    public void showLogin(view v) {
        v.showLoginDialog();
    }
    
    public void btnLogin(view v){
        
        u.login(v.getUserLoginInput(), v.getPasswordLoginInput());
        v.setStatus(u.getStatus());
        System.out.println(u.getStatus());
        /*if(u.getStatus().equals("login success")) {
            //Need to define what to do here
    }
     */   
    }
    
    public void showSignup(view v) {
        v.showSignupDialog();
    }
    
    public void btnSignUp(view v){
        u.signup(v.getUNSignup(), v.getPWSignup());
        v.setStatus(u.getStatus());
        System.out.println(u.getStatus());
        u.userExists(v.getStatus());
        v.setStatus(u.getStatus());
       
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
    }
    public void btnDeleteBook(view v){
       a.deleteBook(Integer.parseInt(v.getDeleteID()));
    }
    
    public void showUpdateBook(view v) {
        v.showUpdate();
    }
    
    public void showOrderDialog(view v) {
        v.showOrder();
    }
    
    public void btnAddtoCart(view v) {
        u.addToCart(Integer.parseInt(v.getOrderID()), Integer.parseInt(v.getOrderQuantity()));
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
        
    }
    public void btnCheckOutBook(view v){
        for(int i =0;i<Integer.parseInt(v.getQuantityAdd());i++){
            checkOutBooks[i]=(Integer.parseInt(v.getBookIDEdit()));
        }
        for(int i =0;i<Integer.parseInt(v.getQuantityAdd());i++){
            a.deleteBook(checkOutBooks[i]);
        }
        
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
}
    

