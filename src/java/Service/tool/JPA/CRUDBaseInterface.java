package metier.service.tool.JPA;

import java.util.List;

public interface CRUDBaseInterface<T> {
    T add(T entity) throws Exception;
    void remove(T entity) throws Exception;
    void update(T entity) throws Exception;
    T getById(Long id) throws Exception;
    long getCount() throws Exception;
    List<T> getAll(int begin, int count) throws Exception;
}
