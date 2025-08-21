public class Display {
    private Task message;
    private static final String border = "\t" + "=".repeat(80);


    public Display(Task message) {
        this.message = message;
    }

    public void addTask(ListOfTasks list) {
        System.out.println(border);
        System.out.println("\tAlright, just let one of my machines do it for you:\n\t  " + this.message);
        System.out.println("\tNow you have " + list.getSize() + " tasks in the list.");
        System.out.println(border);
    }

    public static void greeting() {
        System.out.println(border + "\n\tHey, it's Tony.\n\tGenius, billionaire, philanthropist… and apparently your personal assistant now.\n" + border);
    }

    public static void exit() {
        System.out.println(border + "\n\tI’m powering down. Don’t break anything while I’m gone.\n" + border);
    }

    public static void showList(ListOfTasks list) {
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

}
