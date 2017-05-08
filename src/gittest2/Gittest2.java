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
// aaaysgdshd
    ArrayList<Kund> kundlist;
    kundlist = (ArrayList<Kund>)data.listkund.clone();
   
    LoginUi login = new LoginUi();
    login.setVisible(true);

    KundUI kundUI = new KundUI();
    kundUI.lista = (ArrayList<Kund>)kundlist.clone();
    kundUI.Visa_Kund();
    
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
        kundUI.setVisible(true);
        switch(r){
            case"Admin":
                    

            case"IT-Support":
                
            case"Processledare":
                
            default:
        }
    }
     System.out.println("Running");
    } while(login.isActive());
    
    
    }


}//end FirstExample
    
   
  

