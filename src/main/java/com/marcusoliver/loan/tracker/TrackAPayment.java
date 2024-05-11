/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.marcusoliver.loan.tracker;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcu
 */
public class TrackAPayment extends javax.swing.JFrame {
    
    private String filePath = "loan_data.txt";

    public TrackAPayment() {
        initComponents();
        loadLoanData();
    }

    private void loadLoanData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        DefaultTableModel model = (DefaultTableModel) jtblTrackPayment.getModel();
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 5) { // Check if the line has at least 5 elements
                model.addRow(new Object[]{parts[0], Double.parseDouble(parts[1]), parts[2], parts[3], parts[4]});
            } else {
                // Handle the case where the line has fewer than 5 elements
                // You can choose to skip the line, log an error, or take any other appropriate action
                System.out.println("Skipping line: " + line + " (Incorrect data format)");
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error loading loan data: " + e.getMessage());
    }
    }

    private void saveLoanData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            DefaultTableModel model = (DefaultTableModel) jtblTrackPayment.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                writer.write(model.getValueAt(i, 0) + "," + model.getValueAt(i, 1) + "," + model.getValueAt(i, 2) + "," + model.getValueAt(i, 3) + "," + model.getValueAt(i, 4)); // Write loan type at index 4
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving loan data: " + e.getMessage());
        }
    }

    public void updateTable(String borrowerName, double amountRequested, String dueDate, String loanType) {
        DefaultTableModel model = (DefaultTableModel) jtblTrackPayment.getModel();
        model.addRow(new Object[]{borrowerName, amountRequested, dueDate, "Unpaid", loanType});
        saveLoanData();
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
        jLabel2 = new javax.swing.JLabel();
        jbtnName = new javax.swing.JButton();
        jbtnAmountRequested = new javax.swing.JButton();
        jbtnDate = new javax.swing.JButton();
        jbtnStatus = new javax.swing.JButton();
        jbtnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblTrackPayment = new javax.swing.JTable();
        loanType = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Track a Payment");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Sort By:");

        jbtnName.setText("Name");
        jbtnName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNameActionPerformed(evt);
            }
        });

        jbtnAmountRequested.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jbtnAmountRequested.setText("Amount Request");
        jbtnAmountRequested.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAmountRequestedActionPerformed(evt);
            }
        });

        jbtnDate.setText("Date");
        jbtnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDateActionPerformed(evt);
            }
        });

        jbtnStatus.setText("Status");
        jbtnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnStatusActionPerformed(evt);
            }
        });

        jbtnBack.setText("Back");
        jbtnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnBackMouseClicked(evt);
            }
        });
        jbtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBackActionPerformed(evt);
            }
        });

        jtblTrackPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Borrower's Name", "Amount Requested", "Due", "Status", "Type of Loan"
            }
        ));
        jtblTrackPayment.getTableHeader().setReorderingAllowed(false);
        jtblTrackPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblTrackPaymentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtblTrackPayment);

        loanType.setText("Type of Loan");
        loanType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnBack)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(410, 410, 410)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnAmountRequested, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loanType, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnBack)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtnAmountRequested, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbtnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(loanType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNameActionPerformed
        // TODO add your handling code here:
         // Extracting the data from the table
        DefaultTableModel model = (DefaultTableModel) jtblTrackPayment.getModel();
        int rowCount = model.getRowCount();
        String[][] data = new String[rowCount][5];

        for (int i = 0; i < rowCount; i++) {
            data[i][0] = model.getValueAt(i, 0).toString(); // Borrower's Name
            data[i][1] = model.getValueAt(i, 1).toString(); // Amount Requested
            data[i][2] = model.getValueAt(i, 2).toString(); // Due Date
            data[i][3] = model.getValueAt(i, 3).toString(); // Status
            data[i][4] = model.getValueAt(i, 4).toString(); // Loan 
        }

        // Sort the data based on Borrower's Name using merge sort
        mergeSort(data, 0, rowCount - 1);

        // Updating the table with the sorted data
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < 5; j++) {
                model.setValueAt(data[i][j], i, j);
            }
        }
    }//GEN-LAST:event_jbtnNameActionPerformed

    private void jbtnAmountRequestedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAmountRequestedActionPerformed
        // Extracting the data from the table
        DefaultTableModel model = (DefaultTableModel) jtblTrackPayment.getModel();
        int rowCount = model.getRowCount();
        String[][] data = new String[rowCount][5]; // Assuming 5 columns

        for (int i = 0; i < rowCount; i++) {
            data[i][0] = model.getValueAt(i, 0).toString(); // Borrower's Name
            data[i][1] = model.getValueAt(i, 1).toString(); // Amount Requested
            data[i][2] = model.getValueAt(i, 2).toString(); // Due Date
            data[i][3] = model.getValueAt(i, 3).toString(); // Status
            data[i][4] = model.getValueAt(i, 4).toString(); // Loan Type
        }

        // Sorting the data based on Amount Requested using Insertion Sort
        for (int i = 1; i < rowCount; i++) {
            String[] key = data[i];
            int j = i - 1;

            // Compare Amount Requested
            while (j >= 0 && Double.parseDouble(data[j][1]) > Double.parseDouble(key[1])) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }

        // Updating the table with the sorted data
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < 5; j++) {
                model.setValueAt(data[i][j], i, j);
            }
        }
    }//GEN-LAST:event_jbtnAmountRequestedActionPerformed

    private void jbtnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDateActionPerformed
        // Extracting the data from the table
        DefaultTableModel model = (DefaultTableModel) jtblTrackPayment.getModel();
        int rowCount = model.getRowCount();
        Object[][] data = new Object[rowCount][5]; // Assuming 5 columns

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < 5; j++) {
                data[i][j] = model.getValueAt(i, j);
            }
        }

        // Sorting the data based on the date column using Arrays.sort method
        Arrays.sort(data, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] row1, Object[] row2) {
                String date1 = (String) row1[2]; // Assuming date is at index 2
                String date2 = (String) row2[2]; // Assuming date is at index 2
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd", Locale.ENGLISH);
                try {
                    return sdf.parse(date1).compareTo(sdf.parse(date2));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    return 0;
                }
            }
        });

        // Updating the table with the sorted data
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < 5; j++) {
                model.setValueAt(data[i][j], i, j);
            }
        }
    }//GEN-LAST:event_jbtnDateActionPerformed

    Boolean unpaidFirst = false;
    private void jbtnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnStatusActionPerformed
        // Get the table model
        DefaultTableModel model = (DefaultTableModel) jtblTrackPayment.getModel();

        // Create lists to hold rows with Unpaid and Paid statuses
        ArrayList<Object[]> unpaidRows = new ArrayList<>();
        ArrayList<Object[]> paidRows = new ArrayList<>();

        // Iterate through the table data and categorize rows by status
        for (int i = 0; i < model.getRowCount(); i++) {
            String status = (String) model.getValueAt(i, 3); // Assuming status is at index 3
            Object[] row = new Object[5]; // Assuming 5 columns
            for (int j = 0; j < 5; j++) {
                row[j] = model.getValueAt(i, j);
            }
            if (status.equals("Unpaid")) {
                unpaidRows.add(row);
            } else if (status.equals("Paid")) {
                paidRows.add(row);
            }
        }

        // Clear the table model
        model.setRowCount(0);

        // Toggle between Unpaid and Paid sorting with each click
        if (unpaidFirst) {
            // Sort and add Unpaid rows first
            for (Object[] row : unpaidRows) {
                model.addRow(row);
            }
            for (Object[] row : paidRows) {
                model.addRow(row);
            }
            unpaidFirst = false;
        } else {
            // Sort and add Paid rows first
            for (Object[] row : paidRows) {
                model.addRow(row);
            }
            for (Object[] row : unpaidRows) {
                model.addRow(row);
            }
            unpaidFirst = true;
        }
    }//GEN-LAST:event_jbtnStatusActionPerformed

    private Object[] getRowData(DefaultTableModel model, int rowIndex) {
        Object[] rowData = new Object[model.getColumnCount()];
        for (int i = 0; i < model.getColumnCount(); i++) {
            rowData[i] = model.getValueAt(rowIndex, i);
        }
        return rowData;
    }
    private void jbtnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnBackMouseClicked
        AddATrack at = new AddATrack();
        dispose();
    }//GEN-LAST:event_jbtnBackMouseClicked

    private void jbtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBackActionPerformed
        AddATrack at = new AddATrack();
        at.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_jbtnBackActionPerformed

    private void jtblTrackPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblTrackPaymentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtblTrackPaymentMouseClicked
    
    private boolean ascendingOrder = true; // Flag to track sorting order
    private String previousSortedLoanType = ""; // Track the previously sorted loan type
    
    private void loanTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loanTypeActionPerformed
        // Extracting the data from the table
        DefaultTableModel model = (DefaultTableModel) jtblTrackPayment.getModel();
        int rowCount = model.getRowCount();
        String[][] data = new String[rowCount][5]; // Assuming 5 columns

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < 5; j++) {
                data[i][j] = model.getValueAt(i, j).toString(); // Assuming loan type is at index 4
            }
        }

        // Sorting the data based on loan type
        Arrays.sort(data, new Comparator<String[]>() {
            @Override
            public int compare(String[] row1, String[] row2) {
                String loanType1 = row1[4]; // Assuming loan type is at index 4
                String loanType2 = row2[4]; // Assuming loan type is at index 4
                if (!loanType1.equals(loanType2)) {
                    // If loan types are different, return comparison result
                    previousSortedLoanType = loanType1; // Update the previous sorted loan type
                    return ascendingOrder ? loanType1.compareTo(loanType2) : loanType2.compareTo(loanType1);
                } else {
                    // If loan types are the same, sort by previously sorted loan type
                    return previousSortedLoanType.compareTo(loanType1);
                }
            }
        });

        // Updating the table with the sorted data
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < 5; j++) {
                model.setValueAt(data[i][j], i, j);
            }
        }

        // Toggle sorting order for next click
        ascendingOrder = !ascendingOrder;
    }//GEN-LAST:event_loanTypeActionPerformed
    private void mergeSort(String[][] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(String[][] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        String[][] L = new String[n1][4];
        String[][] R = new String[n2][4];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i][0].compareTo(R[j][0]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
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
            java.util.logging.Logger.getLogger(TrackAPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackAPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackAPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackAPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TrackAPayment trackAPayment = new TrackAPayment();
                trackAPayment.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnAmountRequested;
    private javax.swing.JButton jbtnBack;
    private javax.swing.JButton jbtnDate;
    private javax.swing.JButton jbtnName;
    private javax.swing.JButton jbtnStatus;
    private javax.swing.JTable jtblTrackPayment;
    private javax.swing.JButton loanType;
    // End of variables declaration//GEN-END:variables
}
