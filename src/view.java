package csc4380.finalproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
/**
 *
 * @author FarNooshShh
 */
public class view extends javax.swing.JFrame {

    /**
     * Creates new form Inventory_view
     */
    String name, author, title,genre, publisher;
    int bookId, quantity;
    Controller c;
    //bean myBean;
    public view(Controller con) {
        initComponents();
        this.setTitle("Inventory Tracking System");
        this.setVisible(true);
        centerMe();
        buttonGroup.add(radioByName);
        buttonGroup.add(radioByAuthor);
        this.initListeners();
        c = con;
        adminPanel.setVisible(false);
        userPanel.setVisible(false);
    }

    public void centerMe(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screen.getWidth() - getWidth()) /2);
        int y = (int) ((screen.getHeight() -getHeight()) /2);
        setLocation(x, y); 
    }
    public void addButton(ActionListener number){
        this.addButton.addActionListener(number);
    }
    
    public void deleteButtonList(ActionListener number){
        this.deleteButton.addActionListener(number);
    }
    public void editButtonList(ActionListener number){
        this.editButton.addActionListener(number);
    }
    public void searchButtonList(ActionListener number){
        this.searchButton.addActionListener(number);
    }
    
    public void updateDialogButton(ActionListener number){  // Listener for update button in edit dialog
        this.btnUpdateEdit.addActionListener(number);
    }
     public void submitDialogButton(ActionListener number){  //Listner for submit button in Add Dialog
        this.btnSubmitAdd.addActionListener(number);
    }
     
     public void closeMenuButton(ActionListener number){  //Listner for Close inside the Menu button
        this.mnuClose.addActionListener(number);
    }
     
      public void loginButton(ActionListener number){  
        this.loginButton.addActionListener(number);
    }
      public void signupButton(ActionListener number){  
        this.signUpButton.addActionListener(number);
    }
        public void usernameLoginTxtField(ActionListener number){  
        this.usernameLoginInput.addActionListener(number);
    }
          public void passwordLoginTxtField(ActionListener number){  
        this.passwordLoginInput.addActionListener(number);
    }
            public void dialogLoginSubmit(ActionListener number){  
        this.dialogLoginButton.addActionListener(number);
    }
        public void passwordSignupTxtField(ActionListener number){  
        this.passwordSignup.addActionListener(number);
    }
        public void usernameSignupTxtField(ActionListener number){  
        this.usernameSignup.addActionListener(number);
    }
         public void addToCart(ActionListener number){  
        this.addToCartButton.addActionListener(number);
    }
          public void txtBookId(ActionListener number){  
        this.orderBookID.addActionListener(number);
    }
           public void txtBookQuantity(ActionListener number){  
        this.orderBookQuantity.addActionListener(number);
    }
          public void backButton(ActionListener number){  
        this.goBackButton.addActionListener(number);
    }
           public void submitOrder(ActionListener number){  
        this.submitOrderButton.addActionListener(number);
    }
           public String getUsername(){
            return usernameSignup.getText();
        }
         public String getPassword(){
            return passwordSignup.getText();
        }
         public String getUserLogin(){
             return usernameLoginInput.getText();
         }
         public String getPasswordLogin(){
             return passwordLoginInput.getText();
         }
         
        public void setStatus(String s) {
            status_field.setText(s);
        }
        
        public void setStatus(String s, String category) {
            status_field.setText(s);
            switch(category.toUpperCase()) {
                case "PASS":    status_field.setBackground(new Color(121, 255, 107)); break;
                case "WARNING": status_field.setBackground(new Color(255, 255, 106)); break;
                case "FAIL":    status_field.setBackground(new Color(255, 130, 105)); break;
                default:        status_field.setBackground(new Color(255, 255, 106)); break;
            }
        }
         public String getStatus(){
            return status_field.getText();
        }
         public String getAuthorAdd(){
         return textAuthorAdd.getText();
         }
         public String getAuthorEdit(){
              return textAuthorEdit.getText();
         }
         public String getBookIDEdit(){
              return textBookIDEdit.getText();
         }
        public String getGenreAdd(){
              return textGenreAdd.getText();
         }
        public String getGenreEdit(){
              return textGenreEdit.getText();
         }
        public String getPublisherAdd(){
              return textPublisherAdd.getText();
         }
        public String getPublisherEdit(){
              return textPublisherEdit.getText();
         }
     public String getQuantityAdd(){
              return textQuantityAdd.getText();
         }
     public String getQuantityEdit(){
              return textQuantityEdit.getText();
         }
    public String getTitleAdd(){
              return textTitleAdd.getText();
         }
    public String getTitleEdit(){
              return textTitleEdit.getText();
         }
    public String getUserLoginInput(){
              return usernameLoginInput.getText();
         }
    public String getPasswordLoginInput(){
              return passwordLoginInput.getText();
         }
    public String getUNSignup(){
              return usernameSignup.getText();
         }
     public String getPWSignup(){
              return passwordSignup.getText();
         }
     public String getTitle() {
         return textTitleAdd.getText();
     }
     
     public String getAuthor(){
        return textAuthorAdd.getText();
     }
     
     public String getGenre() {
         return textGenreAdd.getText();
     }
     
     public String getPublisher() {
         return textPublisherAdd.getText();
     }
     
     public String getQuantity() {
         return textQuantityAdd.getText();
     }
     
     public String getDeleteID() {
         return textDelete.getText();
     }
     
     public String getOrderID() {
         return orderBookID.getText();
     }
     
     public String getOrderQuantity() {
         return orderBookQuantity.getText();
     }
     
     public int searchMethod() {
        //ButtonModel bm = buttonGroup.getSelection();
        //Object[] x = bm.getSelectedObjects();
        if(radioByName.isSelected())
            return 1;
        else
            return 2;
     }
     
     public String getSearch() {
         return textSearch.getText();
     }
     
    void initListeners() {
        addButton.addActionListener(e -> c.showAddBook(this));
        deleteButton.addActionListener(e -> c.btnDeleteBook(this));
        editButton.addActionListener(e -> c.showUpdateBook(this));
        loginButton.addActionListener(e -> c.showLogin(this));
        signUpButton.addActionListener(e -> c.showSignup(this));
        searchButton.addActionListener(e -> c.btnSearchBooks(this,searchMethod()));
        dialogLoginButton.addActionListener(e -> c.btnLogin(this));
        dialogSignupButton.addActionListener(e -> c.btnSignUp(this));
        btnSubmitAdd.addActionListener(e -> c.btnAddBook(this));
        btnUpdateEdit.addActionListener(e -> c.btnUpdateBook(this));
        addToCartButton.addActionListener(e -> c.btnAddtoCart(this));
        orderButton.addActionListener(e -> c.showOrderDialog(this));
        cartButton.addActionListener(e -> c.showCart(this));
        checkoutButton.addActionListener(e -> c.showCheckout(this));
        submitOrderButton.addActionListener(e -> c.placeOrder(this));
        mnuClose.addActionListener(e -> c.close());
        buttonRemove.addActionListener(e -> c.remove(this));
        buttonViewOrders.addActionListener(e -> c.getOrders(this));
    }
      
    public void showLoginDialog() {
        dialogLogin.pack();
        dialogLogin.setLocationRelativeTo(null);
        dialogLogin.setVisible(true);
    }
    
    public void showSignupDialog() {
        DialogSignup.pack();
        DialogSignup.setLocationRelativeTo(null);
        DialogSignup.setVisible(true);
    }
    
    public void showAdmin() {
        loginPanel.setVisible(false);
        adminPanel.setVisible(true);
    }
    
    public void showUser() {
        loginPanel.setVisible(false);
        userPanel.add(jPanel4).setLocation(35, 250);
        
        userPanel.revalidate();
        userPanel.setVisible(true);
    }
    
    public void showAdd() {
        dialogAdd.pack();
        dialogAdd.setLocationRelativeTo(null);
        dialogAdd.setVisible(true);
    }
    
    public void showUpdate() {
        dialogEdit.pack();
        dialogEdit.setLocationRelativeTo(null);
        dialogEdit.setVisible(true);
    }
    
    public void showOrder() {
        dialogOrder.pack();
        dialogOrder.setLocationRelativeTo(null);
        dialogOrder.setVisible(true);
    }
    
    public void showCheckout() {
        dialogCheckOut.pack();
        dialogCheckOut.setLocationRelativeTo(null);
        dialogCheckOut.setVisible(true);
    }
    
    public void addToTable(String[][] results) {
        DefaultTableModel dtm = new DefaultTableModel(0,0);
        String[] head = {"BookID", "Title", "Author", "Genre", "Publisher", "Quantity"};
        dtm.setColumnIdentifiers(head);
        mainTable.setModel(dtm);
        TableColumnModel tcm = mainTable.getColumnModel();
        int[] sizes = {60, 0, 100, 100, 150, 70};
        for(int i = 0; i < 6; i++) {
            if(i != 1) {
                tcm.getColumn(i).setMaxWidth(sizes[i]);
                tcm.getColumn(i).setMinWidth(sizes[i]);
            }
        }
        for(int i = 0; i < results.length; i++) {
            try {
                dtm.addRow(new String[] {results[i][0],results[i][1],results[i][2],results[i][3],results[i][4],results[i][5]});
            } catch(Exception e) {
                
            }
        }
    }
    
    public void showCheckoutCart(String[] results) {
        jList1.setListData(results);
    }
    
    public int getSelected() {
        return jList1.getSelectedIndex();
    }
    
    public void remove(int x) {
        DefaultListModel dlm = (DefaultListModel)jList1.getModel();
        dlm.remove(x);
    }
    
    public void viewOrders(String[][] results) {
        DefaultTableModel dtm = new DefaultTableModel(0,0);
        String[] head = {"OrderID","BookID 1","BookID 2","BookID 3","BookID 4","BookID 5","Book 1 Quantity","Book 2 Quantity","Book 3 Quantity","Book 4 Quantity","Book 5 Quantity",};
        dtm.setColumnIdentifiers(head);
        mainTable.setModel(dtm);
        for(int i = 0; i < results.length; i++) {
            try {
                dtm.addRow(results[i]);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public void closeLogin() {dialogLogin.dispose();}
    public void closeSignup() {DialogSignup.dispose();}
    public void closeOrder() {dialogOrder.dispose();}
    public void closeAdd() {dialogAdd.dispose();}
    public void closeCheckout() {dialogCheckOut.dispose();}
    public void closeUpdate() {dialogEdit.dispose();}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        dialogAdd = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSubmitAdd = new javax.swing.JButton();
        textAuthorAdd = new javax.swing.JTextField();
        textTitleAdd = new javax.swing.JTextField();
        textGenreAdd = new javax.swing.JTextField();
        textPublisherAdd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textQuantityAdd = new javax.swing.JTextField();
        dialogEdit = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        textBookIDEdit = new javax.swing.JTextField();
        textTitleEdit = new javax.swing.JTextField();
        textAuthorEdit = new javax.swing.JTextField();
        textGenreEdit = new javax.swing.JTextField();
        textPublisherEdit = new javax.swing.JTextField();
        textQuantityEdit = new javax.swing.JTextField();
        btnUpdateEdit = new javax.swing.JButton();
        dialogLogin = new javax.swing.JDialog();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        usernameLoginInput = new javax.swing.JTextField();
        dialogLoginButton = new javax.swing.JButton();
        passwordLoginInput = new javax.swing.JPasswordField();
        DialogSignup = new javax.swing.JDialog();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        passwordSignup = new javax.swing.JTextField();
        usernameSignup = new javax.swing.JTextField();
        dialogSignupButton = new javax.swing.JButton();
        dialogOrder = new javax.swing.JDialog();
        jLabel27 = new javax.swing.JLabel();
        orderBookID = new javax.swing.JTextField();
        orderBookQuantity = new javax.swing.JTextField();
        addToCartButton = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        dialogCartView = new javax.swing.JDialog();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartListView = new javax.swing.JList<>();
        goBackButton = new javax.swing.JButton();
        dialogCheckOut = new javax.swing.JDialog();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        submitOrderButton = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        adminPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        radioByName = new javax.swing.JRadioButton();
        radioByAuthor = new javax.swing.JRadioButton();
        textSearch = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        mainLabel = new javax.swing.JLabel();
        textDelete = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        buttonViewOrders = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        loginPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();
        userPanel = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        orderButton = new javax.swing.JButton();
        cartButton = new javax.swing.JButton();
        checkoutButton = new javax.swing.JButton();
        status_field = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuClose = new javax.swing.JMenuItem();

        dialogAdd.setTitle("Add Book");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add a new book");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Title:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Author:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Genre:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Publisher:");

        btnSubmitAdd.setBackground(new java.awt.Color(204, 204, 204));
        btnSubmitAdd.setText("Submit");
        btnSubmitAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitAddActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Quantity:");

        javax.swing.GroupLayout dialogAddLayout = new javax.swing.GroupLayout(dialogAdd.getContentPane());
        dialogAdd.getContentPane().setLayout(dialogAddLayout);
        dialogAddLayout.setHorizontalGroup(
            dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAddLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textPublisherAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(textGenreAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTitleAdd, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textAuthorAdd, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textQuantityAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogAddLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmitAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        dialogAddLayout.setVerticalGroup(
            dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogAddLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textTitleAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textAuthorAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textGenreAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textPublisherAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textQuantityAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(btnSubmitAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        dialogEdit.setTitle("Edit Book");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Enter Book ID to edit book from system:");

        jLabel11.setText("Book ID: ");

        jLabel12.setText("Enter the new information. ");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Title: ");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Author:");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("Genre:");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Publisher:");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Quantity: ");

        textBookIDEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBookIDEditActionPerformed(evt);
            }
        });

        btnUpdateEdit.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdateEdit.setText("Update");
        btnUpdateEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogEditLayout = new javax.swing.GroupLayout(dialogEdit.getContentPane());
        dialogEdit.getContentPane().setLayout(dialogEditLayout);
        dialogEditLayout.setHorizontalGroup(
            dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogEditLayout.createSequentialGroup()
                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogEditLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(textBookIDEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogEditLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogEditLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogEditLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textTitleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogEditLayout.createSequentialGroup()
                                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textAuthorEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textGenreEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(dialogEditLayout.createSequentialGroup()
                                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textQuantityEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textPublisherEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(dialogEditLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnUpdateEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogEditLayout.setVerticalGroup(
            dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogEditLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textBookIDEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textTitleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textAuthorEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(textGenreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(textPublisherEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(textQuantityEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnUpdateEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        dialogLogin.setTitle("Login");

        jLabel19.setFont(new java.awt.Font("Menlo", 1, 14)); // NOI18N
        jLabel19.setText("Enter Information to Login:");

        jLabel20.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel20.setText("User Name: ");

        jLabel21.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel21.setText("Password: ");

        dialogLoginButton.setBackground(new java.awt.Color(204, 204, 204));
        dialogLoginButton.setText("Login");

        javax.swing.GroupLayout dialogLoginLayout = new javax.swing.GroupLayout(dialogLogin.getContentPane());
        dialogLogin.getContentPane().setLayout(dialogLoginLayout);
        dialogLoginLayout.setHorizontalGroup(
            dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogLoginLayout.createSequentialGroup()
                .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19))
                    .addGroup(dialogLoginLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dialogLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernameLoginInput, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                .addComponent(passwordLoginInput)))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        dialogLoginLayout.setVerticalGroup(
            dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogLoginLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel19)
                .addGap(26, 26, 26)
                .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLoginInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(dialogLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLoginInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(28, 28, 28)
                .addComponent(dialogLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        DialogSignup.setTitle("Sign Up");

        jLabel22.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel22.setText("Enter Information to register: ");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("User Name: ");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Password:");

        dialogSignupButton.setBackground(new java.awt.Color(204, 204, 204));
        dialogSignupButton.setText("Sign Up");

        javax.swing.GroupLayout DialogSignupLayout = new javax.swing.GroupLayout(DialogSignup.getContentPane());
        DialogSignup.getContentPane().setLayout(DialogSignupLayout);
        DialogSignupLayout.setHorizontalGroup(
            DialogSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogSignupLayout.createSequentialGroup()
                .addGroup(DialogSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogSignupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22))
                    .addGroup(DialogSignupLayout.createSequentialGroup()
                        .addGroup(DialogSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DialogSignupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DialogSignupLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(DialogSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DialogSignupLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(dialogSignupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        DialogSignupLayout.setVerticalGroup(
            DialogSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogSignupLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel22)
                .addGap(37, 37, 37)
                .addGroup(DialogSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogSignupLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel24))
                    .addComponent(usernameSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(DialogSignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(passwordSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dialogSignupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        dialogOrder.setTitle("Order Book");

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Please Enter the BookID for the book you want to order");

        addToCartButton.setBackground(new java.awt.Color(204, 204, 204));
        addToCartButton.setText("Add To Cart");

        jLabel32.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel32.setText("Book ID:");

        jLabel33.setFont(new java.awt.Font("Lucida Sans", 0, 13)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel33.setText("Quantity:");

        javax.swing.GroupLayout dialogOrderLayout = new javax.swing.GroupLayout(dialogOrder.getContentPane());
        dialogOrder.getContentPane().setLayout(dialogOrderLayout);
        dialogOrderLayout.setHorizontalGroup(
            dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogOrderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(dialogOrderLayout.createSequentialGroup()
                .addGroup(dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogOrderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogOrderLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderBookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogOrderLayout.setVerticalGroup(
            dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogOrderLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(dialogOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderBookQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel28.setFont(new java.awt.Font("Phosphate", 1, 18)); // NOI18N
        jLabel28.setText("Inside Your Cart: ");

        cartListView.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(cartListView);

        goBackButton.setText("Go Back");

        javax.swing.GroupLayout dialogCartViewLayout = new javax.swing.GroupLayout(dialogCartView.getContentPane());
        dialogCartView.getContentPane().setLayout(dialogCartViewLayout);
        dialogCartViewLayout.setHorizontalGroup(
            dialogCartViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCartViewLayout.createSequentialGroup()
                .addGroup(dialogCartViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogCartViewLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(dialogCartViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dialogCartViewLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(goBackButton)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        dialogCartViewLayout.setVerticalGroup(
            dialogCartViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCartViewLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(goBackButton)
                .addGap(27, 27, 27))
        );

        dialogCheckOut.setTitle("Checkout");

        jLabel29.setFont(new java.awt.Font("Phosphate", 0, 24)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Checkout");

        jLabel30.setText("Here is whats in your Cart:");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        submitOrderButton.setBackground(new java.awt.Color(102, 255, 102));
        submitOrderButton.setText("Submit Order");

        buttonRemove.setBackground(new java.awt.Color(255, 131, 131));
        buttonRemove.setText("Remove");

        javax.swing.GroupLayout dialogCheckOutLayout = new javax.swing.GroupLayout(dialogCheckOut.getContentPane());
        dialogCheckOut.getContentPane().setLayout(dialogCheckOutLayout);
        dialogCheckOutLayout.setHorizontalGroup(
            dialogCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCheckOutLayout.createSequentialGroup()
                .addGroup(dialogCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogCheckOutLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(buttonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(submitOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogCheckOutLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(dialogCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        dialogCheckOutLayout.setVerticalGroup(
            dialogCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCheckOutLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(dialogCheckOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inventory");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 167, 730, 53));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        mainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Title", "Author", "Genre", "Publisher", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mainTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(mainTable);
        if (mainTable.getColumnModel().getColumnCount() > 0) {
            mainTable.getColumnModel().getColumn(0).setMinWidth(60);
            mainTable.getColumnModel().getColumn(0).setMaxWidth(60);
            mainTable.getColumnModel().getColumn(2).setMinWidth(100);
            mainTable.getColumnModel().getColumn(2).setMaxWidth(100);
            mainTable.getColumnModel().getColumn(3).setMinWidth(100);
            mainTable.getColumnModel().getColumn(3).setMaxWidth(100);
            mainTable.getColumnModel().getColumn(4).setMinWidth(150);
            mainTable.getColumnModel().getColumn(4).setMaxWidth(150);
            mainTable.getColumnModel().getColumn(5).setMinWidth(70);
            mainTable.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 224, -1, 450));

        adminPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton.setBackground(new java.awt.Color(204, 204, 204));
        addButton.setText("Add Books");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        adminPanel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 162, 40));

        editButton.setBackground(new java.awt.Color(204, 204, 204));
        editButton.setText("Edit Books");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        adminPanel.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 162, 41));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Search By:");

        radioByName.setText("Title");
        radioByName.setOpaque(false);
        radioByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioByNameActionPerformed(evt);
            }
        });

        radioByAuthor.setText("Author");
        radioByAuthor.setOpaque(false);

        searchButton.setBackground(new java.awt.Color(204, 204, 204));
        searchButton.setText("Search");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(radioByName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioByAuthor))
                            .addComponent(jLabel1))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(searchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioByName)
                    .addComponent(radioByAuthor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        adminPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 210, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        mainLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        mainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel.setText("What is the Book ID? ");

        deleteButton.setBackground(new java.awt.Color(255, 131, 131));
        deleteButton.setText("Delete Book");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(mainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textDelete)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adminPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 160));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Admin Entry");
        adminPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 162, -1));

        buttonViewOrders.setBackground(new java.awt.Color(204, 204, 204));
        buttonViewOrders.setText("View Orders");
        adminPanel.add(buttonViewOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 160, 40));

        getContentPane().add(adminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));
        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        loginPanel.setBackground(new java.awt.Color(153, 153, 153));

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Login");

        loginButton.setBackground(new java.awt.Color(204, 204, 204));
        loginButton.setText("Login");

        signUpButton.setBackground(new java.awt.Color(204, 204, 204));
        signUpButton.setText("Sign Up");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 250, -1));

        jLabel26.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("User Shopping");

        orderButton.setBackground(new java.awt.Color(204, 204, 204));
        orderButton.setText("Order Books");

        cartButton.setBackground(new java.awt.Color(204, 204, 204));
        cartButton.setText("View Cart");

        checkoutButton.setBackground(new java.awt.Color(204, 204, 204));
        checkoutButton.setText("Check Out");

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(checkoutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(cartButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(orderButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        getContentPane().add(userPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 110, -1, -1));

        status_field.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status_field.setOpaque(true);
        getContentPane().add(status_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 185, 20));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 690, -1, 20));

        jMenu1.setText("File");

        mnuClose.setText("Close");
        jMenu1.add(mnuClose);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioByNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioByNameActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        dialogAdd.pack();
        dialogAdd.setVisible(true);
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void btnSubmitAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitAddActionPerformed
 
    }//GEN-LAST:event_btnSubmitAddActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        dialogEdit.pack();
        dialogEdit.setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void textBookIDEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBookIDEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBookIDEditActionPerformed

    private void btnUpdateEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEditActionPerformed

    }//GEN-LAST:event_btnUpdateEditActionPerformed

    /**
     * @param args the command line arguments
     */
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogSignup;
    public javax.swing.JButton addButton;
    private javax.swing.JButton addToCartButton;
    private javax.swing.JPanel adminPanel;
    public javax.swing.JButton btnSubmitAdd;
    public javax.swing.JButton btnUpdateEdit;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JButton buttonViewOrders;
    private javax.swing.JButton cartButton;
    private javax.swing.JList<String> cartListView;
    private javax.swing.JButton checkoutButton;
    public javax.swing.JButton deleteButton;
    public javax.swing.JDialog dialogAdd;
    private javax.swing.JDialog dialogCartView;
    private javax.swing.JDialog dialogCheckOut;
    public javax.swing.JDialog dialogEdit;
    private javax.swing.JDialog dialogLogin;
    private javax.swing.JButton dialogLoginButton;
    private javax.swing.JDialog dialogOrder;
    private javax.swing.JButton dialogSignupButton;
    public javax.swing.JButton editButton;
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel mainLabel;
    public javax.swing.JTable mainTable;
    private javax.swing.JMenuItem mnuClose;
    private javax.swing.JTextField orderBookID;
    private javax.swing.JTextField orderBookQuantity;
    private javax.swing.JButton orderButton;
    private javax.swing.JPasswordField passwordLoginInput;
    private javax.swing.JTextField passwordSignup;
    public javax.swing.JRadioButton radioByAuthor;
    public javax.swing.JRadioButton radioByName;
    public javax.swing.JButton searchButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel status_field;
    private javax.swing.JButton submitOrderButton;
    public javax.swing.JTextField textAuthorAdd;
    public javax.swing.JTextField textAuthorEdit;
    public javax.swing.JTextField textBookIDEdit;
    public javax.swing.JTextField textDelete;
    public javax.swing.JTextField textGenreAdd;
    public javax.swing.JTextField textGenreEdit;
    public javax.swing.JTextField textPublisherAdd;
    public javax.swing.JTextField textPublisherEdit;
    public javax.swing.JTextField textQuantityAdd;
    public javax.swing.JTextField textQuantityEdit;
    public javax.swing.JTextField textSearch;
    public javax.swing.JTextField textTitleAdd;
    public javax.swing.JTextField textTitleEdit;
    private javax.swing.JPanel userPanel;
    private javax.swing.JTextField usernameLoginInput;
    private javax.swing.JTextField usernameSignup;
    // End of variables declaration//GEN-END:variables
}
