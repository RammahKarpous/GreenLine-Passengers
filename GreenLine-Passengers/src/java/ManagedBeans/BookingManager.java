package ManagedBeans;
//Imports
import DTOS.BookingDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

            PreparedStatement stmt = con.prepareStatement("INSERT INTO BOOKING (CLASSTYPE, FLIGHTID, PERSONID, TYPE) VALUES (?, ?, ?, ?)");
            stmt.setString(1, classType);
            stmt.setInt(2, flightID);
            stmt.setInt(3, personID);
            stmt.setString(4, type);
            
             stmt.execute();
       
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "userpanel";
}
    
    public ArrayList<BookingDTO> fetchBookings() {
        ArrayList<BookingDTO> bookingList = new ArrayList<>();

        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM BOOKING");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                BookingDTO booking = new BookingDTO(
                        rs.getInt("BOOKINGID"),
                        rs.getString("CLASSTYPE"),
                        rs.getInt("FLIGHTID"),
                        rs.getInt("PERSONID"),
                        rs.getString("TYPE")
                );
                bookingList.add(booking);
            }

            stmt.execute();

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingList;
    }
}
