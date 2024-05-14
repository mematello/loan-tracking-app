/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.marcusoliver.loan.tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.*; 

/**
 *
 * @author marcu
 */
public class InterestTrack extends javax.swing.JFrame {
    

    private String filePath = "interest_data.txt";
    /**
     * Creates new form InterestTrack
     */
    public InterestTrack() {
        initComponents();
        loadLoanData();
    }
    
    
    private void loadLoanData() {
        DefaultTableModel model = (DefaultTableModel) jtblInterestTrack.getModel();
        model.setRowCount(0); // Reset the row count to remove existing rows

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) { // Check if the line has at least 5 elements
                    String borrowerName = parts[0];
                    double amountRequested = Double.parseDouble(parts[1]);
                    String startDate = parts[2]; // Blank start date
                    String endDate = parts[3]; // End date or paid date
                    String loanType = parts[4];
                    double interestRate = 0.0; // Default interest rate

                    // Determine interest rate based on loan type
                    switch (loanType) {
                        case "Education Loan":
                        case "1.0":
                            interestRate = 0.01; // 1%
                            break;
                        case "House Loan":
                        case "2.0":
                            interestRate = 0.02; // 2%
                            break;
                        case "Business Loan":
                        case "3.0":
                            interestRate = 0.03; // 3%
                            break;
                        case "Car Loan":
                        case "4.0":
                            interestRate = 0.04; // 4%
                            break;
                        default:
                            break;
                    }
                    
                    // Calculate interest amount
                    double totalDue = amountRequested + (amountRequested * interestRate);

                    // Add the row to the table model
                    model.addRow(new Object[]{borrowerName, amountRequested, startDate, endDate, interestRate * 100,totalDue });
                    saveTrackData();
                } else {
                    // Handle the case where the line has fewer than 5 elements
                    // You can choose to skip the line, log an error, or take any other appropriate action
                    System.out.println("Skipping line: " + line + " (Incorrect data format)");
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading interest data: " + e.getMessage());
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_back = new javax.swing.JButton();
        lbl_trackInt = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblInterestTrack = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 10));

        btn_back.setBackground(new java.awt.Color(204, 204, 204));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        lbl_trackInt.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_trackInt.setText("Tracking Interests");

        jtblInterestTrack.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Original Amount", "Start Date", "End Date/Paid ", "Interest (%)", "Total Due"
            }
        ));
        jScrollPane1.setViewportView(jtblInterestTrack);

        jLabel1.setText("You can find Interest and Total Due of the loan here!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_trackInt, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_trackInt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        AddATrack at = new AddATrack();
        at.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

        private void saveTrackData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            DefaultTableModel model = (DefaultTableModel) jtblInterestTrack.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                writer.write(model.getValueAt(i, 0) + "," + model.getValueAt(i, 1) + "," + 
                        model.getValueAt(i, 2) + "," + model.getValueAt(i, 3) + "," + 
                        model.getValueAt(i, 4) + "," + model.getValueAt(i, 5)); // Write loan type at index 4
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving track data: " + e.getMessage());
        }
    }

    
    public void updateTable(String borrowerName, double amountRequested,String startDate, String endDate, String loanType) {
        DefaultTableModel model = (DefaultTableModel) jtblInterestTrack.getModel();
        model.addRow(new Object[]{borrowerName, amountRequested, startDate, endDate, loanType});
        saveTrackData();
    }
    public void saveIntRate(double interestRate){
        
    }
    
    
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
            java.util.logging.Logger.getLogger(InterestTrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterestTrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterestTrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterestTrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterestTrack().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblInterestTrack;
    private javax.swing.JLabel lbl_trackInt;
    // End of variables declaration//GEN-END:variables
}
