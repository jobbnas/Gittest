/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author mcbookpro
 */
public class DB {
    
   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
   static final String jdbcUrl = "jdbc:sqlserver://myisak.cvhdjaougv6g.eu-central-1.rds.amazonaws.com\\myisak:1433;databaseName=Github2";
   static final String USER = "root";
   static final String PASS = "199404046253";
   static final String get_personal ="SELECT * FROM Personal WHERE userName=? AND password=?";
   Connection conn = null;
   Statement stmt = null;
   PreparedStatement logg = null;
   public ArrayList<Kund>listkund = new ArrayList<>();
       String id;
      String fNamn;
      String eNamn;
      String perNr;


   ResultSet rsJ;

   public boolean loginSc = false;


    public void setListkund(ArrayList<Kund> listkund) {
        this.listkund = listkund;
    }

    public ArrayList<Kund> getListkund() {
        return listkund;
    }
   
   
   public void koppla() throws ClassNotFoundException, SQLException {

       
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(jdbcUrl,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
    stmt = conn.createStatement();
      String sql;
      sql = "SELECT * From Kund";
      
     ResultSet rs = stmt.executeQuery(sql);
     
           while(rs.next()){
         //Retrieve by column name
  
         String first = rs.getString("fNamn");
         String last = rs.getString("eNamn");
         String prnr = rs.getString("perNr");
         String adress = rs.getString("adress");
         String ort = rs.getString("ort");
         String telnr = rs.getString("telNr");
        
          
         //Display values
        
         System.out.println(first + " " +last + " "+prnr+" "+adress+" "+ort+" "+telnr);
         
      }
      
      stmt.close();
     
   }catch(SQLException se){
   }catch(Exception e){
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
             System.out.println("Connection closed");
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      
   }//end try
       
       
   }
   
   public void stang() throws ClassNotFoundException, SQLException{
             try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }
       
   }
   
   public void login(String username, String password) throws ClassNotFoundException, SQLException{   
       
       Connection conn1 = null;
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       conn1 = DriverManager.getConnection(jdbcUrl,USER,PASS);
       logg = conn1.prepareStatement(get_personal);
       logg.setString(1,username);
       logg.setString(2,password);
       ResultSet rs1 = logg.executeQuery();
       
       while (rs1.next()){
           
           String use = rs1.getString("userName");
           
           System.out.println("Välkommen "+use);
           loginSc=true;
       }
       try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
      }
       
   }
   
   public void loginjonas() throws ClassNotFoundException, SQLException{
      Connection conn3 = null;
      Statement stmt3 = null;
      
      try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn3 = DriverManager.getConnection(jdbcUrl, USER, PASS);
          System.out.println("Jonas connection online!");
          
          System.out.println("Skapar statement");
          stmt3 = conn3.createStatement();
          
          String sqlJ = "SELECT * FROM Personal";
          ResultSet rsJ = stmt3.executeQuery(sqlJ);
          
          while (rsJ.next()){
              
              String nam = rsJ.getString("fNamn");
              System.out.println(nam);
              
              
          }
          rsJ.close();
      }catch(SQLException se){
          se.printStackTrace();
       }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
       
   }
   
   public void setKundtoList()throws ClassNotFoundException, SQLException{
       
       Connection conn4 = null;
      Statement stmt4 = null; 
            try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn4 = DriverManager.getConnection(jdbcUrl, USER, PASS);
          System.out.println("Jonas connection online!");
          
          System.out.println("Skapar statement");
          stmt4 = conn4.createStatement();
          
          String sqlJ = "SELECT * FROM Kund";
          ResultSet rsJ = stmt4.executeQuery(sqlJ);
          System.out.println("Result");
          int steg=0;
          while (rsJ.next()){
              
              steg += 1;
              System.out.println(steg);
              int b =rsJ.getInt("Kund_ID");
              String fNamn = rsJ.getString("fNamn");
              String eNamn = rsJ.getString("eNamn");
              String pr =rsJ.getString("perNr");
              String ad = rsJ.getString("adress");
              String o = rsJ.getString("ort");
              String ps = rsJ.getString("postNr");
              String tel = rsJ.getString("telNr");
              
              Kund kk = new Kund(b,fNamn,eNamn,pr,ad,o,ps,tel);
              listkund.add(kk);
              
              
              
              
          }
          stmt4.close();
          rsJ.close();
      }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt!=null) {
             conn.close();
         }
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null) {
             conn.close();
         }
      }catch(SQLException se){
      }//end finally try
   }//end try 
          System.out.print("We made it");
       
       
       
   }
   public void SökKund(){
       
      Scanner input = new Scanner(System.in);
      
      Connection conn3 = null;
      Statement stmt3 = null;


JTextField field1 = new JTextField(10), 
        field2 = new JTextField(10), 
        field3 = new JTextField(10), 
        field4 = new JTextField(10);

            JPanel myPanel = new JPanel();

            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

            myPanel.add(new JLabel("Kund ID:"));
            
            myPanel.add(field1);

            myPanel.add(Box.createHorizontalStrut(5));

            myPanel.add(new JLabel("Förnamn:"));
            
            myPanel.add(field2);

            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Efternamn:"));
            
            myPanel.add(field3);
            
            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Personnummer:"));
            
            myPanel.add(field4);


            int result = JOptionPane.showConfirmDialog(null, myPanel, "Fyll i sökfält:", 
            JOptionPane.OK_CANCEL_OPTION);
            
            
            
            if (field1.getText() != null) {
                id =field1.getText();
                
            }
            if (field2.getText()!=null) {
            fNamn = field2.getText();
            }
            if (field3.getText()!=null){
            eNamn = field3.getText();
            }
            if (field3.getText()!=null){
            perNr = field4.getText();
            
            }

            

            System.out.println(fNamn+"Hej");
            
            int id2 = Integer.parseInt(id);
      try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn3 = DriverManager.getConnection(jdbcUrl, USER, PASS);
          System.out.println("Jonas connection online!");
          
          System.out.println("Skapar statement");
          stmt3 = conn3.createStatement();
          
          CallableStatement cstmt = null;
                
          

                    cstmt = conn3.prepareCall ("{call Sök2Test (?, ?, ?, ?)}");
                    cstmt.setInt(1, id2);
                    cstmt.setString(2, fNamn);
                    cstmt.setString(3, eNamn);
                    cstmt.setString(4, perNr);
                    
                    cstmt.execute();
                    System.out.println("Färdig");
                    rsJ = cstmt.getResultSet();



          while (rsJ.next()){
              
              String fNamn2 = rsJ.getString("fNamn");
              String eNamn2 = rsJ.getString("eNamn");
              String pr =rsJ.getString("perNr");
              String ad = rsJ.getString("adress");
              String o = rsJ.getString("ort");
              String ps = rsJ.getString("postNr");
              String tel = rsJ.getString("telNr");
              
              System.out.println(fNamn2+eNamn2+pr+ad+o+ps+tel);
              
          }
   
          rsJ.close();
          cstmt.close();
      }catch(SQLException se){
          se.printStackTrace();
       }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
       
   }

   
}//end main

    

