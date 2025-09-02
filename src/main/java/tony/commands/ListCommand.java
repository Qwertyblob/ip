package tony.commands;

import tony.storage.Storage;
import tony.tasks.TaskList;
import tony.ui.UI;

/**
 * Represents a command to list a {@link TaskList}.
 */
public class ListCommand extends Command {

    /**
     * Executes the {@code ListCommand}.
     * Displays confirmation of the deleted task through the {@link UI}.
     *
     * @param tasks The {@link TaskList} from which the tasks will be shown.
     * @param ui The {@link UI} instance for displaying feedback to the user.
     * @param storage The {@link Storage} instance for saving tasks to file.
     */
    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        return ui.showList(tasks);
    }
}
