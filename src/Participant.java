public class Participant extends Person {
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
