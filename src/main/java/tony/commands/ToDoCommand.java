package tony.commands;

import tony.exceptions.EmptyTaskException;
import tony.exceptions.TonyException;
import tony.storage.Storage;
import tony.tasks.TaskList;
import tony.tasks.ToDo;
import tony.ui.UI;

public class ToDoCommand extends Command {

    private final String description;

    public ToDoCommand(String args) throws TonyException {
        if (args.isEmpty()) {
            throw new EmptyTaskException("Hey, give me something to work with.");
        }
        this.description = args.trim();
    }

    @Override
    void execute(TaskList tasks, UI ui, Storage storage) throws TonyException {
        ToDo task = new ToDo(description);
        tasks.addTask(task);
        storage.save(tasks);
        ui.showAddTask(tasks, task);
    }
}
