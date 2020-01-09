package ManagedBeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.xml.registry.infomodel.User;

@Named(value = "userLogin")
@SessionScoped
public class UserLogin implements Serializable {

    private String email;
    private String password;
    private int currentCustomer;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }

    public int getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(int currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public boolean userLogin() {
        boolean credentialsOK = false;
        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM USERS WHERE EMAIL = ?");

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                credentialsOK = rs.getString("PASSWORD").equals(password);
                if (credentialsOK = true) {
                    currentCustomer = rs.getInt("USERID");
                }
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, e.toString());
            this.email = "";
            this.password = "";
            this.currentCustomer = 0;
        };
        return credentialsOK;
    }

    public String logout() {
        this.email = "";
        this.password = "";
        this.currentCustomer = 0;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logout";
    }
}
