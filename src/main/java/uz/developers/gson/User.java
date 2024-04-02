package uz.developers.gson;

public class User {

    private String firstname;
    private String lastname;
    private String username;
    private String phoneNumber;

    public User(String firstname, String phoneNumber) {
        this.firstname = firstname;
        this.phoneNumber = phoneNumber;
    }

    public User(String firstname, String lastname, String username, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
