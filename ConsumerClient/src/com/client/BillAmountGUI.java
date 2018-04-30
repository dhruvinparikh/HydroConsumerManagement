/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import com.model.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author imsil
 */
public class BillAmountGUI extends javax.swing.JPanel {

    /**
     * Creates new form BillAmountGUI
     */
    ObjectOutputStream outputObjectToServer = null;
    ObjectInputStream inputObjectFromServer = null;
    DataOutputStream outputDataToServer = null;
    DataInputStream inputDataFromServer = null;
    
    DefaultTableModel model = null;

    public BillAmountGUI() {
        initComponents();
        Object[] columns = {"Consumer Id", "First Name", "Last Name", "City", "Bill Amount", "Due Date"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        // set the model to the table
        consumerTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupBillAmount = new javax.swing.ButtonGroup();
        btnSave = new javax.swing.JButton();
        rbtnLessOrEqual = new javax.swing.JRadioButton();
        rbtnGreater = new javax.swing.JRadioButton();
        txtBillAmount = new javax.swing.JTextField();
        btnDsiplay = new javax.swing.JButton();
        btnCLear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consumerTable = new javax.swing.JTable();
        rbtnLess = new javax.swing.JRadioButton();
        rbtnEqual = new javax.swing.JRadioButton();
        rbtnGreaterOrEqual = new javax.swing.JRadioButton();

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnGroupBillAmount.add(rbtnLessOrEqual);
        rbtnLessOrEqual.setText("<=");
        rbtnLessOrEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnLessOrEqualActionPerformed(evt);
            }
        });

        btnGroupBillAmount.add(rbtnGreater);
        rbtnGreater.setSelected(true);
        rbtnGreater.setText(">");
        rbtnGreater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnGreaterActionPerformed(evt);
            }
        });

        txtBillAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                display(evt);
            }
        });

        btnDsiplay.setText("Display");
        btnDsiplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDsiplayActionPerformed(evt);
            }
        });

        btnCLear.setText("Clear");
        btnCLear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLearActionPerformed(evt);
            }
        });

        jLabel1.setText("Bill Amount :");

        consumerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(consumerTable);

        btnGroupBillAmount.add(rbtnLess);
        rbtnLess.setText("<");

        btnGroupBillAmount.add(rbtnEqual);
        rbtnEqual.setText("=");

        btnGroupBillAmount.add(rbtnGreaterOrEqual);
        rbtnGreaterOrEqual.setText(">=");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCLear)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(txtBillAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDsiplay)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnGreater)
                        .addGap(28, 28, 28)
                        .addComponent(rbtnLess)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(rbtnEqual)
                        .addGap(40, 40, 40)
                        .addComponent(rbtnGreaterOrEqual)
                        .addGap(37, 37, 37)
                        .addComponent(rbtnLessOrEqual)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnLessOrEqual)
                    .addComponent(rbtnGreaterOrEqual)
                    .addComponent(rbtnEqual)
                    .addComponent(rbtnLess)
                    .addComponent(rbtnGreater))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBillAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDsiplay)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCLear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnLessOrEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnLessOrEqualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnLessOrEqualActionPerformed

    private void rbtnGreaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnGreaterActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rbtnGreaterActionPerformed
    int chk = 0;
    String ba = "";
    private void btnDsiplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDsiplayActionPerformed
        // TODO add your handling code here:

        InitTable();
        ba = txtBillAmount.getText();

        try {
            outputObjectToServer = IOUtility.getObjectOutputStream();
            inputObjectFromServer = IOUtility.getObjectInputStream();
            outputDataToServer = IOUtility.getDataOutputStream();
            inputDataFromServer = IOUtility.getDataInputStream();
            outputDataToServer.writeInt(this.getChoice() + 1);
            outputDataToServer.flush();
            outputDataToServer.writeDouble(Double.parseDouble(txtBillAmount.getText()));
            outputDataToServer.flush();

            Object[][] row = CreateTable.getRow((List<Consumer>) inputObjectFromServer.readObject());
            if (row.length == 0) {
                throw new NoRecordException();
            }
            for (int i = 0; i < row.length; i++) {
                model.addRow(row[i]);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Empty field not allowed");
        } catch (NoRecordException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No such records found");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (UnableToConnectException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnDsiplayActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        List<Consumer> consumers = new ArrayList<>();

        int b = model.getRowCount();

        try {
            for (int i = b - 1; i >= 0; i--) {
                Consumer c = new Consumer();
                c.setConsumerID(Long.parseLong(model.getValueAt(i, 0).toString()));
                c.setFirstName(model.getValueAt(i, 1).toString());
                c.setLastName(model.getValueAt(i, 2).toString());
                c.setCity(model.getValueAt(i, 3).toString());
                c.setBillAmount(Double.parseDouble(model.getValueAt(i, 4).toString()));
                DateFormat df = new SimpleDateFormat("dd/MM/yy");
                c.setDueDate(df.parse(model.getValueAt(i, 5).toString()));
                consumers.add(c);
            }
            if (b < 1) {
                throw new UnableToSaveException();
            } else if (chk == 1) {
                SaveConsumerResults.saveRecords("BillAmount-GT-" + ba, consumers);
            } else if (chk == 2) {
                SaveConsumerResults.saveRecords("BillAmount-LE-" + ba, consumers);
            } else if (chk == 3) {
                SaveConsumerResults.saveRecords("BillAmount-GE-" + ba, consumers);
            } else if (chk == 4) {
                SaveConsumerResults.saveRecords("BillAmount-LT-" + ba, consumers);
            } else if (chk == 5) {
                SaveConsumerResults.saveRecords("BillAmount-E-" + ba, consumers);
            } else {
                throw new UnableToSaveException();
            }
            JOptionPane.showMessageDialog(null, "Result saved");
        } catch (ValidBillAmountException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (ValidNameException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (UnableToSaveException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCLearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLearActionPerformed
        // TODO add your handling code here:
        this.setTxtBillAmount("");
        this.InitTable();
    }//GEN-LAST:event_btnCLearActionPerformed

    private void display(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_display
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            btnDsiplayActionPerformed(null);
        }
    }//GEN-LAST:event_display

    public void setTxtBillAmount(String txtBillAmount) {
        this.txtBillAmount.setText(txtBillAmount);
    }

    public void InitTable() {
        int c = model.getRowCount();
        for (int i = c - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private int getChoice() {
        if (rbtnGreater.isSelected()) {
            chk = 1;
        } else if (rbtnLessOrEqual.isSelected()) {
            chk = 2;
        } else if (rbtnGreaterOrEqual.isSelected()) {
            chk = 3;
        } else if (rbtnLess.isSelected()) {
            chk = 4;
        } else if (rbtnEqual.isSelected()) {
            chk = 5;
        }
        return chk;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCLear;
    private javax.swing.JButton btnDsiplay;
    private javax.swing.ButtonGroup btnGroupBillAmount;
    private javax.swing.JButton btnSave;
    private javax.swing.JTable consumerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtnEqual;
    private javax.swing.JRadioButton rbtnGreater;
    private javax.swing.JRadioButton rbtnGreaterOrEqual;
    private javax.swing.JRadioButton rbtnLess;
    private javax.swing.JRadioButton rbtnLessOrEqual;
    private javax.swing.JTextField txtBillAmount;
    // End of variables declaration//GEN-END:variables
}