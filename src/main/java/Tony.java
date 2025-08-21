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
                    if (words.length > 1) {
                        ToDo todo = new ToDo(words[1]);
                        list.setTask(todo);
                    } else {
                        System.out.println("Task cannot be empty.");
                    }
                    break;
                case "deadline":
                    if (words.length > 1 && command.contains("/by")) {
                        String[] d = words[1].split("/by", 2);
                        Deadline deadline = new Deadline(d[0].trim(), d[1].trim());
                        list.setTask(deadline);
                    } else {
                        System.out.println("Invalid deadline task format.");
                    }
                    break;
                case "event":
                    if (words.length > 1 && command.contains("/from") && command.contains("/to")) {
                        String[] parts = words[1].split("/from", 2);
                        String[] fromTo = parts[1].split("/to", 2);
                        String from = fromTo[0].trim();
                        String to   = fromTo[1].trim();
                        Event event = new Event(parts[0].trim(), from, to);
                        list.setTask(event);
                    } else {
                        System.out.println("Invalid event task format.");
                    }
                    break;
                case "mark":
                case "unmark":
                    if (words.length != 2 || !words[1].matches("\\d+")) {
                        System.out.println("Invalid use of mark/unmark.");
                        break;
                    }
                    int index = Integer.parseInt(words[1]);
                    if (index < 1 || index > list.getSize()) {
                        System.out.println("Invalid task index!");
                        break;
                    }
                    Task t = list.getList().get(index - 1);
                    if (keyword.equals("mark")) {
                        new Display(t).showMark();
                    } else {
                        new Display(t).showUnmark();
                    }
                    break;
                default:
                    System.out.println("Please input a valid command.");
            }
            command = scanner.nextLine();
        }
        Display.exit();
    }
}
