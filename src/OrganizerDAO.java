import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizerDAO {
    public int addOrganizer(String name, String contact) {
        String query = "INSERT INTO organizers (name, contact) VALUES (?, ?) RETURNING id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, contact);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id"); // Returns the auto-generated organizer ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // Return -1 if insertion fails
    }
}