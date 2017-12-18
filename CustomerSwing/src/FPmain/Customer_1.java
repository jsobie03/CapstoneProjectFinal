package FPmain;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Jonathan Sobier
 * @version 12/17/2017
 */

@Entity
@Table(name = "customer", catalog = "customerdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Customer_1.findAll", query = "SELECT c FROM Customer_1 c")
    , @NamedQuery(name = "Customer_1.findAllByCustomerID", query = "SELECT c FROM Customer_1 c WHERE c.custID = :custID ")
    , @NamedQuery(name = "Customer_1.findByEmail", query = "SELECT c FROM Customer_1 c WHERE c.email = :email")
    , @NamedQuery(name = "Customer_1.findByFirstName", query = "SELECT c FROM Customer_1 c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "Customer_1.findByLastName", query = "SELECT c FROM Customer_1 c WHERE c.lastName = :lastName")})
public class Customer_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "custID")
    private String custID;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;

    public Customer_1() {
    }

    public String getCustID() {
        return custID;
    }

    public void getCustID(String custID) {
        String oldCustID = this.custID;
        this.custID = custID;
        changeSupport.firePropertyChange("custID", oldCustID, custID);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("FName", oldFName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("LName", oldLName, lastName);
    }

}
