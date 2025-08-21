import java.util.Scanner;

public class Tony {
    public static void main(String[] args) {
        Display.greeting();
        ListOfTasks list = new ListOfTasks();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Task task = new Task(command);

        while (!command.equals("bye")) {
            String[] words = command.trim().split("\\s+");
            if (command.equals("list")) {
                Display.showList(list);
            } else if (words.length == 2
                    && words[1].matches("\\d+")
                    && (words[0].equals("mark") || words[0].equals("unmark"))) {
                int index = Integer.parseInt(words[1]);
                Task t = list.getList().get(index - 1);
                if (index > 0 && index <= list.getSize()) {
                    if (words[0].equals("mark")) {
                        t.markDone();
                        new Display(t).showMark();
                    } else {
                        t.markUndone();
                        new Display(t).showUnmark();
                    }
                } else {
                    System.out.println("Invalid task index!");
                }
            } else {
                list.setTask(task);
                new Display(task).showMessage();
            }
            command = scanner.nextLine();
            task = new Task(command);
        }
        Display.exit();
    }
}
