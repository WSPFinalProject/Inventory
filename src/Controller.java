/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectwsp;

/**
 *
 * @author nikhitak
 */
public class Controller {
    private static Admin_bean a;
    private static User_bean u;
    private static String books [][];
    private static int numOfBooks;
    private static int checkOutBooks[] ;
    
    public Controller(User_bean model)
    {
        u = model;
        
    }
    
    public void btnLogin(view v){
        u.login(v.getUserLogin(), v.getPasswordLogin());
        v.setStatus(u.getStatus());
        if(u.getStatus().equals("login success")) {
            //Need to define what to do here
    }
        
    }
    public void btnSignUp(view v){
        u.signup(v.getUsername(), v.getPassword());
        v.setStatus(u.getStatus());
        u.userExists(v.getStatus());
        v.setStatus(u.getStatus());
       
    }
    public int getTotalNumOfBooks(){
        String books [][] = a.getInventory();
        numOfBooks= books.length;
        return numOfBooks;
    }

    public void btnAddBook(view v){
       a.addBook(v.getTitleAdd(),v.getAuthorAdd(),v.getGenreAdd(),v.getPublisherAdd(),Integer.parseInt(v.getQuantityAdd()));
    }
    public void btnDeleteBook(view v){
       a.deleteBook(Integer.parseInt(v.getBookIDEdit()));
        
    }
    public void btnUpdateBook(view v){
        a.editBook(Integer.parseInt(v.getBookIDEdit()),v.getTitleEdit(),v.getAuthorEdit(),v.getGenreEdit(),v.getPublisherEdit(),Integer.parseInt(v.getQuantityEdit()));
        
    }
    public void btnCheckOutBook(view v){
        for(int i =0;i<Integer.parseInt(v.getQuantityAdd());i++){
            checkOutBooks[i]=(Integer.parseInt(v.getBookIDEdit()));
        }
        for(int i =0;i<Integer.parseInt(v.getQuantityAdd());i++){
            a.deleteBook(checkOutBooks[i]);
        }
        
    }
    public void btnSearchBooks(view v){
        a.checkByAuthor(v.getAuthorAdd());
        a.checkByTitle(v.getTitleAdd());
    }
    }
    

