public class ToDo extends Task {

    public ToDo(String command) {
        super(command);
    }

    public String toString() {
        return "[T]" + super.toString();
    }
}
