public abstract class Command {

    abstract void execute(TaskList tasks, UI ui, Storage storage) throws TonyException;

    boolean isExit() {
        return false;
    }

}
