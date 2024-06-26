/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.marcusoliver.loan.tracker;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Carl Joshua
 */
public class CustomerBalance extends javax.swing.JFrame {
    
    private String borrowerName;
    private double totalDue;
    private double amountPaid;
    private double remainingAmount;
    private String datePaid;

    /**
     * Creates new form History
     */
    public CustomerBalance(){
        initComponents();
    }
    
    private void handleRowSelection(int selectedRow) {
    
    if (selectedRow == 0) { // Only handle the first row (index 0)
        String borrowerName = (String) jtblCustomerBalance.getValueAt(selectedRow, 0);
        double totalDue = (double) jtblCustomerBalance.getValueAt(selectedRow, 1);
        double amountPaid = (double) jtblCustomerBalance.getValueAt(selectedRow, 2);
        double remainingAmount = totalDue - amountPaid;

        JTextField inputField = new JTextField();
        inputField.setDocument(new javax.swing.text.PlainDocument() {
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws javax.swing.text.BadLocationException {
                if (str == null) {
                    return;
                }
                if (getLength() + str.length() > 10) {
                    return;
                }
                char[] chars = str.toCharArray();
                int count = 0;
                for (int i = 0; i < chars.length; i++) {
                    if ((chars[i] >= '0') && (chars[i] <= '9')) {
                        count++;
                    }
                }
                if (count < chars.length) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Please enter numeric digits only.");
                } else {
                    super.insertString(offs, str, a);
                }
            }
        });

        Object[] message = {"Enter the amount you want to pay:", inputField};
        int option = JOptionPane.showConfirmDialog(this, message, "Payment Input", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String input = inputField.getText();
            if (!input.isEmpty()) {
                try {
                    double paymentAmount = Double.parseDouble(input);
                    if (paymentAmount >= 0 && paymentAmount <= remainingAmount) {
                        amountPaid += paymentAmount;
                        remainingAmount = totalDue - amountPaid;
                        LocalDate currentDate = LocalDate.now();
                        String datePaid = currentDate.toString();

                        DefaultTableModel model = (DefaultTableModel) jtblCustomerBalance.getModel();
                        model.addRow(new Object[]{borrowerName, totalDue, paymentAmount, remainingAmount, datePaid});
                        jtblCustomerBalance.setValueAt(amountPaid, selectedRow, 2);
                        jtblCustomerBalance.setValueAt(remainingAmount, selectedRow, 3);
                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid input. Please enter an amount between 0 and the remaining balance.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
    
    private void updateRemainingBalance(double totalDue, double amountPaid, int startRow) {
    DefaultTableModel model = (DefaultTableModel) jtblCustomerBalance.getModel();
    int rowCount = model.getRowCount();
    for (int i = startRow; i < rowCount; i++) {
        double remainingAmount = totalDue - amountPaid;
        model.setValueAt(remainingAmount, i, 3);
    }
    
    
}
    
    public CustomerBalance(String borrowerName, double totalDue, double amountPaid, double remainingAmount, String datePaid) {
        initComponents();
        this.borrowerName = borrowerName;
        this.totalDue = totalDue;
        this.amountPaid = amountPaid;
        this.datePaid = datePaid;
        updateTable();
    }
     private void updateTable() {
            DefaultTableModel model = (DefaultTableModel) jtblCustomerBalance.getModel();
            model.addRow(new Object[]{borrowerName, totalDue, amountPaid, remainingAmount, datePaid});
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
        lbl_history = new javax.swing.JLabel();
        lbl_tip = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblCustomerBalance = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 10));

        btn_back.setBackground(new java.awt.Color(204, 204, 204));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        lbl_history.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_history.setText("Customer Balance");

        lbl_tip.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lbl_tip.setText("click on the first row to pay an amount");

        jtblCustomerBalance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Borrower's Name", "Total Due", "Amount Paid", "Balance Remaining", "Date of Payment"
            }
        ));
        jScrollPane1.setViewportView(jtblCustomerBalance);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbl_tip))
                            .addComponent(lbl_history)
                            .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_history)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_tip)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerBalance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerBalance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblCustomerBalance;
    private javax.swing.JLabel lbl_history;
    private javax.swing.JLabel lbl_tip;
    // End of variables declaration//GEN-END:variables
}
