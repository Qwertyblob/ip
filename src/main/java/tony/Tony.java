package tony;

import tony.commands.Command;
import tony.exceptions.TonyException;
import tony.parsers.Parser;
import tony.storage.Storage;
import tony.tasks.TaskList;
import tony.ui.UI;

public class Tony {
    private Storage storage;
    private TaskList tasks;
    private UI ui;

    public Tony() {
        this.storage = new Storage("./data/tasks.txt");
        this.tasks = this.storage.load();
        this.ui = new UI();
    }

    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, ui, storage);
        } catch (TonyException e) {
            return this.ui.showError(e.getMessage());
        }
    }
}
