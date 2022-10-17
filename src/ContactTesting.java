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
//        Contact mattMilano = new Contact("Matt", "Milano", "12134123");
//        contactList.add(mattMilano);

        ArrayList<String> nameAndNumberList = new ArrayList<>();
        nameAndNumberList.add("First     | Last      | Phone");
        nameAndNumberList.add("-----------------------------");
        for(int i=0; i<contactList.size();i++){
//            List<String> firstNameList = Arrays.asList(contactList.get(i).getFirstName());
            nameAndNumberList.add(contactList.get(i).getFirstName()+"       | "+contactList.get(i).getLastName()+"      | "+contactList.get(i).getPhoneNumber());
        }
        System.out.println(nameAndNumberList);
        Files.write(filepath, nameAndNumberList);

        //turn objects into strings, pass the strings into writing on the contacts text file
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
                    System.out.println("Enter First Name : ");
                    String firstName = s1.nextLine();
                    System.out.println("Enter Last Name : ");
                    String lastName = s1.nextLine();
                    System.out.print("Enter phone number : ");
                    String phoneNumber = s1.nextLine();
                    contactList.add(new Contact(firstName, lastName, phoneNumber));
                    System.out.print("Your new contact name is "+contactList.get(contactList.size()-1).getFirstName()+" ");
                    System.out.print(contactList.get(contactList.size()-1).getLastName()+" ");
                    System.out.println(" and your new contact phone is "+contactList.get(contactList.size()-1).getPhoneNumber());
                    nameAndNumberList.add(contactList.get(contactList.size()-1).getFirstName()+"       | "+contactList.get(contactList.size()-1).getLastName()+"      | "+contactList.get(contactList.size()-1).getPhoneNumber());
                    Files.write(filepath, nameAndNumberList);
                    System.out.println("would you like to return to main menu? enter y if yes, if not, program will end");
                    String userInpu2 = s1.nextLine();
                    if(userInpu2.contains("y")){
                    }else{
                        option = 0;
                        System.out.println("program has ended, goodbye");
                    }
                    //write into text file
                    break;
                case 1:
                    System.out.println("Here is a list of contacts");
                    System.out.println("First  | Last  | Phone Number");
//                    for (int i = 0; i < contactList.size(); i++) {
//                        System.out.println("  " + contactList.get(i).getFirstName() + " | " + contactList.get(i).getLastName() + " |" + contactList.get(i).getPhoneNumber());
//                    }
                    Path contactNamePath = Paths.get("data","contacts.txt");
                    List<String> contactList22 = Files.readAllLines(contactNamePath);
                    for(int i = 2; i<contactList22.size();i++){
                        System.out.println((i-1)+":"+contactList22.get(i));
                    }
                    System.out.println("would you like to return to the main menu? enter y if yes");
                    String userInput1 = s1.nextLine();
                    if(userInput1.contains("y")){
                        System.out.println("okey dokey");
                    }
                    //read from text file
                    // System.out.println(); print out list of contact list
                    break;
                case 3:
                    //search contact by name

                    List<String> contacts15 = Files.readAllLines(Paths.get("data", "contacts.txt"));
//                    List<String> newContactList5 = new ArrayList<>();
                    System.out.println("enter a name to search for");

                    String userInputSearch = s1.nextLine();


                    for (String contact : contacts15) {
                            if(contact.toLowerCase().contains(userInputSearch.toLowerCase())) {
                                System.out.printf("First  | Last  | Phone Number%n"+contact+"%n");
                            }
//                                else if(!(contact.toLowerCase().contains(userInput59.toLowerCase()))){
//                                    System.out.println("no such name found");
//                                };
                            }

                    System.out.println("would you like to return to main menu? enter y if yes, if not, program will end");
                    String userInput2 = s1.nextLine();
                    if(userInput2.contains("y")){
                    }else{
                        option = 0;
                        System.out.println("program has ended, goodbye");
                    }
                case 4:
//                    System.out.println("Would you like to delete a contact? enter y if yes");
//                    System.out.println("Enter the name of the contact to delete: ");
//                    //search for contact from case 3
//                    System.out.println("Are you sure you want to delete this contact? enter y if yes");
//                    System.out.println("contact deleted");
                    //show contact list again
                    List<String> contactsRemove = Files.readAllLines(Paths.get("data", "contacts.txt"));
//                    List<String> newContactList5 = new ArrayList<>();
                    System.out.println(contactsRemove);
                    System.out.println("Enter contact name to search:");
                    String userInputSearchToRemove = s1.nextLine();

                    for (int i=0;i< contactsRemove.size();i++) {
                        if (contactsRemove.get(i).toLowerCase().contains(userInputSearchToRemove.toLowerCase())) {
                            System.out.printf("First  | Last  | Phone Number%n" + contactsRemove.get(i) + "%n");

                            System.out.println("Is this a contact you want to delete?");
                            String userInputRemove = s1.nextLine();

                            if (userInputRemove.contains("y")){
                                contactsRemove.remove(i);
                                System.out.println(contactsRemove);
                                Files.write(filepath, contactsRemove);
                            }
                        }
                        }




//                    System.out.println("would you like to return to main menu? enter y if yes, if not, program will end");
//                    String userInput2 = s1.nextLine();
//                    if(userInput2.contains("y")){
//                    }else{
//                        option = 0;
//                        System.out.println("program has ended, goodbye");
//                    }
                case 5:
                    System.out.println("have a nice day!!");
                    option = 0;


            }
        } while (option != 0);

    }
}

