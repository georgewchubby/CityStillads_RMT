/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Controller;
import domain.Order;

/**
 *
 * @author jekm
 */
public class DataSourceDemoFrame extends javax.swing.JFrame {

    /**
     * Creates new form DataSourceDemoFrame
     */
    private Controller c = new Controller();

    public DataSourceDemoFrame() {
        initComponents();
    }

    private void clearOrderFields() {
        jTextFieldOrderNo.setText("");
        jTextFieldCustomerNo.setText("");
        jTextFieldEmplNo.setText("");
        jTextFieldProductNo.setText("");
        jTextFieldQuantity.setText("");
        jTextAreaOrderDetails.setText("");
        jLabelStatus.setText("");
    }

    private void clearOrderDetailFields() {
        jTextFieldProductNo.setText("");
        jTextFieldQuantity.setText("");
        jLabelStatus.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelOrderNo = new javax.swing.JLabel();
        jLabelCustomerNo = new javax.swing.JLabel();
        jLabelEmployeeNo = new javax.swing.JLabel();
        jLabelOrderDetails = new javax.swing.JLabel();
        jLabelProductNo = new javax.swing.JLabel();
        jLabelQuantity = new javax.swing.JLabel();
        jTextFieldOrderNo = new javax.swing.JTextField();
        jTextFieldCustomerNo = new javax.swing.JTextField();
        jTextFieldEmplNo = new javax.swing.JTextField();
        jTextFieldProductNo = new javax.swing.JTextField();
        jTextFieldQuantity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaOrderDetails = new javax.swing.JTextArea();
        jButtonGetOrder = new javax.swing.JButton();
        jButtonNewOrder = new javax.swing.JButton();
        jButtonNewOrderdetail = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        jButtonUpdateOrder = new javax.swing.JButton();
        jButtonDeleteO = new javax.swing.JButton();
        jButtonUpdateDetails = new javax.swing.JButton();
        jButtonRemProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelOrderNo.setText("Order No");
        getContentPane().add(jLabelOrderNo);
        jLabelOrderNo.setBounds(20, 30, 114, 20);

        jLabelCustomerNo.setText("Customer No");
        getContentPane().add(jLabelCustomerNo);
        jLabelCustomerNo.setBounds(20, 60, 114, 20);

        jLabelEmployeeNo.setText("Employee No");
        getContentPane().add(jLabelEmployeeNo);
        jLabelEmployeeNo.setBounds(20, 90, 114, 20);

        jLabelOrderDetails.setText("Order Details");
        getContentPane().add(jLabelOrderDetails);
        jLabelOrderDetails.setBounds(20, 180, 114, 14);

        jLabelProductNo.setText("Product No");
        getContentPane().add(jLabelProductNo);
        jLabelProductNo.setBounds(22, 343, 114, 14);

        jLabelQuantity.setText("Quantity");
        getContentPane().add(jLabelQuantity);
        jLabelQuantity.setBounds(22, 382, 114, 14);

        jTextFieldOrderNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOrderNoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldOrderNo);
        jTextFieldOrderNo.setBounds(150, 30, 80, 20);
        getContentPane().add(jTextFieldCustomerNo);
        jTextFieldCustomerNo.setBounds(150, 60, 80, 20);
        getContentPane().add(jTextFieldEmplNo);
        jTextFieldEmplNo.setBounds(150, 90, 80, 20);
        getContentPane().add(jTextFieldProductNo);
        jTextFieldProductNo.setBounds(100, 340, 76, 20);
        getContentPane().add(jTextFieldQuantity);
        jTextFieldQuantity.setBounds(100, 380, 76, 20);

        jTextAreaOrderDetails.setColumns(20);
        jTextAreaOrderDetails.setRows(5);
        jScrollPane1.setViewportView(jTextAreaOrderDetails);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(22, 201, 287, 128);

