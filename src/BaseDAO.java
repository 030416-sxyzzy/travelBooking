import java.util.List;

public interface BaseDAO<T> {
    void add(T entity);
    void update(T entity);
    void delete(int id);
    List<T> findById(int id);
}
