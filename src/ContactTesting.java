import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactTesting {
    public static void main(String[] args) throws IOException {


        Path filepath = Paths.get("data","contacts.txt");
        List<String> contactList22 = Files.readAllLines(filepath);
        ArrayList<String> nameAndNumberList = new ArrayList<>();



        for(int i = 0; i<contactList22.size();i++){
            nameAndNumberList.add(contactList22.get(i));
        }

        List<Contact> contactList = new ArrayList<Contact>();

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

