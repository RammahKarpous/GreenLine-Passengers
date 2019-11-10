package ManagedBeans;

import dtos.CustomerDTO;
import java.util.ArrayList;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
public class CustomerManager {

    private ArrayList<CustomerDTO> customers = new ArrayList<>();
    private CustomerDTO customer;
    
    public void fetchCustomerDatabase()
    {
        
    }
    
    public void updateCustomerDatabase()
    {
        
    }
    
    public void customerDTOUpdate()
    {
        customer = new CustomerDTO(0, 0, firstName, surname, dob, passportNumber, 0, 0, gender, country);
        
    }
    
    public void validateCustomerDetails()
    {
        
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
    
    
    
    
}
