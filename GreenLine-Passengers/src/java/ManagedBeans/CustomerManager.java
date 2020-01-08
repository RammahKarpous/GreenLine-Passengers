package ManagedBeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//Managed bean scopes
@Named
@SessionScoped
//Class
public class CustomerManager implements Serializable {

    //Attributes
    private int customerID;
    private String firstName;
    private String middleName;
    private String surName;
    private String dob;
    private String passportNumber;
    private String contactNumber;
    private String emergencyContactNumber;
    private String gender;
    private String country;
    private String city;
    private int userID;

//Getters and setters
    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurName() {
        return surName;
    }

    public String getDob() {
        return dob;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }
    
    public int getUserID() {
        return userID;
    }

    public String getCity() {
        return city;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }

//Methods
    public String addCustomerToDB() {
        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO CUSTOMER (FIRSTNAME, MIDDLENAME, SURNAME, DOB, PASSPORTNUMBER, CONTACTNUMBER, EMERGENCYCONTACTNUMBER, GENDER, COUNTRY, CITY ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, firstName);
            stmt.setString(2, middleName);
            stmt.setString(3, surName);
            stmt.setString(4, dob);
            stmt.setString(5, passportNumber);
            stmt.setString(6, contactNumber);
            stmt.setString(7, emergencyContactNumber);
            stmt.setString(8, gender);
            stmt.setString(9, country);
            stmt.setString(10, city);
            stmt.setInt(11, userID);

            stmt.execute();

            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
