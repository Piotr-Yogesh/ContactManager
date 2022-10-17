public class Contact {

    private String firstName;
    private String lastName;
    private Integer phoneNumber;

    public Contact(String firstName, String lastName, Integer phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Integer getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String contactInfo(){
        return firstName + " " + lastName + " | " + phoneNumber;
    }
}
