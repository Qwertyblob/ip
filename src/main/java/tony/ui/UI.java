package tony.ui;

import tony.tasks.Task;
import tony.tasks.TaskList;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    Scanner sc;
    private static final String border = "\t" + "=".repeat(80);

    public UI() {
        sc = new Scanner(System.in);
    }

    public void showAddTask(TaskList list, Task task) {
        System.out.println(border);
        System.out.println("\tAlright, just let one of my machines do it for you:\n\t  " + task);
        System.out.println("\tNow you have " + list.getSize() + " tasks in the list.");
        System.out.println(border);
    }

    public void greeting() {
        System.out.println(border + "\n\tHey, it's Tony.\n\tGenius, billionaire, philanthropist… and apparently your personal assistant now.\n" + border);
    }

    public void exit() {
        System.out.println(border + "\n\tI’m powering down. Don’t break anything while I’m gone.\n" + border);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showError(String msg) {
        System.out.println(msg);
    }

    public void showList(TaskList list) {
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

    public void showTasksOnDate(ArrayList<Task> tasks, boolean found) {
        System.out.println(border);
        if (!found) {
            System.out.println("\tYou're as busy as a rock");
        } else {
            for (Task task : tasks) {
                System.out.println("\t  " + task);
            }
        }
        System.out.println(border);
    }

}
