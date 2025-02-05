import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrganizerDAO organizerDAO = new OrganizerDAO();
        EventDAO eventDAO = new EventDAO();
        ParticipantDAO participantDAO = new ParticipantDAO();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Event");
            System.out.println("2. Delete Event by Title");
            System.out.println("3. Quit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addEvent(scanner, organizerDAO, eventDAO, participantDAO);
                case 2 -> deleteEvent(scanner, eventDAO);
                case 3 -> {
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEvent(Scanner scanner, OrganizerDAO organizerDAO, EventDAO eventDAO, ParticipantDAO participantDAO) {
        // Gather event details
        System.out.print("Enter event title: ");
        String title = scanner.nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter event time (HH:MM:SS): ");
        String time = scanner.nextLine();

        // Gather organizer details
        System.out.print("Enter organizer name: ");
        String organizerName = scanner.nextLine();
        System.out.print("Enter organizer contact: ");
        String organizerContact = scanner.nextLine();

        // Insert organizer and get ID
        int organizerId = organizerDAO.addOrganizer(organizerName, organizerContact);
        if (organizerId == -1) {
            System.out.println("❌ Failed to add organizer.");
            return;
        }

        // Insert event and get ID
        int eventId = eventDAO.addEvent(title, date, time, organizerId);
        if (eventId == -1) {
            System.out.println("❌ Failed to add event.");
            return;
        }

        // Gather participants
        System.out.print("Enter the number of participants: ");
        int numParticipants = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numParticipants; i++) {
            System.out.print("Enter participant name: ");
            String participantName = scanner.nextLine();
            System.out.print("Enter participant contact: ");
            String participantContact = scanner.nextLine();
            participantDAO.addParticipant(eventId, participantName, participantContact);
        }
    }

    private static void deleteEvent(Scanner scanner, EventDAO eventDAO) {
        System.out.print("Enter event title to delete: ");
        String title = scanner.nextLine();
        eventDAO.deleteEventByTitle(title);
    }
}