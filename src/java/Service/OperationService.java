/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.BankAccount;
import java.util.Date;
import java.util.List;
import Entity.Operation;
import Entity.Third;
import metier.service.tool.JPA.CRUDBaseInterface;

/**
 *
 * @author romanitox
 */
public interface OperationService extends CRUDBaseInterface<Operation> {

    List<Operation> getByDate(Date date, int begin, int size) throws Exception;

    long getCountByDate(Date date) throws Exception;

    List<Operation> getByDates(Date date, int nbDays, int begin, int size) throws Exception;

    long getCountByDates(Date date, int nbDays) throws Exception;

    List<Operation> getByThird(Third third) throws Exception;

    long getCountByThird(Third third) throws Exception;

    public List<Operation> getByAccount(BankAccount account) throws Exception;

    public long getCountByThird(BankAccount account) throws Exception;
}
