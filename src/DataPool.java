
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataPool {
    private List<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public List<Participant> filterByName(String name) {
        return participants.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .toList();
    }

    public List<Participant> filterByEmail(String email) {
        return participants.stream()
                .filter(p -> p.getEmail().equalsIgnoreCase(email))
                .toList();
    }

    public List<Participant> sortByName() {
        return participants.stream()
                .sorted(Comparator.comparing(Person::getName))
                .toList();
    }

    public List<Participant> sortByEmail() {
        return participants.stream()
                .sorted(Comparator.comparing(Participant::getEmail))
                .toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Participants:\n");
        participants.forEach(p -> sb.append(p).append("\n"));
        return sb.toString();
    }
}
