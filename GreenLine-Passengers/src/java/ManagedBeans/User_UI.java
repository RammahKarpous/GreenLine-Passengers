package ManagedBeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                try
                {
                    DriverManager.registerDriver(
                            new org.apache.derby.jdbc.ClientDriver());
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database1", "admin1", "admin1");

                    PreparedStatement stmt = con.prepareStatement("UPDATE user SET loggedin=? WHERE userid=?");
                    stmt.setBoolean(1, true);
                    stmt.setInt(2, userId);

                    stmt.execute();

                    stmt.close();
                    con.close();

                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }
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
        try
        {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database1", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("UPDATE user SET loggedin=? WHERE userid=?");
            stmt.setBoolean(1, false);
            stmt.setInt(2, userId);

            stmt.execute();

            stmt.close();
            con.close();

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        clearFields();
        return "logout";
    }
}
