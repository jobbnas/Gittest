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


//asdadsaasdSADasdASDSAdASasdasdAS

//update
public class Gittest2{ 
   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
   static final String jdbcUrl = "jdbc:sqlserver://myisak.cvhdjaougv6g.eu-central-1.rds.amazonaws.com\\myisak:1433;databaseName=Github2";
   static final String USER = "root";
   static final String PASS = "199404046253";
   
   static String b;
   static String c;
   static String r;
   static DB data = new DB();
   
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner input = new Scanner(System.in);
       
//    GUI test = new GUI();
//    test.setVisible(true);
    

    LoadingScreen1 ladda = new LoadingScreen1();
    
    
    data.setArendetoList();   
    ArrayList<Arende> arendeArray;
    arendeArray = (ArrayList<Arende>)data.arendeArray.clone();
    
    ArandeUI arende = new ArandeUI();
    arende.arendeLista = (ArrayList<Arende>)arendeArray.clone();
    arende.VisaArende();
   
    
    data.setKundtoList();
    ArrayList<Kund> kundlist;
    kundlist = (ArrayList<Kund>)data.listkund.clone();


    KundUI kundUI = new KundUI();
    kundUI.lista = (ArrayList<Kund>)kundlist.clone();
    kundUI.Visa_Kund();
    
    LoginUi login = new LoginUi();
    login.setVisible(true);
    
    Hemskärm hem = new Hemskärm();
    KommentarUI komUI = new KommentarUI();
    
    while(login.getKnapp()==false){
        
       b= login.getUser();
       c=  login.getPass();
        r= login.getPos();
        
    }
     do{
 
       
    if (data.loginjonas(b, c, r)==true){ // Ändrar man detta till false så stängs den, så ifsatsen funkar. men verkar vara något kraj på metoden
        System.out.println("Hej");
        login.dispose();
        
        switch(r){
            case"Admin":
               String f = data.getFornamn();
               String e = data.getEfternman();
                
                hem.setLabelName(f, e);
                hem.setVisible(true);
                
            case"IT-Support":
                
            case"Processledare":
                
            default:
        }
    }
     System.out.println("Running");
    } while(login.isActive());
     
     while(true){
     hem.setLoop3();
     hem.setArendeDefault();
     hem.setKundDefault();
     data.arendeArray.clear();
     data.setArendetoList();
     arendeArray.clear();
     arende.ClearArende();
     arendeArray = (ArrayList<Arende>)data.arendeArray.clone();
     arende.arendeLista = (ArrayList<Arende>)arendeArray.clone();
     arende.VisaArende();
     
     data.kommentarlista.clear();
     
     komUI.ClearKommentar();
     data.getKommentar(10);
     komUI.k_lista =(ArrayList<Kommentar>) data.getKommentarlista().clone();
     komUI.visaKommentarer();
     
     
     while(hem.getLoop()== false){
        arende.setMervToDefault();
         
         login.dispose();
         if(hem.getArende()==true){
            arende.setVisible(true);
            
         }
                
         if(arende.getMerv()== true){
                    
              
              
              int a_id = arende.getA_id();
              int k_id=arende.getK_id();
              
              data.getÄrendeKund(k_id);
              data.getArendeKund2(a_id);
              String arb = data.getArbetsuppgift();
              String stat = data.getSatus();
              String fe = data.getfNamn2();
              String ef= data.geteNamn2();
              
              komUI.setArendeName(a_id);
              komUI.setStatusName(stat);
              komUI.setArbetsuppgiftName(arb);
              komUI.setKundName(fe, ef);
              
              komUI.setVisible(true);
                
            }
             
         
         if(hem.getKund()==true){
             
            kundUI.setVisible(true);
            
           
         }
         
     }
     }
    
    }
    
    static void Arende() throws ClassNotFoundException, SQLException{
    data.setArendetoList();   
    ArrayList<Arende> arendeArray;
    arendeArray = (ArrayList<Arende>)data.arendeArray.clone();
    
    ArandeUI arende = new ArandeUI();
    arende.arendeLista = (ArrayList<Arende>)arendeArray.clone();
    arende.VisaArende();
    arende.setVisible(true);
    }
    
    static void Kund() throws ClassNotFoundException, SQLException{
    data.setKundtoList();
    ArrayList<Kund> kundlist;
    kundlist = (ArrayList<Kund>)data.listkund.clone();

    KundUI kundUI = new KundUI();
    kundUI.lista = (ArrayList<Kund>)kundlist.clone();
    kundUI.Visa_Kund();
    kundUI.setVisible(true);
    }


}
    
   
  

