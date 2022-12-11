package LeaveManangementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zahid
 */
public class Test {

    Login login;

    ArrayList<Feedback> adminDetails = new ArrayList();
    ArrayList<Employee> employeeDetails = new ArrayList();

    //Constructor for initializing objects
    public Test() {
        login = new Login();
    }

    public static void main(String[] args) {
        Test leave = new Test();

    }

    void Display() {
        Scanner scan = new Scanner(System.in);
        String username, password;
        int a = 0;
        int total = 0;

        System.out.println("\"Select any one for login procedure\\n\\n\" + \"1.Admin  \\n\" + \"2.Employee\");");

        try {
            a = scan.nextInt();
            System.out.println("Enter Username :");
            username = scan.next();
            System.out.println("Enter Password :");
            password = scan.next();

            switch (a) {
                case 1:
                    Manager admin = login.checkManager(username, password); // Login verification for admin
                    if (admin == null) {
                        Display();
                    }

                    while (true) {

                        System.out.println("\nPress 1 to add employee." + "\n" + "\n" 
                                + "Press 2 to View Report Employee" + "\n" + "Press 3 to Log Out");
                        
                        a = scan.nextInt();
                        
                        switch(a){
                        
                            case 1 : 
                                System.out.println("How many employees you want to create?");
                                total= scan.nextInt();
                            
                            
                            
                            
                        
                        }
                        

                    }

            }

        } catch (Exception e) {

        }

    }

}
