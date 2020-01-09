package DTOS;

import java.sql.Date;
import java.sql.Time;

public class FlightDTO {

    private int flightID;
    private String flightNumber;
    private String flightCompany;
    private String city;
    private double price;
    private String departureTime;
    private String arrivalTime;
    private String cancelationDeadline;

    public FlightDTO(int flightID, String flightNumber, String flightCompany, String city, double price, String departureTime, String arrivalTime, String cancelationDeadline) {
        this.flightID = flightID;
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.city = city;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.cancelationDeadline = cancelationDeadline;
    }

    public int getFlightID() {
        return flightID;
    }

    public String getFlightNumber() {
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

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getCancelationDeadline() {
        return cancelationDeadline;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setFlightNumber(String flightNumber) {
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

    public void setCancelationDeadline(String cancelationDeadline) {
        this.cancelationDeadline = cancelationDeadline;
    }

}
