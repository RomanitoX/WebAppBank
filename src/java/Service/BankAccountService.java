/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.BankAccount;
import metier.service.tool.JPA.CRUDBaseInterface;

/**
 *
 * @author romanitox
 */
public interface BankAccountService extends CRUDBaseInterface<BankAccount> {

    BankAccount getByName(String name) throws Exception;

    BankAccount getByCurrency(char currency) throws Exception;
    
    BankAccount getByIBAN(String iban) throws Exception;
}
