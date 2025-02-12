import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/hahha"; // Database URL
    private static final String USER = "postgres"; // Your PostgreSQL username
    private static final String PASSWORD = "2112"; // Your PostgreSQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println(" Successfully connected to PostgreSQL!");
            } else {
                System.out.println("Connection failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}