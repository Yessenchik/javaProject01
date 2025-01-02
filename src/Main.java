import java.util.ArrayList;
import java.util.Scanner;

// Declare class Organizer
class Organizer {
    private String name;
    private String contact;

    // Constructor
    public Organizer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    // toString Method
    @Override
    public String toString() {
        return "Organizer Name: " + name + ", Contact: " + contact;
    }
}

// Declare class Participant
class Participant {
    private String name;
    private String email;

    // Constructor
    public Participant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // toString Method
    @Override
    public String toString() {
        return "Participant Name: " + name + ", Email: " + email;
    }
}

// Declare class Event
class Event {
    private String title;
    private String date;
    private String time;
    private Organizer organizer;
    private ArrayList<Participant> participants;

    // Constructor
    public Event(String title, String date, String time, Organizer organizer) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.organizer = organizer;
        this.participants = new ArrayList<>();
    }

    // Method to add participants
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    // toString Method
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Event Title: " + title + "\nDate: " + date + "\nTime: " + time + "\n" + organizer + "\nParticipants:\n");
        for (Participant participant : participants) {
            result.append(participant).append("\n");
        }
        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Organizer
        System.out.print("Enter organizer's name: ");
        String organizerName = scanner.nextLine();
        System.out.print("Enter organizer's contact information: ");
        String organizerContact = scanner.nextLine();
        Organizer organizer = new Organizer(organizerName, organizerContact);

        // Input for Event
        System.out.print("Enter event title: ");
        String eventTitle = scanner.nextLine();
        System.out.print("Enter event date (e.g., 2024-12-20): ");
        String eventDate = scanner.nextLine();
        System.out.print("Enter event time (e.g., 10:00 AM): ");
        String eventTime = scanner.nextLine();
        Event event = new Event(eventTitle, eventDate, eventTime, organizer);

        // Adding Participants
        System.out.print("Enter number of participants: ");
        int numberOfParticipants = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfParticipants; i++) {
            System.out.print("Enter participant's name: ");
            String participantName = scanner.nextLine();
            System.out.print("Enter participant's email: ");
            String participantEmail = scanner.nextLine();
            Participant participant = new Participant(participantName, participantEmail);
            event.addParticipant(participant);
        }

        // Print Event Details
        System.out.println("\nEvent Details:");
        System.out.println(event);

        // Close scanner
        scanner.close();
    }
}