import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactListManager{

    public  add throws void IOException(Record record){
        String directory = "data";
        String filename = "info.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }
    }
}