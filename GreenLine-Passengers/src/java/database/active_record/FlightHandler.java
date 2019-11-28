/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.active_record;

import java.util.ArrayList;
import databaseB.ConnectionManager;
import databaseB.DatabaseConnection;
public class FlightHandler {
    
        public boolean createFlight(Flight s)
    {
        boolean flightCreated = false;
           try
            {
                s.insert();
                flightCreated = true;
            }
            catch (Exception e)
            {
            }
        return flightCreated;
    }


    public boolean deleteFlight(Flight f)
    {
        boolean shiftDeleted = false;
        
        if (f != null)
        {
            try
            {
                f.delete();
                shiftDeleted = true;
            }
            catch (Exception e)
            {
            }
        }
        return shiftDeleted;
    }
}
