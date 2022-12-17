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
        System.out.print("\n\nPlease enter your choice : ");

        try {
            a = scan.nextInt();
            System.out.print("\nEnter Username : ");
            username = scan.next();
            System.out.print("Enter Password : ");
            password = scan.next();

            switch (a) {
                case 1:
                    CEO ceo = login.checkCeo(username, password); // Login verification for CEO
                    if (ceo == null) {
                        Display();
                    }
                    Feedback f = new Feedback();

                    while (ceo != null) {

                        System.out.println("\n1)Press to add manager or employee" + "\n" + "2)Press to view Manager Requests" + "\n"
                                + "3)Press to grant report manager" + "\n" + "4)Press to view report of managers"
                                + "\n" + "5)Press to view report of employees" + "\n" + "6)Press to logout");

                        System.out.print("\nPlease enter your choice : ");
                        a = scan.nextInt();

                        switch (a) {

                            case 1:
                                System.out.println("\n\nPress 1 to add Manager || Press 2 to add Employee\n");
                                System.out.print("Please enter your choice : ");

                                a = scan.nextInt();

                                switch (a) {
                                    case 1 -> { // Creates Manager
                                        System.out.print("\nPlease write your manager's name :  ");
                                        String firstName = scan.nextLine();
                                        firstName = scan.nextLine();

                                        System.out.print("Please write your manager's first last name : ");
                                        String lastName = scan.nextLine();

                                        String ManagerUsername = firstName + lastName;

                                        System.out.print("Please enter your manager's total annual leave entitlement : ");
                                        int totalDayLeaveValue = scan.nextInt();

                                        ceo.createManager(firstName, lastName, ManagerUsername, totalDayLeaveValue);
                                        Company.managers.get(Company.managers.size() - 1);
                                        System.out.println("Your manager's username is " + '"' + ConsoleColorsCode.GREEN_BOLD + ManagerUsername + ConsoleColorsCode.RESET + '"'
                                                + "\t\tYour manager's password is " + '"' + ConsoleColorsCode.BLUE_BOLD + Company.managers.get(Company.managers.size() - 1).getPassword() + ConsoleColorsCode.RESET + '"'
                                                + "\n\n!!!!!Please forward this informations to your employee so that he/she can log into the system!!!!!!");

                                        continue;
                                    }
                                    case 2 -> { //Creates Employee

                                        System.out.print("\n\nPlease write your employee's name :  ");
                                        String firstName = scan.nextLine();
                                        firstName = scan.nextLine();

                                        System.out.print("Please write your employee's last name : ");
                                        String lastName = scan.nextLine();

                                        String EmployeeUsername = firstName + lastName;

                                        System.out.print("Please enter your employee's total annual leave entitlement : ");
                                        int totalDayLeaveValue = scan.nextInt();

                                        ceo.viewManagerWithoutPassword();

                                        System.out.print("\n\nSelect the manager who will be responsible for the employee : ");
                                        a = scan.nextInt();
                                        Manager manager = Company.managers.get(a - 1);

                                        Company.createEmployee(firstName, lastName, EmployeeUsername, manager, totalDayLeaveValue);
                                        System.out.println("Your employee's username is " + '"' + ConsoleColorsCode.GREEN_BOLD + EmployeeUsername + ConsoleColorsCode.RESET + '"'
                                                + "\t\tYour employee's password is " + '"' + ConsoleColorsCode.BLUE_BOLD + Company.employees.get(Company.employees.size() - 1).getPassword() + ConsoleColorsCode.RESET + '"'
                                                + "\n\n!!!!!Please forward this informations to your employee so that he/she can log into the system!!!!!!");
                                        continue;

                                    }
                                    default -> {
                                        System.out.println("Please enter valid choice");
                                        continue;
                                    }
                                }

                            case 2: // View leave request from manager
                                f.ManagerRequests();
                                continue;

                            case 3:
                                f.confirmationForManagerLeaves(ceo);
                                continue;

                            case 4: // View report of Manager
                                ceo.viewManagerWithPassword(Company.managers);

                                continue;

                            case 5: // View report of Employee
                                ceo.viewEmployeeWithPassword(Company.employees);

                                continue;
                            case 6: // Display is called for logout
                                Display();
                            default:
                            //continue;
                        }

                    }
                case 2: // Login verification for manager

                    Manager manager = login.checkManager(username, password);
                    Feedback feedback = new Feedback();

                    if (manager != null) {
                        System.out.println("\n\n------Welcome " + username + "------");

                    } else {
                        Display();

                    }

                    while (manager != null) {
                        int c = 0;
                        int request = 0;
                        System.out.println("\n\n1)View Leaves \n2)Apply for leave \n3)View Report \n4)View Employee Requests \n5)Grant \n6)Logout");
                        System.out.print("\nPlease enter your choice : ");
                        c = scan.nextInt();
                        switch (c) {
                            case 1 ->
                                manager.viewleave();
                            case 2 -> {
                                System.out.println("\nYour total leaves are " + manager.getNumberOfLeavesLeft() + " days");
                                System.out.print("\nHow many leaves do you want : ");
                                request = scan.nextInt();
                                manager.requestLeave(request);
                            }
                            case 3 -> // View his/her Employee's leave report
                                feedback.viewEmployee(manager);
                            case 4 -> // View request of his/her allocated employee
                                feedback.emlpoyeeRequests();
                            case 5 ->
                                feedback.confirmationForEmployeeLeaves(manager);
                            case 6 ->
                                Display();
                            default -> {
                            }

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
                            System.out.println("1. View  Leaves" + "\n" + "2. Apply for leave " + "\n" + "3. Logout");

                            b = scan.nextInt();
                            switch (b) {

                                case 1 -> // Viewing his/her available leave
                                    emp.viewleave();

                                case 2 -> {
                                    // Requesting leave
                                    System.out.println("Your total leaves are: " + emp.getNumberOfLeavesLeft());
                                    System.out.println("\nHow many leaves do you want ?");
                                    request = scan.nextInt();
                                    emp.requestLeave(request);
                                }
                                case 3 -> //Logout
                                    Display();
                                default -> {
                                }

                            }
                        }

                    }
                default:
                    System.out.println("Enter valid number ");
                    Display();

            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            Display();

        }
        scan.close();
    }

}
