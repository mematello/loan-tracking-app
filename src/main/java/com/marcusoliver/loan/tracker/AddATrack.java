/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.marcusoliver.loan.tracker;
import javax.swing.JFrame;
/**
 *
 * @author marcu
 */
public class AddATrack extends javax.swing.JFrame {

    /**
     * Creates new form AddATrack
     */
    public AddATrack() {
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

        jLabel1 = new javax.swing.JLabel();
        jbtnAddLoan = new javax.swing.JButton();
        jbtnTrackPayment = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Loan Tracker");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 180, 300, 64);

        jbtnAddLoan.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jbtnAddLoan.setText("Add a loan");
        jbtnAddLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddLoanActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnAddLoan);
        jbtnAddLoan.setBounds(370, 310, 230, 55);

        jbtnTrackPayment.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jbtnTrackPayment.setText("Track a Payment");
        jbtnTrackPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTrackPaymentActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnTrackPayment);
        jbtnTrackPayment.setBounds(620, 310, 290, 55);

        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 10, 90, 30);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jButton2.setText("Track an Interest");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(620, 370, 290, 60);

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton3.setText("Pay a Loan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(370, 370, 230, 60);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 0, 1280, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        InterestTrack it = new InterestTrack();
        // Set the size of the JFrame to match the screen dimensions
        it.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Center the JFrame on the screen
        it.setLocationRelativeTo(null);

        // Make the JFrame visible
        it.setVisible(true);
        it.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UserInfo ui = new UserInfo();
        ui.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        UserInfo ui = new UserInfo();
        ui.show();
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jbtnTrackPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTrackPaymentActionPerformed

    TrackAPayment tp = new  TrackAPayment();
    // Set the size of the JFrame to match the screen dimensions
    tp.setExtendedState(JFrame.MAXIMIZED_BOTH);

    // Center the JFrame on the screen
    tp.setLocationRelativeTo(null);

    // Make the JFrame visible
    tp.setVisible(true);
    tp.setVisible(true);
    dispose();
    }//GEN-LAST:event_jbtnTrackPaymentActionPerformed

    private void jbtnAddLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddLoanActionPerformed
        // Create an instance of AddALoan
    AddALoan al = new AddALoan();

    // Set the size of the JFrame to match the screen dimensions
    al.setExtendedState(JFrame.MAXIMIZED_BOTH);

    // Center the JFrame on the screen
    al.setLocationRelativeTo(null);

    // Make the JFrame visible
    al.setVisible(true);

    // Close the current frame
    dispose();
    }//GEN-LAST:event_jbtnAddLoanActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PayLoan pl = new PayLoan();
        pl.setExtendedState(JFrame.MAXIMIZED_BOTH);
        pl.setLocationRelativeTo(null);
        pl.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(AddATrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddATrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddATrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddATrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddATrack at = new AddATrack();
                // Set the size of the JFrame to match the screen dimensions
                at.setExtendedState(JFrame.MAXIMIZED_BOTH);
                at.setLocationRelativeTo(null); // Center the JFrame on the screen
                at.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnAddLoan;
    private javax.swing.JButton jbtnTrackPayment;
    // End of variables declaration//GEN-END:variables
}
