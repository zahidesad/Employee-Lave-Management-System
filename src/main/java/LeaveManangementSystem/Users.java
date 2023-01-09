package LeaveManangementSystem;

import java.util.Random;

/**
 *
 * @author zahid
 */
public class Users {

    private String firstName, lastName, username, password;
    private long id;

    public Users(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;

    }

    public Users() {
    }
    
    void viewLeaveRequests(){
    }

    Random random = new Random();
    //Gives the user a random id which becomes the user's password
    public void randomIdGenerator() {
        this.id = random.nextLong(1000000000L, 9999999999L);
        this.password = String.valueOf(id);
    }

    //Beginning of Encapsulation
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() != 0) {
            this.firstName = firstName;
        } else {
            System.out.println("Please write your name. ");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() != 0) {
            this.lastName = lastName;
        } else {
            System.out.println("Please write your surname. ");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() != 0) {
            this.username = username;
        } else {
            System.out.println("Please write your username. ");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }
    ////End of Encapsulation

}
