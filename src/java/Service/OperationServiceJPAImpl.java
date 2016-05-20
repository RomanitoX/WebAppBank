package Service;

import Entity.BankAccount;
import Entity.Operation;
import Entity.Third;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.Query;

import metier.service.tool.JPA.CRUDBaseClass;

public class OperationServiceJPAImpl extends CRUDBaseClass<Operation> implements OperationService {

    @Override
    public long getCount() throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(o) FROM Operation o");
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }

    @Override
    public List<Operation> getAll(int begin, int count) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT o FROM Operation o");
        query.setFirstResult(begin);
        query.setMaxResults(count);
        List<Operation> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }

    @Override
    public List<Operation> getByDate(Date date, int begin, int size) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT o FROM Operation o WHERE o.date LIKE :date");
        query.setParameter("date", "%" + date + "%");
        query.setFirstResult(begin);
        query.setMaxResults(size);
        List<Operation> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }

    @Override
    public long getCountByDate(Date date) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(o) FROM Operation o WHERE o.date LIKE :date");
        query.setParameter("date", "%" + date + "%");
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }

    @Override
    public List<Operation> getByDates(Date date, int nbDays, int begin, int size) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT o FROM Operation o WHERE o.date BETWEEN :date AND :end");
        query.setParameter("date", "%" + date + "%");
        //***//

        GregorianCalendar calendar = new java.util.GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -nbDays);

        //***//
        query.setParameter("end", "%" + calendar.getTime() + "%");
        query.setFirstResult(begin);
        query.setMaxResults(size);
        List<Operation> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }

    @Override
    public long getCountByDates(Date date, int nbDays) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(o) FROM Operation o WHERE o.date BETWEEN :date AND :end");
        query.setParameter("date", "%" + date + "%");
        //***//

        GregorianCalendar calendar = new java.util.GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -nbDays);

        //***//
        query.setParameter("end", "%" + calendar.getTime() + "%");
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }

    @Override
    public List<Operation> getByThird(Third third) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT o FROM Operation o WHERE o.third LIKE :third");
        query.setParameter("third", "%" + third + "%");
        List<Operation> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }

    @Override
    public long getCountByThird(Third third) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(o) FROM Operation o WHERE o.third LIKE :third");
        query.setParameter("third", "%" + third + "%");
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }

    @Override
    public List<Operation> getByAccount(BankAccount account) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT o FROM Operation o WHERE o.account.id = :account");
        query.setParameter("account", account.getId());
        List<Operation> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }

    @Override
    public long getCountByThird(BankAccount account) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(o) FROM Operation o WHERE o.account.id = :account");
        query.setParameter("account", account.getId());
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }

}
