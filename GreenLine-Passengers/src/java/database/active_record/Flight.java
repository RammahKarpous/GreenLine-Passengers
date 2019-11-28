/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.active_record;
import databaseB.ConnectionManager;
import databaseB.DatabaseConnection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 *
 * @author filip
 */
public class Flight implements ActiveRecord {
        private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat stf = new SimpleDateFormat("hh:mm");
    
    private static final String GET_FLIGHT_ID = "SELECT flightId FROM Flights WHERE flightNumber=? AND flightCompany=? AND price=? AND companyImage=? AND departureTime=? AND arrivalTime=? AND country=? AND city=?";
    private static final String INSERT_FLIGHT = "INSERT INTO Flights(flightNumber, flightCompany, price, companyImage, departureTime, arrivalTime, country, city) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_FLIGHT
            = "UPDATE Flights "
            + "SET flightNumber=?, flightCompany=?, price=?, companyImage=?, departureTime=?, arrivalTime=?, country=?, city=? "
            + "WHERE flightId=?";
    private static final String DELETE_FLIGHT = "DELETE FROM Flights WHERE flightId=?";

    private int flightId;
    private String flightNumber;
    private String flightCompany;
    private Double price;
    private String companyImage;
    private Date departureTime;
    private Date arrivalTime;
    private String country;
    private String city;
    private HashMap<Integer, PersonFlight> personFlights;
    
    public Flight(String flightNumber, String flightCompany, double price, String companyImage, Date departureTime, Date arrivalTime, String country, String city)
    {
        this(-1, flightNumber, flightCompany, price, companyImage, departureTime, arrivalTime, country,city);
    }

    public Flight(int flightId, String flightNumber, String flightCompany, double price, String companyImage, Date departureTime, Date arrivalTime, String country, String city)
    {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.price = price;
        this.companyImage = companyImage;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.country = country;
        this.city = city;  
        
        personFlights = new HashMap<>();
    }

    public int getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public Double getPrice() {
        return price;
    }

    public String getCompanyImage() {
        return companyImage;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCompanyImage(String companyImage) {
        this.companyImage = companyImage;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }


    



   @Override
    public void insert() throws Exception
    {
        DatabaseConnection con = ConnectionManager.getInstance().getConnection();
        con.prepareStatement(INSERT_FLIGHT);
        con.setStatementParameter(1, flightId);
        con.setStatementParameter(2, flightNumber);
        con.setStatementParameter(3, flightCompany);
        con.setStatementParameter(4, price);
        con.setStatementParameter(5, companyImage);
        con.setStatementParameter(6, departureTime);
        con.setStatementParameter(7, country);
        con.setStatementParameter(8, city);
        if (!con.executePreparedStatement()
                && con.getUpdateCount() < 1)
        {
            throw new Exception("Insertion failed for: " + this);
        }
        con.prepareStatement(GET_FLIGHT_ID);
        con.setStatementParameter(1, flightId);
        con.setStatementParameter(2, flightNumber);
        con.setStatementParameter(3, flightCompany);
        con.setStatementParameter(4, price);
        con.setStatementParameter(5, companyImage);
        con.setStatementParameter(6, departureTime);
        con.setStatementParameter(7, country);
        con.setStatementParameter(8, city);
        if (con.executePreparedStatement())
        {
            try
            {
                ResultSet rs = con.getResultSet();
                if (rs.next())
                {
                    flightId = rs.getInt("ShiftId");
                }
            }
            catch (SQLException sqle)
            {

            }
            for (Integer key : personFlights.keySet())
        {
           // personFlights.get(key).insert();
        }
        con.close();
    }
    }
    
        @Override
    public void update() throws Exception
    {
        DatabaseConnection con = ConnectionManager.getInstance().getConnection();
        con.prepareStatement(UPDATE_FLIGHT);
        con.setStatementParameter(1, flightId);
        con.setStatementParameter(2, flightNumber);
        con.setStatementParameter(3, flightCompany);
        con.setStatementParameter(4, price);
        con.setStatementParameter(5, companyImage);
        con.setStatementParameter(6, departureTime);
        con.setStatementParameter(7, country);
        con.setStatementParameter(8, city);
        if (!con.executePreparedStatement()
                && con.getUpdateCount() < 1)
        {
            throw new Exception("Update failed for: " + this);
        }
        for (Integer key : personFlights.keySet())
        {
           /// personFlights.get(key).insert();
        }
        con.close();
    }

    @Override
    public void delete() throws Exception
    {
        //relies on the database cascading the deletion to the PersonShift records
        DatabaseConnection con = ConnectionManager.getInstance().getConnection();
        con.prepareStatement(DELETE_FLIGHT);
        con.setStatementParameter(1, flightId);
        if (!con.executePreparedStatement()
                && con.getUpdateCount() < 1)
        {
            throw new Exception("Deletion failed for: " + this);
        }
        con.close();
     //   personFlights = null;
    }
}
