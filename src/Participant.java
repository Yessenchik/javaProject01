public class Participant extends Person {
    public Participant(String name, String contact) {
        super(name, contact);
    }

    @Override
    public String toString() {
        return "Participant{" + super.toString() + "}";
    }
}