package ManagedBeans;

import database.active_record.FlightHandler;
import database.active_record.User;
import database.active_record.Flight;
import database.active_record.PersonFlight;
import database.active_record.UserHandler;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="admin")
@SessionScoped
public class Admin_UI  implements Serializable
{
    private String username;
    private String password;
    private final transient FlightHandler flightHandler;
    private final transient UserHandler userHandler;
    @Inject
  
    private transient Flight flightToCreate;
    private transient Flight flightToView;
    private transient Flight flightToDelete;
    private User user = null;
    public Admin_UI()
    {
        clearFields();
        
        flightHandler = new FlightHandler();
        userHandler = new UserHandler();
    }
    public String getUsername()
    { 
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String pwd)
    {
        this.password = pwd;
    }


    public void clearFields()
    {
        username = "";
        password = "";
        flightToCreate = null;
        flightToView = null;
        flightToDelete = null;
    }

    public String checkCredentials()
    {
        String outcome = "";

        if (username.equalsIgnoreCase("admin")
                && password.equals("Admin"))
        {
            password = "";
            outcome = "loginOK";
        }

        if (outcome.isEmpty())
        {
            clearFields();
            FacesMessage msg = new FacesMessage("Username and/or password not recognised.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        return outcome;
    }
        public String logout()
    {
            clearFields();
            return "logout";
    }
  //  public ArrayList<Flight> getAllFlights()
//    {
 //       return flightHandler.findAllShifts();
  //  }

    public Flight getFlightToCreate()
    {
        return flightToCreate;
    }

   public String setFlightToCreate()
   {
       Date d = new Date(System.currentTimeMillis());
       flightToCreate = new Flight("ghaha","haha",3.5,"haha",d,d,"haha","haha");
        return "planFlight";
    }

    public String createFlight()
    {
        String outcome = "";
        
        if (flightHandler.createFlight(flightToCreate))
        {
            flightToView = flightToCreate;
            flightToCreate = null;
            outcome = "shiftCreated";
        }
        return outcome;
    }
    public String cancelFlightCreation()
    {
        flightToCreate = null;
        return "cancel";
    }

    public Flight getFlightToView()
    {
        return flightToView;
    }

    public String setFlightToView(Flight s)
    {
        flightToView = s;
        return "FlightDetails";
    }

    public Flight getFlightToDelete()
    {
        return flightToDelete;
    }

    public String setFlightToDelete(Flight s)
    {
        flightToDelete = s;
        return "deleteFlight";
    }

    public String deleteFlight()
    {
        String outcome = "cancel";

        if (flightHandler.deleteFlight(flightToDelete))
        {
            flightToDelete = null;
            outcome = "shiftDeleted";
        }

        return outcome;
    }
    
}
