public class Contact {

    private String firstName;
    private String lastName;
    private Integer phoneNumber;

    Contact(String name, Integer phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Integer getPhoneNumber(){
        return phoneNumber;
    }

    public String contactInfo(){
        return firstName + " " + lastName + "  " + phoneNumber;
    }
}
