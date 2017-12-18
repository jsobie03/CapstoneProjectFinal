package FPdialog;

import FPdb.DBException;
import FPdb.DBUtil;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan Sobier
 * @version 12/17/2017
 */
public class updateDialog extends JDialog implements ActionListener {

    public updateDialog() {

        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        emailUpdate = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        fNameLabel = new javax.swing.JLabel();
        lNameLabel = new javax.swing.JLabel();
        idUpdate = new javax.swing.JTextField();
        firstNameUpdate = new javax.swing.JTextField();
        lastNameUpdate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 400));
        setTitle("Update Customer"); // NOI18N
        setResizable(true);
        setLocation(725, 400);

        jPanel1.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel1.setName("jPanel1");

        idLabel.setText("Customer ID:");
        idLabel.setName("idLabel");

        idUpdate.setText("");
        idUpdate.setName("idUpdate");

        emailLabel.setText("Email:");
        emailLabel.setName("emailLabel");

        emailUpdate.setText("");
        emailUpdate.setName("emailUpdate");

        updateButton.setText("UPDATE");
        updateButton.setName("updateButton");
        updateButton.addActionListener(this);

        exitBtn.setText("CANCEL");
        exitBtn.setName("exitBtn");
        exitBtn.addActionListener(this);

        saveBtn.setText("SAVE");
        saveBtn.setName("saveBtn");
        saveBtn.addActionListener(this);

        fNameLabel.setText("First Name:");
        fNameLabel.setName("fNameLabel");

        lNameLabel.setText("Last Name:");
        lNameLabel.setName("lNameLabel");

        firstNameUpdate.setText("");
        firstNameUpdate.setName("firstNameUpdate");

        lastNameUpdate.setText("");
        lastNameUpdate.setName("lastNameUpdate");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(fNameLabel)
                                                        .add(idLabel)
                                                        .add(emailLabel)
                                                        .add(lNameLabel))
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, firstNameUpdate)
                                                        .add(lastNameUpdate)
                                                        .add(idUpdate)
                                                        .add(emailUpdate)))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(updateButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(saveBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(exitBtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED))
        );

        jPanel1Layout.linkSize(new java.awt.Component[]{updateButton, saveBtn, exitBtn}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(idUpdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(idLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(emailUpdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(emailLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(fNameLabel)
                                        .add(firstNameUpdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(lNameLabel)
                                        .add(lastNameUpdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(updateButton)
                                        .add(saveBtn)
                                        .add(exitBtn))
                                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 375, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setVisible(true);
    }

    // Code for dispatching events from components to event handlers.
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == updateButton) {
            try {
                updateDialog.this.updateButtonActionPerformed(evt);
            } catch (DBException ex) {
                Logger.getLogger(updateDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getSource() == saveBtn) {
            try {
                updateDialog.this.saveBtnActionPerformed(evt);
            } catch (DBException | SQLException ex) {
                Logger.getLogger(updateDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getSource() == exitBtn) {
            updateDialog.this.exitBtnActionPerformed(evt);
        }
    }

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) throws DBException {
        String first = idUpdate.getText();
        Connection connection = DBUtil.getConnection();

        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM customer WHERE custID=?");
            st.setString(1, first);
            ResultSet res = st.executeQuery();
            res.next();
            idUpdate.setText(res.getString(1));
            firstNameUpdate.setText(res.getString(2));
            lastNameUpdate.setText(res.getString(3));
            emailUpdate.setText(res.getString(4));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot edit data!");
        }

    }

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) throws DBException, SQLException {
        try {

            String v1 = idUpdate.getText();
            String v2 = firstNameUpdate.getText();
            String v3 = lastNameUpdate.getText();
            String v4 = emailUpdate.getText();

            String update = "UPDATE customer SET custID = '" + v1 + "',firstName='" + v2 + "',lastName='" + v3 + "',email='" + v4 + "'WHERE custID='" + v1 + "'";

            Connection connection = DBUtil.getConnection();
            PreparedStatement pst = connection.prepareStatement(update);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data for " + firstNameUpdate.getText() + " " + lastNameUpdate.getText() + " has been updated successfully");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        idUpdate.setText(" ");
        firstNameUpdate.setText(" ");
        lastNameUpdate.setText(" ");
        emailUpdate.setText(" ");
        dispose();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton updateButton;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JLabel lNameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField emailUpdate;
    private javax.swing.JTextField idUpdate;
    private javax.swing.JTextField firstNameUpdate;
    private javax.swing.JTextField lastNameUpdate;
    // End of variables declaration                   
}
