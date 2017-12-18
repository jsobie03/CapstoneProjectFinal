package FPdialog;

import FPdb.DBException;
import FPdb.DBUtil;
import FPutils.Validator;

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
public class addDialog extends JDialog implements ActionListener {

    public addDialog() {

        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        fNameLabel = new javax.swing.JLabel();
        lNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        fNameField = new javax.swing.JTextField();
        lNameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        addNewButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Add a New Customer");
        this.setMaximumSize(new java.awt.Dimension(800, 500));
        this.setSize(new java.awt.Dimension(500, 450));
        this.setLocation(725, 400);
        this.setResizable(true);
        this.setVisible(true);
        JDialog.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add New Customer", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial", 1, 16), new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setName("jPanel1");

        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        idLabel.setText("Customer ID:");
        idLabel.setName("idLabel");

        fNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        fNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        fNameLabel.setText("First Name:");
        fNameLabel.setName("fNameLabel");

        lNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        lNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lNameLabel.setText("Last Name:");
        lNameLabel.setName("lNameLabel");

        emailLabel.setForeground(new java.awt.Color(0, 0, 0));
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        emailLabel.setText("Email:");
        emailLabel.setName("emailLabel");

        idField.setText("");
        idField.setName("idField");
        idField.addActionListener(this);

        fNameField.setText("");
        fNameField.setName("fNameField");
        fNameField.addActionListener(this);

        lNameField.setText("");
        lNameField.setName("lNameField");
        lNameField.addActionListener(this);

        emailField.setText("");
        emailField.setName("emailField");
        emailField.addActionListener(this);

        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setName("jPanel2");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(0, 44, Short.MAX_VALUE)
        );

        addNewButton.setBackground(new java.awt.Color(255, 255, 255));
        addNewButton.setFont(new java.awt.Font("Verdana", 1, 12));
        addNewButton.setForeground(new java.awt.Color(0, 0, 0));
        addNewButton.setText("ADD");
        addNewButton.setToolTipText("Add a new customer");
        addNewButton.setName("addNewButton");
        addNewButton.addActionListener(this);

        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setFont(new java.awt.Font("Verdana", 1, 12));
        cancelButton.setForeground(new java.awt.Color(0, 0, 0));
        cancelButton.setText("CANCEL");
        cancelButton.setToolTipText("Cancel and exit form");
        cancelButton.setName("cancelButton");
        cancelButton.addActionListener(this);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(idLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(emailLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(lNameLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                                        .add(fNameLabel))
                                                .add(10, 10, 10)
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                                                .add(org.jdesktop.layout.GroupLayout.LEADING, emailField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                                .add(org.jdesktop.layout.GroupLayout.LEADING, idField)
                                                                .add(org.jdesktop.layout.GroupLayout.LEADING, lNameField)
                                                                .add(org.jdesktop.layout.GroupLayout.LEADING, fNameField))))
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(addNewButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(10, 10, 10)
                                                .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        jPanel1Layout.linkSize(new java.awt.Component[]{idLabel, emailLabel, fNameLabel, lNameLabel}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.linkSize(new java.awt.Component[]{addNewButton, cancelButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(idLabel)
                                        .add(idField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(fNameLabel)
                                        .add(fNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(lNameLabel)
                                        .add(lNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(emailLabel)
                                        .add(emailField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(addNewButton)
                                        .add(cancelButton))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 215, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == addNewButton) {
            try {
                addDialog.this.addNewButtonActionPerformed(evt);
            } catch (SQLException | DBException ex) {
                Logger.getLogger(addDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getSource() == cancelButton) {
            addDialog.this.cancelButtonActionPerformed(evt);
        }
    }// </editor-fold>                        

    private void addNewButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, DBException {
        if (isValidData()) {
            try {
                Connection connection = DBUtil.getConnection();
                PreparedStatement insertNewData = connection.prepareStatement("INSERT INTO Customer (custID, firstName, lastName, email)"
                        + "VALUES (?, ?, ?, ?)");

                String tf1, tf2, tf3, tf4;

                tf1 = idField.getText();
                tf2 = fNameField.getText();
                tf3 = lNameField.getText();
                tf4 = emailField.getText();

                insertNewData.setString(1, tf1);
                insertNewData.setString(2, tf2);
                insertNewData.setString(3, tf3);
                insertNewData.setString(4, tf4);

                int result = 0;
                result = insertNewData.executeUpdate();

                JOptionPane.showMessageDialog(rootPane, "The data for " + tf2 + " " + tf3 + " has been added to the database!", "Customer Added", JOptionPane.INFORMATION_MESSAGE);

                idField.setText("");
                fNameField.setText("");
                lNameField.setText("");
                emailField.setText("");
                dispose();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    public boolean isValidData() {
        Validator sv = new Validator();
        return sv.isNotEmpty(idField, "Customer ID")
                && sv.isNotEmpty(fNameField, "First Name")
                && sv.isNotEmpty(lNameField, "Last Name")
                && sv.isNotEmpty(emailField, "Email")
                && sv.isNotInteger(fNameField, "First Name")
                && sv.isNotInteger(lNameField, "Last Name")
                && sv.isEmail(emailField, "Email")
                && sv.isInteger(idField, "Customer ID");
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton addNewButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField fNameField;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lNameField;
    private javax.swing.JLabel lNameLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idField;
    // End of variables declaration                   
}
