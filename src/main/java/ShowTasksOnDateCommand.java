import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShowCommand extends Command {
    private final LocalDateTime targetDate;

    public ShowCommand(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws TonyException {
        boolean found = false;
        StringBuilder sb = new StringBuilder();

        sb.append("Here's the stuff happening on ")
                .append(targetDate.DateTimeFormatter + ":"))
                .append(":\n");

        for (Task task : tasks.getList()) {
            if (task instanceof Deadline) {
                LocalDateTime dt = ((Deadline) task).getDeadline();
                if (dt.toLocalDate().equals(targetDate)) {
                    sb.append("  ").append(task).append("\n");
                    found = true;
                }
            } else if (task instanceof Event) {
                LocalDateTime from = ((Event) task).getFrom();
                LocalDateTime to = ((Event) task).getTo();
                if (!from.toLocalDate().isAfter(targetDate) && !to.toLocalDate().isBefore(targetDate)) {
                    sb.append("  ").append(task).append("\n");
                    found = true;
                }
            }
        }

        if (!found) {
            sb.append("  You're as busy as a rock\n");
        }

        ui.showMessage(sb.toString());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
