import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class DeadlineCommand extends Command {

    private final String description;
    private final String by;

    public DeadlineCommand(String args) throws TonyException {
        String[] parts = args.split(" /by ", 2);
        if (parts.length < 2 || parts[0].trim().isEmpty()) {
            throw new TonyException("JARVIS, show them how it's done.\n\tdeadline <task> /by time.");
        }
        this.description = parts[0].trim();
        this.by = parts[1].trim();
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws TonyException {
        try {
            LocalDateTime deadlineDateTime = DateTimeManager.parse(this.by);
            Deadline task = new Deadline(this.description, deadlineDateTime);
            tasks.addTask(task);
            storage.save(tasks);
            ui.showAddTask(tasks, task);
        } catch (DateTimeParseException e) {
            throw new TonyException("Let me spell it out for you:\n" +
                    "Use: dd-MM-yyyy HH:mma (e.g. 12-09-2025 6:00PM).");
        }
    }

}

