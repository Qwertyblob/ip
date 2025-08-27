package tony.commands;

import tony.exceptions.InvalidIndexException;
import tony.exceptions.TonyException;
import tony.storage.Storage;
import tony.tasks.Task;
import tony.tasks.TaskList;
import tony.ui.UI;

public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(String args) throws TonyException {
        try {
            this.index = Integer.parseInt(args.trim());
        } catch (NumberFormatException e) {
            throw new TonyException("JARVIS, show them how it's done.\n\tmark <number>");
        }
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws TonyException {
        try {
            if (this.index > tasks.getSize() || this.index < 1) {
                throw new InvalidIndexException("No offence, but do you know how to count?");
            } else {
                Task task = tasks.getTask(index);
                tasks.markDone(index);
                storage.save(tasks);
                ui.showMark(task);
            }
        } catch (TonyException e) {
            ui.showError(e.getMessage());
        }
    }
}
