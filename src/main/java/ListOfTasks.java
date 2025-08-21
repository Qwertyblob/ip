import java.util.ArrayList;

public class ListOfTasks {
    private ArrayList<String> tasks = new ArrayList<>();

    public void setTask(String task) {
        this.tasks.add(task);
    }

    public ArrayList<String> getList() {
        return this.tasks;
    }

    public int getSize() {
        return tasks.size();
    }
}
