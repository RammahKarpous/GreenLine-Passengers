package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "adminManager")
@SessionScoped
public class AdminManager implements Serializable {

    public AdminManager() {
        
    }
    
}
