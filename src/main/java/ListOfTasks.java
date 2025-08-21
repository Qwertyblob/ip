import java.util.ArrayList;

public class ListOfTasks {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void setTask(Task task) {
        this.tasks.add(task);
    }

    public ArrayList<Task> getList() {
        return this.tasks;
    }

    public void mark(String[] words) {
        if (words.length == 2 && words[1].matches("\\d+")) {
            int index = Integer.parseInt(words[1]);
            if (index > 0 && index <= this.getSize()) {
                Task t = this.getList().get(index - 1);
                new Display(t).showMark(t);
            } else {
                System.out.println("Invalid task index!");
            }
        } else {
            System.out.println("Invalid use of mark/unmark.");
        }

    }

    public void unMark(String[] words) {
        if (words.length == 2 && words[1].matches("\\d+")) {
            int index = Integer.parseInt(words[1]);
            if (index > 0 && index <= this.getSize()) {
                Task t = this.getList().get(index - 1);
                new Display(t).showUnmark(t);
            } else {
                System.out.println("Invalid task index!");
            }
        } else {
            System.out.println("Invalid use of mark/unmark.");
        }
    }

    public int getSize() {
        return tasks.size();
    }
}
