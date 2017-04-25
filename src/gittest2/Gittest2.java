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




//update
public class Gittest2{ 
   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
   static final String jdbcUrl = "jdbc:sqlserver://myisak.cvhdjaougv6g.eu-central-1.rds.amazonaws.com\\myisak:1433;databaseName=Github2";
   static final String USER = "root";
   static final String PASS = "199404046253";
   
   static String b;
   static String c;
   static String r;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
       
//    GUI test = new GUI();
//    test.setVisible(true);
    

    LoadingScreen1 ladda = new LoadingScreen1();
    
    DB data = new DB();
    
    System.out.println("Ange användarnamn");
    String u;
    System.out.println("Ange lösen");
    String l;
    data.setKundtoList();
// aaay
    ArrayList<Kund> kundlist;
    kundlist = (ArrayList<Kund>)data.listkund.clone();
   
    LoginUi login = new LoginUi();
    login.setVisible(true);

    KundUI isak = new KundUI();
    isak.lista = (ArrayList<Kund>)kundlist.clone();
    isak.Visa_Kund();
    isak.setVisible(true);
    while(login.getKnapp()==false){
        
       b= login.getUser();
       c=  login.getPass();
        r= login.getPos();
        
    }
    
    
    
    do{
 
       System.out.println(b+c);
    if (data.loginjonas(b, c, r)==true){ // Ändrar man detta till false så stängs den, så ifsatsen funkar. men verkar vara något kraj på metoden
        System.out.println("Hej");
        login.dispose();
        
        switch(r){
            case"Admin":
                
                LoadingScreen1 hola = new LoadingScreen1();
                hola.setVisible(true);
            case"IT-Position":
                
            case"Processledare":
                
            default:
        }
    }
     System.out.println("Running");
    } while(login.isActive());
    
    
    }


}//end FirstExample
    
   
  

