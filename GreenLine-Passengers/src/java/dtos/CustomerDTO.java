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

    public CustomerDTO(int personID, int userID, String firstName, String surname, Date dob, String passportNumber, int contactNumber, int emergencyContactNumber, String gender, String country) {
        this.personID = personID;
        this.userID = userID;
        this.firstName = firstName;
        this.surname = surname;
        this.dob = dob;
        this.passportNumber = passportNumber;
        this.contactNumber = contactNumber;
        this.emergencyContactNumber = emergencyContactNumber;
        this.gender = gender;
        this.country = country;
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

    @Override
    public String toString() {
        return "Customer Details{" + "personID=" + personID + ", userID=" + userID + ", firstName=" + firstName + ", surname=" + surname + ", dob=" + dob + ", passportNumber=" + passportNumber + ", contactNumber=" + contactNumber + ", emergencyContactNumber=" + emergencyContactNumber + ", gender=" + gender + ", country=" + country + '}';
    }
    
    
    
}
