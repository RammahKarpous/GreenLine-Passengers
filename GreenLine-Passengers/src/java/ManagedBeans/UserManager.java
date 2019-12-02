/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Nurul Amin
 */
@Named(value = "userManager")
@Dependent
public class UserManager{

    /**
     * Creates a new instance of UserManager
     */
    
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

        return "index";
    
}
