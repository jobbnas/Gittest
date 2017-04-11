/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Panel;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author mcbookpro
 */
public class Gittest2 extends JFrame { // extends betyder att Gittest ärver allt som ingår  JFrame. extend ska vi använda till sub/superclasser
    
    private static final long serialVersionUID = 1L;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    new Gittest2().setVisible(true);    
    
      


    }
    private Gittest2(){
        super("Welcome");
        setSize(1000,1000); // fönsterstorlek
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // programmet slutar när man trycker på close
        setLayout(new FlowLayout()); // layout
        
        
        
        JPanel pnl = new JPanel(); // schysst panel med bild
        JLabel pnllable = new JLabel(new ImageIcon("/Users/mcbookpro/Downloads/dj-artist-dixon.jpg")); // här kan du lägga till bakrund
        pnl.setVisible(true); // synlighet
        pnl.setLocation(500, 500); // panelen placering
        pnl.setLayout(new GridBagLayout());
        JButton button2 = new JButton("Test"); //knappar
        JButton button = new JButton("Jk");
        button.setBounds(200, 300, 20, 100);
        add(button); // Lägger till knappar i ramen
        add(button2);
        add(pnllable);
        add(pnl);
        
    }
    
    
}
