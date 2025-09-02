package tony.ui;

import java.util.ArrayList;
import java.util.Scanner;

import tony.tasks.Task;
import tony.tasks.TaskList;

public class UI {
    private Scanner sc;

    public UI() {
        sc = new Scanner(System.in);
    }

    public String showAddTask(TaskList list, Task task) {
        StringBuilder s = new StringBuilder();
        //System.out.println(BORDER);
        //System.out.println("\tAlright, just let one of my machines do it for you:\n\t  " + task);
        //System.out.println("\tNow you have " + list.getSize() + " tasks in the list.");
        //System.out.println(BORDER);
        s.append("Alright, just let one of my machines do it for you:\n  ").append(task);
        s.append("\nNow you have ").append(list.getSize()).append(" tasks in the list.");
        return s.toString();
    }

    public String greeting() {
        StringBuilder s = new StringBuilder();
        //System.out.println(BORDER + "\n\tHey, it's Tony.");
        //System.out.println("\tGenius, billionaire, philanthropist… and apparently your personal assistant now.\n" + BORDER);
        s.append("Hey, it's Tony.\n");
        s.append("Genius, billionaire, philanthropist… and apparently your personal assistant now.");
        return s.toString();
    }

    public String exit() {
        StringBuilder s = new StringBuilder();
        s.append("I’m powering down. Don’t break anything while I’m gone.");
        //System.out.println(BORDER + "\n\tI’m powering down. Don’t break anything while I’m gone.\n" + BORDER);
        return s.toString();
    }

//    public String readCommand() {
//        return sc.nextLine();
//    }

    public String showError(String msg) {
        return msg;
    }

    public String showList(TaskList list) {
        StringBuilder s = new StringBuilder();
        s.append("JARVIS, show them their list of tasks:\n");
        //System.out.println(BORDER);
        //System.out.println("\tJARVIS, show them their list of tasks:");
        for (int i = 1; i <= list.getSize(); i++) {
            s.append("  ").append(i).append(": ").append(list.getList().get(i - 1).toString()).append("\n");
        }
        //System.out.println(BORDER);
        return s.toString();
    }

    public String showMark(Task t) {
        t.markDone();
        //System.out.println(BORDER);
        //System.out.println("\tDone. Look at you, being efficient.");
        //System.out.println("\t  " + t);
        //System.out.println(BORDER);
        StringBuilder s = new StringBuilder();
        s.append("Done. Look at you, being efficient.\n  ");
        s.append(t);
        return s.toString();
    }

    public String showUnmark(Task t) {
        t.markUndone();
        //System.out.println(BORDER);
        //System.out.println("\tUnmarked. Happens to the best of us.");
        //System.out.println("\t  " + t);
        //System.out.println(BORDER);
        StringBuilder s = new StringBuilder();
        s.append("Unmarked. Happens to the best of us.\n  ");
        s.append(t);
        return s.toString();
    }

    public String showDelete(Task t) {
        //System.out.println(BORDER);
        //System.out.println("\tOverachieving might not be for everybody.");
        //System.out.println("\t  " + t);
        //System.out.println(BORDER);
        StringBuilder s = new StringBuilder();
        s.append("Overachieving might not be for everybody.\n  ");
        s.append(t);
        return s.toString();
    }

    public String showTasksOnDate(ArrayList<Task> tasks, boolean isFound) {
        //System.out.println(BORDER);
        StringBuilder s = new StringBuilder();
        if (!isFound) {
            //System.out.println("\tYou're as busy as a rock");
            s.append("You're as busy as a rock");
        } else {
            for (Task task : tasks) {
                //System.out.println("\t  " + task);
                s.append("  ").append(task).append("\n");
            }
        }
        //System.out.println(BORDER);
        return s.toString();
    }

    public String showFound(ArrayList<Task> tasks, String keyword) {
        StringBuilder s = new StringBuilder();
        if (tasks.isEmpty()) {
            s.append("Well, I tried my best.");
        } else {
            s.append("That didn't take long.");
            for (int i = 1; i <= tasks.size(); i++) {
                s.append("\t").append(i).append(": ").append(tasks.get(i - 1).toString()).append("\n");
            }
        }
        //System.out.println(BORDER);
        return s.toString();
    }

}
