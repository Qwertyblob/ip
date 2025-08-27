package tony.tasks;

public class ToDo extends Task {

    public ToDo(String command) {
        super(command);
    }

    public String toString() {
        return "[T]" + super.toString();
    }

    public String toDataFormat() {
        return "T | " + (doneStatus() ? 1 : 0) + " | " + this.command;
    }
}
