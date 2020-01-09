package DTOS;

public class UserDTO {

    //Attributes
    private int userID;
    private String email;
    private String password;

    //Constructor
    public UserDTO(int userID, String email, String password) {
        this.userID = userID;
        this.email = email;
        this.password = password;
    }

    //Getter and setter
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //String
    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", email=" + email + ", password=" + password + '}';
    }

}
