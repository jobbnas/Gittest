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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTidsatgang() {
        return tidsatgang;
    }

    public void setTidsatgang(double tidsatgang) {
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

    public int getKund_ID() {
        return Kund_ID;
    }

    public void setKund_ID(int Kund_ID) {
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

    public void laggTillTid(double tid) {
        this.tidsatgang = this.tidsatgang + tid / 60;

    }

    public void setTidsatgangMinuter(int tidsatgang) {

        this.tidsatgang = tidsatgang / 60;
    }

    public void setTidsatgangTimmar(int timmar) {

        this.tidsatgang = this.tidsatgang + timmar;

    }

    int arande_id;
    
    String status;
    double tidsatgang;
    int preTid;
    int timPris;
    String arbetsuppgift;
    int Kund_ID;
    String userNamne;
    String kompId;

    public Arende(int arande_id, double tidsatgang, int preTid,
            int timPris, String arbetsuppgift, String userNamne, String kompId, String status, int Kund_ID) {

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
