import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
    private int id;
    private String title;
    private LocalDate date;
    private LocalTime time;
    private int organizerId;

    public Event(String title, LocalDate date, LocalTime time, int organizerId) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.organizerId = organizerId;
    }

    public Event(int id, String title, LocalDate date, LocalTime time, int organizerId) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.organizerId = organizerId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }

    public int getOrganizerId() { return organizerId; }
    public void setOrganizerId(int organizerId) { this.organizerId = organizerId; }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", organizerId=" + organizerId +
                '}';
    }
}