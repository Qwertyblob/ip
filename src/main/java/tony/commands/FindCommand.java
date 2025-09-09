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

    @Override
    public String execute(TaskList tasks, UI ui, Storage storage) {
        assert tasks != null : "TaskList should not be null";
        assert ui != null : "UI should not be null";
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks.getList()) {
            if (task.toString().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTasks.add(task);
            }
        }
        return ui.showFound(matchingTasks, keyword);
    }
}
