import java.util.ArrayList;

public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;

//    public Contact(String newFirstName,String newLastName, String newPhoneNumber){
//        this(newFirstName, newLastName, new newPhoneNumber);
//    }

    public Contact(String newfirstName, String newlastName, String newPhoneNumber){
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

    public String getPhoneNumber(){
        return phoneNumber;
    }

//    public  void addPhoneNumber(int phoNumber){
//        phoneNumber.add(phoNumber);
//    }

    public String contactInfo(){
        return firstName + " " + lastName + "  " + phoneNumber;
    }
}
