import java.io.File;
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
}

