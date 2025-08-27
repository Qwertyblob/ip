package tony.tasks;

import tony.storage.Storage;

/**
 * Represents a task.
 */
public abstract class Task {
    protected String command;
    private boolean done = false;

    public Task(String command) {
        this.command = command;
    }

    public boolean isDone() {
        return this.done;
    }

    public void markDone() {
        this.done = true;
    }

    public void markUndone() {
        this.done = false;
    }

    public String toString() {
        return (this.isDone() ? "[X]" : "[ ]") + " " + this.command;
    }

    /**
     * Modifies the task to a format to be saved in {@link Storage}.
     * @return The task formatted to a {@link String}.
     */
    public abstract String toDataFormat();
}
