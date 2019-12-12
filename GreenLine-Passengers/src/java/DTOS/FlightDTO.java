package DTOS;

import java.sql.Date;
import java.sql.Time;

public class FlightDTO {
 
private int flightID;
private int flightNumber;
private String flightCompany;
private String city;
private double price;
private String departureTime;
private String arrivalTime;
private Time cancelationDeadline;
private String country;
private int adminID;

    public FlightDTO(int flightID, int flightNumber, String flightCompany, String city, double price, String departureTime, String arrivalTime, String country, int adminID) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.city = city;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.country = country;
        this.adminID = adminID;
    }

    public int getFlightID() {
        return flightID;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public String getCity() {
        return city;
    }

    public double getPrice() {
        return price;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }


    public int getAdminID() {
        return adminID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }



    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    


}
