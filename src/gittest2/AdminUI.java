/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

import java.util.Scanner;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author El Rey
 */
public class AdminUI extends javax.swing.JFrame {

    
    boolean boolLäggTillP = false;

    public boolean isBoolLäggTillP() {
        return boolLäggTillP;
    }

    public void setBoolLäggTillP(boolean boolLäggTillP) {
        this.boolLäggTillP = boolLäggTillP;
    }
    
    
    public AdminUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Förnamn", "Efternamn", "Personnummer", "Adress", "Postnummer", "Ort", "Användarnamn", "Position", "Kompetens"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
        }

        jButton1.setText("Skapa Anställd");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Uppdatera Anställd");

        jButton3.setText("Tabort Anställd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(297, 297, 297))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      JTextField field1 = new JTextField(10), 
        field2 = new JTextField(10), 
        field3 = new JTextField(10), 
        field4 = new JTextField(10),
        field5 = new JTextField(10),
        field6 = new JTextField(10),
        field7 = new JTextField(10),
        field8 = new JTextField(10),
        field9 = new JTextField(10),
        field10 = new JTextField(10);

            JPanel myPanel = new JPanel();

            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

            myPanel.add(new JLabel("Förnamn:"));
            
            myPanel.add(field1);

            myPanel.add(Box.createHorizontalStrut(5));

            myPanel.add(new JLabel("Efternamn:"));
            
            myPanel.add(field2);

            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Personnummer:"));
            
            myPanel.add(field3);
            
            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Adress:"));
            
            myPanel.add(field4);
            
            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Ort:"));
            
            myPanel.add(field5);
            
            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Postnummer:"));
            
            myPanel.add(field6);
            
            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Användarnamn:"));
            
            myPanel.add(field7);
            
            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Position:"));
            
            myPanel.add(field8);

            myPanel.add(Box.createHorizontalStrut(5));
            myPanel.add(new JLabel("Kompetens:"));
            
            myPanel.add(field9);
            

            

            int result = JOptionPane.showConfirmDialog(null, myPanel, "Fyll i kunduppgifter:", 
            JOptionPane.OK_CANCEL_OPTION);
            
      String fNamn, eNamn, prnr,adr,or,pstnr,telnr;
      Scanner input = new Scanner(System.in);
    JFrame frame = new JFrame();
     
      int id =0;
      fNamn = field1.getText();
      eNamn = field2.getText();
      prnr  = field3.getText();
      adr  = field4.getText();
      or  = field5.getText();
      pstnr  = field6.getText();
      String anvNamn  = field7.getText();
     String position  = field8.getText();
    String  komp  = field9.getText();
    
    
        
        
        
        
       
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
