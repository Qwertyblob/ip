package tony.commands;

import java.util.ArrayList;

import tony.storage.Storage;
import tony.tasks.Task;
import tony.tasks.TaskList;
import tony.ui.UI;

public class FindCommand extends Command {

    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the {@link FindCommand}.
     * Goes through the {@link TaskList} to find tasks that contain the keyword specified by the user.
     * Displays tasks that contain the keyword specified by the user through the {@link UI}.
     *
     * @param tasks The {@link TaskList} that stores tasks.
     * @param ui The {@link UI} instance for displaying feedback to the user.
     * @param storage The {@link Storage} instance for saving tasks to file.
     * @return The tasks found as a {@link String}.
     */
    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        assert tasks != null : "TaskList cannot be null";
        assert ui != null : "UI cannot be null";
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks.getList()) {
            if (task.toString().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(task);
            }
        }
        return ui.showFound(matchingTasks, keyword);
    }
}
