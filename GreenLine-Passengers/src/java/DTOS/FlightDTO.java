package DTOS;

import java.sql.Date;
import java.sql.Time;

public class FlightDTO {
 
private int flightID;
private int flightNumber;
private String flightCompany;
private String cityCode;
private double price;
private Date departureTime;
private Date arrivalTime;
private Time cancelationDeadline;
private int adminID;

    public FlightDTO(int flightID, int flightNumber, String flightCompany, String cityCode, double price, Date departureTime, Date arrivalTime, Time cancelationDeadline, int adminID) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.cityCode = cityCode;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.cancelationDeadline = cancelationDeadline;
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

    public String getCityCode() {
        return cityCode;
    }

    public double getPrice() {
        return price;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public Time getCancelationDeadline() {
        return cancelationDeadline;
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

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setCancelationDeadline(Time cancelationDeadline) {
        this.cancelationDeadline = cancelationDeadline;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    


}
