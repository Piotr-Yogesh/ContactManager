import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactTesting {
    public static void main(String[] args) throws IOException {
        //        String directory = "data";
//        String filename = "contacts.txt";
//
//        Path dataDirectory = Paths.get(directory);
//        Path dataFile = Paths.get(directory, filename);
//        if (Files.notExists(dataDirectory)) {
//            Files.createDirectories(dataDirectory);
//        }
//        if (! Files.exists(dataFile)) {
//            Files.createFile(dataFile);
//        }
//
//        List<String> contactList = Arrays.asList("John","Jacob","JingleHeinerSchmidt");
//        Path filepath = Paths.get(filename);
//        Files.write(filepath, contactList);
//

        Path filepath = Paths.get("../data/contacts.txt");

        List<Contact> contactList = new ArrayList<Contact>();
        Contact josh = new Contact("Josh","Allen", 716123222);
//        contactList.add(josh);
//        System.out.println(josh.getFirstName().toString());
//        System.out.println(josh.getLastName());
//        System.out.println(josh.getPhoneNumber());
//        String joshNameString = josh.getFirstName().toString();
//        Files.write(filepath, joshNameString.getBytes());
//        Files.write(filepath, contactList);

        //turn objects into strings, pass the strings into writing on the contacts text file
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int option;
        do{
            System.out.println("1. Add contact");
            System.out.println("2. View List of Contacts");
            System.out.println("3. Search contact by name");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Choose option to proceed : ");
            option = s.nextInt();

            switch(option){
                case 1:
                    System.out.println("Enter First Name : ");
                    String firstName = s.nextLine();
                    System.out.println("Enter Last Name : ");
                    String lastName = s1.nextLine();
                    System.out.print("Enter phone number : ");
                    int phoneNumber = s.nextInt();

                    contactList.add(new Contact(firstName,lastName,phoneNumber));
                    //write into text file
                    break;
                case 2:
                    //read from text file
                   // System.out.println(); print out list of contact list

                case 3:
                    //search contact by name

                case 4:
                    System.out.println("Would you like to delete a contact? enter y if yes");
                    System.out.println("Enter the name of the contact to delete: ");
                    //search for contact from case 3
                    System.out.println("Are you sure you want to delete this contact? enter y if yes");
                    System.out.println("contact deleted");
                    //show contact list again
                case 5:
                    System.out.println("are you sure you want to exit? enter y if yes");
                    String userInput = s1.nextLine();
                    if (userInput.contains("y")){
                        option = 0;
                        System.out.println("program has ended, have a nice day!!");
                    }



            }
        }while(option != 0);
        System.out.println(contactList);
    }
}

