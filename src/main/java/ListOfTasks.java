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
        try {
            if (words.length == 2 && words[1].matches("\\d+")) {
                int index = Integer.parseInt(words[1]);
                if (index > 0 && index <= this.getSize()) {
                    Task t = this.getList().get(index - 1);
                    new Display(t).showMark(t);
                } else {
                    throw new InvalidIndexException("No offence, but do you know how to count?");
                }
            } else {
                throw new MarkException("JARVIS, show them how it's done.\n\tmark <number>");
            }
        } catch (TonyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void unMark(String[] words) {
        try {
            if (words.length == 2 && words[1].matches("\\d+")) {
                int index = Integer.parseInt(words[1]);
                if (index > 0 && index <= this.getSize()) {
                    Task t = this.getList().get(index - 1);
                    new Display(t).showUnmark(t);
                } else {
                    throw new InvalidIndexException("No offence, but do you know how to count?");
                }
            } else {
                throw new MarkException("JARVIS, show them how it's done.\n\tunmark <number>");
            }
        } catch (TonyException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTask(String[] words) {
        try {
            if (words.length == 2 && words[1].matches("\\d+")) {
                int index = Integer.parseInt(words[1]);
                if (index > 0 && index <= this.getSize()) {
                    Task t = this.getList().get(index - 1);
                    this.tasks.remove(index);
                    new Display(t).showDelete(t);
                } else {
                    throw new InvalidIndexException("No offence, but do you know how to count?");
                }
            } else {
                throw new DeleteException("JARVIS, show them how it's done.\n\tdelete <number>");
            }
        } catch (TonyException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getSize() {
        return tasks.size();
    }
}
