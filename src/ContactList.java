import java.util.Scanner;

public class ContactList {

    public static void menu()
    {

        // Printing statements displaying menu on console
        System.out.println("MENU");
        System.out.println("1: Add a new contact");
        System.out.println("2: Delete an existing contact.");
        System.out.println("4: Search a contact by name.");
        System.out.println("5: View contacts.");
        System.out.println("9: Exit");
        System.out.print("Enter an option (1, 2, 3, 4 or 5): ");

    }

    public static void main(String[] args) {

        ContactListManager contacts = new ContactListManager();

        Record record = new Record();

        record.setFirstName();
        record.setLastName();
        record.setPhoneNumber();

        contacts.add(record);

        Scanner input = new Scanner(System.in);

        int option = 0;

        // Do - While loop
        do {
            menu();
            option = input.nextInt();

            // Switch case
            switch (option) {

                // Case 1
                case 1:

                    // Display message
                    System.out.print(
                            "First Name ? ");

                    int idNumber = input.nextInt();

                    // Display message
                    System.out.print(
                            "Last Name ? ");

                    int contactNumber = input.nextInt();
                    input.nextLine();

                    // Display message
                    System.out.print(
                            "Phone Number ? ");

                    String name = input.nextLine();

                    // Create record object and pass constructor
                    // parameters.
                    record = new Record(firstName, lastName,
                            phoneNumber);
                    // Call add() record
                    contacts.add(record);
                    System.out.println(record.toString());

                    // Break statement used to terminate program
                    // from here only once it entered this case
                    break;

                // Case 2
                case 2:

                    // Display message
                    System.out.print(
                            "What is the Student id number ? ");
                    int rId = input.nextInt();

                    // Invoke remove/delete record
                    hr.delete(rId);

                    break;

                // Case 3
                case 3:

                    // Display message
                    System.out.print(
                            "What is the Student id number? ");

                    int rIdNo = input.nextInt();
                    hr.update(rIdNo, input);

                    break;

                // Case 4
                case 4:

                    // Display message
                    System.out.print(
                            "What is the Student id ? ");
                    int bookId = input.nextInt();

                    if (!hr.find(bookId)) {
                        System.out.println(
                                "Student id does not exist\n");
                    }

                    break;

                // Case 5
                case 5:
                    hr.display();
                    break;

                // Case 6
                case 9:

                    // Display message
                    System.out.println(
                            "\nThank you for using the program. Goodbye!\n");
                    System.exit(0);

                    break;

                // Case 7: Default case
                // If none above case executes
                default:

                    // Print statement
                    System.out.println("\nInvalid input\n");
                    break;
            }
        }

        // Checking condition
        while (option != 9);
    }


    }
}