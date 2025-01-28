import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventDAO eventDAO = new EventDAO();
        ParticipantDAO participantDAO = new ParticipantDAO();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Event");
            System.out.println("2. Delete Event by Title");
            System.out.println("3. Update Event by Title");
            System.out.println("4. Quit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addEvent(scanner, eventDAO, participantDAO);
                case 2 -> deleteEvent(scanner, eventDAO);
                case 3 -> updateEvent(scanner, eventDAO);
                case 4 -> {
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEvent(Scanner scanner, EventDAO eventDAO, ParticipantDAO participantDAO) {
        System.out.print("Enter event title: ");
        String title = scanner.nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter event time (HH:MM:SS): ");
        String time = scanner.nextLine();
        System.out.print("Enter organizer name: ");
        String organizerName = scanner.nextLine();
        System.out.print("Enter organizer contact: ");
        String organizerContact = scanner.nextLine();

        Organizer organizer = new Organizer(organizerName, organizerContact);
        int eventId = eventDAO.addEvent(title, date, time, organizer);

        if (eventId != -1) {
            System.out.print("Enter the number of participants: ");
            int numParticipants = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numParticipants; i++) {
                System.out.print("Enter participant name: ");
                String participantName = scanner.nextLine();
                System.out.print("Enter participant contact: ");
                String participantContact = scanner.nextLine();
                Participant participant = new Participant(participantName, participantContact);
                participantDAO.addParticipant(eventId, participant);
            }
        }
    }

    private static void deleteEvent(Scanner scanner, EventDAO eventDAO) {
        System.out.print("Enter event title to delete: ");
        String title = scanner.nextLine();
        eventDAO.deleteEventByTitle(title);
    }

    private static void updateEvent(Scanner scanner, EventDAO eventDAO) {
        System.out.print("Enter current event title to update: ");
        String currentTitle = scanner.nextLine();
        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new date (YYYY-MM-DD): ");
        String newDate = scanner.nextLine();
        System.out.print("Enter new time (HH:MM:SS): ");
        String newTime = scanner.nextLine();
        System.out.print("Enter new organizer name: ");
        String newOrganizerName = scanner.nextLine();
        System.out.print("Enter new organizer contact: ");
        String newOrganizerContact = scanner.nextLine();

        Organizer organizer = new Organizer(newOrganizerName, newOrganizerContact);
        eventDAO.updateEventByTitle(currentTitle, newTitle, newDate, newTime, organizer);
    }
}