package tony.commands;

import tony.exceptions.TonyException;
import tony.parsers.DateTimeManager;
import tony.storage.Storage;
import tony.tasks.Deadline;
import tony.tasks.Event;
import tony.tasks.Task;
import tony.tasks.TaskList;
import tony.ui.UI;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ShowTasksOnDateCommand extends Command {
    private final LocalDateTime targetDate;

    public ShowTasksOnDateCommand(String targetDate) {
        this.targetDate = DateTimeManager.parse(targetDate);
    }

    @Override
    public void execute(TaskList tasks, UI ui, Storage storage) throws TonyException {
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
