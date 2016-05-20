/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.BankAccount;
import Entity.Operation;
import Service.tool.JPA.MetierFactory;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author romanitox
 */
@ManagedBean
@ViewScoped
public class OperationController {

    @ManagedProperty(value = "#{BankAccountController}")
    private BankAccountController actCtrl;
    private String IBAN;
    private Long id;
    private char currency;

    private BankAccount current;
    private List<Operation> operations;

    public BankAccountController getActCtrl() {
        return actCtrl;
    }

    public void setActCtrl(BankAccountController actCtrl) {
        this.actCtrl = actCtrl;
    }

    public char getCurrency() {
        return currency;
    }

    public void setCurrency(char currency) {
        this.currency = currency;
    }

    public BankAccount getCurrent() {
        return current;
    }

    public void setCurrent(BankAccount current) {
        this.current = current;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public OperationController() {
        ExternalContext content = FacesContext.getCurrentInstance().getExternalContext();
        if (IBAN == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            IBAN = context.getExternalContext().getRequestParameterMap().get("IBAN");
        }
        if (current == null) {
            try {
                current = MetierFactory.getBankAccountService().getByIBAN(IBAN);
            } catch (Exception ex) {
                Logger.getLogger(OperationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
