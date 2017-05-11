/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

import java.util.ArrayList;

/**
 *
 * @author El Rey
 */
public class IT_Support extends Personal {
    
    String något;
    int hour;
    int minutes;
    
    private ArrayList<Kompetens>kompetenslista = new ArrayList<>();
    
    
    void addKompetens (Kompetens k){
        
        kompetenslista.add(k);
        
        
        
    }
    
    
    
    
}
