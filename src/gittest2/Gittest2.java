/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;


import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


//asdadsaasdSADasdASDSAdASasdasdAS

//update
public class Gittest2{ 
   static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
   static final String jdbcUrl = "jdbc:sqlserver://myisak.cvhdjaougv6g.eu-central-1.rds.amazonaws.com\\myisak:1433;databaseName=Github2";
   static final String USER = "root";
   static final String PASS = "199404046253";
   static String text= "BETA V.100";
   static String text1= "© 2017 ISAKJONAS GROUP ALL RIGHTS RESERVED";
   
   static String b;
   static String c;
   static String r;
   static DB data = new DB();
   
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Scanner input = new Scanner(System.in);
    Hemskärm hem = new Hemskärm();
    KommentarUI komUI = new KommentarUI();
    ArandeUI arende = new ArandeUI();
    KundUI kundUI = new KundUI();
    LoginUi login = new LoginUi();
    ArbetsBeskrivningUI arbUI = new ArbetsBeskrivningUI();
    hem.setText(text,text1);
    komUI.setText(text,text1);
    arende.setText(text,text1);
    kundUI.setText(text,text1);
    login.setText(text, text1);

   
    
    
    data.setArendetoList();   
    ArrayList<Arende> arendeArray;
    arendeArray = (ArrayList<Arende>)data.arendeArray.clone();
    
    
    arende.arendeLista = (ArrayList<Arende>)arendeArray.clone();
    arende.VisaArende();
   
    
    data.setKundtoList();
    ArrayList<Kund> kundlist;
    kundlist = (ArrayList<Kund>)data.listkund.clone();


    
    kundUI.lista = (ArrayList<Kund>)kundlist.clone();
    kundUI.Visa_Kund();
    
   
    login.setVisible(true);
    

    
    while(login.getKnapp()==false){
        hem.setTid();
       b= login.getUser();
       c=  login.getPass();
        r= login.getPos();
        
    }
     do{
 
       
    if (data.loginjonas(b, c, r)==true){ // Ändrar man detta till false så stängs den, så ifsatsen funkar. men verkar vara något kraj på metoden
       
        login.dispose();
        
        switch(r){
            case"Admin":
               String f = data.getFornamn();
               String e = data.getEfternman();
                
                hem.setLabelName(f, e);
                hem.setTid();
                hem.setVisible(true);
                hem.setKlockaDefault();
                break;
            case"IT-Support":
                
                break;
            case"Processledare":
                AdminUI adm = new AdminUI();
                adm.setVisible(true);
                break;
            default:
        }
    }
 
    } while(login.isActive());
     
     while(true){
         hem.setTid();
     hem.setLoop3();
     hem.setArendeDefault();
     hem.setKundDefault();
     
     data.arendeArray.clear();
     data.setArendetoList();
     arendeArray.clear();
     arende.ClearArende();
     hem.ClearHemskärm();
     
     arendeArray = (ArrayList<Arende>)data.arendeArray.clone();
     arende.arendeLista = (ArrayList<Arende>)arendeArray.clone();
     arende.VisaArende();
   
     hem.VisaHemskärm(arendeArray);

     while(hem.getLoop()== false){
        arende.setMervToDefault();
        hem.setDefaultBoolHemskärm();
         hem.setTid();
         login.dispose();
         if(hem.getArende()==true){
            arende.setVisible(true);
            
         }

                
         if(arende.getMerv()== true || hem.getBoolHemskärm()== true){
            int a_id;  
            int k_id;
                  
            if(arende.getMerv()== true){ 
                a_id = arende.getA_id();
                k_id=arende.getK_id();
            }
            else{
             
                 a_id = hem.getA_id();
                 k_id = hem.getK_id();
            }

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
            data.kommentarlista.clear();

            komUI.ClearKommentar();


           data.getKommentar(a_id);
           komUI.k_lista =(ArrayList<Kommentar>) data.getKommentarlista().clone();
           komUI.visaKommentarer();

            komUI.setVisible(true);
            komUI.setDefaultTryckLoop();
            komUI.setDefaultKommentar();
            komUI.setDefaultkomID();

              while(komUI.getTryckLoop()== false){

                  login.dispose();
              hem.setTid();
              
                if(komUI.getBoolDDKom()==true){
                    
                    komUI.LäsKommentar();
                    komUI.setBoolDDKom(false);
                    
                }
              
                if(komUI.getTryck()==true){
                    

                    String kom = komUI.getKommentar();
                    String und =  komUI.getUnderskrift();
                    int ide = komUI.getId();

                    data.setKommentar(ide, kom, und);
                    komUI.setDefaultTryck();
                    
                   
                  }
                
                if(komUI.getArbUI()==true){
                    
                    
                    data.getSpecArende(a_id, arb);
                    
                    arbUI.setVisible(true);
                    komUI.setArbUI(false);
                    if(!"".equals(data.nat.getHastighet())){
                        arbUI.setChoice(arb, data.nat.getHastighet(), data.nat.getLeverantör(), data.nat.typ);
                        
                    }
                    else if(!"".equals(data.fel.getAtgard())){
                        arbUI.setChoice(arb, data.fel.getAtgard(), data.fel.getHandelse(), data.fel.getLevel());
                        
                    }
                    else if(!"".equals(data.lagring.getMarke())){
                        arbUI.setChoice(arb,data.lagring.getMarke(),data.lagring.getStorlekGB(),data.lagring.getTyp());
                        
                    }
                    
                    data.setSpecArende(a_id, arb, arbUI.getPos1(), arbUI.getPos2(), arbUI.getPos3());
                    arbUI.clearChoice();
                }
                
                if(komUI.getBoolTillstånd()==true){
                    
                    int kID= komUI.getKomID();
                    data.setKommentarToLast(kID);
                    komUI.setDefaultBoolTillstånd();
                    
                    
                }
                                              // default kommentar
                 if(komUI.getÄndraStatus1()==true){
                    String val =komUI.getVal1();
                    data.setStatus(a_id, val);
                    komUI.ändraStatus=false;
                    
                 }
                if(komUI.getTidbool()==true){
                    
                     data.setTidtoArende(a_id,komUI.getTimmar());
                     komUI.tidbool=false;
                    
                    
                 }  

                  //
              }
 
            }
         
 
         
         if(hem.getKund()==true){
             
            kundUI.setVisible(true);
            
           
         }
         
     }
     }
    
    }
    



}
    
   
  

