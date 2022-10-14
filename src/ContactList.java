import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ContactList {

    public static void main(String[] args) throws IOException {
        String filename = "contacts.tx";
        String directory = "data";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(filename);



        List<String> contactList = Arrays.asList("John","Jacob","JingleHeinerSchmidt");
        Path filepath = Paths.get(filename);
        Files.write(filepath, contactList);



    }
}
