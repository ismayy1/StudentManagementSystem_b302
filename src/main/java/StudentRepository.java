import java.sql.SQLException;
import java.util.List;

public class StudentRepository implements GenericRepository<Student, Integer> {
    @Override
    public void createTable() {

        JDBCUtils.setConnection();
        JDBCUtils.setStatement();

        try {
            JDBCUtils.statement.execute("CREATE TABLE IF NOT EXISTS t_student (" +
                    "id SERIAL UNIQUE, " +
                    "firstName VARCHAR(50) NOT NULL CHECK(LENGTH(firstName)>0)" +
                    "lastName VARCHAR(50) NOT NULL CHECK(LENGTH(lastName)>0)" +
                    "city VARCHAR(50) NOT NULL CHECK(LENGTH(city)>0)" +
                    "age INT NOT NULL CHECK(age>0)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JDBCUtils.statement.close();
                JDBCUtils.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void save(Student student) {

        String sql = "INSERT INTO t_student(firstName, lastName, city, age) VALUES(?, ?, ?, ?)";
        JDBCUtils.setConnection();
        JDBCUtils.setPreparedStatement(sql);

        try {
            JDBCUtils.preparedStatement.setString(1, student.getFirstName());
            JDBCUtils.preparedStatement.setString(2, student.getLastName());
            JDBCUtils.preparedStatement.setString(3, student.getCity());
            JDBCUtils.preparedStatement.setInt(4, student.getAge());

            JDBCUtils.preparedStatement.executeUpdate();
            System.out.println("Saved student Successfully: " + student.getFirstName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JDBCUtils.preparedStatement.close();
                JDBCUtils.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public void update(Student entity) {

    }
}