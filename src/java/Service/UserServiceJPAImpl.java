package Service;

import Entity.User;
import java.util.List;
import javax.persistence.Query;
import metier.service.tool.JPA.CRUDBaseClass;

public class UserServiceJPAImpl extends CRUDBaseClass<User> implements UserService {

    public UserServiceJPAImpl() {
        super.setType(User.class);
    }

    @Override
    public User getByLogin(String login) throws Exception {
        jpa.open();
        Query query = jpa.em.createQuery("SELECT u FROM User u WHERE u.login like :login");
        query.setParameter("login", "%" + login + "%");
        User u = (User) query.getSingleResult();
        jpa.close();
        return u;
    }

    @Override
    public long getCount() throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT COUNT(u) FROM User u");
        long count = ((Long) query.getSingleResult()).longValue();
        this.jpa.close();
        return count;
    }

    @Override
    public List<User> getAll(int begin, int count) throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT u FROM User u");
        query.setFirstResult(begin);
        query.setMaxResults(count);
        List<User> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }

    @Override
    public User getByNationality(String nationality) throws Exception {
        jpa.open();
        Query query = jpa.em.createQuery("SELECT u FROM User u WHERE u.nationality like :nationality");
        query.setParameter("nationality", "%" + nationality + "%");
        User u = (User) query.getSingleResult();
        jpa.close();
        return u;
    }

    @Override
    public User getByEmail(String email) throws Exception {
        jpa.open();
        Query query = jpa.em.createQuery("SELECT u FROM User u WHERE u.email like :email");
        query.setParameter("email", "%" + email + "%");
        User u = (User) query.getSingleResult();
        jpa.close();
        return u;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        this.jpa.open();
        Query query = jpa.em.createQuery("SELECT u FROM User u");
        List<User> entitys = query.getResultList();
        this.jpa.close();
        return entitys;
    }
}
