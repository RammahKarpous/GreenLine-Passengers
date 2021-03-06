package ManagedBeans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "admin")
@SessionScoped

public class Admin_UI implements Serializable {

  private String username;
  private String password;

  public Admin_UI() {
    clearFields();

  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String pwd) {
    this.password = pwd;
  }

  public void clearFields() {
    username = "";
    password = "";
  }

  public String checkCredentials() {
    String outcome = null;

    if (username.equalsIgnoreCase("admin") && password.equals("Admin")) {
      outcome = "loginOK";
    }
    else{
      clearFields();
      FacesMessage msg = new FacesMessage("Username and/or password not recognised.");
      FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    return outcome;
  }

  public String logout() {
    clearFields();
    return "logout";
  }

}
