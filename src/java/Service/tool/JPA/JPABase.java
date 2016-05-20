package metier.service.tool.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPABase {

    JPABase() {
    }

    private final String PU = "WebAppBankPU";
    public EntityManagerFactory emf;
    public EntityManager em;
    public EntityTransaction transac;

    public void close() {
        if (this.transac != null) {
            this.transac = null;
        }

        if (this.em != null) {
            this.em.close();
            this.em = null;
        }

        if (this.emf != null) {
            this.emf.close();
            this.emf = null;
        }
    }

    public void open() {
        try {
            this.emf = Persistence.createEntityManagerFactory(this.PU);
            this.em = this.emf.createEntityManager();
            this.transac = this.em.getTransaction();
            this.transac.begin();
        } catch (Exception ex) {
            System.out.println("open BOBO :" + ex.getMessage());
        }
    }
}
