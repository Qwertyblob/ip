package tony.ui;

import java.util.ArrayList;
import java.util.Scanner;

import tony.tasks.Task;
import tony.tasks.TaskList;

public class UI {
    private static final String BORDER = "\t" + "=".repeat(80);
    private Scanner sc;

    public UI() {
        sc = new Scanner(System.in);
    }

    public void showAddTask(TaskList list, Task task) {
        System.out.println(BORDER);
        System.out.println("\tAlright, just let one of my machines do it for you:\n\t  " + task);
        System.out.println("\tNow you have " + list.getSize() + " tasks in the list.");
        System.out.println(BORDER);
    }

    public void greeting() {
        System.out.println(BORDER + "\n\tHey, it's Tony.");
        System.out.println("\tGenius, billionaire, philanthropist… and apparently your personal assistant now.\n"
                + BORDER);
    }

    public void exit() {
        System.out.println(BORDER + "\n\tI’m powering down. Don’t break anything while I’m gone.\n" + BORDER);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showError(String msg) {
        System.out.println(msg);
    }

    public void showList(TaskList list) {
        System.out.println(BORDER);
        System.out.println("\tJARVIS, show them their list of tasks:");
        for (int i = 1; i <= list.getSize(); i++) {
            System.out.println("\t" + i + ": " + list.getList().get(i - 1).toString());
        }
        System.out.println(BORDER);
    }

    public void showMark(Task t) {
        t.markDone();
        System.out.println(BORDER);
        System.out.println("\tDone. Look at you, being efficient.");
        System.out.println("\t  " + t);
        System.out.println(BORDER);
    }

    public void showUnmark(Task t) {
        t.markUndone();
        System.out.println(BORDER);
        System.out.println("\tUnmarked. Happens to the best of us.");
        System.out.println("\t  " + t);
        System.out.println(BORDER);
    }

    public void showDelete(Task t) {
        System.out.println(BORDER);
        System.out.println("\tOverachieving might not be for everybody.");
        System.out.println("\t  " + t);
        System.out.println(BORDER);
    }

    public void showTasksOnDate(ArrayList<Task> tasks, boolean isFound) {
        System.out.println(BORDER);
        if (!isFound) {
            System.out.println("\tYou're as busy as a rock");
        } else {
            for (Task task : tasks) {
                System.out.println("\t  " + task);
            }
        }
        System.out.println(BORDER);
    }

    public void showFound(ArrayList<Task> tasks, String keyword) {
        System.out.println(BORDER);
        if (tasks.isEmpty()) {
            System.out.println("\tWell, I tried my best.");
        } else {
            System.out.println("\tThat didn't take long.");
            for (int i = 1; i <= tasks.size(); i++) {
                System.out.println("\t" + i + ": " + tasks.get(i - 1).toString());
            }
        }
        System.out.println(BORDER);
    }

}
