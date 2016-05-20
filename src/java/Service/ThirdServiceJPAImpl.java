package Service;

import java.util.List;
import javax.persistence.Query;
import Entity.Third;
import metier.service.tool.JPA.CRUDBaseClass;

/**
 *
 * @author romanitox
 */
public class ThirdServiceJPAImpl extends CRUDBaseClass<Third> implements ThirdService {

    public ThirdServiceJPAImpl() {
        super.setType(Third.class);
    }

    @Override
    public long getCount() throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(t) FROM Third t");
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }

    @Override
    public List<Third> getAll(int begin, int count) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT t FROM User t");
        query.setFirstResult(begin);
        query.setMaxResults(count);
        List<Third> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }

    @Override
    public Third getByName(String name) throws Exception {
        jpa.open();
        Query query = jpa.em.createQuery("SELECT t FROM Third t WHERE t.name like :name");
        query.setParameter("name", "%" + name + "%");
        Third t = (Third) query.getSingleResult();
        jpa.close();
        return t;
    }

}
