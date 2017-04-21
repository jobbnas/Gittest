/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

import java.sql.*;
import java.util.ArrayList;


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
   
   public ArrayList<Kund>kundlist()throws ClassNotFoundException, SQLException{
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
          
          while (rsJ.next()){
              int i =rsJ.getInt("Kund_ID");
              String nam = rsJ.getString("fNamn");
              String enam = rsJ.getString("eNamn");
              String pr =rsJ.getString("perNr");
              String ad = rsJ.getString("adress");
              String o = rsJ.getString("ort");
              String ps = rsJ.getString("postNr");
              String tel = rsJ.getString("telNr");
              
              Kund kk = new Kund(i,nam,pr,ad,o,ps,tel);
              kundlist().add(kk);
              
              
              
              
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
         if(stmt4!=null)
            conn4.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn4!=null)
            conn4.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try 
            
     return kundlist();       
   }
}//end main
    

