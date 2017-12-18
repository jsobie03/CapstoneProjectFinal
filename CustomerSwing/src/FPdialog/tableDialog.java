package FPdialog;

import FPdb.CustomerDB;
import FPdb.DBException;
import FPdb.DBUtil;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan Sobier
 * @version 12/17/2017
 */
public class tableDialog extends JPanel {

    public tableDialog() throws DBException, SQLException {

        JTable table = new JTable();
        JDialog.setDefaultLookAndFeelDecorated(true);
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = DBUtil.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer ORDER BY custID");
        Object[] columnsName = new Object[4];

        columnsName[0] = "Customer ID";
        columnsName[1] = "First Name";
        columnsName[2] = "Last Name";
        columnsName[3] = "Email";
        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[4];

        for (int i = 0; i < CustomerDB.getAll().size(); i++) {

            rowData[0] = CustomerDB.getAll().get(i).getID();
            rowData[1] = CustomerDB.getAll().get(i).getFirst();
            rowData[2] = CustomerDB.getAll().get(i).getLast();
            rowData[3] = CustomerDB.getAll().get(i).getEmail();

            model.addRow(rowData);
        }

        table.setModel(model);
        table.setSize(505, 500);
        table.getColumnModel().getColumn(0).setMaxWidth(85);
        table.getColumnModel().getColumn(1).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setMaxWidth(100);
        table.getColumnModel().getColumn(3).setMaxWidth(210);

        JFrame window = new JFrame();

        window.setTitle("Customer Data Table");
        window.setResizable(false);
        window.setForeground(Color.BLACK);
        table.setForeground(Color.BLACK);
        window.setSize(505, 300);
        window.setLocation(725, 400);
        JScrollPane pane = new JScrollPane(table);
        window.setContentPane(pane);
        window.setVisible(true);

    }
}
