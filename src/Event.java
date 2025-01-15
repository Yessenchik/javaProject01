public class Event {
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
