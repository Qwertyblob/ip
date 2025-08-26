public class ToDo extends Task {

    public ToDo(String command) {
        super(command);
    }

    public static void makeToDo(ListOfTasks list, String command) {
        try {
            String[] words = command.trim().split("\\s+", 2);
            if (words.length > 1) {
                ToDo todo = new ToDo(words[1].trim());
                list.setTask(todo);
                new Display(todo).addTask(list);
            } else {
                throw new EmptyTaskException("Hey, give me something to work with.");
            }
        } catch (EmptyTaskException e) {
            System.out.println(e.getMessage());
        }
    }

    public String toString() {
        return "[T]" + super.toString();
    }

    public String toDataFormat() {
        return "T | " + (doneStatus() ? 1 : 0) + " | " + this.command;
    }
}
