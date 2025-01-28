import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class EventDAO {

    public int addEvent(String title, String date, String time, Organizer organizer) {
        String query = "INSERT INTO events (title, date, time, organizer_name, organizer_contact) VALUES (?, ?, ?, ?, ?) RETURNING id";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, title);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setTime(3, Time.valueOf(time));
            stmt.setString(4, organizer.getName());
            stmt.setString(5, organizer.getContact());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int eventId = rs.getInt("id");
                System.out.println("Event added successfully with ID: " + eventId);
                return eventId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void deleteEventByTitle(String title) {
        String query = "DELETE FROM events WHERE title = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, title);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Event and all related participants deleted successfully!");
            } else {
                System.out.println("Event not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEventByTitle(String currentTitle, String newTitle, String newDate, String newTime, Organizer organizer) {
        String query = "UPDATE events SET title = ?, date = ?, time = ?, organizer_name = ?, organizer_contact = ? WHERE title = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newTitle);
            stmt.setDate(2, Date.valueOf(newDate));
            stmt.setTime(3, Time.valueOf(newTime));
            stmt.setString(4, organizer.getName());
            stmt.setString(5, organizer.getContact());
            stmt.setString(6, currentTitle);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Event updated successfully!");
            } else {
                System.out.println("Event not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}