package tony.tasks;

import tony.parsers.DateTimeManager;

import java.time.LocalDateTime;

public class Deadline extends Task {
    private final LocalDateTime deadline;

    public Deadline(String description, LocalDateTime deadline) {
        super(description);
        this.deadline = deadline;
    }

    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + DateTimeManager.formatForDisplay(deadline) + ")";
    }

    public String toDataFormat() {
        return "D | " + (doneStatus() ? 1 : 0) + " | " + this.command + " | " + DateTimeManager.format(deadline);
    }
}
