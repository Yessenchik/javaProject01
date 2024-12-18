import java.util.Scanner;

// declare class Organizer
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

class Event {
    private String title;
    private String date;
    private String time;
    private Organizer organizer;

    // Constructor
    public Event(String title, String date, String time, Organizer organizer) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.organizer = organizer;
    }

    // toString Method
    @Override
    public String toString() {
        return "Event Title: " + title + "\nDate: " + date + "\nTime: " + time + "\n" + organizer;
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

        // Print Event Details
        System.out.println("\nEvent Details:");
        System.out.println(event);

        // Close scanner
        scanner.close();
    }
}