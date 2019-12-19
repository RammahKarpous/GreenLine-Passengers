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
import org.apache.derby.client.am.DateTime;
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
private ArrayList<FlightDTO> flightList = new ArrayList<>();
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
    public void fetchFlights(){
        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM FLIGHTS");
            
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                flightID = rs.getInt("FLIGHTID");
                flightNumber = rs.getInt("FLIGHTNUMBER");
                flightCompany = rs.getString("FLIGHTCOMPANY");
                city = rs.getString("CITY");
                departureTime = rs.getString("DEPARTURETIME");
                arrivalTime = rs.getString("ARRIVALTIME");
                country = rs.getString("COUNTRY");
                adminID = rs.getInt("ADMINID");
                flightList.add(new FlightDTO(flightID, flightNumber, flightCompany, city, price, departureTime, arrivalTime, departureTime, adminID, country));
                       
            }
            
             stmt.execute();
       
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public String addFlight(){
        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<FlightDTO> getFlightList() {
        return flightList;
    }

    public void setFlightList(ArrayList<FlightDTO> flightList) {
        this.flightList = flightList;
    }

    
}
