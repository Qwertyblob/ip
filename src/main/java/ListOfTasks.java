import java.util.ArrayList;

public class ListOfTasks {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void setTask(Task task) {
        this.tasks.add(task);
    }

    public ArrayList<Task> getList() {
        return this.tasks;
    }

    public int getSize() {
        return tasks.size();
    }
}
