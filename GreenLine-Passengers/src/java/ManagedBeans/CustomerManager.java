package ManagedBeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

//Managed bean scopes
@Named
@SessionScoped
//Class
public class CustomerManager implements Serializable {

    //Attributes
    private int personID;
    private int userID;
    private String firstName;
    private String middleName;
    private String surName;
    private Date dob;
    private String passportNumber;
    private int contactNumber;
    private int emergencyContactNumber;
    private String gender;
    private String country;
    private String email;
    private String city;
    private String password;

//Getters and setters
    public String getMiddleName() {
        return middleName;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public int getPersonID() {
        return personID;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public Date getDob() {
        return dob;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public int getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getPassword() {
        return password;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmergencyContactNumber(int emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//Methodss
    public String addCustomerToDB() {

        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database1", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO PERSON (FIRSTNAME, MIDDLENAME, SURNAME, DOB, PASSPORTNUMBER, EMERGANCYCONTACT, GENDER, COUNTRY, CITY, TELEPHONE ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, firstName);
            stmt.setString(3, surName);
            stmt.setDate(4, (java.sql.Date) dob);
            stmt.setString(5, passportNumber);
            stmt.setInt(6, emergencyContactNumber);
            stmt.setString(7, gender);
            stmt.setString(8, country);
            stmt.setString(2, middleName);
            stmt.setString(9, city);
            stmt.setInt(10, contactNumber);
            
             stmt.execute();
       
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }

        return "index";
    }
}