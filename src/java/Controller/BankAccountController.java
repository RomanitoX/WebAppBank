/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.BankAccount;
import Entity.Managed;
import Entity.User;
import Service.tool.JPA.MetierFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author romanitox
 */
@ManagedBean
@ViewScoped
@SessionScoped
public class BankAccountController implements Serializable {

    @Resource
    private LoginController logCtrl;
    private List<BankAccount> accounts;
    private List<Managed> manageds;
    private double totalBalance;
    private char currency;
    private String type;

    public LoginController getLogCtrl() {
        return logCtrl;
    }

    public void setLogCtrl(LoginController logCtrl) {
        this.logCtrl = logCtrl;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public char getCurrency() {
        return currency;
    }

    public void setCurrency(char currency) {
        this.currency = currency;
    }

    public List<Managed> getManageds() {
        return manageds;
    }

    public void setManageds(List<Managed> manageds) {
        this.manageds = manageds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BankAccountController() {
        try {
            this.accounts = new ArrayList<BankAccount>();
            logCtrl = (LoginController) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginController");
            this.manageds = MetierFactory.getManagedService().getByUser(logCtrl.getUsr());
            if (manageds != null) {
                for (Managed managed : manageds) {
                    this.accounts.add(managed.getAccount());
                    totalBalance += managed.getAccount().getBalance();
                    this.currency = managed.getAccount().getCurrency();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(BankAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
