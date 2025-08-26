import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Display {
    private Task message;
    private static final String border = "\t" + "=".repeat(80);
    private static final DateTimeFormatter DATE_INPUT_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Display(Task message) {
        this.message = message;
    }

    public void addTask(ListOfTasks list) {
        System.out.println(border);
        System.out.println("\tAlright, just let one of my machines do it for you:\n\t  " + this.message);
        System.out.println("\tNow you have " + list.getSize() + " tasks in the list.");
        System.out.println(border);
    }

    public static void greeting() {
        System.out.println(border + "\n\tHey, it's Tony.\n\tGenius, billionaire, philanthropist… and apparently your personal assistant now.\n" + border);
    }

    public static void exit() {
        System.out.println(border + "\n\tI’m powering down. Don’t break anything while I’m gone.\n" + border);
    }

    public static void showList(ListOfTasks list) {
        System.out.println(border);
        System.out.println("\tJARVIS, show them their list of tasks:");
        for (int i = 1; i <= list.getSize(); i++) {
            System.out.println("\t" + i + ": " + list.getList().get(i - 1).toString());
        }
        System.out.println(border);
    }

    public void showMark(Task t) {
        t.markDone();
        System.out.println(border);
        System.out.println("\tDone. Look at you, being efficient.");
        System.out.println("\t  " + t);
        System.out.println(border);
    }

    public void showUnmark(Task t) {
        t.markUndone();
        System.out.println(border);
        System.out.println("\tUnmarked. Happens to the best of us.");
        System.out.println("\t  " + t);
        System.out.println(border);
    }

    public void showDelete(Task t) {
        System.out.println(border);
        System.out.println("\tOverachieving might not be for everybody.");
        System.out.println("\t  " + t);
        System.out.println(border);
    }

    public static void showTasksOnDate(ListOfTasks list, String command) {
        LocalDate targetDate;
        try {
            String[] words = command.trim().split("\\s+", 2);
            if (words.length != 2) {
                throw new ShowTasksException("JARVIS, show them how it's done.\n\tUsage: show <dd-MM-yyyy>");
            }
            targetDate = LocalDate.parse(words[1], DATE_INPUT_FORMAT);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        boolean found = false;
        System.out.println(border);
        System.out.println("\tHere's the stuff happening on "
                + targetDate.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ":");

        for (Task task : list.getList()) {
            if (task instanceof Deadline) {
                LocalDateTime dt = ((Deadline) task).getDeadline();
                if (dt.toLocalDate().equals(targetDate)) {
                    System.out.println("\t  " + task);
                    found = true;
                }
            } else if (task instanceof Event) {
                LocalDateTime from = ((Event) task).getFrom();
                LocalDateTime to = ((Event) task).getTo();
                if (!from.toLocalDate().isAfter(targetDate) && !to.toLocalDate().isBefore(targetDate)) {
                    System.out.println("\t  " + task);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("\tYou're as busy as a rock");
        }
        System.out.println(border);
    }

}
