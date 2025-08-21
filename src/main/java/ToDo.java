public class ToDo extends Task {

    public ToDo(String command) {
        super(command);
    }

    public static void makeToDo(ListOfTasks list, String command) {
        String[] words = command.trim().split("\\s+", 2);
        if (words.length > 1) {
            ToDo todo = new ToDo(words[1]);
            list.setTask(todo);
        } else {
            System.out.println("Task cannot be empty.");
        }
    }

    public String toString() {
        return "[T]" + super.toString();
    }
}
