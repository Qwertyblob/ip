public class ToDo extends Task {

    public ToDo(String command) {
        super(command);
    }

    public static void makeToDo(ListOfTasks list, String command) {
        try {
            String[] words = command.trim().split("\\s+", 2);
            if (words.length > 1 && !words[1].isBlank()) {
                ToDo todo = new ToDo(words[1].trim());
                list.setTask(todo);
                new Display(todo).addTask(list);
            } else {
                throw new ToDoException("Hey, give me something to work with.");
            }
        } catch (ToDoException e) {
            System.out.println("\t" + e.getMessage());
        }
    }

    public String toString() {
        return "[T]" + super.toString();
    }
}
