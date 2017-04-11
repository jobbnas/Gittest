/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author mcbookpro
 */
public class Gittest2 extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    new Gittest2().setVisible(true);    
       


    }
    private Gittest2(){
        super("hey");
        setSize(1000,1000);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JButton button = new JButton("Jk");
        add(button);
        
    }
    
    
}
