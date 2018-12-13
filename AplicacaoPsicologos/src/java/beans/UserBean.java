/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.inject.Named;




@Named(value = "UserBean")

public class UserBean implements Serializable {

    public UserBean(){
    
    }
    
    public UserBean(String login, String nome, String email, Integer ID, String start, String end){
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.ID = ID;
        this.start = start;
        this.end = end;
    }
    
    private String login;
    private String nome;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    private String email;
    private Integer ID;
    private String start;
    private String end;

    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

}