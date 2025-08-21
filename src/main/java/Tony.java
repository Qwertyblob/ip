import java.util.Scanner;

public class Tony {
    public static void main(String[] args) {
        Display.greeting();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Task task = new Task(command);

        while (!task.toString().equals("bye")) {
            Display display = new Display(task);
            display.showMessage();
            command = scanner.nextLine();
            task = new Task(command);
        }

        Display.exit();
    }
}
