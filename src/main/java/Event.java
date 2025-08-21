public class Event extends Task {
    private String from;
    private String to;

    public Event(String command, String from, String to) {
        super(command);
        this.from = from;
        this.to = to;
    }

    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }
}
