package dtos;

public class AdminDTO 
{
    private int userID;
    private String username;
    private String password;

    public int getUserID() 
    {
        return userID;
    }

    public String getUsername() 
    {
        return username;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
