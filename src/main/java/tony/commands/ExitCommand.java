package tony.commands;

import tony.storage.Storage;
import tony.tasks.TaskList;
import tony.ui.UI;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {

    }

    @Override
    public boolean isExit() {
        return true;
    }
}
