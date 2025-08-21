public class Task {
    private String command;
    private boolean done = false;

    public Task(String command) {
        this.command = command;
    }

    public String doneStatus() {
        return this.done ? "[X]" : "[ ]";
    }

    public void markDone() {
        this.done = true;
    }

    public void markUndone() {
        this.done = false;
    }

    public String toString() {
        return this.doneStatus() + " " + this.command;
    }

}
