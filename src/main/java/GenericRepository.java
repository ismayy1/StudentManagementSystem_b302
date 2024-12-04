import java.util.List;

public interface GenericRepository<S, U> {

    void createTable();

    void save(S entity);

    List<S> findAll();

    void deleteById(U id);

    S findById(U id);

    int update(S entity);
}
