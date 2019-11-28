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
private String cityCode;
private double price;
private Date departureTime;
private Date arrivalTime;
private Time cancelationDeadline;
private int adminID;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getCancelationDeadline() {
        return cancelationDeadline;
    }

    public void setCancelationDeadline(Time cancelationDeadline) {
        this.cancelationDeadline = cancelationDeadline;
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
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database1", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM FLIGHTS");
            
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                flightID = rs.getInt("FLIGHTID");
                flightNumber = rs.getInt("FLIGHTNUMBER");
                flightCompany = rs.getString("FLIGHTCOMPANY");
                cityCode = rs.getString("CITYCODE");
                departureTime = rs.getDate("DEPARTURETIME");
                arrivalTime = rs.getDate("ARRIVALTIME");
                cancelationDeadline = rs.getTime("CANCELATIONDEADLINE");
                adminID = rs.getInt("ADMINID");
                flightList.add(new FlightDTO(flightID, flightNumber, flightCompany, cityCode, price, departureTime, arrivalTime, cancelationDeadline, adminID));
            }
            
             stmt.execute();
       
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public ArrayList<FlightDTO> getFlightList() {
        return flightList;
    }

    public void setFlightList(ArrayList<FlightDTO> flightList) {
        this.flightList = flightList;
    }

    
}
