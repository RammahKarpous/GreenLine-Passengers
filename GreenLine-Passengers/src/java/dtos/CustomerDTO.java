package dtos;

import java.util.Date;

public class CustomerDTO 
{
    private int personID;
    private int userID;
    private String firstName;
    private String surname;
    private Date dob;
    private String passportNumber;
    private int contactNumber;
    private int emergencyContactNumber;
    private String gender;
    private String country;

    public int getPersonID() {
        return personID;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
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

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
    
       
}
