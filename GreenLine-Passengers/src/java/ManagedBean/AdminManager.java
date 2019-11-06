package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

@Named(value = "adminManager")
@SessionScoped
public class AdminManager implements Serializable 
{
    ArrayList<dtos.AdminDTO> admins = new ArrayList<>();

    public AdminManager() 
    {
        
    }
    
    
}
