import java.util.Scanner;

public class Tony {
    public static void main(String[] args) {
        Display.greeting();
        ListOfTasks list = new ListOfTasks();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Task task = new Task(command);

        while (!task.toString().equals("bye")) {
            if (task.toString().equals("list")) {
                Display.showList(list);
            } else {
                list.setTask(task);
                Display display = new Display(task);
                display.showMessage();
            }
            command = scanner.nextLine();
            task = new Task(command);
        }
        Display.exit();
    }
}
