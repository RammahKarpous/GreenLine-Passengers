package ManagedBeans;
//Imports
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
//Managed Bean properties
@Named(value = "bookingManager")
@SessionScoped
//class
public class BookingManager implements Serializable{
    //attributes
    private int bookingID;
    private String classType;
    private int flightID;
    private int personID;
    private String type;
//Setter and getter methods
    public int getBookingID() {
        return bookingID;
    }
    
    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //Methods
    public String createBookFlight(){
                try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO BOOKINGS (CLASS, FLIGHTID, PERSONID, TYPE) VALUES (?, ?, (SELECT userid FROM user WHERE loggedin = true), ?)");
            stmt.setString(1, classType);
            stmt.setInt(2, flightID);
            stmt.setString(3, type);
            
             stmt.execute();
       
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "userpanel";
}
}
