import java.util.*;

// Abstract class Person
abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }
}

// Organizer class
class Organizer extends Person {
    private String contact;

    public Organizer(String name, String contact) {
        super(name);
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return super.toString() + ", Contact: " + contact;
    }
}

// Participant class
class Participant extends Person {
    private String email;

    public Participant(String name, String email) {
        super(name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return super.toString() + ", Email: " + email;
    }
}

// DataPool for managing participants
class DataPool {
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

// Event class
class Event {
    private String title;
    private String date;
    private String time;
    private Organizer organizer;
    private DataPool dataPool;

    public Event(String title, String date, String time, Organizer organizer) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.organizer = organizer;
        this.dataPool = new DataPool();
    }

    public void addParticipant(Participant participant) {
        dataPool.addParticipant(participant);
    }

    public DataPool getDataPool() {
        return dataPool;
    }

    @Override
    public String toString() {
        return "Event Title: " + title + "\nDate: " + date + "\nTime: " + time + "\nOrganizer: " + organizer + "\n" + dataPool;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Organizer
        System.out.print("Enter organizer's name: ");
        String organizerName = scanner.nextLine();
        System.out.print("Enter organizer's contact: ");
        String organizerContact = scanner.nextLine();
        Organizer organizer = new Organizer(organizerName, organizerContact);

        // Input Event
        System.out.print("Enter event title: ");
        String eventTitle = scanner.nextLine();
        System.out.print("Enter event date (e.g., 2024-12-20): ");
        String eventDate = scanner.nextLine();
        System.out.print("Enter event time (e.g., 10:00 AM): ");
        String eventTime = scanner.nextLine();
        Event event = new Event(eventTitle, eventDate, eventTime, organizer);

        // Add Participants
        System.out.print("Enter number of participants: ");
        int numParticipants = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numParticipants; i++) {
            System.out.print("Enter participant's name: ");
            String participantName = scanner.nextLine();
            System.out.print("Enter participant's email: ");
            String participantEmail = scanner.nextLine();
            event.addParticipant(new Participant(participantName, participantEmail));
        }

        // Output Event Details
        System.out.println("\nEvent Details:");
        System.out.println(event);

        // Demonstrate Filtering and Sorting
        System.out.println("\nParticipants sorted by name:");
        event.getDataPool().sortByName().forEach(System.out::println);

        System.out.println("\nParticipants filtered by email (example@example.com):");
        event.getDataPool().filterByEmail("example@example.com").forEach(System.out::println);

        scanner.close();
    }
}