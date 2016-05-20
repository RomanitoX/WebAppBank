/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.User;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author romanitox
 */
@ManagedBean
@SessionScoped
public class LogoutController implements Serializable {

    private String firstName;
    private String name;
    private String loginName;
    private String password;
    private User usr;
    FacesMessage msg = null;
    boolean loggedIn = false;
    @ManagedProperty(value = "LoginController")
    private LoginController logCtrl;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacesMessage getMsg() {
        return msg;
    }

    public void setMsg(FacesMessage msg) {
        this.msg = msg;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public LoginController getLogCtrl() {
        return logCtrl;
    }

    public void setLogCtrl(LoginController logCtrl) {
        this.logCtrl = logCtrl;
    }

    public void logout(ActionEvent evt) {
        FacesMessage message = null;
        if (usr == null) {
            usr = logCtrl.getUsr();
        }
        if (usr != null) {
            try {
                usr = null;
                loggedIn = false;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "A bientôt", loginName);
                ExternalContext content = FacesContext.getCurrentInstance().getExternalContext();
                content.redirect("/WebAppBank");
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Déconnexion ", "A bientôt " + this.logCtrl.getFirstName());
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
