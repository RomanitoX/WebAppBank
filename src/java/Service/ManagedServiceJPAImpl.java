/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
import javax.persistence.Query;
import Entity.BankAccount;
import Entity.Managed;
import Entity.User;
import metier.service.tool.JPA.CRUDBaseClass;

/**
 *
 * @author romanitox
 */
public class ManagedServiceJPAImpl extends CRUDBaseClass<Managed> implements ManagedService {

public ManagedServiceJPAImpl() {
        super.setType(Managed.class);
    }

    @Override
    public long getCount() throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(mg) FROM Managed mg");
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }

    @Override
    public List<Managed> getAll(int begin, int count) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT mg FROM Managed mg");
        query.setFirstResult(begin);
        query.setMaxResults(count);
        List<Managed> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }

    @Override
    public List<Managed> getByUser(User user) throws Exception {
        jpa.open();
        Query query = jpa.em.createQuery("SELECT mg FROM Managed mg WHERE mg.user.id = :id");
        query.setParameter("id", user.getId());
        List<Managed> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }

    @Override
    public long getCountByUser(User user) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(mg) Managed mg WHERE mg.user.id = :id");
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }

    @Override
    public Managed getByBankAccount(BankAccount account) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT mg FROM Managed mg WHERE mg.account.id = :id");
        query.setParameter("id", account.getId());
        Managed management = (Managed) query.getSingleResult();
        this.jpa.close();
        return management;
    }

    @Override
    public long getCountByBankAccount(BankAccount account) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(mg) Managed mg WHERE mg.account.id = :id");
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }
}
