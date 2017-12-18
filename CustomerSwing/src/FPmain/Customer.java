package FPmain;

import FPutils.StringUtils;

/**
 * Stores data for the customers email address, first name, and last name
 *
 * @author Jonathan Sobier
 * @version 12/17/2017
 */
public class Customer implements CustomerConstants {

    String id;
    String firstName;
    String lastName;
    String email;

    public Customer() {
        id = "";
        firstName = "";
        lastName = "";
        email = "";
    }

    public Customer(String id, String firstName, String lastName, String email) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    public void setFirst(String firstName) {
        this.firstName = firstName;
    }

    public String getFirst() {
        return firstName;
    }

    public void setLast(String lastName) {
        this.lastName = lastName;
    }

    public String getLast() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.padWithSpaces(
                getID(), CUST_ID_SIZE));
        sb.append(StringUtils.padWithSpaces(
                getFirst(), FIRST_NAME_SIZE));
        sb.append(StringUtils.padWithSpaces(
                getLast(), LAST_NAME_SIZE));
        sb.append(StringUtils.padWithSpaces(
                getEmail(), EMAIL_SIZE));
        return sb.toString();
    }

}
