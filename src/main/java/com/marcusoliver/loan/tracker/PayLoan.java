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
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcu
 */
public class PayLoan extends javax.swing.JFrame {

    String filePath = "interest_data.txt";
    /**
     * Creates new form PayLoan
     */
    public PayLoan() {
        initComponents();
        loadLoanData();
    }
    
    public void loadLoanData() {
        DefaultTableModel model = (DefaultTableModel) jtblPayLoanTable.getModel();
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
                    LocalDate dateStart = LocalDate.parse(startDate);
                    LocalDate dateEnd = LocalDate.parse(endDate);
                    
                    
                    // Calculate interest amount
                    double totalDue = amountRequested + (amountRequested * interestRate);

                    // Add the row to the table model
                    model.addRow(new Object[]{borrowerName, amountRequested, startDate, endDate, interestRate * 100, totalDue });
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
    
    private void saveTrackData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            DefaultTableModel model = (DefaultTableModel) jtblPayLoanTable.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                writer.write(model.getValueAt(i, 0) + "," + model.getValueAt(i, 1) + "," + model.getValueAt(i, 2) + "," + model.getValueAt(i, 3) + "," + model.getValueAt(i, 4) + "," + model.getValueAt(i, 5)); // Write loan type at index 4
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblPayLoanTable = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        lbl_payloan = new javax.swing.JLabel();
        lbl_tip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(jtblPayLoanTable);

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        lbl_payloan.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_payloan.setText("Pay a Loan");

        lbl_tip.setText("Click a row to pay the balance of selected borrower");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tip)
                    .addComponent(lbl_payloan)
                    .addComponent(btn_back))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_payloan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_tip)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        AddATrack at = new AddATrack();
        at.setExtendedState(JFrame.MAXIMIZED_BOTH);
        at.setLocationRelativeTo(null);
        at.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblPayLoanTable;
    private javax.swing.JLabel lbl_payloan;
    private javax.swing.JLabel lbl_tip;
    // End of variables declaration//GEN-END:variables
}
