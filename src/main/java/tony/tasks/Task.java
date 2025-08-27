package tony.tasks;

public abstract class Task {
    protected String command;
    private boolean done = false;

    public Task(String command) {
        this.command = command;
    }

    public boolean doneStatus() {
        return this.done;
    }

    public void markDone() {
        this.done = true;
    }

    public void markUndone() {
        this.done = false;
    }

    public String toString() {
        return (this.doneStatus() ? "[X]" : "[ ]") + " " + this.command;
    }

    public abstract String toDataFormat();
}
