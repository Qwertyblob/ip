package tony.commands;

import tony.exceptions.TonyException;
import tony.storage.Storage;
import tony.tasks.TaskList;
import tony.ui.UI;

public class ListCommand extends Command {

    @Override
    void execute(TaskList tasks, UI ui, Storage storage) throws TonyException {
        ui.showList(tasks);
    }
}
