/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.BankAccount;
import Entity.Managed;
import Entity.User;
import java.util.List;
import metier.service.tool.JPA.CRUDBaseInterface;

/**
 *
 * @author romanitox
 */
public interface ManagedService extends CRUDBaseInterface<Managed> {

    List<Managed> getByUser(User user) throws Exception;

    long getCountByUser(User user) throws Exception;

    Managed getByBankAccount(BankAccount account) throws Exception;

    long getCountByBankAccount(BankAccount account) throws Exception;
}
