/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;
///shdbshdbs
import static gittest2.DB.jdbcUrl;
import static gittest2.Kund.jdbcUrl;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


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
   static ResultSet rsTable;
   Connection conn = null;
   Statement stmt = null;
   PreparedStatement logg = null;
   public ArrayList<Kund>listkund = new ArrayList<>();
   public ArrayList<Arende>arendeArray = new ArrayList<>();
   int kompetens;

    public ArrayList<Arende> getArendeArray() {
        return arendeArray;
    }

    public void setArendeArray(ArrayList<Arende> arendeArray) {
        this.arendeArray = arendeArray;
    }
       String id;
      String fNamn;
      String eNamn;
      String fornamn;
      String efternman;

    public String getFornamn() {
        return fornamn;
    }

    public String getEfternman() {
        return efternman;
    }
      String perNr;
    int id2;

   ResultSet rsJ;

   public boolean loginSc = false;


    public void setListkund(ArrayList<Kund> listkund) {
        this.listkund = listkund;
    }

    public ArrayList<Kund> getListkund() {
        return listkund;
    }
   
   

   
   public boolean loginjonas(String user, String pass, String pos) throws ClassNotFoundException, SQLException{
      Connection conn3 = null;
      Statement stmt3 = null;
      boolean temp = false;
      String tempu =null;
      String tempp=null;
      String use=null;
      String p=null;
      boolean grind1 =false;
      boolean grind2 =false;
              
      try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn3 = DriverManager.getConnection(jdbcUrl, USER, PASS);
          System.out.println("Jonas connection online!");
          
          System.out.println("Skapar statement");
          stmt3 = conn3.createStatement();
          
          String sqlJ = "SELECT * FROM Personal WHERE position= "+"'"+ pos+"'";
          ResultSet rsJ = stmt3.executeQuery(sqlJ);
          
          while (rsJ.next()){
              
              tempu = rsJ.getString("userName");
              tempp = rsJ.getString("password");

              
              if (tempp.equals(pass)){
                grind1=true;
              }
              
              if (tempu.equals(user)){
                  grind2=true;
              this.fornamn = rsJ.getString("fNamn");
              this.efternman = rsJ.getString("eNamn");
              
              
                
              System.out.println("sfd");
              }

              
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
         if(stmt3!=null)
            conn3.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn3!=null)
            conn3.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
                          if (grind1==true && grind2==true)  {
                              System.out.println("Lösenord giltigt");
                return true;
            }
            else{
                 System.out.println("Funkar ej");             
                return false;
                
            }  
      
      
   }
   public void setKundtoList()throws ClassNotFoundException, SQLException{
       
      Connection conn8 = null;
      Statement stmt8 = null; 
            try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn8 = DriverManager.getConnection(jdbcUrl, USER, PASS);
          System.out.println("Jonas connection online!");
          
          System.out.println("Skapar statement");
          stmt8 = conn8.createStatement();
          
          String sqlJ = "SELECT * FROM Kund";
          ResultSet rsJ8 = stmt8.executeQuery(sqlJ);
          System.out.println("Result");
          int steg=0;
          while (rsJ8.next()){
              
              steg += 1;
              System.out.println(steg);
              int b =rsJ8.getInt("Kund_ID");
              String fNamn = rsJ8.getString("fNamn");
              String eNamn = rsJ8.getString("eNamn");
              String pr =rsJ8.getString("perNr");
              String ad = rsJ8.getString("adress");
              String o = rsJ8.getString("ort");
              String ps = rsJ8.getString("postNr");
              String tel = rsJ8.getString("telNr");
              
              Kund kk = new Kund(b,fNamn,eNamn,pr,ad,o,ps,tel);
              listkund.add(kk);
              
              
              
              
          }
          stmt8.close();
          rsJ8.close();
      }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt8!=null) {
             conn8.close();
         }
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn8!=null) {
             conn8.close();
         }
      }catch(SQLException se){
      }//end finally try
   }//end try 
          System.out.print("We made it");
       
       
       
   }
   public void setArendetoList()throws ClassNotFoundException, SQLException{
       
      Connection conn20 = null;
      Statement stmt20 = null; 
            try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn20 = DriverManager.getConnection(jdbcUrl, USER, PASS);
          System.out.println("Jonas connection online!");
          
          System.out.println("Skapar statement");
          stmt20 = conn20.createStatement();
          
          String sqlJ4 = "SELECT * FROM Arande";
          ResultSet rsJ20 = stmt20.executeQuery(sqlJ4);
            
          System.out.println("Result");
          int steg=0;
          while (rsJ20.next()){
              System.out.println("YO");
              steg += 1;
              System.out.println("fan");
              int b =rsJ20.getInt("arande_ID");
              boolean status = rsJ20.getBoolean("tillstånd");
              int tidsatgang = rsJ20.getInt("tidsatgang");
              int preltid =rsJ20.getInt("preltid");
              int timpris = rsJ20.getInt("timpris");
              String arbetsuppgift = rsJ20.getString("arbetsuppgift");
              String userName = rsJ20.getString("userName");
              String kompID = rsJ20.getString("komp_ID");
              String kundID = rsJ20.getString("Kund_ID");
              
              Arende arende = new Arende(b,tidsatgang, preltid,
            timpris,arbetsuppgift,userName,kompID, kundID);
              arendeArray.add(arende);
              
              System.out.println("bajs");
              
              
          }
          stmt20.close();
          rsJ20.close();
      }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt20!=null) {
             conn20.close();
         }
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn20!=null) {
             conn20.close();
         }
      }catch(SQLException se){
      }//end finally try
   }//end try 
          System.out.print("We made it");
       
       
       
   }
   public void SökKund(){
       
      Scanner input = new Scanner(System.in);
      
      Connection conn3 = null;
      Statement stmt3 = null;


JTextField field1 = new JTextField(10), 
        field2 = new JTextField(10), 
        field3 = new JTextField(10), 
        field4 = new JTextField(10);

            JPanel myPanel = new JPanel();

            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

            myPanel.add(new JLabel("Kund ID:"));
            
            myPanel.add(field1);

            myPanel.add(Box.createHorizontalStrut(5));

            myPanel.add(new JLabel("Förnamn:"));
            
            myPanel.add(field2);

            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Efternamn:"));
            
            myPanel.add(field3);
            
            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Personnummer:"));
            
            myPanel.add(field4);


            int result = JOptionPane.showConfirmDialog(null, myPanel, "Fyll i sökfält:", 
            JOptionPane.OK_CANCEL_OPTION);
            
            
                if (field1.getText().isEmpty()){
                  
                }
                else {
                   id=field1.getText();
                   id2 = Integer.parseInt(id);
                }
                
                if (field2.getText().equals("")){
                  
                }
                else {
                 fNamn=field2.getText();
                }     
                
                 if (field3.getText().equals("")){
                  
                }
                else {
                  eNamn=field3.getText();
                }
                 
                if (field4.getText().equals("")){
                 
                }
                else {
                 perNr=field4.getText();
                }                

            



            

            System.out.println(fNamn+"Hej");
            
            
      try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn3 = DriverManager.getConnection(jdbcUrl, USER, PASS);
          System.out.println("Jonas connection online!");
          
          System.out.println("Skapar statement");
          stmt3 = conn3.createStatement();
          
          CallableStatement cstmt = null;
                
          

                    cstmt = conn3.prepareCall ("{call Sök2Test (?, ?, ?, ?)}");
                    cstmt.setInt(1, id2);
                    cstmt.setString(2, fNamn);
                    cstmt.setString(3, eNamn);
                    cstmt.setString(4, perNr);
                    
                    cstmt.execute();
                    System.out.println("Färdig");
                    rsJ = cstmt.getResultSet();



          while (rsJ.next()){
              
              String fNamn2 = rsJ.getString("fNamn");
              String eNamn2 = rsJ.getString("eNamn");
              String pr =rsJ.getString("perNr");
              String ad = rsJ.getString("adress");
              String o = rsJ.getString("ort");
              String ps = rsJ.getString("postNr");
              String tel = rsJ.getString("telNr");
              
              System.out.println(fNamn2+eNamn2+pr+ad+o+ps+tel);
              
          }
   
          rsJ.close();
          cstmt.close();
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
   public void laggTillArende2(int id, int tid,String upp, float pris,String sign, String komp, int kundID){
        
       Connection conn10 = null;
      Statement stmt10 = null; 
            try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn10 = DriverManager.getConnection(jdbcUrl, USER, PASS);
          System.out.println("Jonas connection online!");
          
          System.out.println("Skapar statement");
          stmt10 = conn10.createStatement();
          
        String sqlJ = ("SELECT komp_ID FROM  Kompetens\n" +
            "WHERE namn =" +"'"+komp+"'");
          
          ResultSet rsJ10 = stmt10.executeQuery(sqlJ);
          System.out.println("Result");
          int steg=0;
          while (rsJ10.next()){
              
              steg += 1;
              System.out.println(steg);

              kompetens = rsJ10.getInt("komp_ID");

          System.out.println("JAJAJAJAJ");
          }
          

     
     String sql =("INSERT INTO Arande (preltid,arbetsuppgift,timpris,userName,komp_ID, Kund_ID) " +
     "VALUES('"+tid+"','"+upp+"','"+pris+"','"+sign+"',"+kompetens+",'"+kundID+"')");
     
     System.out.println("Skapar ärendet");

     stmt10.executeUpdate(sql);
     

          stmt10.close();
          rsJ10.close();
      }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt10!=null) {
             conn10.close();
         }
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn10!=null) {
             conn10.close();
         }
      }catch(SQLException se){
      }//end finally try
   }//end try 
          System.out.print("We made it");
       
       
       
   }     

} 


    

