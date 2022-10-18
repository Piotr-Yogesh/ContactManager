import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactTesting {
    public static void main(String[] args) throws IOException {
        String directory = "data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);
        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }
        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }
        Path filepath = Paths.get("data","contacts.txt");
        List<Contact> contactList = new ArrayList<Contact>();
        Contact joshAllen = new Contact("Josh", "Allen", "716123222");
        contactList.add(joshAllen);;
        Contact vonMiller = new Contact("Von", "Miller", "1231231313");
        contactList.add(vonMiller);
        Contact jordanPoyer = new Contact("Jordan", "Poyer", "4677413");
        contactList.add(jordanPoyer);
        Contact gabeDavis = new Contact("Gabe", "Davis", "95483498");
        contactList.add(gabeDavis);

        ArrayList<String> nameAndNumberList = new ArrayList<>();
        nameAndNumberList.add("First     | Last      | Phone");
        nameAndNumberList.add("-----------------------------");
        for(int i=0; i<contactList.size();i++){
            nameAndNumberList.add(contactList.get(i).getFirstName()+"       | "+contactList.get(i).getLastName()+"      | "+contactList.get(i).getPhoneNumber());
        }
        Files.write(filepath, nameAndNumberList);

        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. View List of Contacts");
            System.out.println("2. Add contact");
            System.out.println("3. Search contact by name");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");
            System.out.print("Choose option to proceed : ");
            option = s.nextInt();

            switch (option) {
                case 2:
                    boolean keepAdding;
                    do {
                        //do while loop, ask user if they want to add another contact, after adding one, if not, returns to main menu
                        System.out.println("Enter First Name : ");
                        String firstName = s1.nextLine();
                        System.out.println("Enter Last Name : ");
                        String lastName = s1.nextLine();
                        System.out.print("Enter phone number : ");
                        String phoneNumber = s1.nextLine();
                        contactList.add(new Contact(firstName, lastName, phoneNumber));
                        System.out.print("Your new contact name is " + contactList.get(contactList.size() - 1).getFirstName() + " ");
                        System.out.print(contactList.get(contactList.size() - 1).getLastName() + " ");
                        System.out.println(" the new contact phone number is " + contactList.get(contactList.size() - 1).getPhoneNumber());
                        nameAndNumberList.add(contactList.get(contactList.size() - 1).getFirstName() + "       | " + contactList.get(contactList.size() - 1).getLastName() + "      | " + contactList.get(contactList.size() - 1).getPhoneNumber());
                        Files.write(filepath, nameAndNumberList);
                        System.out.println("Do you want to add another contact? Enter yes to add another contact, enter anything else to return to the main menu");
                        String userInput2 = s1.nextLine();
                        if (userInput2.contains("yes")) {
                                keepAdding = true;
                        } else {
                            keepAdding = false;
                        }
                    }while(keepAdding);
                        break;
                case 1:
                    System.out.printf("Here is a list of contacts%n");
                    System.out.printf("%nFirst       | Last  | Phone Number%n");
                    System.out.println("--------------------------------------");
                    Path contactNamePath = Paths.get("data","contacts.txt");
                    List<String> contactList22 = Files.readAllLines(contactNamePath);
                    for(int i = 2; i<contactList22.size();i++){
                        System.out.println((i-1)+":"+contactList22.get(i));
                    }
                    System.out.println("press enter to return to main menu");
                    String userInput1 = s1.nextLine();
                    if(userInput1.contains("")){
                        System.out.printf("%nokey dokey%n");
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    boolean keepSearching;
                    do {
                        List<String> contacts15 = Files.readAllLines(Paths.get("data", "contacts.txt"));
                        System.out.println("enter a name to search for");
                        String userInputSearch = s1.nextLine();
                        int counter=0;
                        for (String contact : contacts15) {
                            if (contact.toLowerCase().contains(userInputSearch.toLowerCase())) {
                                System.out.printf("First  | Last  | Phone Number%n" + contact + "%n");
                                counter +=1;
                            }
                        }
                        if(counter==0){
                            System.out.println("This contact does not exist");
                            System.out.println("");
                        }
                        System.out.println("Enter y if you want to search another contact, if not return main menu with any key");
                        String userInput2 = s1.nextLine();
                        if (userInput2.contains("y")) {
                            keepSearching = true;
                        } else {
                            keepSearching = false;
                            System.out.println("return to main menu");
                            System.out.println("");
                        }
                    }while(keepSearching);
                    break;
                case 4:
                    List<String> contactsRemove = Files.readAllLines(Paths.get("data", "contacts.txt"));
                    System.out.println("You have chosen to delete a contact:");
                    System.out.println("Enter name of contact you wish to delete:");
                    String userInputSearchToRemove = s1.nextLine();
                    for (int i=0;i< contactsRemove.size();i++) {
                        if (contactsRemove.get(i).toLowerCase().contains(userInputSearchToRemove.toLowerCase())) {
                            System.out.printf("First  | Last  | Phone Number%n" + contactsRemove.get(i) + "%n");

                            System.out.println("Is this a contact you want to delete? enter y if yes");
                            String userInputRemove = s1.nextLine();
                            if (userInputRemove.contains("y")){
                                contactsRemove.remove(i);
                                System.out.println(contactsRemove);
                                Files.write(filepath, contactsRemove);
                            }

                        }
                        }
                    break;
                case 5:
                    System.out.println("have a nice day!!");
                    option = 0;


            }
        } while (option != 0);

    }
}

