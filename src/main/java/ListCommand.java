public class ListCommand extends Command {

    @Override
    void execute(TaskList tasks, UI ui, Storage storage) throws TonyException {
        ui.showList(tasks);
    }
}
