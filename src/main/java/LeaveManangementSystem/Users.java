package LeaveManangementSystem;

import java.util.Random;

/**
 *
 * @author zahid
 */
public class Users {

    private String firstName, lastName, username, password;
    private long id;
    
    Random random = new Random();

    public long randomIdGenerator(){
    
    return random.nextLong(1000000000L,9999999999L);
    
    }

    //Beginning of Encapsulation
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() != 0) {
            this.firstName = firstName;
        } else {
            System.out.println("Please write your name");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() != 0) {
            this.lastName = lastName;
        } else {
            System.out.println("Please write your surname");
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

    public long getId() {
        return id;
    }

    public void setId(long id) {

        int count = 0;

        while (id > 0) {
            id /= 10;
            count++;

        }
        if (id == 10 && id > 0) {
            this.id = id;
        } else {
            System.out.println("You entered an incorrect value.");

        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() != 0 && password.contains("!")) {
            this.password = password;
        } else {
            System.out.println("You entered an incorrect value.");
        }

    }
    ////End of Encapsulation
    

}
