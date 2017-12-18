package FPdialog;

import FPdb.DBException;
import FPdb.DBUtil;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class deleteDialog extends JDialog implements ActionListener {

    /**
     * Creates new form deleteDialog
     */
    public deleteDialog() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDelete = new javax.swing.JLabel();
        fieldDelete = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setForeground(Color.BLACK);
        this.setTitle("Delete Customer");
        this.setMaximumSize(new java.awt.Dimension(800, 500));
        this.setSize(500, 500);
        this.setLocation(725, 400);
        this.setResizable(false);
        this.setVisible(true);
        JDialog.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);

        jPanel1.setForeground(Color.BLACK);
        jPanel1.setName("jPanel1"); // NOI18N
        lblDelete.setForeground(Color.BLACK);

        lblDelete.setText("Email:"); // NOI18N
        lblDelete.setName("lblDelete"); // NOI18N

        fieldDelete.setText(""); // NOI18N
        fieldDelete.setName("fieldDelete"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(lblDelete)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(fieldDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 288, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(lblDelete)
                                        .add(fieldDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDelete.setText("DELETE");
        btnDelete.setName("btnDelete");
        btnDelete.addActionListener(this);

        btnCancel.setText("CANCEL");
        btnCancel.setName("btnCancel");
        btnCancel.addActionListener(this);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                .add(btnDelete)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(btnCancel)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(btnCancel)
                                        .add(btnDelete))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold> 

    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == btnDelete) {
            try {
                deleteDialog.this.btnDeleteActionPerformed(evt);
            } catch (SQLException | DBException ex) {
                Logger.getLogger(deleteDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getSource() == btnCancel) {
            deleteDialog.this.btnCancelActionPerformed(evt);
        }
    }// </editor-fold>                        

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void btnDeleteActionPerformed(ActionEvent evt) throws SQLException, DBException {
        try {

            String sql = "DELETE FROM customerdb.customer WHERE email = ? ";
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, fieldDelete.getText());

            int ask = JOptionPane.showConfirmDialog(this, "Are you sure you want to permanently delete all data for the email address "
                    + fieldDelete.getText() + " from the database?",
                    "Confirm delete", JOptionPane.YES_NO_OPTION);
            if (ask == JOptionPane.YES_NO_OPTION) {
                ps.executeUpdate();
                fieldDelete.setText(" ");
                dispose();
            }
        } catch (SQLException e) {
            for (Throwable t : e) {
                System.out.println(t);
            }

        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JTextField fieldDelete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDelete;
    // End of variables declaration                   

}
