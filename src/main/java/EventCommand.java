import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class EventCommand extends Command {
    private final String description;
    private final String from;
    private final String to;

    public EventCommand(String args) throws TonyException {
        if (!args.contains("/from") || !args.contains("/to")) {
            throw new EventException("JARVIS, show them how it's done.\n\tevent <event> /from <start> /to <end>");
        } else {
            String[] parts = args.split("/from", 2);
            String[] fromTo = parts[1].split("/to", 2);
            this.from = fromTo[0].trim();
            this.to = fromTo[1].trim();
            this.description = parts[0].trim();
        }
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws TonyException {
        try {
            LocalDateTime fromDateTime = DateTimeManager.parse(this.from);
            LocalDateTime toDateTime = DateTimeManager.parse(this.to);
            Event task = new Event(this.description, fromDateTime, toDateTime);
            tasks.addTask(task);
            storage.save(tasks);
            ui.showAddTask(tasks, task);
        } catch (DateTimeParseException e) {
            throw new TonyException("Let me spell it out for you: dd-MM-yyyy HH:mma (e.g. 12-09-2025 6:00PM).");
        }
    }
}
