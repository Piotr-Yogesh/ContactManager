import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ContactTesting {
    public static void main(String[] args) throws IOException {
        List<Contact> contactList = new ArrayList<Contact>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int option;
        do{
            System.out.println("1. Add contact");
            System.out.println("2. View contact");
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
                    break;

            }
        }while(option != 0);
        System.out.println(contactList);
    }
}

