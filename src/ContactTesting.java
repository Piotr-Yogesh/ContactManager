import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactTesting {
    public static void main(String[] args) throws IOException {

//        String directory = "data";
//        String filename = "contacts.txt";
//        Path dataDirectory = Paths.get(directory);
//        Path dataFile = Paths.get(directory, filename);
//        if (Files.notExists(dataDirectory)) {
//            Files.createDirectories(dataDirectory);
//        }
//        if (! Files.exists(dataFile)) {
//            Files.createFile(dataFile);
//        }
        Path filepath = Paths.get("data","contacts.txt");
        List<String> contactList22 = Files.readAllLines(filepath);
        ArrayList<String> nameAndNumberList = new ArrayList<>();
//        nameAndNumberList.add("First     | Last      | Phone");
//        nameAndNumberList.add("-----------------------------");
        for(int i = 0; i<contactList22.size();i++){
//            System.out.println((i-1)+":"+contactList22.get(i));
            nameAndNumberList.add(contactList22.get(i));
        }

        List<Contact> contactList = new ArrayList<Contact>();
//        nameAndNumberList.add("First     | Last      | Phone");
//        nameAndNumberList.add("-----------------------------");
//        Contact joshAllen = new Contact("Josh", "Allen", "716123222");
//        contactList.add(joshAllen);;
//        Contact vonMiller = new Contact("Von", "Miller", "1231231313");
//        contactList.add(vonMiller);
//        Contact jordanPoyer = new Contact("Jordan", "Poyer", "4677413");
//        contactList.add(jordanPoyer);
//        Contact gabeDavis = new Contact("Gabe", "Davis", "95483498");
//        contactList.add(gabeDavis);

        for(int i=0; i<contactList.size();i++){
            nameAndNumberList.add(contactList.get(i).getFirstName()+"       | "+contactList.get(i).getLastName()+"      | "+contactList.get(i).getPhoneNumber());
        }

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
                        System.out.println("Are you sure you want to add this contact? enter y if yes");
                        String yesSir = s1.nextLine();
                        if(yesSir.contains("y")) {
                            nameAndNumberList.add(contactList.get(contactList.size() - 1).getFirstName() + "       | " + contactList.get(contactList.size() - 1).getLastName() + "      | " + contactList.get(contactList.size() - 1).getPhoneNumber());
                        }else{
                            System.out.println("you have chosen not to add that contact");
                        }
                        System.out.println("Do you want to add another contact? Enter y to add another contact, enter anything else to return to the main menu");

                        String userInput2 = s1.nextLine();
                        if (userInput2.contains("y")) {
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
                    for(int i =0;i<nameAndNumberList.size();i++) {
                        System.out.println((i+1)+". "+nameAndNumberList.get(i));
                    }

                    System.out.println("hit any key to return to the main menu");
                    String userInput1 = s1.nextLine();
                    if(userInput1.contains("")){
                    }
                    break;
                case 3:
                    boolean keepSearching;
                    do {
                        System.out.println("enter a name to search for");
                        String userInputSearch = s1.nextLine();
                        int counter=0;
                        for(int i=0; i<nameAndNumberList.size();i++){
                            if(nameAndNumberList.get(i).toLowerCase().contains(userInputSearch.toLowerCase())){
                                System.out.printf("First  | Last  | Phone Number%n" + nameAndNumberList.get(i) + "%n");
                                counter +=1;
                        }}

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
                    boolean keepDeleting;
                    do {
                        System.out.println("enter the name of the contact you want to delete");
                        String userInputSearch = s1.nextLine();
                        int counter=0;
                        for(int i=0; i<nameAndNumberList.size();i++){
                            if(nameAndNumberList.get(i).toLowerCase().contains(userInputSearch.toLowerCase())){
//                                System.out.printf("First  | Last  | Phone Number%n" + nameAndNumberList.get(i) + "%n");
                                System.out.printf(nameAndNumberList.get(i)+"%nis this the contact you want to delete? y if yes");
                                String yesNo = s1.nextLine();
                                if(yesNo.contains("y")){
                                    System.out.println(nameAndNumberList.get(i)+" has been deleted");
                                    nameAndNumberList.remove(i);
                                    keepDeleting = true;
                                }else{
                                    System.out.printf("%n%nyou have chosen not to delete "+nameAndNumberList.get(i));
                                    keepDeleting = false;
                                }
                                counter +=1;
                                System.out.println("");
                            }}


                        if(counter==0){
                            System.out.println("This contact does not exist");

                        }

//                        List<String> contactsRemove = Files.readAllLines(Paths.get("data", "contacts.txt"));
//                        System.out.println("Enter name of contact you wish to delete:");
//                        String userInputSearchToRemove = s1.nextLine();

//                        for(int i=0; i<nameAndNumberList.size();i++){
//                            if(nameAndNumberList.get(i).toLowerCase().contains(userInputSearchToRemove.toLowerCase())) {
//
//                                System.out.printf(nameAndNumberList.get(i)+"%nis this the contact you want to delete? y if yes");
//                            }
//                            String yesOrNo = s1.nextLine();
//                            if(yesOrNo.contains("y")){
//                                System.out.println("hello");
//                            }
//                            if(nameAndNumberList.get(i).toLowerCase().contains(userInputSearch.toLowerCase())){
//
//                                System.out.println();
//                                System.out.println(nameAndNumberList.get(i));
////                                nameAndNumberList.remove(i);
//                                System.out.println(nameAndNumberList.get(i)+" has been deleted");
//                            }
//                        }
//                        for (int i = 0; i < contactsRemove.size(); i++) {
//                            if (contactsRemove.get(i).toLowerCase().contains(userInputSearchToRemove.toLowerCase())) {
//                                System.out.printf("First  | Last  | Phone Number%n" + contactsRemove.get(i) + "%n");
//
//                                String userInputRemove = s1.nextLine();
//                                if (userInputRemove.contains("y")) {
//                                    contactsRemove.remove(i);
//                                    Files.write(filepath, contactsRemove);
//                                }
//                            }
//                        }
                        System.out.println("Do you wish to delete another contact? Enter y if yes, if not enter another key to return to main menu");
                        String continuer = s1.nextLine();
                        if(continuer.contains("y")){
                            keepDeleting = true;
                        }else{
                            keepDeleting = false;
                        }
                    }while(keepDeleting);
                    break;
                case 5:
                    System.out.printf("%n%n%n");
                    System.out.println("have a nice day!!");
                    Files.write(filepath, nameAndNumberList);
                    option = 0;
            }
        } while (option != 0);

    }
}