        jButtonGetOrder.setText("Get Order");
        jButtonGetOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetOrderActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGetOrder);
        jButtonGetOrder.setBounds(310, 30, 100, 23);

        jButtonNewOrder.setText("New Order");
        jButtonNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewOrderActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNewOrder);
        jButtonNewOrder.setBounds(310, 60, 100, 23);

        jButtonNewOrderdetail.setText("New Order Detail");
        jButtonNewOrderdetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewOrderdetailActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNewOrderdetail);
        jButtonNewOrderdetail.setBounds(310, 340, 120, 23);
        getContentPane().add(jLabelStatus);
        jLabelStatus.setBounds(20, 150, 410, 20);

        jButtonUpdateOrder.setText("Update Order");
        jButtonUpdateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateOrderActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdateOrder);
        jButtonUpdateOrder.setBounds(310, 90, 100, 23);

        jButtonDeleteO.setText("Delete Order");
        jButtonDeleteO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDeleteO);
        jButtonDeleteO.setBounds(310, 120, 100, 23);

        jButtonUpdateDetails.setText("Update Details");
        jButtonUpdateDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdateDetails);
        jButtonUpdateDetails.setBounds(200, 340, 103, 23);

        jButtonRemProd.setText("Remove Product");
        jButtonRemProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemProdActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRemProd);
        jButtonRemProd.setBounds(200, 380, 230, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldOrderNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOrderNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOrderNoActionPerformed

    private void jButtonGetOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetOrderActionPerformed
        int ono = Integer.parseInt(jTextFieldOrderNo.getText());
        clearOrderFields();
        Order o = c.getOrder(ono);
        if (o != null) {
            jTextFieldOrderNo.setText(o.getOno() + "");
            jTextFieldCustomerNo.setText(o.getCustomerNo() + "");
            jTextFieldEmplNo.setText(o.getEmployeeNo() + "");
            jTextAreaOrderDetails.setText(c.getOrderDetailsToString() + "");
        } else {
            jLabelStatus.setText("No matching order!");
        }

    }//GEN-LAST:event_jButtonGetOrderActionPerformed

    private void jButtonNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewOrderActionPerformed
        int cno = Integer.parseInt(jTextFieldCustomerNo.getText());
        int eno = Integer.parseInt(jTextFieldEmplNo.getText());
        clearOrderFields();
        Order o = c.createNewOrder(cno, eno, null, null);
        if (o != null) {
            jTextFieldOrderNo.setText(o.getOno() + "");
            jTextFieldCustomerNo.setText(o.getCustomerNo() + "");
            jTextFieldEmplNo.setText(o.getEmployeeNo() + "");
            jLabelStatus.setText("New order created");
        } else {
            jLabelStatus.setText("No order created!");
        }
    }//GEN-LAST:event_jButtonNewOrderActionPerformed

    private void jButtonNewOrderdetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewOrderdetailActionPerformed
        int partNo = Integer.parseInt(jTextFieldProductNo.getText());
        int quantity = Integer.parseInt(jTextFieldQuantity.getText());
        clearOrderDetailFields();
        boolean status = c.addOrderDetail(partNo, quantity);
        if (status) {
            jTextAreaOrderDetails.setText(c.getOrderDetailsToString() + "");
            jLabelStatus.setText("Order detail inserted");
        } else {
            jLabelStatus.setText("Order detail not inserted");
        }
    }//GEN-LAST:event_jButtonNewOrderdetailActionPerformed

    private void jButtonUpdateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateOrderActionPerformed
        // TODO add your handling code here:
        Order tempO = new Order(Integer.parseInt(jTextFieldOrderNo.getText()),
                Integer.parseInt(jTextFieldCustomerNo.getText()),
                Integer.parseInt(jTextFieldEmplNo.getText()),null,null);
                boolean status = c.isOrderUpdated(tempO);
                
                if(status){
                    jLabelStatus.setText("Order Update sucessfull");
                }else {
            jLabelStatus.setText("Order Update NOT sucessfull");
            }
                
    }//GEN-LAST:event_jButtonUpdateOrderActionPerformed

    private void jButtonDeleteOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteOActionPerformed
        // TODO add your handling code here:
        boolean status = c.isOrderDeleted(Integer.parseInt(jTextFieldOrderNo.getText()));
        if(status){
                    jLabelStatus.setText("Order Delete sucessfull");
                }else {
            jLabelStatus.setText("Order Delete NOT sucessfull");
            }
    }//GEN-LAST:event_jButtonDeleteOActionPerformed

    private void jButtonUpdateDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateDetailsActionPerformed
        // TODO add your handling code here:
        boolean status = c.updateODetails(Integer.parseInt(jTextFieldOrderNo.getText()),
                         Integer.parseInt(jTextFieldProductNo.getText()),
                         Integer.parseInt(jTextFieldQuantity.getText()));
        if(status){
                    jLabelStatus.setText("Order Detail Update sucessfull");
                }else {
            jLabelStatus.setText("Order Detail Update NOT sucessfull");
            }
    }//GEN-LAST:event_jButtonUpdateDetailsActionPerformed

    private void jButtonRemProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemProdActionPerformed
        // TODO add your handling code here:
        boolean status = c.removePartFromOrder(Integer.parseInt(jTextFieldOrderNo.getText()),
                        Integer.parseInt(jTextFieldProductNo.getText()));
        if(status){
                    jLabelStatus.setText("Product Remove from Order sucessfull");
                }else {
            jLabelStatus.setText("Product Remove from Order NOT sucessfull");
            }
    }//GEN-LAST:event_jButtonRemProdActionPerformed
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
            java.util.logging.Logger.getLogger(DataSourceDemoFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSourceDemoFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSourceDemoFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSourceDemoFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSourceDemoFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteO;
    private javax.swing.JButton jButtonGetOrder;
    private javax.swing.JButton jButtonNewOrder;
    private javax.swing.JButton jButtonNewOrderdetail;
    private javax.swing.JButton jButtonRemProd;
    private javax.swing.JButton jButtonUpdateDetails;
    private javax.swing.JButton jButtonUpdateOrder;
    private javax.swing.JLabel jLabelCustomerNo;
    private javax.swing.JLabel jLabelEmployeeNo;
    private javax.swing.JLabel jLabelOrderDetails;
    private javax.swing.JLabel jLabelOrderNo;
    private javax.swing.JLabel jLabelProductNo;
    private javax.swing.JLabel jLabelQuantity;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaOrderDetails;
    private javax.swing.JTextField jTextFieldCustomerNo;
    private javax.swing.JTextField jTextFieldEmplNo;
    private javax.swing.JTextField jTextFieldOrderNo;
    private javax.swing.JTextField jTextFieldProductNo;
    private javax.swing.JTextField jTextFieldQuantity;
    // End of variables declaration//GEN-END:variables
}
