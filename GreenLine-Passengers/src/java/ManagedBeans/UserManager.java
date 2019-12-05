package ManagedBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "userManager")
@Dependent
public class UserManager {
    
    private int userID;
    private String email;
    private String password;
    private String passwordCheck;

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String addUserToDB() {
        if (password == passwordCheck) {
            try {
                DriverManager.registerDriver(
                        new org.apache.derby.jdbc.ClientDriver());
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database1", "admin1", "admin1");

                PreparedStatement stmt = con.prepareStatement("INSERT INTO USERS (EMAIL, PASSWORD) VALUES (?, ?)");
                stmt.setString(1, email);
                stmt.setString(2, password);

                stmt.execute();

                stmt.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Password does not match"));
        }
                return "null";
    }
}
