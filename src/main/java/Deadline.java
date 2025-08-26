import java.time.LocalDateTime;

public class Deadline extends Task {
    private LocalDateTime deadline;

    public Deadline(String command, String deadline) {
        super(command);
        this.deadline = DateTimeManager.parse(deadline);
    }

    public static void makeDeadline(ListOfTasks list, String command) {
        try {
            String[] words = command.trim().split("\\s+", 2);
            if (words.length > 1 && command.contains("/by")) {
                String[] d = words[1].split("/by", 2);
                Deadline deadline = new Deadline(d[0].trim(), d[1].trim());
                list.setTask(deadline);
                new Display(deadline).addTask(list);
            } else {
                throw new DeadlineException("JARVIS, show them how it's done.\n\tdeadline <task> /by <deadline>");
            }
        } catch (DeadlineException e) {
            System.out.println(e.getMessage());
        }

    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + DateTimeManager.format(deadline) + ")";
    }

    public String toDataFormat() {
        return "D | " + (doneStatus() ? 1 : 0) + " | " + this.command + " | " + DateTimeManager.format(deadline);
    }
}
