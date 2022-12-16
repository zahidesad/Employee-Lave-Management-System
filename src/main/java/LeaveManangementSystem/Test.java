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

    //Constructor for initializing objects
    public Test() {
        login = new Login();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.Display();
        Company.ceo = new CEO();
    }

    void Display() {
        Scanner scan = new Scanner(System.in);
        String username, password;
        int a = 0;
        int total = 0;

        System.out.println("Select any one for login procedure\n\n" + "1.CEO \n" + "2.Manager \n" + "3.Employee");

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

                    while (ceo!=null) {

                        System.out.println("\nPress 1 to add employee" + "\n" + "Press 2 to view report manager" + "\n"
                                + "Press 3 to view report of employee" + "\n" + "Press 4 to log out");

                        a = scan.nextInt();

                        switch (a) {

                            case 1:
                                System.out.println("Press 1 to add Reporting Manager || press 2 to add Employee");

                                a = scan.nextInt();

                                if (a == 1) { // Creates Manager
                                    System.out.println("Please write your manager's name :  ");
                                    String firstName = scan.nextLine();
                                    firstName = scan.nextLine();
                                    

                                    System.out.println("Please write your manager's last name : ");
                                    String lastName = scan.nextLine();

                                    String ManagerUsername = firstName + lastName;
                                    System.out.println("Your manager's username : " + ManagerUsername + ". Please tell him/her that");

                                 

                                    ceo.createManager(firstName, lastName, ManagerUsername);
                                    Company.managers.get(Company.managers.size() - 1);

                                    System.out.println("Your manager's password : " + Company.managers.get(Company.managers.size() - 1).getPassword()
                                            + ". Please tell him/her that");
                                    continue;
                                } else if (a == 2) { //Creates Employee

                                    System.out.println("Please write your employee's name :  ");
                                    String firstName = scan.nextLine();
                                    firstName = scan.nextLine();

                                    System.out.println("Please write your employee's last name : ");
                                    String lastName = scan.nextLine();

                                    String EmployeeUsername = firstName + lastName;
                                    System.out.println("Your employee's username : " + EmployeeUsername + " Please tell him/her that");

                                    

                                    System.out.println("Please write your employee's total day value : ");
                                    int totalDayLeaveValue = scan.nextInt();

                                    

                                        ceo.viewManagerWithoutPassword();

                                 
                                    System.out.println("Select Manager : ");
                                    a = scan.nextInt();
                                    Manager manager = Company.managers.get(a - 1);

                                    Company.createEmployee(firstName, lastName, EmployeeUsername, manager, totalDayLeaveValue);
                                    System.out.println("Your employee's password : " + Company.employees.get(Company.employees.size() - 1).getPassword()
                                            + " Please tell him/her that");
                                    continue;

                                } else {
                                    System.out.println("Enter valid choice");
                                    continue;
                                }
                            case 2: // View report of Manager
                                ceo.viewManagerWithPassword(Company.managers);

                                continue;

                            case 3: // View report of Employee
                                ceo.viewEmployeeWithPassword(Company.employees);

                                continue;
                            case 4: // Display is called for logout
                                Display();
                            default:
                                continue;
                        }

                    }
                case 2: // Login verification for manager

                    Manager manager = login.checkManager(username, password);
                    Feedback feedback = new Feedback(); 

                    if (manager != null) {
                        System.out.println("Welcome " + username);

                    } else {
                        Display();

                    }

                    while (manager != null) {
                        int c = 0;
                        System.out.println("1.View Report \n2.View Requests \n3.Grant \n4.Logout");
                        c = scan.nextInt();
                        if (c == 1) { // View his/her Employee's leave report
                            feedback.viewEmployee(manager);
                        } else if (c == 2) { // View request of his/her allocated employee
                            feedback.emlpoyeeRequests();

                        } else if (c == 3) {
                            feedback.confirmationForLeave(manager);

                        } else if (c == 4) {
                            Display();
                        }

                    }
                case 3:
                    //Login verification for employee

                    Employee emp = login.checkEmployee(username, password);

                    if (emp != null) {
                        System.out.println("Welcome " + username);

                        while (emp!=null) {
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
                                    System.out.println("\nHow many leaves do you want ?");
                                    request = scan.nextInt();
                                    emp.requestLeave(request);
                                    break;
                                case 3: //Logout
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
