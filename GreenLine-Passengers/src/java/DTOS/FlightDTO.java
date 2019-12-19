package DTOS;

import java.sql.Date;
import java.sql.Time;

public class FlightDTO {
 
private int flightID;
private int flightNumber;
private String flightCompany;
private String cityCode;
private double price;
private String departureTime;
private String arrivalTime;
private String cancelationDeadline;
private int adminID;
private String country;

    public FlightDTO(int flightID, int flightNumber, String flightCompany, String cityCode, double price, String departureTime, String arrivalTime, String cancelationDeadline, int adminID, String country) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.cityCode = cityCode;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.cancelationDeadline = cancelationDeadline;
        this.adminID = adminID;
        this.country = country;
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

    public String getCityCode() {
        return cityCode;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getCancelationDeadline() {
        return cancelationDeadline;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getCountry()
    {
        return country;
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

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
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

    public void setCancelationDeadline(String cancelationDeadline) {
        this.cancelationDeadline = cancelationDeadline;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }
    
    
    


}
