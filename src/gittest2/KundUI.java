/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gittest2;

//ayhshs
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author El Rey
 */
public  class KundUI extends javax.swing.JFrame {
Scanner input = new Scanner(System.in);
File icon = new File("C:\\Users\\El Rey\\Desktop\\Skola\\reload-icon-blue-symbol-circle-arrows-refresh-update_f"); 

   DB db = new DB();
   public ArrayList<Kund> lista;
   int pung;
   
    public KundUI() throws ClassNotFoundException, SQLException {
        initComponents();
        
     
        
    }
    
    public void Visa_Kund() throws ClassNotFoundException, SQLException{
        
        
        
        DefaultTableModel mode = (DefaultTableModel)JTable_KundLista.getModel();
        Object[] row = new Object[8];
        for(int i=0; i<lista.size();i++){
            
            
            row[0]=lista.get(i).getfNamn();
            row[1]=lista.get(i).geteNamn();
            row[2]=lista.get(i).getPerNr();
            row[3]=lista.get(i).getAdress();
            row[4]=lista.get(i).getOrt();
            row[5]=lista.get(i).getPostNr();
            row[6]=lista.get(i).getTelNr();
            row[7]=lista.get(i).getKund_id();
            mode.addRow(row);
            
           
            
        }
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_KundLista = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        scrollbar1 = new java.awt.Scrollbar();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTable_KundLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Förnamn", "Efternamn", "Personnummer", "Adress", "Ort", "Postnummer", "Telefonnummer", "Kund_Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable_KundLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_KundListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_KundLista);

        jButton1.setText("Skapa Kund");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ändra Kund");

        jButton3.setText("Tabort Kund");

        jButton4.setText("Sök Kund");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Uppdatera");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(70, 70, 70)
                        .addComponent(jButton2)
                        .addGap(46, 46, 46)
                        .addComponent(jButton3)
                        .addGap(64, 64, 64)
                        .addComponent(jButton4)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
      String fNamn, eNamn, prnr,adr,or,pstnr,telnr;
      Scanner input = new Scanner(System.in);
    JFrame frame = new JFrame();
     
      int id =0;
      fNamn = JOptionPane.showInputDialog(frame, "Skriv in Kundens namn");
      eNamn = JOptionPane.showInputDialog(frame, "Skriv in Kundens efternamn");
      prnr  = JOptionPane.showInputDialog(frame, "SKriv in Kundens personnummer");
      adr  = JOptionPane.showInputDialog(frame, "SKriv in Kundens adress");
      or  = JOptionPane.showInputDialog(frame, "Skriv in Kundens ort");
      pstnr  = JOptionPane.showInputDialog(frame, "SKriv in Kundens postnummer");
      telnr  = JOptionPane.showInputDialog(frame, "SKriv in Kundens telefonnummer");
      
       Kund k = new Kund(id,fNamn, eNamn, prnr,adr,or,pstnr,telnr);
        k.laggTillKund();
       
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        db.SökKund();
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void JTable_KundListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_KundListaMouseClicked
      JTable_KundLista.addMouseListener(new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getClickCount() == 2) {
      JTable target = (JTable)e.getSource();
      int row = target.getSelectedRow();
            int column = target.getColumnCount();
      
      for(int i = 1; i<=column; i++){

          if(JTable_KundLista.getModel().getColumnName(i).equalsIgnoreCase("Kund_Id")){
             
           
              
             pung = ((Integer) JTable_KundLista.getModel().getValueAt(row, i));
             
             System.out.println(pung);
          }
      }
      
      System.out.println("Hejhgdsjfkladkfjklsafj");
      
      // do some action if appropriate column
    }
  }
});
        
        
        
        
    }//GEN-LAST:event_JTable_KundListaMouseClicked

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
            java.util.logging.Logger.getLogger(KundUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KundUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KundUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KundUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new KundUI().setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(KundUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable_KundLista;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Scrollbar scrollbar1;
    // End of variables declaration//GEN-END:variables
}
