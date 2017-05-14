/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

/**
 *
 * @author El Rey
 */
public class Kommentar {
    
   int kommentarid;

   public int getKommentarid() {
        return kommentarid;
    }

   public void setKommentarid(int kommentarid) {
        this.kommentarid = kommentarid;
    }

   public String getDatum() {
        return datum;
    }

   public void setDatum(String datum) {
        this.datum = datum;
    }

   public String getUnderskrift() {
        return underskrift;
    }

   public void setUnderskrift(String underskrift) {
        this.underskrift = underskrift;
    }

   public String getKommentar() {
        return kommentar;
    }

   public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

   public int getArande_id() {
        return arande_id;
    }

   public void setArande_id(int arande_id) {
        this.arande_id = arande_id;
    }

   public String getUsername() {
        return username;
    }

   public void setUsername(String username) {
        this.username = username;
    }

   public boolean isOlast() {
        return olast;
    }

   public void setOlast(boolean olast) {
        this.olast = olast;
    }
    String datum;
    String underskrift;
    String kommentar;
    int arande_id;
    String username;
    boolean olast;
    
   
   public Kommentar(int id,String date,String under,String kommentar,int a_id,String user,boolean o){
        this.kommentarid = id;
        this.datum = date;
        this.underskrift = under;
        this.kommentar = kommentar;
        this.arande_id = a_id;
        this.username = user;
        this.olast = o;
        
       
   }
    
}
