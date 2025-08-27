package tony.commands;

import tony.exceptions.EmptyTaskException;
import tony.exceptions.TonyException;
import tony.storage.Storage;
import tony.tasks.TaskList;
import tony.tasks.ToDo;
import tony.ui.UI;

/**
 * Represents a command to create a {@link ToDo} task.
 * A todo task requires a task description after the command <code>todo</code>
 */
public class ToDoCommand extends Command {

    private final String description;

    public ToDoCommand(String args) throws TonyException {
        if (args.isEmpty()) {
            throw new EmptyTaskException("Hey, give me something to work with.");
        }
        this.description = args.trim();
    }

    /**
     * Executes the {@code ToDoCommand}.
     * Creates and adds a {@link ToDo} task to the given {@link TaskList}.
     * Saves the updated task list to persistent storage via {@link Storage}.
     * Displays confirmation of the added task through the {@link UI}.
     *
     * @param tasks The {@link TaskList} to which the new task will be added.
     * @param ui The {@link UI} instance for displaying feedback to the user.
     * @param storage The {@link Storage} instance for saving tasks to file.
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        ToDo task = new ToDo(description);
        tasks.addTask(task);
        storage.save(tasks);
        ui.showAddTask(tasks, task);
    }
}
