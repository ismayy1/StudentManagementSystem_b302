public interface GenericRepository<S, U> {

    void createTable();

    void save(S entity);

    List<S> findAll();

    void deleteById(U id);

    S findById(U id);

    void update(S entity);
}
