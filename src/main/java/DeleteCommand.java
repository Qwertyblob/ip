public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(String args) throws TonyException {
        try {
            this.index = Integer.parseInt(args.trim());
        } catch (NumberFormatException e) {
            throw new TonyException("JARVIS, show them how it's done.\n\tdelete <number>");
        }
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws TonyException {
        try {
            if (this.index > tasks.getSize() || this.index < 1) {
                throw new InvalidIndexException("No offence, but do you know how to count?");
            } else {
                Task task = tasks.deleteTask(index);
                storage.save(tasks);
                ui.showDelete(task);
            }
        } catch (TonyException e) {
            ui.showError(e.getMessage());
        }
    }
}
