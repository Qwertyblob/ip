public class Display {
    private Task message;
    private static final String border = "\t" + "=".repeat(80);


    public Display(Task message) {
        this.message = message;
    }

    public void showMessage() {
        System.out.println(border + "\n\t added: " + this.message.toString() + "\n" + border);
    }

    public static void greeting() {
        System.out.println(border + "\n\tHello! I'm Tony.\n\tWhat can I do for you?\n" + border);
    }

    public static void exit() {
        System.out.println(border + "\n\tBye. Hope to see you again soon!\n" + border);
    }

    public static void showList(ListOfTasks list) {
        System.out.println(border);
        System.out.println("\tHere are the tasks in your list:");
        for (int i = 1; i <= list.getSize(); i++) {
            System.out.println("\t" + i + ": " + list.getList().get(i - 1).toString());
        }
        System.out.println(border);
    }

    public void showMark(Task t) {
        t.markDone();
        System.out.println(border);
        System.out.println("\tNice! I've marked this task as done:");
        System.out.println("\t  " + t);
        System.out.println(border);
    }

    public void showUnmark(Task t) {
        t.markUndone();
        System.out.println(border);
        System.out.println("\tOK, I've marked this task as not done yet:");
        System.out.println("\t  " + t);
        System.out.println(border);
    }

}
