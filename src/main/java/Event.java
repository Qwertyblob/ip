import java.time.LocalDateTime;

public class Event extends Task {
    private final LocalDateTime from;
    private final LocalDateTime to;

    public Event(String command, LocalDateTime from, LocalDateTime to) {
        super(command);
        this.from = from;
        this.to = to;
    }

    public LocalDateTime getFrom() {
        return this.from;
    }

    public LocalDateTime getTo() {
        return this.to;
    }

    public String toString() {
        return "[E]" + super.toString() + " (from: " + DateTimeManager.formatForDisplay(this.from)
                + " to " + DateTimeManager.formatForDisplay(this.to) + ")";
    }

    public String toDataFormat() {
        return "E | " + (doneStatus() ? 1 : 0) + " | "
                + this.command + " | " + DateTimeManager.format(this.from) + " - " + DateTimeManager.format(this.to);
    }
}
