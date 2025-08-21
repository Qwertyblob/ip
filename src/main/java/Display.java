public class Display {
    private Task message;
    private final String border = "=".repeat(80);


    public Display(Task message) {
        this.message = message;
    }

    public void showMessage() {
        System.out.println(border + "\n" + this.message.toString() + "\n" + border);
    }

    public static void greeting() {
        new Display(new Task("Hello! I'm Tony.\nWhat can I do for you?")).showMessage();
    }

    public static void exit() {
        new Display(new Task("Bye. Hope to see you again soon!")).showMessage();
    }


}
