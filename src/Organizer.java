public class Organizer extends Person {
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
