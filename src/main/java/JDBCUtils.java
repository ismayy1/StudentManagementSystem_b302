import java.sql.*;

public class JDBCUtils {

    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;

    public static void setConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/miniProjectDB", "miniProjectUser", "miniProjectUser");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setStatement() {

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setPreparedStatement(String sql) {

        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
