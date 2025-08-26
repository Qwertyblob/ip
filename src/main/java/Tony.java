import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Tony {
    public static void main(String[] args) {
        Display.greeting();
        ListOfTasks list = new ListOfTasks();
        SaveFile saveFile = new SaveFile("./data/tasks.txt");
        saveFile.load(list);
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().trim();

        while (!command.equals("bye")) {
            String[] words = command.trim().split("\\s+", 2);
            String keyword = words[0];
            switch (keyword) {
                case "list":
                    Display.showList(list);
                    break;
                case "todo":
                    ToDo.makeToDo(list, command);
                    saveFile.save(list);
                    break;
                case "deadline":
                    Deadline.makeDeadline(list, command);
                    saveFile.save(list);
                    break;
                case "event":
                    Event.makeEvent(list, command);
                    saveFile.save(list);
                    break;
                case "mark":
                    list.mark(words);
                    saveFile.save(list);
                    break;
                case "unmark":
                    list.unMark(words);
                    saveFile.save(list);
                    break;
                case "delete":
                    list.deleteTask(words);
                    saveFile.save(list);
                    break;
                case "show":
                    Display.showTasksOnDate(list, command);
                    break;
                case "":
                    try {
                        throw new EmptyTaskException("Don't be shy, I won't bite.");
                    } catch (EmptyTaskException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    try {
                        throw new InvalidCommandException("Hey man, I have no idea what you're saying");
                    } catch (InvalidCommandException e) {
                        System.out.println(e.getMessage());
                    }
            }
            command = scanner.nextLine();
        }
        Display.exit();
    }
}
