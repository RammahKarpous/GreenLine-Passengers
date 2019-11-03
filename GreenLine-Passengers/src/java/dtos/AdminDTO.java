package dtos;

public class AdminDTO 
{
    private int userID;
    private String username;
    private String password;

    public AdminDTO(int userID, String username, String password) 
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

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
    
    @Override
    public String toString()
    {
        String str = "user ID: " + userID + "username: " + username;
        return str;
    }
    
}
