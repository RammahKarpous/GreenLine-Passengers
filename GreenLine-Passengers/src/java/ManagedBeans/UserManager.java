package ManagedBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "userManager")
@RequestScoped

public class UserManager {

    private int userID;
    private String email;
    private String password;

    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String addUserToDB() {
        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database05", "admin1", "admin1");

            PreparedStatement stmt = con.prepareStatement("INSERT INTO USERS (PASSWORD, EMAIL) VALUES (?, ?)");

            stmt.setString(1, password);
            stmt.setString(2, email);

            stmt.executeUpdate();

            stmt.close();
            con.close();
            return "login";
        } catch (SQLException e) {
            e.printStackTrace();
            this.email = "";
            this.password = "";
            this.userID = 0;
        }
        return "register";
    }
}
