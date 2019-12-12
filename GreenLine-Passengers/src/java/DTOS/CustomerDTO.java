package DTOS;

import java.sql.Date;


public class CustomerDTO {
    
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

    public CustomerDTO(int personID, int userID, String firstName, String middleName, String surName, Date dob, String passportNumber, int contactNumber, int emergencyContactNumber, String gender, String country, String email, String city, String password) {
        this.personID = personID;
        this.userID = userID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surName = surName;
        this.dob = dob;
        this.passportNumber = passportNumber;
        this.contactNumber = contactNumber;
        this.emergencyContactNumber = emergencyContactNumber;
        this.gender = gender;
        this.country = country;
        this.email = email;
        this.city = city;
        this.password = password;
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

    public String getMiddleName() {
        return middleName;
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

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
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

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
