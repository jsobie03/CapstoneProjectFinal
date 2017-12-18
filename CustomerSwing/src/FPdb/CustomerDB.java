package FPdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan Sobier
 * @version 12/17/2017
 */
import FPmain.Customer;

public class CustomerDB {

    public static List<Customer> getAll() throws DBException {
        String sql = "SELECT * FROM customer ORDER BY custID";
        List<Customer> customers = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString("custID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");

                Customer cust = new Customer();
                cust.setID(id);
                cust.setFirst(firstName);
                cust.setLast(lastName);
                cust.setEmail(email);
                customers.add(cust);
            }
            return customers;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public static Customer get(String Email) throws DBException {
        String sql = "SELECT * FROM customer WHERE email = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, Email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String id = rs.getString("custID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                rs.close();

                Customer p = new Customer();
                p.setEmail(Email);
                p.setFirst(firstName);
                p.setLast(lastName);
                p.setID(id);

                return p;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public static void add(Customer customer) throws DBException {
        String sql
                = "INSERT INTO customer (custID, firstName, lastName, email) "
                + "VALUES (?, ?, ?, ?)";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(0, customer.getID());
            ps.setString(1, customer.getFirst());
            ps.setString(2, customer.getLast());
            ps.setString(3, customer.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public static void update(Customer customer) throws DBException {
        String sql = "UPDATE customer SET "
                + "custID = ?, "
                + "firstName = ?, "
                + "lastName = ?, "
                + "WHERE email = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(0, customer.getID());
            ps.setString(1, customer.getFirst());
            ps.setString(2, customer.getLast());
            ps.setString(3, customer.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public static void delete(Customer customer)
            throws DBException {
        String sql = "DELETE FROM customer "
                + "WHERE email = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, customer.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
