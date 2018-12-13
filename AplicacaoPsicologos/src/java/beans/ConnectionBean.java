/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.inject.Named;

/**
 *
 * @author marc
 */
@Named(value = "ConnectionBean")

public class ConnectionBean implements Serializable {

    public ConnectionBean() {
    }
    
    private String host;
    private String password;
    private Integer port;
    private String dbName;

}
