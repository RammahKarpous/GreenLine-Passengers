package DTOS;

import java.sql.Date;

public class CustomerDTO {

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

    public CustomerDTO(int personID, String firstName, String middleName, String surName, String dob, String passportNumber, String contactNumber, String emergencyContactNumber, String gender, String country, String city) {
        this.customerID = personID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surName = surName;
        this.dob = dob;
        this.passportNumber = passportNumber;
        this.contactNumber = contactNumber;
        this.emergencyContactNumber = emergencyContactNumber;
        this.gender = gender;
        this.country = country;
        this.city = city;
    }

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
}
