package ManagedBeans;

import databaseB.ConnectionManager;
import databaseB.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class User
{

    private static final String GET_USER_ID = "SELECT UserId FROM Users WHERE Email=?";
    private static final String INSERT_USER = "INSERT INTO USERS(Email, Password) VALUES (?, ?)";

    private int userId;
    private String email;
    private String password;

    public User(int userId, String email, String password)
    {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String pwd)
    {
        this.password = pwd;
    }

    public boolean passwordIsCorrect(String pwd)
    {
        return password.equals(pwd);
    }

    @Override
    public String toString()
    {
        return userId + ":" + email;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof User))
        {
            return false;
        }
        
        if (obj == this)
        {
            return true;
        }
        
        User sp = (User)obj;
        return (this.userId == sp.userId &&
                this.email.equals(sp.getEmail()));
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 67 * hash + this.userId;
        hash = 67 * hash + Objects.hashCode(this.email);
        return hash;
    }
}
    