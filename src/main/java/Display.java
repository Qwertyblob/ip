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
        for (int i = 1; i <= list.getSize(); i++) {
            System.out.println("\t" + i + ": " + list.getList().get(i - 1));
        }
        System.out.println(border);
    }

}
