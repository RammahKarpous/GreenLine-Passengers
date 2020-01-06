//Package 
package ManagedBeans;
//Import packages

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import DTOS.FlightDTO;
//Managed bean scopes

@Named(value = "flightManager")
@SessionScoped
//Class
public class FlightManager implements Serializable {
//Attributes

  private int flightID;
  private int flightNumber;
  private String flightCompany;
  private String city;
  private double price;
  private String departureTime;
  private String arrivalTime;
  private int adminID;
  private String country;

//Getter and setters
  public int getFlightID() {
    return flightID;
  }

  public void setFlightID(int flightID) {
    this.flightID = flightID;
  }

  public int getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(int flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getFlightCompany() {
    return flightCompany;
  }

  public void setFlightCompany(String flightCompany) {
    this.flightCompany = flightCompany;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public int getAdminID() {
    return adminID;
  }

  public void setAdminID(int adminID) {
    this.adminID = adminID;
  }

  //Methods
  public ArrayList<FlightDTO> fetchFlights() {
    ArrayList<FlightDTO> flightList = new ArrayList<>();

    try {
      DriverManager.registerDriver(
              new org.apache.derby.jdbc.ClientDriver());
      Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database1", "admin1", "admin1");

      PreparedStatement stmt = con.prepareStatement("SELECT * FROM FLIGHTS");

      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        FlightDTO flights = new FlightDTO(
                rs.getInt("FLIGHTID"),
                rs.getString("FLIGHTNUMBER"),
                rs.getString("FLIGHTCOMPANY"),
                rs.getString("CITYCODE"),
                rs.getDouble("PRICE"),
                rs.getString("DEPARTURELOCATION"),
                rs.getString("ARRIVALDESTINATION"),
                rs.getTime("DEPARTURETIME"),
                rs.getTime("ARRIVALTIME"),
                rs.getDate("CANCELLATIONDATE")
        );
        flightList.add(flights);
      }

      rs.close();
      stmt.close();
      con.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flightList;
  }

  public String addFlight() {
    try {
      DriverManager.registerDriver(
              new org.apache.derby.jdbc.ClientDriver());
      Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database1", "admin1", "admin1");

      PreparedStatement stmt = con.prepareStatement("INSERT INTO FLIGHTS (FLIGHTNUMBER, FLIGHTCOMPANY, CITY, DEPARTURETIME, ARRIVALTIME, COUNTRY, PRICE) VALUES (?, ?, ?, ?, ?, ?, ?)");

      stmt.setInt(1, flightNumber);
      stmt.setString(2, flightCompany);
      stmt.setString(3, city);
      stmt.setString(4, departureTime);
      stmt.setString(5, arrivalTime);
      stmt.setString(6, country);
      stmt.setDouble(7, price);

      stmt.execute();

      stmt.close();
      con.close();

    } catch (SQLException e) {
      System.out.println(e);
    }
    return "adminpanel";
  }

  public String deleteFlight() {
    try {
      DriverManager.registerDriver(
              new org.apache.derby.jdbc.ClientDriver());
      Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database1", "admin1", "admin1");

      PreparedStatement stmt = con.prepareStatement("DELETE FROM FLIGHTS WHERE FLIGHTNUMBER = ?");

      stmt.setInt(1, flightNumber);
      stmt.executeUpdate();

      stmt.close();
      con.close();

    } catch (SQLException e) {
      System.out.println(e);
    }
    return "adminpanel";
  }

  public String updateFlight() {
    try {
      DriverManager.registerDriver(
              new org.apache.derby.jdbc.ClientDriver());
      Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database1", "admin1", "admin1");

      PreparedStatement stmt = con.prepareStatement("UPDATE FLIGHTS " + "FLIGHTNUMBER, FLIGHTCOMPANY, CITY, DEPARTURETIME, ARRIVALTIME, COUNTRY, PRICE");

      stmt.setInt(1, flightNumber);
      stmt.setString(2, flightCompany);
      stmt.setString(3, city);
      stmt.setString(4, departureTime);
      stmt.setString(5, arrivalTime);
      stmt.setString(6, country);
      stmt.setDouble(7, price);

      stmt.executeUpdate();

      stmt.close();
      con.close();

    } catch (SQLException e) {
      System.out.println(e);
    }
    return "adminpanel";
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

}
