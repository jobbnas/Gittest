/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

import static gittest2.DB.get_personal;
import static gittest2.DB.jdbcUrl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author mcbookpro
 */
public class Kund {
   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
   static final String jdbcUrl = "jdbc:sqlserver://myisak.cvhdjaougv6g.eu-central-1.rds.amazonaws.com\\myisak:1433;databaseName=Github2";
   static final String USER = "root";
   static final String PASS = "199404046253";
   
   Connection conn = null;
   Statement stmt = null;
   PreparedStatement logg = null;
   
    int kund_id;
    String namn;
    int perNr;
    String adress;
    String ort;
    String postNr;
    String telNr;
    
    public Kund(int id,String n,int prnr,String adr,String or,String pstnr,String telnr){
        this.kund_id = id;
        this.namn = n;
        this.perNr = prnr;
        this.adress = adr;
        this.ort = or;
        this.postNr = pstnr;
        this.telNr = telnr;
        
        
    }
    
    
    public void laggTillKund(){
        
   String fNamn, eNamn, perNr,adress,ort,postNr,telNr;
   Scanner input = new Scanner(System.in);
        
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(jdbcUrl, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
      

      System.out.println("SKriv in Kundens namn");
      fNamn = input.nextLine();
      System.out.println("SKriv in Kundens efternamn");
      eNamn = input.nextLine();
      System.out.println("SKriv in Kundens personnummer");
      perNr = input.nextLine();
      System.out.println("SKriv in Kundens adress");
      adress = input.nextLine();
      System.out.println("SKriv in Kundens ort");
      ort = input.nextLine();
      System.out.println("SKriv in Kundens postnummer");
      postNr = input.nextLine();
      System.out.println("SKriv in Kundens telefonnummer");
      telNr = input.nextLine();
     
     String sql =("INSERT INTO Kund\n" +
     "VALUES('"+fNamn+"','"+eNamn+"','"+perNr+"','"+adress+"','"+ort+"','"+postNr+"','"+telNr+"')");

     stmt.executeUpdate(sql);
    
     
   }catch(SQLException se){
   }catch(Exception e){
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
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
    
    
    

