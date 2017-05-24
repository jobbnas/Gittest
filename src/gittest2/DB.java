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
import java.text.SimpleDateFormat;
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
import java.util.Date;

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
   public ArrayList<Kommentar>kommentarlista = new ArrayList<>();
   public ArrayList<Kommentar>hemskärmLista = new ArrayList<>();
   public Natvark nat = new Natvark();
   public Lagring lagring = new Lagring();
   public Felsokning fel = new Felsokning();

    public ArrayList<Kommentar> getHemskärmLista() {
        return hemskärmLista;
    }

    public ArrayList<Kommentar> getKommentarlista() {
        return kommentarlista;
    }
   int kompetens;
   static String Date_Format = "yyyy-MM-dd";
   static SimpleDateFormat sdf = new SimpleDateFormat(Date_Format);

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
      String fNamn2;
      String eNamn2;
      String satus;
      String arbetsuppgift;
      String användarnamn;

    public String getAnvändarnamn() {
        return användarnamn;
    }

    public String getfNamn2() {
        return fNamn2;
    }

    public String geteNamn2() {
        return eNamn2;
    }

    public String getSatus() {
        return satus;
    }

    public String getArbetsuppgift() {
        return arbetsuppgift;
    }


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
              this.användarnamn = rsJ.getString("userName");
              
                
             
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

          
 
          stmt8 = conn8.createStatement();
          
          String sqlJ = "SELECT * FROM Kund";
          ResultSet rsJ8 = stmt8.executeQuery(sqlJ);

          int steg=0;
          while (rsJ8.next()){
              

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
    
       
       
       
   }
   public void setArendetoList()throws ClassNotFoundException, SQLException{
       
      Connection conn20 = null;
      Statement stmt20 = null; 
            try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn20 = DriverManager.getConnection(jdbcUrl, USER, PASS);
     
          
    
          stmt20 = conn20.createStatement();
          
          String sqlJ4 = "SELECT * FROM Arande";
          ResultSet rsJ20 = stmt20.executeQuery(sqlJ4);
            
   
          int steg=0;
          while (rsJ20.next()){

 
              int b =rsJ20.getInt("arande_ID");
              String status = rsJ20.getString("tillstånd");
              double tidsatgang = rsJ20.getInt("tidsatgang");
              int preltid =rsJ20.getInt("preltid");
              int timpris = rsJ20.getInt("timpris");
              String arbetsuppgift = rsJ20.getString("arbetsuppgift");
              String userName = rsJ20.getString("userName");
              String kompID = rsJ20.getString("komp_ID");
              int kundID = rsJ20.getInt("Kund_ID");
              
              Arende arende = new Arende(b,tidsatgang, preltid,
            timpris,arbetsuppgift,userName,kompID,status, kundID);
              arendeArray.add(arende);
         
              
              
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

            



            

         
            
            
      try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn3 = DriverManager.getConnection(jdbcUrl, USER, PASS);
       
          
 
          stmt3 = conn3.createStatement();
          
          CallableStatement cstmt = null;
                
          

                    cstmt = conn3.prepareCall ("{call Sök2Test (?, ?, ?, ?)}");
                    cstmt.setInt(1, id2);
                    cstmt.setString(2, fNamn);
                    cstmt.setString(3, eNamn);
                    cstmt.setString(4, perNr);
                    
                    cstmt.execute();
             
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
 
          
   
          stmt10 = conn10.createStatement();
          
        String sqlJ = ("SELECT komp_ID FROM  Kompetens\n" +
            "WHERE namn =" +"'"+komp+"'");
          
          ResultSet rsJ10 = stmt10.executeQuery(sqlJ);
   
          int steg=0;
          while (rsJ10.next()){
              

              

              kompetens = rsJ10.getInt("komp_ID");


          }
          

     
     String sql =("INSERT INTO Arande (preltid,arbetsuppgift,timpris,userName,komp_ID, Kund_ID) " +
     "VALUES('"+tid+"','"+upp+"','"+pris+"','"+sign+"',"+kompetens+",'"+kundID+"')");
     
   

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
       
       
       
       
   }   
   public void getÄrendeKund(int kundID){
   
   Connection conn21 = null;
   Statement stmt21 = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      //STEP 3: Open a connection
   
      conn21 = DriverManager.getConnection(jdbcUrl, USER, PASS);

      //STEP 4: Execute a query
     
      stmt21 = conn21.createStatement();
      String sql;
      sql = "SELECT * FROM Kund WHERE  Kund_ID = "+kundID;
     
      
      ResultSet rs30 = stmt21.executeQuery(sql);
    

      //STEP 5: Extract data from result set
      while(rs30.next()){
          
             String fNamn = rs30.getString("fNamn");
             String eNamn = rs30.getString("eNamn");
         this.fNamn2 = fNamn;
         this.eNamn2 = eNamn; 
      }
     

      
      
      
      
      rs30.close();
      stmt21.close();
      }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt21!=null) {
             conn21.close();
         }
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn21!=null) {
             conn21.close();
         }
      }catch(SQLException se){
      }//end finally try
   }//end try 
   }
   public void getArendeKund2(int arendeID){
       
     Connection conn40 = null;
      Statement stmt40 = null; 
      
    
      
            try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn40 = DriverManager.getConnection(jdbcUrl, USER, PASS);

          

          stmt40 = conn40.createStatement();
          

      String sql2 = "SELECT * FROM Arande WHERE arande_ID = "+arendeID;
      
     
      ResultSet rs32 = stmt40.executeQuery(sql2);
            

          

           while (rs32.next()){
             String arbetsuppgift = rs32.getString("arbetsuppgift");
             String status = rs32.getString("tillstånd");          
         this.satus = status;
         this.arbetsuppgift = arbetsuppgift;
              
              
          }
           
         
          
          stmt40.close();
          rs32.close();
      }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt40!=null) {
             conn40.close();
         }
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn40!=null) {
             conn40.close();
         }
      }catch(SQLException se){
      }//end finally try
   }//end try 
      
       
       
       
   }
   public void getKommentar(int komid)throws ClassNotFoundException, SQLException{
      
       Connection conn55=null;
       Statement stmt55=null;
      
       try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
         conn55 = DriverManager.getConnection(jdbcUrl, USER, PASS);

          
   
          stmt55 = conn55.createStatement();
          
         
         String sql55 = "SELECT * FROM Kommentar WHERE arande_ID=" +komid;
          ResultSet rsJ55 = stmt55.executeQuery(sql55);
          while (rsJ55.next()){
              int id = rsJ55.getInt("kommentar_ID");
              Date date = new Date();
              date = rsJ55.getDate("datum");
              String datum = sdf.format(date);
              String underskrift = rsJ55.getString("underskrift");
              String kommentar = rsJ55.getString("kommentar");
              int arende_ID = rsJ55.getInt("arande_ID");
              String user = rsJ55.getString("userName");
              int olastt = rsJ55.getInt("Olast");
              boolean olast= false;
              if(olastt == 1){
                  olast=true;
                  
             }
              else{
                  
              olast=false;  
              }
              
             
             Kommentar k = new Kommentar(id,datum,underskrift,kommentar,arende_ID,user,olast);
             kommentarlista.add(k);
              

             
             
         }
          stmt55.close();
          rsJ55.close();
          
      }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt55!=null) {
             conn55.close();
         }
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn55!=null) {
             conn55.close();
         }
      }catch(SQLException se){
      }//end finally try
   }//end try
      
      
      
      
      
      
      
      
   }  
   public void setKommentar(int arandeID, String Kommen, String underskrift){
     
       
      Connection conn45 = null;
      Statement stmt45 = null; 
      
        String username = användarnamn;

      
            try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          conn45 = DriverManager.getConnection(jdbcUrl, USER, PASS);
 
          
    
          stmt45 = conn45.createStatement();
          
        
      String sql2 = "INSERT INTO Kommentar (kommentar, underskrift, userName, arande_ID)\n" +
                    "VALUES('"+Kommen+"','"+underskrift+"','"+username+"',"+arandeID+")";
   
           stmt45.executeUpdate(sql2);
         
          
          stmt45.close();
         
          
      }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt45!=null) {
             conn45.close();
         }
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn45!=null) {
             conn45.close();
         }
      }catch(SQLException se){
      }//end finally try
   }//end try 

       
       
       
   }
   public void setKommentarToLast(int k_id)throws ClassNotFoundException,SQLException{
        Connection conn88=null;
       Statement stmt88=null;
      
       
      
        try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
        conn88 = DriverManager.getConnection(jdbcUrl, USER, PASS);
        
          
    
          stmt88 = conn88.createStatement();
          
         String sql88 = "Update Kommentar SET Olast=0 WHERE kommentar_ID = "+k_id;
          
         stmt88.executeUpdate(sql88);
          
         
         
          
         }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt88!=null) {
             conn88.close();
         }
      }catch(SQLException se){
      }// do nothing
      if(conn88!=null) {
          conn88.close();
      }
   }//end try  
      
      
      
      
   } // DB
   public void setTidtoArende(int a_id,double tid )throws ClassNotFoundException, SQLException{
       Connection conn77=null;
       Statement stmt77=null;
      
      
        try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
        conn77 = DriverManager.getConnection(jdbcUrl, USER, PASS);

          
     
          stmt77 = conn77.createStatement();
          
         String sql77 = "Update Arande SET tidsatgang=(tidsatgang +"+tid+") "+"WHERE "+a_id+"="+"arande_ID";
          
          
         stmt77.executeUpdate(sql77);
          
         stmt77.close();
         
          
         }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt77!=null) {
             conn77.close();
         }
      }catch(SQLException se){
      }// do nothing
      if(conn77!=null) {
          conn77.close();
      }
   }//end try
      
      
   }
   public void setStatus(int a_id, String val )throws ClassNotFoundException, SQLException{
       Connection conn666=null;
       Statement stmt666=null;
      
      
        try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
        conn666 = DriverManager.getConnection(jdbcUrl, USER, PASS);
       
          
       
          stmt666 = conn666.createStatement();
          
         String sql666 = "Update Arande SET tillstånd="+"'"+val+"'"+" "+"WHERE "+a_id+"="+"arande_ID";
          
         stmt666.executeUpdate(sql666);
          
         
       
          
         }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt666!=null) {
             conn666.close();
         }
      }catch(SQLException se){
      }// do nothing
      if(conn666!=null) {
          conn666.close();
      }
   }//end try
      
      
   }
   public void getSpecArende(int s, String a)throws ClassNotFoundException, SQLException{
      
       Connection conn666=null;
       Statement stmt666=null;
      ResultSet rs32 =null;
      String sql66;
              
     
       try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
       conn666 = DriverManager.getConnection(jdbcUrl, USER, PASS);
         
          
      
          stmt666 = conn666.createStatement();
          switch (a){
              case "Nätverk":
          sql66 = "SELECT * Natverk WHERE natID ="+s;
                  
         
     
                  rs32 =stmt666 .executeQuery(sql66);
            
               
          

                 while (rs32.next()){
                  String hastighet = rs32.getString("Hastighet");
                  String leverantor = rs32.getString("tillstånd");          
                 String typ = rs32.getString("Uppkopplingstyp");
                  nat.setHastighet(hastighet);
                  nat.setLeverantör(leverantor);
                  nat.setNatvarkstyp(typ);
                  
               
                 
                 
             
             
         }
                  break;
              case "Lagring":
                  sql66 = "SELECT * Lagring WHERE lagID ="+s;
                  
                 rs32 =stmt666 .executeQuery(sql66);
                  
                 while (rs32.next()){
                  String marke = rs32.getString("Marke");
                  String typ = rs32.getString("Typ");          
                 String strlk = rs32.getString("Storlek");
                  lagring.setMarke(marke);
                  lagring.setStorlekGB(strlk);
                  lagring.setTyp(typ);
                
                  
               
             
         }
                  break;
                    
             case "Incident":
                  sql66 = "SELECT * Incident WHERE incID ="+s;
                  
                 rs32 =stmt666 .executeQuery(sql66);
                  
                 while (rs32.next()){
                  String marke = rs32.getString("Handelse");
                  String typ = rs32.getString("Nivå");          
                 String strlk = rs32.getString("Åtgärd");
                  fel.setAtgard(strlk);
                  fel.setHandelse(marke);
                  fel.setLevel(typ);

               
                  
               
             
         }
                  break;
              default:
                  break;
                  
       }
        
         

         stmt666.close();
         }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt666!=null) {
             conn666.close();
         }
      }catch(SQLException se){
      }// do nothing
      if(conn666!=null) {
          conn666.close();
      }
   }//end try
      
  } // db spec
  
    public void setSpecArende(int s, String a, String typ1,String typ2,String typ3)throws ClassNotFoundException, SQLException{
      
       Connection conn666=null;
       Statement stmt666=null;
      ResultSet rs32 =null;
      String sql66;
              
     
       try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
       conn666 = DriverManager.getConnection(jdbcUrl, USER, PASS);
          
          
       
          stmt666 = conn666.createStatement();
          switch (a){
              case "Nätverk":
          sql66 = "UPDATE Natverk SET Hastighet= '"+typ1+"'"+", Leverantor= '"+typ2+"'"+",Uppkopplingstyp= '"+typ3+"' "+ "WHERE natID ="+s;
                  
         
     
                  stmt666.executeUpdate(sql66);
            
                 System.out.println("Result");
          

    
                  break;
              case "Lagring":
                  sql66 = "UPDATE Lagring SET Marke= '"+typ1+"'"+", Typ= '"+typ2+"'"+",Åtgärd= '"+typ3+"' "+ "WHERE lagID ="+s;
                  
                 stmt666.executeUpdate(sql66);
                  
    
                  break;
                    
             case "Incident":
                  sql66 = "UPDATE Incident SET Handelse= '"+typ1+"'"+", Nivå= '"+typ2+"'"+",Åtgärd= '"+typ3+"' "+ "WHERE incID ="+s;
                 stmt666.executeUpdate(sql66);
                  

                  break;
              default:
                  break;
                  
       }
        
         

         stmt666.close();
         }catch(SQLException | ClassNotFoundException se){
       }finally{
      //finally block used to close resources
      try{
         if(stmt666!=null) {
             conn666.close();
         }
      }catch(SQLException se){
      }// do nothing
      if(conn666!=null) {
          conn666.close();
      }
   }//end try
      
  } // db spec
   }
      
 


    


