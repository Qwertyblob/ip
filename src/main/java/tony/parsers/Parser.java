package tony.parsers;

import tony.commands.*;
import tony.exceptions.InvalidCommandException;
import tony.exceptions.TonyException;

public class Parser {

    public static Command parse(String input) throws TonyException {
        String[] parts = input.trim().split(" ", 2);
        String keyword = parts[0];
        String args = (parts.length < 2) ? "" : parts[1];

        switch (keyword) {
            case "todo": return new ToDoCommand(args);
            case "deadline": return new DeadlineCommand(args);
            case "event": return new EventCommand(args);
            case "list": return new ListCommand();
            case "delete": return new DeleteCommand(args);
            case "mark": return new MarkCommand(args);
            case "unmark": return new UnmarkCommand(args);
            case "show": return new ShowTasksOnDateCommand(args);
            case "bye": return new ExitCommand();
            default: throw new InvalidCommandException("Hey man, I don't know what you're saying.");
        }
    }
}