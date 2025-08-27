package tony;

import tony.commands.Command;
import tony.exceptions.TonyException;
import tony.parsers.Parser;
import tony.storage.Storage;
import tony.tasks.TaskList;
import tony.ui.UI;

public class Tony {
    Storage storage;
    TaskList tasks;
    UI ui;

    public Tony() {
        this.storage = new Storage("./data/tasks.txt");
        this.tasks = new TaskList();
        this.ui = new UI();
    }

    void run() {
        this.ui.greeting();
        this.storage.load(tasks);
        boolean isExit = false;
        while (!isExit) {
            String command = this.ui.readCommand();
            try {
                Command c = Parser.parse(command);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (TonyException e) {
                this.ui.showError(e.getMessage());
            }
        }
        this.ui.exit();
    }

    public static void main(String[] args) {
        new Tony().run();
    }
}
