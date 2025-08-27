package tony.commands;

import tony.exceptions.TonyException;
import tony.storage.Storage;
import tony.tasks.TaskList;
import tony.ui.UI;

public abstract class Command {

    public abstract void execute(TaskList tasks, UI ui, Storage storage) throws TonyException;

    public boolean isExit() {
        return false;
    }

}
