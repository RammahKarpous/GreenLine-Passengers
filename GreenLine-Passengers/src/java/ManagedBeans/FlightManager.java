package ManagedBeans;

import DTOS.FlightDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Named(value = "flightManager")
@SessionScoped

public class FlightManager implements Serializable {

//Attributes
    private int flightID;
    private String flightNumber;
    private String flightCompany;
    private String city;
    private double price;
    private String departureTime;
    private String arrivalTime;

//Getter and setters
    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //Methods
    public ArrayList<FlightDTO> fetchFlights() {
        ArrayList<FlightDTO> flightList = new ArrayList<>();

        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM FLIGHTS");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FlightDTO flights = new FlightDTO(
                        rs.getInt("FLIGHTID"),
                        rs.getString("FLIGHTNUMBER"),
                        rs.getString("FLIGHTCOMPANY"),
                        rs.getString("CITY"),
                        rs.getDouble("PRICE"),
                        rs.getString("DEPARTURETIME"),
                        rs.getString("ARRIVALTIME"),
                        rs.getString("CANCELLATIONDATE")
                );
                flightList.add(flights);
            }

            stmt.execute();

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
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO FLIGHTS (FLIGHTNUMBER, FLIGHTCOMPANY, CITY, DEPARTURETIME, ARRIVALTIME, PRICE, CANCELLATIONDATE) VALUES (?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, flightNumber);
            stmt.setString(2, flightCompany);
            stmt.setString(3, city);
            stmt.setString(4, departureTime);
            stmt.setString(5, arrivalTime);
            stmt.setDouble(6, price);
            stmt.setString(7, "00/00/0000");
            stmt.execute();

            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "adminpanel";
    }

    public String deleteFlight() {
        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("DELETE FROM FLIGHTS WHERE FLIGHTNUMBER = ?");

            stmt.setString(1, flightNumber);
            stmt.executeUpdate();

            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "adminpanel";
    }

    public String updateFlight() {
        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("UPDATE FLIGHTS SET FLIGHTNUMBER = ?, FLIGHTCOMPANY = ?, CITY = ?, DEPARTURETIME = ?, ARRIVALTIME = ?, PRICE = ?, CANCELLATIONDATE = ? WHERE FLIGHTID = ?");

            stmt.setString(1, flightNumber);
            stmt.setString(2, flightCompany);
            stmt.setString(3, city);
            stmt.setString(4, departureTime);
            stmt.setString(5, arrivalTime);
            stmt.setDouble(6, price);
            stmt.setString(7, "00/00/0000");
            stmt.setInt(8, flightID);
            stmt.executeUpdate();

            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "adminpanel";
    }

}
