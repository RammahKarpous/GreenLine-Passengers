<<<<<<< HEAD
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
>>>>>>> origin/BackEndAdmin
package ManagedBeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
<<<<<<< HEAD
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "userManager")
@Dependent
public class UserManager {
=======

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
>>>>>>> origin/BackEndAdmin
    
    private int userID;
    private String email;
    private String password;
<<<<<<< HEAD
    private String passwordCheck;

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }
=======
>>>>>>> origin/BackEndAdmin

    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

<<<<<<< HEAD
=======
    public void setUserID(int userID) {
        this.userID = userID;
    }
>>>>>>> origin/BackEndAdmin

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
<<<<<<< HEAD

    public String addUserToDB() {
        if (password == passwordCheck) {
            try {
                DriverManager.registerDriver(
                        new org.apache.derby.jdbc.ClientDriver());
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Database1", "admin1", "admin1");

                PreparedStatement stmt = con.prepareStatement("INSERT INTO USERS ( EMAIL, PASSWORD ) VALUES ( ?, ? )");
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
        return null;
=======
    
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
    
>>>>>>> origin/BackEndAdmin
    }
}
