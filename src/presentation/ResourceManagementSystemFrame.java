/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.PartController;
import domain.Part;
import domain.Vogn;
import domain.VognController;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.text.PlainDocument;

/**
 *
 * @author joachim
 */
public class ResourceManagementSystemFrame extends javax.swing.JFrame {

    /**
     * Creates new form ResourceManagementSystemFrame
     */
    private final PartController pc = new PartController();
    private final VognController vc = new VognController();

    public ResourceManagementSystemFrame() {
        initComponents();

        ListSelectionModel listSelectionModelParts = jTableParts.getSelectionModel();
        ListSelectionModel listSelectionModelVogne = jTableVogne.getSelectionModel();
        listSelectionModelParts.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                jButtonUpdatePart.setEnabled(!lsm.isSelectionEmpty());
                jButtonUpdateQty.setEnabled(!lsm.isSelectionEmpty());
                jButtonDeletePart.setEnabled(!lsm.isSelectionEmpty());
            }
        });
        listSelectionModelVogne.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm2 = (ListSelectionModel) e.getSource();
                jButtonDeleteVogn.setEnabled(!lsm2.isSelectionEmpty());
                jButtonUpdateVogn.setEnabled(!lsm2.isSelectionEmpty());
            }
        });
    }

    class MyIntFilter extends DocumentFilter {

        @Override
        public void insertString(FilterBypass fb, int offset, String string,
                AttributeSet attr) throws BadLocationException {

            Document doc = fb.getDocument();
            StringBuilder sb = new StringBuilder();
            sb.append(doc.getText(0, doc.getLength()));
            sb.insert(offset, string);

            if (test(sb.toString())) {
                super.insertString(fb, offset, string, attr);
            } else {
                // warn the user and don't allow the insert
            }
        }

        private boolean test(String text) {
            try {
                Integer.parseInt(text);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    private void clearPartNewFields() {
        jTextFieldNewPartNo.setText("");
        jTextFieldNewPartName.setText("");
        jTextFieldNewPartQuantity.setText("");
        jTextFieldNewPartDescription.setText("");
        jLabelSaved.setText("");
    }

    private void clearPartUpdateFields() {
        jTextFieldUpdatePartNo.setText("");
        jTextFieldUpdatePartName.setText("");
        jTextFieldUpdatePartDescription.setText("");
        jLabelUpdated.setText("");
    }

    private void clearPartUpdateQtyFields() {
        jTextFieldUpdateQtyNo.setText("");
        jTextFieldUpdateQtyName.setText("");
        jTextFieldUpdateQtyQty.setText("");
        jLabelQty.setText("");
    }

    private void clearPartDeleteFields() {
        jTextFieldDeletePartNo.setText("");
        jTextFieldDeletePartName.setText("");
        jTextFieldDeletePartQuantity.setText("");
        jTextFieldDeletePartDescription.setText("");
        jLabelDeleted.setText("");
    }

    private void clearVognUpdateFields() {
        jTextFieldVognUpdateNo.setText("");
        jTextFieldVognUpdateOno.setText("");
        jTextFieldVognUpdateResFrom.setText("");
        jTextFieldVognUpdateResUntil.setText("");
        jComboBoxVognUpdateStatus.setSelectedIndex(0);
        jComboBoxVognUpdateType.setSelectedIndex(0);
        jCheckBoxOno.setSelected(false);
        jCheckBoxStatus.setSelected(false);
        jCheckBoxResFrom.setSelected(false);
        jCheckBoxResUntil.setSelected(false);
    }

    private void clearVognDeleteFields() {
        jTextFieldVognDeleteNo.setText("");
        jTextFieldVognDeleteOno.setText("");
        jTextFieldVognDeleteResFrom.setText("");
        jTextFieldVognDeleteResUntil.setText("");
        jComboBoxVognDeleteStatus.setSelectedIndex(0);
        jComboBoxVognDeleteType.setSelectedIndex(0);
        jLabelVognDeleted.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameNewPart = new javax.swing.JFrame();
        jPanelNewPart = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNewPartNo = new javax.swing.JTextField();
        jTextFieldNewPartName = new javax.swing.JTextField();
        jTextFieldNewPartQuantity = new javax.swing.JTextField();
        jTextFieldNewPartDescription = new javax.swing.JTextField();
        jButtonSavePart = new javax.swing.JButton();
        jButtonNewPartBack = new javax.swing.JButton();
        jLabelSaved = new javax.swing.JLabel();
        jFrameUpdatePart = new javax.swing.JFrame();
        jPanelUpdatePart = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldUpdatePartNo = new javax.swing.JTextField();
        jTextFieldUpdatePartName = new javax.swing.JTextField();
        jTextFieldUpdatePartDescription = new javax.swing.JTextField();
        jButtonUpdatePartUpdate = new javax.swing.JButton();
        jButtonUpdatePartBack = new javax.swing.JButton();
        jLabelUpdated = new javax.swing.JLabel();
        jFrameUpdateQty = new javax.swing.JFrame();
        jPanelUpdateQty = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldUpdateQtyNo = new javax.swing.JTextField();
        jTextFieldUpdateQtyName = new javax.swing.JTextField();
        jTextFieldUpdateQtyQty = new javax.swing.JTextField();
        jButtonUpdateQtyUpdate = new javax.swing.JButton();
        jButtonUpdateQtyBack = new javax.swing.JButton();
        jLabelQty = new javax.swing.JLabel();
        jFrameDeletePart = new javax.swing.JFrame();
        jPanelDeletePart = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldDeletePartNo = new javax.swing.JTextField();
        jTextFieldDeletePartName = new javax.swing.JTextField();
        jTextFieldDeletePartQuantity = new javax.swing.JTextField();
        jTextFieldDeletePartDescription = new javax.swing.JTextField();
        jButtonDeletePartDelete = new javax.swing.JButton();
        jButtonDeletePartBack = new javax.swing.JButton();
        jLabelDeleted = new javax.swing.JLabel();
        jFrameNewVogn = new javax.swing.JFrame();
        jPanelNewVogn = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextFieldVognNewNo = new javax.swing.JTextField();
        jTextFieldVognNewOno = new javax.swing.JTextField();
        jButtonSaveVogn = new javax.swing.JButton();
        jButtonNewVognBack = new javax.swing.JButton();
        jLabelSavedVogn = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextFieldVognNewResFrom = new javax.swing.JTextField();
        jTextFieldVognNewResUntil = new javax.swing.JTextField();
        jComboBoxVognNewStatus = new javax.swing.JComboBox();
        jComboBoxVognNewType = new javax.swing.JComboBox();
        jFrameUpdateVogn = new javax.swing.JFrame();
        jPanelUpdateVogn = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextFieldVognUpdateNo = new javax.swing.JTextField();
        jTextFieldVognUpdateOno = new javax.swing.JTextField();
        jButtonVognUpdateBack = new javax.swing.JButton();
        jLabelVognUpdated = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextFieldVognUpdateResFrom = new javax.swing.JTextField();
        jTextFieldVognUpdateResUntil = new javax.swing.JTextField();
        jComboBoxVognUpdateStatus = new javax.swing.JComboBox();
        jComboBoxVognUpdateType = new javax.swing.JComboBox();
        jCheckBoxStatus = new javax.swing.JCheckBox();
        jCheckBoxOno = new javax.swing.JCheckBox();
        jCheckBoxResFrom = new javax.swing.JCheckBox();
        jCheckBoxResUntil = new javax.swing.JCheckBox();
        jButtonVognUpdate = new javax.swing.JButton();
        jFrameDeleteVogn = new javax.swing.JFrame();
        jPanelDeleteVogn = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextFieldVognDeleteNo = new javax.swing.JTextField();
        jTextFieldVognDeleteOno = new javax.swing.JTextField();
        jButtonVognDeleteBack = new javax.swing.JButton();
        jLabelVognDeleted = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextFieldVognDeleteResFrom = new javax.swing.JTextField();
        jTextFieldVognDeleteResUntil = new javax.swing.JTextField();
        jComboBoxVognDeleteStatus = new javax.swing.JComboBox();
        jComboBoxVognDeleteType = new javax.swing.JComboBox();
        jButtonVognDelete = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelGetPart = new javax.swing.JPanel();
        jButtonNewPart = new javax.swing.JButton();
        jButtonUpdatePart = new javax.swing.JButton();
        jButtonUpdateQty = new javax.swing.JButton();
        jButtonDeletePart = new javax.swing.JButton();
        jScrollPaneAllParts = new javax.swing.JScrollPane();
        jTableParts = new javax.swing.JTable();
        jTableParts.setAutoCreateRowSorter(true);
        jButtonLoadParts = new javax.swing.JButton();
        jPanelGetVogn = new javax.swing.JPanel();
        jButtonLoadVogne = new javax.swing.JButton();
        jButtonNewVogn = new javax.swing.JButton();
        jButtonUpdateVogn = new javax.swing.JButton();
        jButtonDeleteVogn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVogne = new javax.swing.JTable();
        jTableVogne.setAutoCreateRowSorter(true);

        jFrameNewPart.setMinimumSize(new java.awt.Dimension(550, 450));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Opret ny del");

        jLabel6.setText("Del nummer");

        jLabel7.setText("Del navn");

        jLabel8.setText("Del antal");

        jLabel9.setText("Del beskrivelse");

        jTextFieldNewPartNo.setToolTipText("Leave empty for auto-number");
        jTextFieldNewPartNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNewPartNoFocusGained(evt);
            }
        });

        jButtonSavePart.setText("Gem del");
        jButtonSavePart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSavePartActionPerformed(evt);
            }
        });

        jButtonNewPartBack.setText("Tilbage");
        jButtonNewPartBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewPartBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNewPartLayout = new javax.swing.GroupLayout(jPanelNewPart);
        jPanelNewPart.setLayout(jPanelNewPartLayout);
        jPanelNewPartLayout.setHorizontalGroup(
            jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewPartLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSaved)
                    .addComponent(jLabel5)
                    .addGroup(jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNewPartLayout.createSequentialGroup()
                            .addComponent(jButtonSavePart)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                            .addComponent(jButtonNewPartBack))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelNewPartLayout.createSequentialGroup()
                            .addGroup(jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addGap(21, 21, 21)
                            .addGroup(jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldNewPartName)
                                .addComponent(jTextFieldNewPartNo, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                .addComponent(jTextFieldNewPartQuantity)
                                .addComponent(jTextFieldNewPartDescription)))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanelNewPartLayout.setVerticalGroup(
            jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewPartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addGroup(jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldNewPartNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldNewPartName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldNewPartQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldNewPartDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSavePart)
                    .addComponent(jButtonNewPartBack))
                .addGap(18, 18, 18)
                .addComponent(jLabelSaved)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        PlainDocument doc17 = (PlainDocument) jTextFieldNewPartNo.getDocument();
        doc17.setDocumentFilter(new MyIntFilter());
        PlainDocument doc18 = (PlainDocument) jTextFieldNewPartQuantity.getDocument();
        doc18.setDocumentFilter(new MyIntFilter());

        javax.swing.GroupLayout jFrameNewPartLayout = new javax.swing.GroupLayout(jFrameNewPart.getContentPane());
        jFrameNewPart.getContentPane().setLayout(jFrameNewPartLayout);
        jFrameNewPartLayout.setHorizontalGroup(
            jFrameNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNewPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrameNewPartLayout.setVerticalGroup(
            jFrameNewPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNewPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFrameUpdatePart.setMinimumSize(new java.awt.Dimension(550, 450));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Opdater del");

        jLabel11.setText("Del nummer");

        jLabel12.setText("Del navn");

        jLabel14.setText("Del beskrivelse");

        jTextFieldUpdatePartNo.setToolTipText("");
        jTextFieldUpdatePartNo.setEnabled(false);
        jTextFieldUpdatePartNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUpdatePartNoFocusGained(evt);
            }
        });

        jButtonUpdatePartUpdate.setText("Opdater del");
        jButtonUpdatePartUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdatePartUpdateActionPerformed(evt);
            }
        });

        jButtonUpdatePartBack.setText("Tilbage");
        jButtonUpdatePartBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdatePartBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUpdatePartLayout = new javax.swing.GroupLayout(jPanelUpdatePart);
        jPanelUpdatePart.setLayout(jPanelUpdatePartLayout);
        jPanelUpdatePartLayout.setHorizontalGroup(
            jPanelUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdatePartLayout.createSequentialGroup()
                .addGroup(jPanelUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUpdatePartLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel10))
                    .addGroup(jPanelUpdatePartLayout.createSequentialGroup()
                        .addGroup(jPanelUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUpdatePartLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelUpdated)
                                .addGap(111, 111, 111))
                            .addGroup(jPanelUpdatePartLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanelUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)
                                    .addComponent(jButtonUpdatePartUpdate))
                                .addGap(12, 12, 12)))
                        .addGroup(jPanelUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonUpdatePartBack, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldUpdatePartName, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jTextFieldUpdatePartNo)
                            .addComponent(jTextFieldUpdatePartDescription))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanelUpdatePartLayout.setVerticalGroup(
            jPanelUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdatePartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(20, 20, 20)
                .addGroup(jPanelUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldUpdatePartNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldUpdatePartName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldUpdatePartDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdatePartUpdate)
                    .addComponent(jButtonUpdatePartBack))
                .addGap(18, 18, 18)
                .addComponent(jLabelUpdated)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        PlainDocument doc15 = (PlainDocument) jTextFieldUpdatePartNo.getDocument();
        doc15.setDocumentFilter(new MyIntFilter());

        javax.swing.GroupLayout jFrameUpdatePartLayout = new javax.swing.GroupLayout(jFrameUpdatePart.getContentPane());
        jFrameUpdatePart.getContentPane().setLayout(jFrameUpdatePartLayout);
        jFrameUpdatePartLayout.setHorizontalGroup(
            jFrameUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUpdatePart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jFrameUpdatePartLayout.setVerticalGroup(
            jFrameUpdatePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUpdatePart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jFrameUpdateQty.setMinimumSize(new java.awt.Dimension(550, 450));

        jPanelUpdateQty.setMinimumSize(new java.awt.Dimension(410, 225));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Opdater antal");

        jLabel15.setText("Del nummer");

        jLabel16.setText("Del navn");

        jLabel17.setText("Del antal");

        jTextFieldUpdateQtyNo.setToolTipText("");
        jTextFieldUpdateQtyNo.setEnabled(false);
        jTextFieldUpdateQtyNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUpdateQtyNoFocusGained(evt);
            }
        });

        jButtonUpdateQtyUpdate.setText("Opdater antal");
        jButtonUpdateQtyUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateQtyUpdateActionPerformed(evt);
            }
        });

        jButtonUpdateQtyBack.setText("Tilbage");
        jButtonUpdateQtyBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateQtyBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUpdateQtyLayout = new javax.swing.GroupLayout(jPanelUpdateQty);
        jPanelUpdateQty.setLayout(jPanelUpdateQtyLayout);
        jPanelUpdateQtyLayout.setHorizontalGroup(
            jPanelUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateQtyLayout.createSequentialGroup()
                .addGroup(jPanelUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUpdateQtyLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel13))
                    .addGroup(jPanelUpdateQtyLayout.createSequentialGroup()
                        .addGroup(jPanelUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelUpdateQtyLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanelUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jButtonUpdateQtyUpdate))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUpdateQtyLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelQty)
                                .addGap(111, 111, 111)))
                        .addGroup(jPanelUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonUpdateQtyBack, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldUpdateQtyName, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(jTextFieldUpdateQtyNo)
                            .addComponent(jTextFieldUpdateQtyQty))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanelUpdateQtyLayout.setVerticalGroup(
            jPanelUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateQtyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(12, 12, 12)
                .addGroup(jPanelUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldUpdateQtyNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldUpdateQtyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldUpdateQtyQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUpdateQtyUpdate)
                    .addComponent(jButtonUpdateQtyBack))
                .addGap(24, 24, 24)
                .addComponent(jLabelQty)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        PlainDocument doc13 = (PlainDocument) jTextFieldUpdateQtyNo.getDocument();
        doc13.setDocumentFilter(new MyIntFilter());
        PlainDocument doc14 = (PlainDocument) jTextFieldUpdateQtyQty.getDocument();
        doc14.setDocumentFilter(new MyIntFilter());

        javax.swing.GroupLayout jFrameUpdateQtyLayout = new javax.swing.GroupLayout(jFrameUpdateQty.getContentPane());
        jFrameUpdateQty.getContentPane().setLayout(jFrameUpdateQtyLayout);
        jFrameUpdateQtyLayout.setHorizontalGroup(
            jFrameUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUpdateQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrameUpdateQtyLayout.setVerticalGroup(
            jFrameUpdateQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUpdateQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFrameDeletePart.setMinimumSize(new java.awt.Dimension(550, 450));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Slet del");

        jLabel19.setText("Del nummer");

        jLabel20.setText("Del navn");

        jLabel21.setText("Del antal");

        jLabel22.setText("Del beskrivelse");

        jTextFieldDeletePartNo.setToolTipText("");
        jTextFieldDeletePartNo.setEnabled(false);
        jTextFieldDeletePartNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDeletePartNoFocusGained(evt);
            }
        });

        jTextFieldDeletePartName.setEnabled(false);

        jTextFieldDeletePartQuantity.setEnabled(false);

        jTextFieldDeletePartDescription.setEnabled(false);

        jButtonDeletePartDelete.setText("Slet del");
        jButtonDeletePartDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletePartDeleteActionPerformed(evt);
            }
        });

        jButtonDeletePartBack.setText("Tilbage");
        jButtonDeletePartBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletePartBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDeletePartLayout = new javax.swing.GroupLayout(jPanelDeletePart);
        jPanelDeletePart.setLayout(jPanelDeletePartLayout);
        jPanelDeletePartLayout.setHorizontalGroup(
            jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeletePartLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDeleted)
                    .addComponent(jLabel18)
                    .addGroup(jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelDeletePartLayout.createSequentialGroup()
                            .addComponent(jButtonDeletePartDelete)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                            .addComponent(jButtonDeletePartBack))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDeletePartLayout.createSequentialGroup()
                            .addGroup(jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21)
                                .addComponent(jLabel22))
                            .addGap(21, 21, 21)
                            .addGroup(jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldDeletePartName)
                                .addComponent(jTextFieldDeletePartNo, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                .addComponent(jTextFieldDeletePartQuantity)
                                .addComponent(jTextFieldDeletePartDescription)))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanelDeletePartLayout.setVerticalGroup(
            jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeletePartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(20, 20, 20)
                .addGroup(jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldDeletePartNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldDeletePartName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldDeletePartQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextFieldDeletePartDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeletePartDelete)
                    .addComponent(jButtonDeletePartBack))
                .addGap(18, 18, 18)
                .addComponent(jLabelDeleted)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        PlainDocument doc11 = (PlainDocument) jTextFieldDeletePartNo.getDocument();
        doc11.setDocumentFilter(new MyIntFilter());
        PlainDocument doc12 = (PlainDocument) jTextFieldDeletePartQuantity.getDocument();
        doc12.setDocumentFilter(new MyIntFilter());

        javax.swing.GroupLayout jFrameDeletePartLayout = new javax.swing.GroupLayout(jFrameDeletePart.getContentPane());
        jFrameDeletePart.getContentPane().setLayout(jFrameDeletePartLayout);
        jFrameDeletePartLayout.setHorizontalGroup(
            jFrameDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDeletePart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrameDeletePartLayout.setVerticalGroup(
            jFrameDeletePartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDeletePart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFrameNewVogn.setMinimumSize(new java.awt.Dimension(550, 450));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Create new truck");

        jLabel26.setText("Truck No");

        jLabel31.setText("Truck Type");

        jLabel32.setText("Truck Status");

        jLabel33.setText("Order No");

        jButtonSaveVogn.setText("Save Truck");
        jButtonSaveVogn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveVognActionPerformed(evt);
            }
        });

        jButtonNewVognBack.setText("Back");
        jButtonNewVognBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewVognBackActionPerformed(evt);
            }
        });

        jLabel34.setText("Reserved From");

        jLabel35.setText("Reserved Until");

        jTextFieldVognNewResFrom.setText("dd,mm,åååå");
        jTextFieldVognNewResFrom.setToolTipText("Hvis ingen dato ønskes, skriv 0");
        jTextFieldVognNewResFrom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldVognNewResFromFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldVognNewResFromFocusLost(evt);
            }
        });

        jTextFieldVognNewResUntil.setText("dd,mm,åååå");
        jTextFieldVognNewResUntil.setToolTipText("Hvis ingen dato ønskes, skriv 0");
        jTextFieldVognNewResUntil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldVognNewResUntilFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldVognNewResUntilFocusLost(evt);
            }
        });

        jComboBoxVognNewStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hjemme", "Opsætning", "Nedrivning" }));

        jComboBoxVognNewType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lille", "Mellem", "Stor" }));

        javax.swing.GroupLayout jPanelNewVognLayout = new javax.swing.GroupLayout(jPanelNewVogn);
        jPanelNewVogn.setLayout(jPanelNewVognLayout);
        jPanelNewVognLayout.setHorizontalGroup(
            jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewVognLayout.createSequentialGroup()
                .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelNewVognLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel34)
                            .addComponent(jLabel33)
                            .addComponent(jLabel32)
                            .addComponent(jLabel31)
                            .addComponent(jLabel26))
                        .addGap(10, 10, 10)
                        .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldVognNewResUntil, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldVognNewResFrom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldVognNewNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jTextFieldVognNewOno, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxVognNewStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxVognNewType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelNewVognLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelNewVognLayout.createSequentialGroup()
                                .addComponent(jButtonSaveVogn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonNewVognBack))
                            .addComponent(jLabelSavedVogn)
                            .addComponent(jLabel25))))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jPanelNewVognLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel26, jLabel31, jLabel32, jLabel33, jLabel34, jLabel35});

        jPanelNewVognLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldVognNewNo, jTextFieldVognNewOno, jTextFieldVognNewResFrom, jTextFieldVognNewResUntil});

        jPanelNewVognLayout.setVerticalGroup(
            jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNewVognLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(34, 34, 34)
                .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextFieldVognNewNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBoxVognNewType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jComboBoxVognNewStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextFieldVognNewOno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVognNewResFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVognNewResUntil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(36, 36, 36)
                .addComponent(jLabelSavedVogn)
                .addGap(18, 18, 18)
                .addGroup(jPanelNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveVogn)
                    .addComponent(jButtonNewVognBack))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanelNewVognLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel26, jLabel31, jLabel32, jLabel33, jLabel34, jLabel35});

        jPanelNewVognLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldVognNewNo, jTextFieldVognNewOno, jTextFieldVognNewResFrom, jTextFieldVognNewResUntil});

        PlainDocument doc9 = (PlainDocument) jTextFieldVognNewNo.getDocument();
        doc9.setDocumentFilter(new MyIntFilter());
        PlainDocument doc10 = (PlainDocument) jTextFieldVognNewOno.getDocument();
        doc10.setDocumentFilter(new MyIntFilter());

        javax.swing.GroupLayout jFrameNewVognLayout = new javax.swing.GroupLayout(jFrameNewVogn.getContentPane());
        jFrameNewVogn.getContentPane().setLayout(jFrameNewVognLayout);
        jFrameNewVognLayout.setHorizontalGroup(
            jFrameNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNewVogn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrameNewVognLayout.setVerticalGroup(
            jFrameNewVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNewVogn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFrameUpdateVogn.setMinimumSize(new java.awt.Dimension(550, 450));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Opdater vogn");

        jLabel37.setText("Vogn nummer");

        jLabel38.setText("Vogn type");

        jLabel39.setText("Vogn status");

        jLabel40.setText("Ordre nummer");

        jTextFieldVognUpdateNo.setToolTipText("");
        jTextFieldVognUpdateNo.setEnabled(false);

        jButtonVognUpdateBack.setText("Tilbage");
        jButtonVognUpdateBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVognUpdateBackActionPerformed(evt);
            }
        });

        jLabel41.setText("Reserveret fra");

        jLabel42.setText("Reserveret til");

        jTextFieldVognUpdateResFrom.setText("dd,mm,åååå");
        jTextFieldVognUpdateResFrom.setToolTipText("Hvis ingen dato ønskes, skriv 0");
        jTextFieldVognUpdateResFrom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldVognUpdateResFromFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldVognUpdateResFromFocusLost(evt);
            }
        });

        jTextFieldVognUpdateResUntil.setText("dd,mm,åååå");
        jTextFieldVognUpdateResUntil.setToolTipText("Hvis ingen dato ønskes, skriv 0");
        jTextFieldVognUpdateResUntil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldVognUpdateResUntilFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldVognUpdateResUntilFocusLost(evt);
            }
        });

        jComboBoxVognUpdateStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hjemme", "Opsætning", "Nedrivning" }));

        jComboBoxVognUpdateType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lille", "Mellem", "Stor" }));

        jCheckBoxStatus.setToolTipText("Check box to update this");

        jCheckBoxOno.setToolTipText("Check box to update this");

        jCheckBoxResFrom.setToolTipText("Check box to update this");

        jCheckBoxResUntil.setToolTipText("Check box to update this");

        jButtonVognUpdate.setText("Opdater vogn");
        jButtonVognUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVognUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUpdateVognLayout = new javax.swing.GroupLayout(jPanelUpdateVogn);
        jPanelUpdateVogn.setLayout(jPanelUpdateVognLayout);
        jPanelUpdateVognLayout.setHorizontalGroup(
            jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateVognLayout.createSequentialGroup()
                .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelUpdateVognLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37))
                        .addGap(10, 10, 10)
                        .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldVognUpdateResUntil, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldVognUpdateResFrom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldVognUpdateNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jTextFieldVognUpdateOno, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxVognUpdateStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxVognUpdateType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxStatus)
                            .addComponent(jCheckBoxOno)
                            .addComponent(jCheckBoxResFrom)
                            .addComponent(jCheckBoxResUntil)))
                    .addGroup(jPanelUpdateVognLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelUpdateVognLayout.createSequentialGroup()
                                .addComponent(jButtonVognUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonVognUpdateBack))
                            .addComponent(jLabelVognUpdated)
                            .addComponent(jLabel36))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanelUpdateVognLayout.setVerticalGroup(
            jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUpdateVognLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addGap(20, 20, 20)
                .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextFieldVognUpdateNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jComboBoxVognUpdateType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jComboBoxVognUpdateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextFieldVognUpdateOno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxOno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVognUpdateResFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jCheckBoxResFrom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVognUpdateResUntil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(jCheckBoxResUntil))
                .addGap(34, 34, 34)
                .addComponent(jLabelVognUpdated)
                .addGap(18, 18, 18)
                .addGroup(jPanelUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVognUpdateBack)
                    .addComponent(jButtonVognUpdate))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        PlainDocument doc7 = (PlainDocument) jTextFieldVognUpdateNo.getDocument();
        doc7.setDocumentFilter(new MyIntFilter());
        PlainDocument doc8 = (PlainDocument) jTextFieldVognUpdateOno.getDocument();
        doc8.setDocumentFilter(new MyIntFilter());

        javax.swing.GroupLayout jFrameUpdateVognLayout = new javax.swing.GroupLayout(jFrameUpdateVogn.getContentPane());
        jFrameUpdateVogn.getContentPane().setLayout(jFrameUpdateVognLayout);
        jFrameUpdateVognLayout.setHorizontalGroup(
            jFrameUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUpdateVogn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrameUpdateVognLayout.setVerticalGroup(
            jFrameUpdateVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUpdateVogn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jFrameDeleteVogn.setMinimumSize(new java.awt.Dimension(550, 450));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Slet vogn");

        jLabel49.setText("Vogn nummer");

        jLabel50.setText("Vogn type");

        jLabel51.setText("Vogn status");

        jLabel52.setText("Ordre nummer");

        jTextFieldVognDeleteNo.setToolTipText("");
        jTextFieldVognDeleteNo.setEnabled(false);

        jTextFieldVognDeleteOno.setEnabled(false);

        jButtonVognDeleteBack.setText("Tilbage");
        jButtonVognDeleteBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVognDeleteBackActionPerformed(evt);
            }
        });

        jLabel53.setText("Reserveret til");

        jLabel54.setText("Reserveret fra");

        jTextFieldVognDeleteResFrom.setEnabled(false);

        jTextFieldVognDeleteResUntil.setEnabled(false);

        jComboBoxVognDeleteStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hjemme", "Opsætning", "Nedrivning" }));
        jComboBoxVognDeleteStatus.setEnabled(false);

        jComboBoxVognDeleteType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lille", "Mellem", "Stor" }));
        jComboBoxVognDeleteType.setEnabled(false);

        jButtonVognDelete.setText("Slet vogn");
        jButtonVognDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVognDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDeleteVognLayout = new javax.swing.GroupLayout(jPanelDeleteVogn);
        jPanelDeleteVogn.setLayout(jPanelDeleteVognLayout);
        jPanelDeleteVognLayout.setHorizontalGroup(
            jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteVognLayout.createSequentialGroup()
                .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDeleteVognLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel53)
                            .addComponent(jLabel52)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50)
                            .addComponent(jLabel49))
                        .addGap(10, 10, 10)
                        .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldVognDeleteResUntil, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldVognDeleteResFrom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldVognDeleteNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(jTextFieldVognDeleteOno, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxVognDeleteStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxVognDeleteType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelDeleteVognLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDeleteVognLayout.createSequentialGroup()
                                .addComponent(jButtonVognDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonVognDeleteBack))
                            .addGroup(jPanelDeleteVognLayout.createSequentialGroup()
                                .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelVognDeleted)
                                    .addComponent(jLabel48))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanelDeleteVognLayout.setVerticalGroup(
            jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeleteVognLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addGap(20, 20, 20)
                .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jTextFieldVognDeleteNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jComboBoxVognDeleteType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jComboBoxVognDeleteStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jTextFieldVognDeleteOno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVognDeleteResFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldVognDeleteResUntil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addGap(35, 35, 35)
                .addComponent(jLabelVognDeleted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVognDeleteBack)
                    .addComponent(jButtonVognDelete))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        PlainDocument doc5 = (PlainDocument) jTextFieldVognDeleteNo.getDocument();
        doc5.setDocumentFilter(new MyIntFilter());
        PlainDocument doc6 = (PlainDocument) jTextFieldVognDeleteOno.getDocument();
        doc6.setDocumentFilter(new MyIntFilter());

        javax.swing.GroupLayout jFrameDeleteVognLayout = new javax.swing.GroupLayout(jFrameDeleteVogn.getContentPane());
        jFrameDeleteVogn.getContentPane().setLayout(jFrameDeleteVognLayout);
        jFrameDeleteVognLayout.setHorizontalGroup(
            jFrameDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDeleteVogn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrameDeleteVognLayout.setVerticalGroup(
            jFrameDeleteVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDeleteVogn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane.setMinimumSize(new java.awt.Dimension(550, 450));

        jButtonNewPart.setText("Opret ny del");
        jButtonNewPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewPartActionPerformed(evt);
            }
        });

        jButtonUpdatePart.setText("Opdater del");
        jButtonUpdatePart.setEnabled(false);
        jButtonUpdatePart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdatePartActionPerformed(evt);
            }
        });

        jButtonUpdateQty.setText("Opdater antal");
        jButtonUpdateQty.setEnabled(false);
        jButtonUpdateQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateQtyActionPerformed(evt);
            }
        });

        jButtonDeletePart.setText("Slet del");
        jButtonDeletePart.setEnabled(false);
        jButtonDeletePart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletePartActionPerformed(evt);
            }
        });

        jTableParts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Del nummer", "Navn", "Beskrivelse", "Antal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneAllParts.setViewportView(jTableParts);

        jButtonLoadParts.setText("Indlæs dele");
        jButtonLoadParts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadPartsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGetPartLayout = new javax.swing.GroupLayout(jPanelGetPart);
        jPanelGetPart.setLayout(jPanelGetPartLayout);
        jPanelGetPartLayout.setHorizontalGroup(
            jPanelGetPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGetPartLayout.createSequentialGroup()
                .addGroup(jPanelGetPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLoadParts)
                    .addGroup(jPanelGetPartLayout.createSequentialGroup()
                        .addComponent(jScrollPaneAllParts, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGetPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonUpdateQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonUpdatePart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNewPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeletePart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGetPartLayout.setVerticalGroup(
            jPanelGetPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGetPartLayout.createSequentialGroup()
                .addGroup(jPanelGetPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGetPartLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonNewPart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdatePart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateQty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeletePart))
                    .addComponent(jScrollPaneAllParts, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLoadParts)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Dele", jPanelGetPart);

        jPanelGetVogn.setMinimumSize(new java.awt.Dimension(550, 350));

        jButtonLoadVogne.setText("Indlæs vogne");
        jButtonLoadVogne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadVogneActionPerformed(evt);
            }
        });

        jButtonNewVogn.setText("Opret ny vogn");
        jButtonNewVogn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewVognActionPerformed(evt);
            }
        });

        jButtonUpdateVogn.setText("Opdater vogn");
        jButtonUpdateVogn.setEnabled(false);
        jButtonUpdateVogn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateVognActionPerformed(evt);
            }
        });

        jButtonDeleteVogn.setText("Slet vogn");
        jButtonDeleteVogn.setEnabled(false);
        jButtonDeleteVogn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteVognActionPerformed(evt);
            }
        });

        jTableVogne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vogn nummer", "Vogn type", "Status", "Ordre nummer", "Reserveret fra", "Reserveret til"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVogne);

        javax.swing.GroupLayout jPanelGetVognLayout = new javax.swing.GroupLayout(jPanelGetVogn);
        jPanelGetVogn.setLayout(jPanelGetVognLayout);
        jPanelGetVognLayout.setHorizontalGroup(
            jPanelGetVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGetVognLayout.createSequentialGroup()
                .addGroup(jPanelGetVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGetVognLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGetVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonNewVogn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonUpdateVogn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDeleteVogn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelGetVognLayout.createSequentialGroup()
                        .addComponent(jButtonLoadVogne)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanelGetVognLayout.setVerticalGroup(
            jPanelGetVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGetVognLayout.createSequentialGroup()
                .addGroup(jPanelGetVognLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelGetVognLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonNewVogn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdateVogn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteVogn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLoadVogne)
                .addGap(56, 56, 56))
        );

        jTabbedPane.addTab("Vognpark", jPanelGetVogn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSavePartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSavePartActionPerformed
        // TODO add your handling code here:
        String newName = jTextFieldNewPartName.getText();
        int newQty = Integer.parseInt(jTextFieldNewPartQuantity.getText());
        String newDesc = jTextFieldNewPartDescription.getText();

        if (jTextFieldNewPartNo.getText().compareTo("") == 0) {
            try {
                Part p = new Part(newName, newDesc, newQty);
                pc.saveNewPart(p);
                clearPartNewFields();
                jLabelSaved.setText("Gemt");
            } catch (SQLException ex) {
                if (ex.getErrorCode() == 1) {
                    JOptionPane.showMessageDialog(null, "Del nummeret er allerede i brug, vælg venligst et andet", "Fejl", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            try {
                Part p = new Part(Integer.parseInt(jTextFieldNewPartNo.getText()), newName, newDesc, newQty);
                pc.saveNewPartWitnum(p);
                clearPartNewFields();
                jLabelSaved.setText("Gemt");
            } catch (SQLException ex) {
                if (ex.getErrorCode() == 1) {
                    JOptionPane.showMessageDialog(null, "Del nummeret er allerede i brug, vælg venligst et andet", "Fejl", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jButtonSavePartActionPerformed

    private void jButtonNewPartBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewPartBackActionPerformed
        // TODO add your handling code here:
        jFrameNewPart.setVisible(false);
        jFrameNewPart.dispose();
        jButtonLoadParts.doClick();
    }//GEN-LAST:event_jButtonNewPartBackActionPerformed

    private void jButtonUpdatePartUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdatePartUpdateActionPerformed
        // TODO add your handling code here:
        try {
            String updateName = jTextFieldUpdatePartName.getText();
            String updateDescription = jTextFieldUpdatePartDescription.getText();
            int updatePnum = Integer.parseInt(jTextFieldUpdatePartNo.getText());

            Part p = new Part(updatePnum, updateName, updateDescription, 0);

            pc.updatePart(p);

            clearPartUpdateFields();
            jFrameUpdatePart.setVisible(false);
            jFrameUpdatePart.dispose();
            jButtonLoadParts.doClick();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonUpdatePartUpdateActionPerformed

    private void jButtonUpdatePartBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdatePartBackActionPerformed
        // TODO add your handling code here:
        jFrameUpdatePart.setVisible(false);
        jFrameUpdatePart.dispose();
        clearPartUpdateFields();
    }//GEN-LAST:event_jButtonUpdatePartBackActionPerformed

    private void jButtonUpdateQtyUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateQtyUpdateActionPerformed
        // TODO add your handling code here:
        try {
            int pnum, qty;

            if (jTextFieldUpdateQtyNo.getText().equals("")) {
                pnum = 0;
            } else {
                pnum = Integer.parseInt(jTextFieldUpdateQtyNo.getText());
            }

            if (jTextFieldUpdateQtyQty.getText().equals("")) {
                qty = 0;
            } else {
                qty = Integer.parseInt(jTextFieldUpdateQtyQty.getText());
            }

            pc.updatePartQty(pnum, qty);

            clearPartUpdateQtyFields();
            jFrameUpdateQty.setVisible(false);
            jFrameUpdateQty.dispose();
            jButtonLoadParts.doClick();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonUpdateQtyUpdateActionPerformed

    private void jButtonUpdateQtyBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateQtyBackActionPerformed
        // TODO add your handling code here:
        jFrameUpdateQty.setVisible(false);
        jFrameUpdateQty.dispose();
        clearPartUpdateQtyFields();
    }//GEN-LAST:event_jButtonUpdateQtyBackActionPerformed

    private void jButtonDeletePartDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletePartDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int pnum;

            if (jTextFieldDeletePartNo.getText().equals("")) {
                pnum = 0;
            } else {
                pnum = Integer.parseInt(jTextFieldDeletePartNo.getText());
            }

            int reply = JOptionPane.showConfirmDialog(null, "Sletning er permanent. Er du sikker på at du vil fortsætte?",
                    "Advarsel", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                pc.deletePart(pnum);
            }

            jTextFieldDeletePartNo.setText("");
            jTextFieldDeletePartName.setText("");
            jTextFieldDeletePartQuantity.setText("");
            jTextFieldDeletePartDescription.setText("");
            jFrameDeletePart.setVisible(false);
            jFrameDeletePart.dispose();
            jButtonLoadParts.doClick();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeletePartDeleteActionPerformed

    private void jButtonDeletePartBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletePartBackActionPerformed
        // TODO add your handling code here:
        jFrameDeletePart.setVisible(false);
        jFrameDeletePart.dispose();
        clearPartDeleteFields();
    }//GEN-LAST:event_jButtonDeletePartBackActionPerformed

    private void jTextFieldNewPartNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNewPartNoFocusGained
        // TODO add your handling code here:
        jLabelSaved.setText("");
    }//GEN-LAST:event_jTextFieldNewPartNoFocusGained

    private void jTextFieldUpdatePartNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUpdatePartNoFocusGained
        // TODO add your handling code here:
        jLabelUpdated.setText("");
    }//GEN-LAST:event_jTextFieldUpdatePartNoFocusGained

    private void jTextFieldUpdateQtyNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUpdateQtyNoFocusGained
        // TODO add your handling code here:
        jLabelQty.setText("");
    }//GEN-LAST:event_jTextFieldUpdateQtyNoFocusGained

    private void jTextFieldDeletePartNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDeletePartNoFocusGained
        // TODO add your handling code here:
        jLabelDeleted.setText("");
    }//GEN-LAST:event_jTextFieldDeletePartNoFocusGained

    private void jButtonSaveVognActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveVognActionPerformed
        // TODO add your handling code here:
        try {
            int vognNo = Integer.parseInt(jTextFieldVognNewNo.getText());
            String vognType = (String) jComboBoxVognNewType.getSelectedItem();
            String vognStatus = (String) jComboBoxVognNewStatus.getSelectedItem();
            int ono = Integer.parseInt(jTextFieldVognNewOno.getText());
            String resFra = jTextFieldVognNewResFrom.getText();
            String resTil = jTextFieldVognNewResUntil.getText();

            Vogn v = new Vogn(vognNo, vognType, vognStatus, ono, resFra, resTil);

            vc.saveVogn(v);

            jTextFieldVognNewNo.setText("");
            jTextFieldVognNewOno.setText("");
            jTextFieldVognNewResFrom.setText("");
            jTextFieldVognNewResUntil.setText("");
            jLabelSavedVogn.setText("Gemt");
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1) {
                JOptionPane.showMessageDialog(null, "Vogn nummeret er allerede i brug, vælg venligst et andet", "Fejl", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonSaveVognActionPerformed

    private void jButtonNewVognBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewVognBackActionPerformed
        // TODO add your handling code here:
        jFrameNewVogn.setVisible(false);
        jFrameNewVogn.dispose();
        jButtonLoadVogne.doClick();
    }//GEN-LAST:event_jButtonNewVognBackActionPerformed

    private void jTextFieldVognNewResFromFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVognNewResFromFocusGained
        // TODO add your handling code here:
        jTextFieldVognNewResFrom.setText("");
    }//GEN-LAST:event_jTextFieldVognNewResFromFocusGained

    private void jTextFieldVognNewResUntilFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVognNewResUntilFocusGained
        // TODO add your handling code here:
        jTextFieldVognNewResUntil.setText("");
    }//GEN-LAST:event_jTextFieldVognNewResUntilFocusGained

    private void jTextFieldVognNewResFromFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVognNewResFromFocusLost
        // TODO add your handling code here:
        if (jTextFieldVognNewResFrom.getText().equals("")) {
            jTextFieldVognNewResFrom.setText("dd,mm,åååå");
        }
    }//GEN-LAST:event_jTextFieldVognNewResFromFocusLost

    private void jTextFieldVognNewResUntilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVognNewResUntilFocusLost
        // TODO add your handling code here:
        if (jTextFieldVognNewResUntil.getText().equals("")) {
            jTextFieldVognNewResUntil.setText("dd,mm,åååå");
        }
    }//GEN-LAST:event_jTextFieldVognNewResUntilFocusLost

    private void jButtonVognUpdateBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVognUpdateBackActionPerformed
        // TODO add your handling code here:
        jFrameUpdateVogn.setVisible(false);
        jFrameUpdateVogn.dispose();
    }//GEN-LAST:event_jButtonVognUpdateBackActionPerformed

    private void jTextFieldVognUpdateResFromFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVognUpdateResFromFocusGained
        // TODO add your handling code here:
        jTextFieldVognUpdateResFrom.setText("");
    }//GEN-LAST:event_jTextFieldVognUpdateResFromFocusGained

    private void jTextFieldVognUpdateResFromFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVognUpdateResFromFocusLost
        // TODO add your handling code here:
        if (jTextFieldVognUpdateResFrom.getText().equals("")) {
            jTextFieldVognUpdateResFrom.setText("dd,mm,åååå");
        }
    }//GEN-LAST:event_jTextFieldVognUpdateResFromFocusLost

    private void jTextFieldVognUpdateResUntilFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVognUpdateResUntilFocusGained
        // TODO add your handling code here:
        jTextFieldVognUpdateResUntil.setText("");
    }//GEN-LAST:event_jTextFieldVognUpdateResUntilFocusGained

    private void jTextFieldVognUpdateResUntilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldVognUpdateResUntilFocusLost
        // TODO add your handling code here:
        if (jTextFieldVognUpdateResUntil.getText().equals("")) {
            jTextFieldVognUpdateResUntil.setText("dd,mm,åååå");
        }
    }//GEN-LAST:event_jTextFieldVognUpdateResUntilFocusLost

    private void jButtonVognUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVognUpdateActionPerformed
        // TODO add your handling code here:
        int vognID = Integer.parseInt(jTextFieldVognUpdateNo.getText());
        int ono = Integer.parseInt(jTextFieldVognUpdateOno.getText());
        String status = (String) jComboBoxVognUpdateStatus.getSelectedItem();
        String resFrom = jTextFieldVognUpdateResFrom.getText();
        String resTo = jTextFieldVognUpdateResUntil.getText();

        if (jCheckBoxOno.isSelected() == true) {
            try {
                vc.updateVognOno(vognID, ono);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (jCheckBoxStatus.isSelected() == true) {
            try {
                vc.updateVognStatus(vognID, status);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (jCheckBoxResFrom.isSelected() == true) {
            try {
                vc.updateVognDatoFra(vognID, resFrom);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (jCheckBoxResUntil.isSelected() == true) {
            try {
                vc.updateVognDatoTil(vognID, resTo);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (jCheckBoxOno.isSelected() == false && jCheckBoxResFrom.isSelected() == false
                && jCheckBoxResUntil.isSelected() == false && jCheckBoxStatus.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Sæt hak i en boks for at opdatere vognen", "Fejl", JOptionPane.ERROR_MESSAGE);
        } else {
            jFrameUpdateVogn.setVisible(false);
            jFrameUpdateVogn.dispose();
            jButtonLoadVogne.doClick();
        }
    }//GEN-LAST:event_jButtonVognUpdateActionPerformed

    private void jButtonVognDeleteBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVognDeleteBackActionPerformed
        // TODO add your handling code here:
        jFrameDeleteVogn.setVisible(false);
        jFrameDeleteVogn.dispose();
    }//GEN-LAST:event_jButtonVognDeleteBackActionPerformed

    private void jButtonVognDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVognDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int vognID = Integer.parseInt(jTextFieldVognDeleteNo.getText());

            int reply = JOptionPane.showConfirmDialog(null, "Sletning er permanent. Er du sikker på at du vil fortsætte?",
                    "Advarsel", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                vc.deleteVogn(vognID);
                clearVognDeleteFields();
                jFrameDeleteVogn.setVisible(false);
                jFrameDeleteVogn.dispose();
                jButtonLoadVogne.doClick();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonVognDeleteActionPerformed

    private void jButtonDeletePartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletePartActionPerformed
        // TODO add your handling code here:
        jFrameDeletePart.setVisible(true);

        int selectedRow = jTableParts.getSelectedRow();
        int partNo = Integer.parseInt((jTableParts.getValueAt(selectedRow, 0).toString()));

        try {
            clearPartDeleteFields();

            Part p = pc.getPart(partNo);

            if (p != null) {
                jTextFieldDeletePartName.setText(p.getPnavn());
                jTextFieldDeletePartNo.setText(p.getPnum() + "");
                jTextFieldDeletePartQuantity.setText(p.getQty() + "");
                jTextFieldDeletePartDescription.setText(p.getPbeskrivelse());
            } else {
                JOptionPane.showMessageDialog(null, "Delen findes ikke", "Fejl", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeletePartActionPerformed

    private void jButtonUpdateQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateQtyActionPerformed
        // TODO add your handling code here:
        jFrameUpdateQty.setVisible(true);

        int selectedRow = jTableParts.getSelectedRow();
        int partNo = Integer.parseInt((jTableParts.getValueAt(selectedRow, 0).toString()));

        try {
            clearPartUpdateQtyFields();

            Part p = pc.getPart(partNo);

            if (p != null) {
                jTextFieldUpdateQtyName.setText(p.getPnavn());
                jTextFieldUpdateQtyNo.setText(p.getPnum() + "");
                jTextFieldUpdateQtyQty.setText(p.getQty() + "");
            } else {
                JOptionPane.showMessageDialog(null, "Delen findes ikke", "Fejl", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonUpdateQtyActionPerformed

    private void jButtonUpdatePartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdatePartActionPerformed
        // TODO add your handling code here:
        jFrameUpdatePart.setVisible(true);

        int selectedRow = jTableParts.getSelectedRow();
        int partNo = Integer.parseInt((jTableParts.getValueAt(selectedRow, 0).toString()));

        try {
            clearPartUpdateFields();

            Part p = pc.getPart(partNo);

            if (p != null) {
                jTextFieldUpdatePartName.setText(p.getPnavn());
                jTextFieldUpdatePartNo.setText(p.getPnum() + "");
                jTextFieldUpdatePartDescription.setText(p.getPbeskrivelse());
            } else {
                JOptionPane.showMessageDialog(null, "Delen findes ikke", "Fejl", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonUpdatePartActionPerformed

    private void jButtonNewPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewPartActionPerformed
        // TODO add your handling code here:
        jFrameNewPart.setVisible(true);
    }//GEN-LAST:event_jButtonNewPartActionPerformed

    private void jButtonDeleteVognActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteVognActionPerformed
        // TODO add your handling code here:
        jFrameDeleteVogn.setVisible(true);

        int selectedRow = jTableVogne.getSelectedRow();
        int vognNo = Integer.parseInt((jTableVogne.getValueAt(selectedRow, 0).toString()));

        try {
            clearVognDeleteFields();

            Vogn v = vc.getVogn(vognNo);

            if (v != null) {
                jTextFieldVognDeleteNo.setText(vognNo + "");
                jTextFieldVognDeleteOno.setText(v.getOno() + "");
                jComboBoxVognDeleteType.setSelectedItem(v.getvType());
                jComboBoxVognDeleteStatus.setSelectedItem(v.getStatus());
                jTextFieldVognDeleteResFrom.setText(v.getReserveretFra());
                jTextFieldVognDeleteResUntil.setText(v.getReserveretTil());

            } else {
                JOptionPane.showMessageDialog(null, "Vognen findes ikke", "Fejl", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDeleteVognActionPerformed

    private void jButtonUpdateVognActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateVognActionPerformed
        // TODO add your handling code here:
        jFrameUpdateVogn.setVisible(true);

        int selectedRow = jTableVogne.getSelectedRow();
        int vognNo = Integer.parseInt((jTableVogne.getValueAt(selectedRow, 0).toString()));

        try {
            clearVognUpdateFields();

            Vogn v = vc.getVogn(vognNo);

            if (v != null) {
                jTextFieldVognUpdateNo.setText(v.getVognID() + "");
                jTextFieldVognUpdateOno.setText(v.getOno() + "");
                jComboBoxVognUpdateType.setSelectedItem(v.getvType());
                jComboBoxVognUpdateStatus.setSelectedItem(v.getStatus());
                jTextFieldVognUpdateResFrom.setText(v.getReserveretFra());
                jTextFieldVognUpdateResUntil.setText(v.getReserveretTil());
                jComboBoxVognUpdateType.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Vognen findes ikke", "Fejl", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonUpdateVognActionPerformed

    private void jButtonNewVognActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNewVognActionPerformed
        // TODO add your handling code here:
        jFrameNewVogn.setVisible(true);
    }//GEN-LAST:event_jButtonNewVognActionPerformed

    private void jButtonLoadVogneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadVogneActionPerformed
        // TODO add your handling code here:
        try {
            jTableVogne.setModel(vc.getAllVogn());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }

        jButtonLoadVogne.setText("Genindlæs vogne");
    }//GEN-LAST:event_jButtonLoadVogneActionPerformed

    private void jButtonLoadPartsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadPartsActionPerformed
        // TODO add your handling code here:
        try {
            jTableParts.setModel(pc.getAllParts());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kontakt venligst systemadministratoren og giv dem følgende fejlbesked " + ex.getMessage(), "Fejl", JOptionPane.ERROR_MESSAGE);
        }

        jButtonLoadParts.setText("Genindlæs dele");
    }//GEN-LAST:event_jButtonLoadPartsActionPerformed

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
            java.util.logging.Logger.getLogger(ResourceManagementSystemFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResourceManagementSystemFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResourceManagementSystemFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResourceManagementSystemFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResourceManagementSystemFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeletePart;
    private javax.swing.JButton jButtonDeletePartBack;
    private javax.swing.JButton jButtonDeletePartDelete;
    private javax.swing.JButton jButtonDeleteVogn;
    private javax.swing.JButton jButtonLoadParts;
    private javax.swing.JButton jButtonLoadVogne;
    private javax.swing.JButton jButtonNewPart;
    private javax.swing.JButton jButtonNewPartBack;
    private javax.swing.JButton jButtonNewVogn;
    private javax.swing.JButton jButtonNewVognBack;
    private javax.swing.JButton jButtonSavePart;
    private javax.swing.JButton jButtonSaveVogn;
    private javax.swing.JButton jButtonUpdatePart;
    private javax.swing.JButton jButtonUpdatePartBack;
    private javax.swing.JButton jButtonUpdatePartUpdate;
    private javax.swing.JButton jButtonUpdateQty;
    private javax.swing.JButton jButtonUpdateQtyBack;
    private javax.swing.JButton jButtonUpdateQtyUpdate;
    private javax.swing.JButton jButtonUpdateVogn;
    private javax.swing.JButton jButtonVognDelete;
    private javax.swing.JButton jButtonVognDeleteBack;
    private javax.swing.JButton jButtonVognUpdate;
    private javax.swing.JButton jButtonVognUpdateBack;
    private javax.swing.JCheckBox jCheckBoxOno;
    private javax.swing.JCheckBox jCheckBoxResFrom;
    private javax.swing.JCheckBox jCheckBoxResUntil;
    private javax.swing.JCheckBox jCheckBoxStatus;
    private javax.swing.JComboBox jComboBoxVognDeleteStatus;
    private javax.swing.JComboBox jComboBoxVognDeleteType;
    private javax.swing.JComboBox jComboBoxVognNewStatus;
    private javax.swing.JComboBox jComboBoxVognNewType;
    private javax.swing.JComboBox jComboBoxVognUpdateStatus;
    private javax.swing.JComboBox jComboBoxVognUpdateType;
    private javax.swing.JFrame jFrameDeletePart;
    private javax.swing.JFrame jFrameDeleteVogn;
    private javax.swing.JFrame jFrameNewPart;
    private javax.swing.JFrame jFrameNewVogn;
    private javax.swing.JFrame jFrameUpdatePart;
    private javax.swing.JFrame jFrameUpdateQty;
    private javax.swing.JFrame jFrameUpdateVogn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDeleted;
    private javax.swing.JLabel jLabelQty;
    private javax.swing.JLabel jLabelSaved;
    private javax.swing.JLabel jLabelSavedVogn;
    private javax.swing.JLabel jLabelUpdated;
    private javax.swing.JLabel jLabelVognDeleted;
    private javax.swing.JLabel jLabelVognUpdated;
    private javax.swing.JPanel jPanelDeletePart;
    private javax.swing.JPanel jPanelDeleteVogn;
    private javax.swing.JPanel jPanelGetPart;
    private javax.swing.JPanel jPanelGetVogn;
    private javax.swing.JPanel jPanelNewPart;
    private javax.swing.JPanel jPanelNewVogn;
    private javax.swing.JPanel jPanelUpdatePart;
    private javax.swing.JPanel jPanelUpdateQty;
    private javax.swing.JPanel jPanelUpdateVogn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneAllParts;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableParts;
    private javax.swing.JTable jTableVogne;
    private javax.swing.JTextField jTextFieldDeletePartDescription;
    private javax.swing.JTextField jTextFieldDeletePartName;
    private javax.swing.JTextField jTextFieldDeletePartNo;
    private javax.swing.JTextField jTextFieldDeletePartQuantity;
    private javax.swing.JTextField jTextFieldNewPartDescription;
    private javax.swing.JTextField jTextFieldNewPartName;
    private javax.swing.JTextField jTextFieldNewPartNo;
    private javax.swing.JTextField jTextFieldNewPartQuantity;
    private javax.swing.JTextField jTextFieldUpdatePartDescription;
    private javax.swing.JTextField jTextFieldUpdatePartName;
    private javax.swing.JTextField jTextFieldUpdatePartNo;
    private javax.swing.JTextField jTextFieldUpdateQtyName;
    private javax.swing.JTextField jTextFieldUpdateQtyNo;
    private javax.swing.JTextField jTextFieldUpdateQtyQty;
    private javax.swing.JTextField jTextFieldVognDeleteNo;
    private javax.swing.JTextField jTextFieldVognDeleteOno;
    private javax.swing.JTextField jTextFieldVognDeleteResFrom;
    private javax.swing.JTextField jTextFieldVognDeleteResUntil;
    private javax.swing.JTextField jTextFieldVognNewNo;
    private javax.swing.JTextField jTextFieldVognNewOno;
    private javax.swing.JTextField jTextFieldVognNewResFrom;
    private javax.swing.JTextField jTextFieldVognNewResUntil;
    private javax.swing.JTextField jTextFieldVognUpdateNo;
    private javax.swing.JTextField jTextFieldVognUpdateOno;
    private javax.swing.JTextField jTextFieldVognUpdateResFrom;
    private javax.swing.JTextField jTextFieldVognUpdateResUntil;
    // End of variables declaration//GEN-END:variables
}
