import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {

    private final File saveFile;

    public SaveFile(String saveFilePath) {
        this.saveFile = new File(saveFilePath);
        createIfNotExists();
    }

    private void createIfNotExists() {
        try {
            File parentDir = saveFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error creating save file: " + e.getMessage());
        }
    }

    public void save(ListOfTasks list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile))) {
            for (Task task : list.getList()) {
                writer.write(task.toDataFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to save file: " + e.getMessage());
        }
    }

    public void load(ListOfTasks list) {
        try (BufferedReader reader = new BufferedReader(new FileReader(saveFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(" \\| ");
                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                Task task = null;
                switch (type) {
                    case "T":
                        task = new ToDo(parts[2]);
                        break;
                    case "D":
                        task = new Deadline(parts[2], parts[3].replace("by ", ""));
                        break;
                    case "E":
                        String[] duration = parts[3].split("-");
                        task = new Event(parts[2],
                                duration[0].replace("from ", ""),
                                duration[1].replace("to ", ""));
                        break;
                }
                if (task != null) {
                    if (isDone) task.markDone();
                    list.setTask(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading save file: " + e.getMessage());
        }
    }
}

