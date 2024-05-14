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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcu
 */
public class PayLoan extends javax.swing.JFrame {

    private String filePath = "interest_data.txt";

    public PayLoan() {
        initComponents();
        loadLoanData();
    }

    public void loadLoanData() {
        DefaultTableModel model = (DefaultTableModel) jtblPayLoanTable.getModel();
    model.setRowCount(0);

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 6) {
                try {
                    String borrowerName = parts[0];
                    double amountRequested = Double.parseDouble(parts[1]);
                    String startDate = parts[2];
                    String endDate = parts[3];

                    double interestRate = Double.parseDouble(parts[4]);
                    double totalDue = Double.parseDouble(parts[5]);

                    
                    
                    

                    model.addRow(new Object[]{borrowerName, amountRequested, startDate, endDate, interestRate, totalDue, 0.0});
                    
                } catch (NumberFormatException e) {
                    System.out.println("Skipping line due to number format issue: " + line);
                }
            } else {
                System.out.println("Skipping line: " + line + " (Incorrect data format)");
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error loading interest data: " + e.getMessage());
    }
}
    private void saveTrackData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            DefaultTableModel model = (DefaultTableModel) jtblPayLoanTable.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                writer.write(model.getValueAt(i, 0) + ","
                        + model.getValueAt(i, 1) + ","
                        + model.getValueAt(i, 2) + ","
                        + model.getValueAt(i, 3) + ","
                        + model.getValueAt(i, 4) + ","
                        + model.getValueAt(i, 5) + ","
                        + model.getValueAt(i, 6));        // Amount Paid
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving track data: " + e.getMessage());
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
        lbl_payloan = new javax.swing.JLabel();
        lbl_tip = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPayLoanTable = new javax.swing.JTable();

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

        lbl_payloan.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_payloan.setText("Pay a Loan");

        lbl_tip.setText("Click a row to pay the balance of selected borrower");

        jtblPayLoanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Original Amount", "Start Date", "End Date/Paid ", "Interest (%)", "Total Due", "Amount Paid"
            }
        ));
        jtblPayLoanTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblPayLoanTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblPayLoanTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_tip))
                    .addComponent(lbl_payloan)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_payloan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_tip)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        AddATrack at = new AddATrack();
        at.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void jtblPayLoanTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblPayLoanTableMouseClicked
        int row = jtblPayLoanTable.getSelectedRow();
        if (row != -1) {
            String borrowerName = (String) jtblPayLoanTable.getValueAt(row, 0);
            double totalDue = (double) jtblPayLoanTable.getValueAt(row, 5);
            double currentAmountPaid = (double) jtblPayLoanTable.getValueAt(row, 6);

            // Prompt user to pay an amount
            String input = JOptionPane.showInputDialog("Enter amount to pay for " + borrowerName + ":");
            if (input != null && !input.isEmpty()) {
                double amountPaid = Double.parseDouble(input);

                // Calculate the remaining amount after payment
                double remainingAmount = totalDue - amountPaid;

                // Ensure the remaining amount doesn't become negative
                if (remainingAmount < 0) {
                    JOptionPane.showMessageDialog(this, "Amount paid exceeds the total due.");
                    return; // Exit the method without further processing
                }

                // Update the table with the correct values
                jtblPayLoanTable.setValueAt(remainingAmount, row, 5);
                jtblPayLoanTable.setValueAt(currentAmountPaid + amountPaid, row, 6);
                saveTrackData();
            }
        }
    }//GEN-LAST:event_jtblPayLoanTableMouseClicked

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
            java.util.logging.Logger.getLogger(PayLoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayLoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayLoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayLoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayLoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblPayLoanTable;
    private javax.swing.JLabel lbl_payloan;
    private javax.swing.JLabel lbl_tip;
    // End of variables declaration//GEN-END:variables
}
