import java.util.*;
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

        System.out.print("Enter email to filter participants: ");
        String emailToFilter = scanner.nextLine();
        System.out.println("\nParticipants filtered by email (" + emailToFilter + "):");
        event.getDataPool().filterByEmail(emailToFilter).forEach(System.out::println);

        scanner.close();
    }
}