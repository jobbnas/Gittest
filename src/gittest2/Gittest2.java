/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;


import java.sql.*;
import javax.swing.JFrame;





public class Gittest2{ 
   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
   static final String DB_URL = "jdbc:sqlserver://myisak.cvhdjaougv6g.eu-central-1.rds.amazonaws.com,1433/Github2?user=root&password=199404046253";
   static final String jdbcUrl = "jdbc:sqlserver://myisak.cvhdjaougv6g.eu-central-1.rds.amazonaws.com:1433/Github2?user=root&password=199404046253";
   static final String USER = "root";
   static final String PASS = "199404046263";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
       
//    GUI test = new GUI();
//    test.setVisible(true);
    
    KopplaUpp();
    

    }

    private static void KopplaUpp() throws ClassNotFoundException, SQLException {
        
            Connection conn = null;
            Statement stmt = null;
    

   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
    

      //STEP 5: Extract data from result set
     
      //STEP 6: Clean-up environment
      
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end FirstExample
    
   
  

