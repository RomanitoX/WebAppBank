/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import javax.persistence.Query;
import Entity.BankAccount;
import Service.tool.JPA.MetierFactory;
import metier.service.tool.JPA.CRUDBaseClass;

/**
 *
 * @author romanitox
 */
public class BankAccountServiceJPAImpl extends CRUDBaseClass<BankAccount> implements BankAccountService {

    @Override
    public long getCount() throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(b) FROM BankAccounts b");
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }

    @Override
    public List<BankAccount> getAll(int begin, int count) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT b FROM BankAccounts b");
        query.setFirstResult(begin);
        query.setMaxResults(count);
        List<BankAccount> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }

    @Override
    public BankAccount getByName(String name) throws Exception {
        jpa.open();
        Query query = jpa.em.createQuery("SELECT b FROM BankAccounts b WHERE b.name like :name");
        query.setParameter("name", "%" + name + "%");
        BankAccount b = (BankAccount) query.getSingleResult();
        jpa.close();
        return b;
    }

    @Override
    public BankAccount getByCurrency(char currency) throws Exception {
        jpa.open();
        Query query = jpa.em.createQuery("SELECT b FROM BankAccounts b WHERE b.currency like :currency");
        query.setParameter("currency", "%" + currency + "%");
        BankAccount b = (BankAccount) query.getSingleResult();
        jpa.close();
        return b;
    }

    @Override
    public BankAccount getByIBAN(String iban) throws Exception {
        BankAccount b = null;
        try {
            jpa.open();
            Query query = jpa.em.createQuery("SELECT b FROM BankAccount b WHERE b.IBAN LIKE :IBAN");
            query.setParameter("IBAN", "%" + iban + "%");
            b = (BankAccount) query.getSingleResult();
            b.setOperations(MetierFactory.getOperationService().getByAccount(b));
            jpa.close();
        } catch (Exception e) {
            System.out.println("Aucun iban" + e.getMessage());
        }
        return b;
    }
}
