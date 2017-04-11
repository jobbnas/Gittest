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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
        JButton button = new JButton("Tryck här");
        button.setBounds(200, 300, 20, 100);
        
        JMenuBar hog = new JMenuBar();
        
        JMenu menyn = new JMenu("DO IT");
        JMenuItem item = new JMenuItem("Nike");
        menyn.add(item);
        
        add(hog);
        hog.setVisible(true);
        hog.add(menyn);
        add(button); // Lägger till knappar i ramen
        add(button2);
        add(pnllable);
        add(pnl);
        button.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
   JOptionPane.showMessageDialog(null, "Isak my brother", "Isak suger", JOptionPane.ERROR_MESSAGE);
  }
});
        
        item.addActionListener(new ActionListener()
{
  public void actionPerformed(ActionEvent e)
  {
   JFrame nikes = new JFrame();
   
        nikes.setVisible(true);
        nikes.setSize(500,500); // fönsterstorlek
        nikes.setResizable(false);
         // programmet slutar när man trycker på close
        nikes.setLayout(new FlowLayout()); // layout
  }
});
    }
    
    
}
