package ManagedBeans;

import database.active_record.UserHandler;
import database.active_record.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
@Named
@SessionScoped
public class User_UI implements Serializable
{

    private int userId;
    private String email;
    private String password;

    private final transient UserHandler userHandler;


    public User_UI()
    {
        clearFields();

        userHandler = new UserHandler();
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
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
        userId = -1;
        email = "";
        password = "";
    }

    public String checkCredentials()
    {
        String outcome = "";
        User sp = userHandler.findUserByEmail(email);

        if (sp != null)
        {
            if (sp.passwordIsCorrect(password))
            {
                userId = sp.getUserId();
                email = sp.getEmail();
                password = "";
                outcome = "loginOK";
            }
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
}

