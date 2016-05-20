/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.BankAccount;
import Entity.User;
import Service.BankAccountService;
import Service.BankAccountServiceJPAImpl;
import Service.ManagedService;
import Service.ManagedServiceJPAImpl;
import Service.tool.JPA.MetierFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;

/**
 *
 * @author romanitox
 */
@ManagedBean
@SessionScoped
public class CreateAccountController {

    /**
     * Creates a new instance of CreateAccountController
     */
    private String IBAN;
    private String name;
    private LoginController logCtrl;
    private int index;
    private User usr;
    private String type;
    private DualListModel<User> users;

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoginController getLogCtrl() {
        return logCtrl;
    }

    public void setLogCtrl(LoginController logCtrl) {
        this.logCtrl = logCtrl;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void indexUp(ActionEvent event) {
        this.index++;
    }

    public DualListModel<User> getUsers() {
        return users;
    }

    public void setUsers(DualListModel<User> users) {
        this.users = users;
    }

    public CreateAccountController() {
        List<User> usrSource = new ArrayList<>();
        List<User> usrTarget = new ArrayList<>();
        try {
            for (User usr : MetierFactory.getUserService().getAllUsers()) {
                usrSource.add(usr);
            }
            users = new DualListModel<>(usrSource, usrTarget);
        } catch (Exception ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(ActionEvent event) {
        FacesMessage message = null;
        RequestContext context = RequestContext.getCurrentInstance();
        ExternalContext content = FacesContext.getCurrentInstance().getExternalContext();
        BankAccount account = new BankAccount();
        BankAccountService bankAccountSrv = new BankAccountServiceJPAImpl();
        ManagedService managedSrv = new ManagedServiceJPAImpl();

        if (this.logCtrl == null) {
            this.logCtrl = (LoginController) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginController");
        }
        try {
            List<User> usrSource = new ArrayList<>();
            List<User> usrTarget = new ArrayList<>();
            for (int i = 0; i < MetierFactory.getUserService().getCount(); i++) {
                usrSource = (MetierFactory.getUserService().getAll(0, i));
            }
            users = new DualListModel<>(usrSource, usrTarget);
        } catch (Exception ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }

        account.setName(name);
        account.setBalance(0);
        account.setCurrency(logCtrl.getUsr().getNationality());
        try {
            bankAccountSrv.add(account);
        } catch (Exception ex) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur de création", "Problème bdd");
        }

        try {
            content.redirect("./index.htxml");
        } catch (IOException ex) {
            Logger.getLogger(CreateAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LoginController ctrl = (LoginController) content.getSessionMap().get("loginController");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
