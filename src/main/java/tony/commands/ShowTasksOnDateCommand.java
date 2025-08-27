package tony.commands;

import tony.parsers.DateTimeManager;
import tony.storage.Storage;
import tony.tasks.Deadline;
import tony.tasks.Event;
import tony.tasks.Task;
import tony.tasks.TaskList;
import tony.ui.UI;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Represents a command to show list of tasks from the task list
 * that lie on a specified date by the user.
 * The user specifies the tasks to show using the format <code>dd-MM-yyyy</code>.
 */
public class ShowTasksOnDateCommand extends Command {
    private final LocalDateTime targetDate;

    public ShowTasksOnDateCommand(String targetDate) {
        this.targetDate = DateTimeManager.parse(targetDate);
    }

    /**
     * Executes the {@code ShowTasksOnDateCommand}.
     * Goes through the {@link TaskList} to find tasks that lie on the date specified by the user.
     * Displays tasks that lie on the date specified by the user through the {@link UI}.
     *
     * @param tasks The {@link TaskList} from which the task will be marked.
     * @param ui The {@link UI} instance for displaying feedback to the user.
     * @param storage The {@link Storage} instance for saving tasks to file.
     */
    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) {
        ArrayList<Task> currTasks = new ArrayList<>();
        boolean isFound = false;
        for (Task task : tasks.getList()) {
            if (task instanceof Deadline) {
                LocalDateTime dt = ((Deadline) task).getDeadline();
                if (dt.equals(targetDate)) {
                    isFound = true;
                    currTasks.add(task);
                }
            } else if (task instanceof Event) {
                LocalDateTime from = ((Event) task).getFrom();
                LocalDateTime to = ((Event) task).getTo();
                if (!from.isAfter(targetDate) && !to.isBefore(targetDate)) {
                    isFound = true;
                    currTasks.add(task);                }
            }
        }
        ui.showTasksOnDate(currTasks, isFound);
    }
}
