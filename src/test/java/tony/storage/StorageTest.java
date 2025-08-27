package tony.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import tony.tasks.*;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {

    @TempDir
    Path tempDir;
    private File saveFile;
    private Storage storage;

    @BeforeEach
    void setUp() {
        saveFile = tempDir.resolve("testSave.txt").toFile();
        storage = new Storage(saveFile.getAbsolutePath());
    }

    @Test
    void testSaveAndLoadTodoTask() {
        TaskList list = new TaskList();
        list.addTask(new ToDo("Buy milk"));
        storage.save(list);
        TaskList loadedList = new TaskList();
        storage.load(loadedList);
        assertEquals(1, loadedList.getSize());
        assertEquals("[T][ ] Buy milk", loadedList.getTask(1).toString());
        assertFalse(loadedList.getTask(1).doneStatus());
    }

    @Test
    void testSaveAndLoadDeadlineTask() {
        TaskList list = new TaskList();
        Deadline deadline = new Deadline("Submit report",
                tony.parsers.DateTimeManager.parse("30-08-2025 11:59PM"));
        deadline.markDone();
        list.addTask(deadline);
        storage.save(list);
        TaskList loadedList = new TaskList();
        storage.load(loadedList);
        assertEquals(1, loadedList.getSize());
        Task loaded = loadedList.getTask(1);
        assertTrue(loaded.doneStatus());
        assertInstanceOf(Deadline.class, loaded);
        assertEquals("[D][X] Submit report (by: 30 Aug 25 11:59PM)", loaded.toString());
    }

    @Test
    void testSaveAndLoadEventTask() {
        TaskList list = new TaskList();
        Event event = new Event("Project meeting",
                tony.parsers.DateTimeManager.parse("28-08-2025 10:00AM"),
                tony.parsers.DateTimeManager.parse("28-08-2025 12:00PM"));
        list.addTask(event);
        storage.save(list);
        TaskList loadedList = new TaskList();
        storage.load(loadedList);
        assertEquals(1, loadedList.getSize());
        Task loaded = loadedList.getTask(1);
        assertInstanceOf(Event.class, loaded);
        assertEquals("[E][ ] Project meeting (from: 28 Aug 25 10:00AM to 28 Aug 25 12:00PM)", loaded.toString());
    }
}
