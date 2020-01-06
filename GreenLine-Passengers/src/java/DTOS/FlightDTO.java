package DTOS;

import java.sql.Date;
import java.sql.Time;

public class FlightDTO {
 
private int flightID;
private String flightNumber;
private String flightCompany;
private String cityCode;
private double price;
private String departureLocation;
private String arrivalDestination;
private Time departureTime;
private Time arrivalTime;
private Date cancelationDeadline;

  public FlightDTO(int flightID, String flightNumber, String flightCompany, String cityCode, double price, String departureLocation, String arrivalDestination, Time departureTime, Time arrivalTime, Date cancelationDeadline) {
    this.flightID = flightID;
    this.flightNumber = flightNumber;
    this.flightCompany = flightCompany;
    this.cityCode = cityCode;
    this.price = price;
    this.departureLocation = departureLocation;
    this.arrivalDestination = arrivalDestination;
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

  public String getCityCode() {
    return cityCode;
  }

  public double getPrice() {
    return price;
  }

  public String getDepartureLocation() {
    return departureLocation;
  }

  public String getArrivalDestination() {
    return arrivalDestination;
  }

  public Time getDepartureTime() {
    return departureTime;
  }

  public Time getArrivalTime() {
    return arrivalTime;
  }

  public Date getCancelationDeadline() {
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

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setDepartureLocation(String departureLocation) {
    this.departureLocation = departureLocation;
  }

  public void setArrivalDestination(String arrivalDestination) {
    this.arrivalDestination = arrivalDestination;
  }

  public void setDepartureTime(Time departureTime) {
    this.departureTime = departureTime;
  }

  public void setArrivalTime(Time arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public void setCancelationDeadline(Date cancelationDeadline) {
    this.cancelationDeadline = cancelationDeadline;
  }
}
