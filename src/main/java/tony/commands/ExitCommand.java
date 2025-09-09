package tony.commands;

import tony.storage.Storage;
import tony.tasks.TaskList;
import tony.ui.UI;

/**
 * Represents a command to end the program.
 */
public class ExitCommand extends Command {
    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        assert tasks != null : "TaskList should not be null";
        assert ui != null : "UI should not be null";
        return ui.exit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
