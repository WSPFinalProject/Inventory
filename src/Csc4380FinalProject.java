/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc4380.finalproject;

/**
 *
 * @author Michael
 */
public class Csc4380FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DB_bean db = new DB_bean();
        User_bean ub = new User_bean(db.getCon());
        Admin_bean ab = new Admin_bean(db.getCon());
        Controller c = new Controller(db,ub,ab);
        view v = new view(c);
        c.setView(v);
    }
    
}
