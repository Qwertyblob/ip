public class Deadline extends Task {
    private String deadline;

    public Deadline(String command, String deadline) {
        super(command);
        this.deadline = deadline;
    }

    public static void makeDeadline(ListOfTasks list, String command) {
        String[] words = command.trim().split("\\s+", 2);
        if (words.length > 1 && command.contains("/by")) {
            String[] d = words[1].split("/by", 2);
            Deadline deadline = new Deadline(d[0].trim(), d[1].trim());
            list.setTask(deadline);
        } else {
            System.out.println("Invalid deadline task format.");
        }
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}
