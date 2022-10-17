import java.util.ArrayList;

public class Contact {

    private String firstName;
    private String lastName;
    private ArrayList<Integer> phoneNumber;

    public Contact(String newFirstName,String newLastName, String newPhoneNumber){
        this(newFirstName, newLastName, new ArrayList<Integer>());
    }

    public Contact(String newfirstName, String newlastName, ArrayList<Integer> newPhoneNumber){
        this.firstName = newfirstName;
        this.lastName = newlastName;
        this.phoneNumber = newPhoneNumber;
    }
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public ArrayList<Integer> getPhoneNumber(){
        return phoneNumber;
    }

    public  void addPhoneNumber(int phoNumber){
        phoneNumber.add(phoNumber);
    }

    public String contactInfo(){
        return firstName + " " + lastName + "  " + phoneNumber;
    }
}
