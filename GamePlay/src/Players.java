public class Players extends Person {
    Players() {
        super();
    }

    public String toString() {
        return super.getFirstName() + " " + super.getLastName();
    }
}
