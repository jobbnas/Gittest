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

    public int getKund_id() {
        return kund_id;
    }

    public void setKund_id(int kund_id) {
        this.kund_id = kund_id;
    }
    
   
    String perNr;
    String adress;
    String ort;
    String postNr;
    String telNr;
    String fNamn;
    String eNamn;
    public Kund(int kund_id, String fNamn,String eNamn, String prnr,String adr,String or,String pstnr,String telnr){
        
        this.fNamn = fNamn;
        this.eNamn = eNamn;
        this.perNr = prnr;
        this.adress = adr;
        this.ort = or;
        this.postNr = pstnr;
        this.telNr = telnr;
        this.kund_id = kund_id;
        
    }

    public String getfNamn() {
        return fNamn;
    }

    public void setfNamn(String fNamn) {
        this.fNamn = fNamn;
    }

    public String geteNamn() {
        return eNamn;
    }

    public void seteNamn(String eNamn) {
        this.eNamn = eNamn;
    }

    public String getPerNr() {
        return perNr;
    }

    public void setPerNr(String perNr) {
        this.perNr = perNr;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPostNr() {
        return postNr;
    }

    public void setPostNr(String postNr) {
        this.postNr = postNr;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }
    

    
    public void laggTillKund(){
        
   
        
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
    
    
    

