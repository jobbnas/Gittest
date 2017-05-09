/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

/**
 *
 * @author mcbookpro
 */
public class Arende {

    public int getArande_id() {
        return arande_id;
    }

    public void setArande_id(int arande_id) {
        this.arande_id = arande_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTidsatgang() {
        return tidsatgang;
    }

    public void setTidsatgang(int tidsatgang) {
        this.tidsatgang = tidsatgang;
    }

    public int getPreTid() {
        return preTid;
    }

    public void setPreTid(int preTid) {
        this.preTid = preTid;
    }

    public int getTimPris() {
        return timPris;
    }

    public void setTimPris(int timPris) {
        this.timPris = timPris;
    }

    public String getArbetsuppgift() {
        return arbetsuppgift;
    }

    public void setArbetsuppgift(String arbetsuppgift) {
        this.arbetsuppgift = arbetsuppgift;
    }

    public String getKund_ID() {
        return Kund_ID;
    }

    public void setKund_ID(String Kund_ID) {
        this.Kund_ID = Kund_ID;
    }

    public String getUserNamne() {
        return userNamne;
    }

    public void setUserNamne(String userNamne) {
        this.userNamne = userNamne;
    }

    public String getKompId() {
        return kompId;
    }

    public void setKompId(String kompId) {
        this.kompId = kompId;
    }
    
     int arande_id;
     boolean status = true;
     int tidsatgang;
     int preTid;
     int timPris;
     String arbetsuppgift;
     String Kund_ID;
     String userNamne;
     String kompId;
    


    public Arende(int arande_id,int tidsatgang, int preTid,
            int timPris,String arbetsuppgift,String Kund_ID,String userNamne, String kompId){
        
        this.arande_id = arande_id;
        this.status = status;
        this.tidsatgang = tidsatgang;
        this.preTid = preTid;
        this.timPris = timPris;
        this.arbetsuppgift = arbetsuppgift;
        this.Kund_ID = Kund_ID;
        this.userNamne = userNamne;
        this.kompId = kompId;
        
    }
}
