package LeaveManangementSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zahid
 */
public class Test {

    Login login;

    ArrayList<CEO> CeoDetails = new ArrayList();
    ArrayList<Employee> employeeDetails = new ArrayList();
    ArrayList<Manager> managerDetails = new ArrayList();

    //Constructor for initializing objects
    public Test() {
        login = new Login();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.Display();

    }

    void Display() {
        Scanner scan = new Scanner(System.in);
        String username, password;
        int a = 0;
        int total = 0;

        System.out.println("Select any one for login procedure\n\n" + "1.Admin \n" + "2.Manager \n" + "3.Employee");

        try {
            a = scan.nextInt();
            System.out.println("Enter Username :");
            username = scan.next();
            System.out.println("Enter Password :");
            password = scan.next();

            switch (a) {
                case 1:
                    CEO ceo = login.checkCeo(username, password); // Login verification for CEO
                    if (ceo == null) {
                        Display();
                    }

                    while (true) {

                        System.out.println("\nPress 1 to add employee" + "\n" + "Press 2 to view report manager" + "\n"
                                + "Press 3 to view report of employee" + "\n" + "Press 4 to log out");

                        a = scan.nextInt();

                        switch (a) {

                            case 1:
                                System.out.println("Press 1 to add Reporting Manager || press 2 to add Employee");

                                a = scan.nextInt();

                                if (a == 1) { // Creates Manager
                                    System.out.println("How many manager you want to create?");
                                    total = scan.nextInt();
                                    //Company.createManager(username, username, username, password);
                                    continue;
                                } else if (a == 2) { //Creates Employee
                                    System.out.println("How many employees you want to create?");
                                    total = scan.nextInt();
                                    //Company.createEmployee(username, username, username, manager, password);
                                    continue;

                                } else {
                                    System.out.println("Enter valid choice");
                                    continue;
                                }
                            case 2: // View report of Manager
                                ceo.viewManagerWithPassword(managerDetails);

                                continue;

                            case 3: // View report of Employee
                                ceo.viewEmployeeWithPassword(employeeDetails);

                                continue;
                            case 4: // Display is called for logout
                                Display();
                            default:
                                continue;
                        }

                    }
                case 2: // Login verification for manager

                    Manager mlogin = login.checkManager(username, password);
                    Feedback feedback = new Feedback(); //EMİRHANA SOOORR!!!!!!

                    if (mlogin != null) {
                        System.out.println("Welcome " + username);

                    } else {
                        Display();

                    }

                    while (true) {
                        int c = 0;
                        System.out.println("1.View Report \n2.View Requests \n3.Grant \n4.Logout");
                        c = scan.nextInt();
                        if (c == 1) { // View his/her Employee's leave report
                            feedback.viewEmployee(employeeDetails);
                        } else if (c == 2) { // View request of his/her allocated employee
                            feedback.emlpoyeeRequests(employeeDetails);

                        } else if (c == 3) {
                            feedback.confirmationForLeave(mlogin);

                        } else if (c == 4) {
                            Display();
                        }

                    }
                case 3:
                    //Login verification for employee

                    Employee emp = login.checkEmployee(username, password);

                    if (emp != null) {
                        System.out.println("Welcome " + username);

                        while (true) {
                            int b = 0;
                            int request = 0;
                            System.out.println("1. View  Leaves" + "\n" + "2. Apply for leave application" + "\n" + "3. Logout");

                            b = scan.nextInt();
                            switch (b) {

                                case 1: // Viewing his/her available leave
                                    emp.viewleave();
                                    break;

                                case 2: // Requesting leave
                                    System.out.println("Your total leaves are: " + emp.getNumberOfLeavesLeft());
                                    System.out.println("\nHow many leaves do you want");
                                    request = scan.nextInt();
                                    emp.getNumberOfLeaveRequest();
                                    break;
                                case 3: //Logour
                                    Display();
                                    break;
                                default:
                                    break;

                            }
                        }

                    }
                default:
                    System.out.println("Enter valid number ");
                    Display();

            }

        } catch (Exception e) {
            System.out.println("Exception Occured");
            Display();

        }
        scan.close();
    }

}
