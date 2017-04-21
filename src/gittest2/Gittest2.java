/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFrame;





public class Gittest2{ 
   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
   static final String jdbcUrl = "jdbc:sqlserver://myisak.cvhdjaougv6g.eu-central-1.rds.amazonaws.com\\myisak:1433;databaseName=Github2";
   static final String USER = "root";
   static final String PASS = "199404046253";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
       
//    GUI test = new GUI();
//    test.setVisible(true);
    


    DB data = new DB();
    
    System.out.println("Ange användarnamn");
    String u;
    System.out.println("Ange lösen");
    String l;
    data.setKundtoList();

    ArrayList<Kund> kundlist;
    
 
    
    LoginUi login = new LoginUi();
    login.setVisible(true);
    data.loginjonas();
    
    
    
    
    while(login.isActive()){
    u = login.getUser();
    l = login.getPass();
    data.login(u, l);
    }
    
    
    }


}//end FirstExample
    
   
  

