/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;


import javax.swing.JFrame;





public class Gittest2{ 
   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
   static final String DB_URL = "jdbc:sqlserver://localhost;databaseName=Github2;integratedSecurity=true;";
   static final String USER = "username";
   static final String PASS = "password";

    public static void main(String[] args) {
        
       
    GUI test = new GUI();
    test.setVisible(true);
    
    KopplaUpp();
    

    }

    private static void KopplaUpp() {
       
    }
   
  
}
