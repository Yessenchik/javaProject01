import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;  // Import java.sql.Date
import java.sql.Time;  // Import java.sql.Time

public class EventDAO {
    public int addEvent(String title, String date, String time, int organizerId) {
        String query = "INSERT INTO events (title, date, time, organizer_id) VALUES (?, ?, ?, ?) RETURNING id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, title);
            stmt.setDate(2, Date.valueOf(date));  // Uses java.sql.Date
            stmt.setTime(3, Time.valueOf(time));  // Uses java.sql.Time
            stmt.setInt(4, organizerId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id"); // Returns the auto-generated event ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // Return -1 if insertion fails
    }

    public void deleteEventByTitle(String title) {
        String query = "DELETE FROM events WHERE title = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, title);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("✅ Event and related organizer & participants deleted!");
            } else {
                System.out.println("❌ Event not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}