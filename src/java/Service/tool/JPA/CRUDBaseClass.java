package metier.service.tool.JPA;

public abstract class CRUDBaseClass<T> implements CRUDBaseInterface<T> {

    protected final JPABase jpa = new JPABase();

    private Class<T> type;

    protected void setType(Class<T> type) {
        this.type = type;
    }

    @Override
    public T add(T entity) throws Exception {
        this.jpa.open();
        this.jpa.em.persist(entity);
        this.jpa.transac.commit();
        this.jpa.close();
        return entity;
    }

    @Override
    public void remove(T entity) throws Exception {
        this.jpa.open();
        this.jpa.em.remove(entity);
        this.jpa.close();
    }

    @Override
    public void update(T entity) throws Exception {
        this.jpa.open();
        this.jpa.em.merge(entity);
        this.jpa.close();
    }

    @Override
    public T getById(Long id) throws Exception {
        this.jpa.open();
        T t = this.jpa.em.find(this.type, id);
        this.jpa.close();
        return t;
    }
}
