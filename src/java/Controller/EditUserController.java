/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.User;
import Service.tool.JPA.MetierFactory;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author romanitox
 */
@ManagedBean
@ViewScoped
public class EditUserController implements Serializable {

    public EditUserController() {
    }

    private User usr;
    private User usrBase;
    private LoginController logCtrl;

    public LoginController getLogCtrl() {
        return logCtrl;
    }

    public void setLogCtrl(LoginController logCtrl) {
        this.logCtrl = logCtrl;
    }

    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }

    public void editUser(ActionEvent event) {
        FacesMessage message = null;
        RequestContext context = RequestContext.getCurrentInstance();
        ExternalContext content = FacesContext.getCurrentInstance().getExternalContext();

        if (this.logCtrl == null) {
            this.logCtrl = (LoginController) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginController");
        }

        this.usr = this.logCtrl.getUsr();

        if (this.usr != null) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Prénom", "Prénom modifié avec succés !");
            try {
                MetierFactory.getUserService().update(usr);
            } catch (Exception ex) {
                Logger.getLogger(EditUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
