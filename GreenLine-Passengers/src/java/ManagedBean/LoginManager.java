/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Nurul Amin
 */
@Named(value = "loginManager")
@Dependent
public class LoginManager {

    /**
     * Creates a new instance of LoginManager
     */
    public LoginManager() {
    }
    
}
