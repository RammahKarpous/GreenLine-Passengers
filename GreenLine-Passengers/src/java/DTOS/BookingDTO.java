package DTOS;

public class BookingDTO {
    
    
    private int bookingID;
    private String classType;
    private int flightID;
    private int personID;
    private String type;

    public BookingDTO(int bookingID, String classType, int flightID, int personID, String type) {
        this.bookingID = bookingID;
        this.classType = classType;
        this.flightID = flightID;
        this.personID = personID;
        this.type = type;
    }

    public int getBookingID() {
        return bookingID;
    }

    public String getClassType() {
        return classType;
    }

    public int getFlightID() {
        return flightID;
    }

    public int getPersonID() {
        return personID;
    }

    public String getType() {
        return type;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public void setSlassType(String classType) {
        this.classType = classType;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
