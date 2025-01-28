import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipantDAO {

    public void addParticipant(int eventId, Participant participant) {
        String query = "INSERT INTO participants (event_id, name, contact) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, eventId);
            stmt.setString(2, participant.getName());
            stmt.setString(3, participant.getContact());
            stmt.executeUpdate();
            System.out.println("Participant added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}