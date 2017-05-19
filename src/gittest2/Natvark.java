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
public class Natvark extends Arende {
    
    String natvarkstyp;
    String hastighet;
    String leverantör;

    public Natvark(int arande_id, double tidsatgang, int preTid, int timPris, String arbetsuppgift, String userNamne, String kompId, String status, int Kund_ID) {
        super(arande_id, tidsatgang, preTid, timPris, arbetsuppgift, userNamne, kompId, status, Kund_ID);
    }


    public String getNatvarkstyp() {
        return natvarkstyp;
    }

    public String getHastighet() {
        return hastighet;
    }

    public String getLeverantör() {
        return leverantör;
    }
    
    

    
   
}
   

