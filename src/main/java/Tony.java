import java.util.Scanner;

public class Tony {
    public static void main(String[] args) {
        Display.greeting();
        ListOfTasks list = new ListOfTasks();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!command.equals("bye")) {
            String[] words = command.trim().split("\\s+", 2);
            String keyword = words[0];
            switch (keyword) {
                case "list":
                    Display.showList(list);
                    break;
                case "todo":
                    ToDo.makeToDo(list, command);
                    break;
                case "deadline":
                    Deadline.makeDeadline(list, command);
                    break;
                case "event":
                    Event.makeEvent(list, command);
                    break;
                case "mark":
                    list.mark(words);
                    break;
                case "unmark":
                    list.unMark(words);
                    break;
                default:
                    System.out.println("Please input a valid command.");
            }
            command = scanner.nextLine();
        }
        Display.exit();
    }
}
